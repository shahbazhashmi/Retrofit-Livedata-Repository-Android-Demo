package matrixsystems.retrofitrepositorypattern

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import matrixsystems.retrofitrepositorypattern.di.DIManager
import matrixsystems.retrofitrepositorypattern.models.LoginRequest
import matrixsystems.retrofitrepositorypattern.network.APIService
import matrixsystems.retrofitrepositorypattern.network.Resource
import matrixsystems.retrofitrepositorypattern.network.ServiceGenerator
import matrixsystems.retrofitrepositorypattern.repositories.LoginRepository
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

/**
 * Created by Shahbaz Hashmi on 2019-12-09.
 */

class ApiTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun doLoginRepository_positiveResponse() {

        val request = LoginRequest().also {
            it.email = "lawfirm@ct.com"
            it.password = "Legal@123"
            it.source = "2"
            it.lat = "298"
            it.lang = "97887"
        }

        val loginLiveData = LoginRepository(ServiceGenerator.createService(APIService::class.java)).doLogin(request)

        loginLiveData.observeForApiTesting {
            if(it?.status == Resource.Status.ERROR) {
                System.out.println("API ERROR -> ${it.apiError}")
            }
            else {
                System.out.println("API RESPONSE -> ${it?.data}")
            }
            assertEquals(it?.status, Resource.Status.SUCCESS)
        }
    }


}