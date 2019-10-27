package matrixsystems.retrofitrepositorypattern

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import matrixsystems.retrofitrepositorypattern.di.DIManager
import matrixsystems.retrofitrepositorypattern.network.APIResponse
import matrixsystems.retrofitrepositorypattern.network.APIService
import matrixsystems.retrofitrepositorypattern.network.Resource
import matrixsystems.retrofitrepositorypattern.network.ServiceGenerator
import matrixsystems.retrofitrepositorypattern.repositories.LoginRepository
import javax.inject.Inject

/**
 * Created by Shahbaz Hashmi on 2019-10-27.
 */
class MainViewModel(appContext : Application) : AndroidViewModel(appContext) {

    private val TAG = "MainViewModel"

    val classEvent = MutableLiveData<ClassEvent>()

    init {

    }

    fun onCallClick(v : View) {
        classEvent.value = ClassEvent.DoLogin("9876543210", "admin123")
    }



    sealed class ClassEvent() {
        class DoLogin(val username : String, val password : String) : ClassEvent()
    }

}