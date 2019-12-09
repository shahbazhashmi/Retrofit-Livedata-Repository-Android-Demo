package matrixsystems.retrofitrepositorypattern

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import junit.framework.Assert.assertEquals
import matrixsystems.retrofitrepositorypattern.network.APIService
import matrixsystems.retrofitrepositorypattern.network.Resource
import matrixsystems.retrofitrepositorypattern.network.ServiceGenerator
import matrixsystems.retrofitrepositorypattern.repositories.LoginRepository
import org.junit.Rule
import org.junit.Test

/**
 * Created by Shahbaz Hashmi on 2019-12-09.
 */

class ApiTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()


    @Test
    fun fetchUserRepositories_positiveResponse() {
        val loginRepository  = LoginRepository(ServiceGenerator.createService(APIService::class.java))

        /*loginRepository.doLogin("9876543210", "admin123").observeForever {
            when(it.status) {
                Resource.Status.LOADING -> {
                    //assert(false)
                }
                Resource.Status.SUCCESS -> {
                    //assertEquals(Resource.Status.SUCCESS, it.status)
                    assert(false)

                }
                Resource.Status.ERROR -> {
                    assert(false)
                }
            }
        }*/

        assertEquals(loginRepository.doLogin("9876543210", "admin123").getOrAwaitValue().status, Resource.Status.ERROR)
    }


}