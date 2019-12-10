package matrixsystems.retrofitrepositorypattern

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import matrixsystems.retrofitrepositorypattern.network.Resource
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

/**
 * Created by Shahbaz Hashmi on 2019-12-09.
 */
/* Copyright 2019 Google LLC.
  SPDX-License-Identifier: Apache-2.0 */
fun <T> MutableLiveData<Resource<T>>.getOrAwaitValue(
    time: Long = 10,
    timeUnit: TimeUnit = TimeUnit.SECONDS
): Resource<T> {
    var data: Resource<T>? = null
    val latch = CountDownLatch(1)
    val observer = object : Observer<Resource<T>> {
        override fun onChanged(o: Resource<T>?) {
            if(o?.status != Resource.Status.LOADING) {
                data = o
                latch.countDown()
                this@getOrAwaitValue.removeObserver(this)
            }
        }
    }

    this.observeForever(observer)

    // Don't wait indefinitely if the LiveData is not set.
    if (!latch.await(time, timeUnit)) {
        throw TimeoutException("LiveData value was never set.")
    }

    @Suppress("UNCHECKED_CAST")
    return data as Resource<T>
}


/**
 * Observes a [LiveData] until the `block` is done executing.
 */
fun <T> LiveData<T>.observeForTesting(block: () -> Unit) {
    val observer = Observer<T> { }
    try {
        observeForever(observer)
        block()
    } finally {
        removeObserver(observer)
    }
}