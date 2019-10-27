package matrixsystems.retrofitrepositorypattern

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import matrixsystems.retrofitrepositorypattern.di.DIManager
import matrixsystems.retrofitrepositorypattern.network.APIService
import matrixsystems.retrofitrepositorypattern.network.ServiceGenerator
import matrixsystems.retrofitrepositorypattern.repositories.LoginRepository
import javax.inject.Inject

/**
 * Created by Shahbaz Hashmi on 2019-10-27.
 */
class MainViewModel(appContext : Application) : AndroidViewModel(appContext) {

    private val TAG = "MainViewModel"

    //@Inject
    val loginRepository = LoginRepository(ServiceGenerator.createService(APIService::class.java))

    init {
        //DIManager.repositoryComponent.inject(appContext)

    }

    fun onCallClick(v : View) {
        loginRepository.doLogin("9876543210", "123")
    }
}