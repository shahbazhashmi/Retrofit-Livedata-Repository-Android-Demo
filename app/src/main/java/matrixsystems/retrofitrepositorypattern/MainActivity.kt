package matrixsystems.retrofitrepositorypattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import matrixsystems.retrofitrepositorypattern.network.APIService
import matrixsystems.retrofitrepositorypattern.network.LoginRepository
import matrixsystems.retrofitrepositorypattern.network.ServiceGenerator

class MainActivity : AppCompatActivity() {

    lateinit var loginRepository: LoginRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginRepository = LoginRepository(ServiceGenerator.createService(APIService::class.java))

        loginRepository.doLogin("9097769906", "123")

    }
}
