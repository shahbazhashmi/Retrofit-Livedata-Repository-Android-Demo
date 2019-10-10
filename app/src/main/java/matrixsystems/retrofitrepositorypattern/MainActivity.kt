package matrixsystems.retrofitrepositorypattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import matrixsystems.retrofitrepositorypattern.repositories.LoginRepository
import matrixsystems.retrofitrepositorypattern.network.Resource
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    @Inject
    lateinit var loginRepository: LoginRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MyApplication).getRepositoryComponent().inject(this)

        loginRepository.doLogin("9876543210", "123").observe(this, Observer {
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
