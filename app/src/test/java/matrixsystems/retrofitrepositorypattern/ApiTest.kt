package matrixsystems.retrofitrepositorypattern

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import junit.framework.Assert.*
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
    fun doLoginRepository_positiveResponse() {
        val loginRepository  = LoginRepository(ServiceGenerator.createService(APIService::class.java))
        val loginLiveData = loginRepository.doLogin("9876543210", "admin123")
        assertEquals(loginLiveData.getOrAwaitValue().status, Resource.Status.SUCCESS)
    }


}