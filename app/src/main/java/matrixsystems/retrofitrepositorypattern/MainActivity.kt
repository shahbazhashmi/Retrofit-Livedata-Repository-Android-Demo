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
import matrixsystems.retrofitrepositorypattern.network.APIService
import matrixsystems.retrofitrepositorypattern.repositories.LoginRepository
import matrixsystems.retrofitrepositorypattern.network.Resource
import matrixsystems.retrofitrepositorypattern.network.ServiceGenerator
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    lateinit var binding: ActivityMainBinding

    val viewModel : MainViewModel by lazy {
        MainViewModel(application)
    }

    //@Inject
    val loginRepository = LoginRepository(ServiceGenerator.createService(APIService::class.java))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.vm = viewModel

        viewModel.classEvent.observe(this, Observer {
            when(it) {
                is MainViewModel.ClassEvent.DoLogin -> {
                    loginRepository.doLogin(it.username, it.password).observe(this, Observer {
                        when(it.status) {
                            Resource.Status.LOADING -> {
                                Log.d(TAG, "api loading ...")
                            }
                            Resource.Status.SUCCESS -> {
                                Log.d(TAG, "api success")
                            }
                            Resource.Status.ERROR -> {
                                Log.d(TAG, "api error - ${it.apiError?.message}")
                            }
                        }
                    })
                }
            }
        })
    }


}
