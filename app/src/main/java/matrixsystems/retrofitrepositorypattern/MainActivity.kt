package matrixsystems.retrofitrepositorypattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.Transformations
import kotlinx.android.synthetic.main.activity_main.*
import matrixsystems.retrofitrepositorypattern.databinding.ActivityMainBinding
import matrixsystems.retrofitrepositorypattern.di.DIManager
import matrixsystems.retrofitrepositorypattern.models.LoginRequest
import matrixsystems.retrofitrepositorypattern.network.APIService
import matrixsystems.retrofitrepositorypattern.repositories.LoginRepository
import matrixsystems.retrofitrepositorypattern.network.Resource
import matrixsystems.retrofitrepositorypattern.network.ServiceGenerator
import javax.inject.Inject



class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var loginRepository : LoginRepository

    private val TAG = "MainActivity"

    lateinit var binding: ActivityMainBinding

    val viewModel : MainViewModel by lazy {
        MainViewModel(application)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.vm = viewModel

        DIManager.repositoryComponent.inject(this)

        viewModel.classEvent.observe(this, Observer {
            when(it) {
                is MainViewModel.ClassEvent.DoLogin -> {
                    val request = LoginRequest().also {
                        it.email = "lawfirm@ct.com"
                        it.password = "Legal@123"
                        it.source = "2"
                        it.lat = "298"
                        it.lang = "97887"
                    }
                    loginRepository.doLogin(request).observe(this, Observer {
                        viewModel.handleLoginCallbacks(it)
                    })
                }
            }
        })
    }


}
