package matrixsystems.retrofitrepositorypattern

import android.app.Application
import matrixsystems.retrofitrepositorypattern.di.RepositoryComponent
import matrixsystems.retrofitrepositorypattern.di.RepositoryModule
import matrixsystems.retrofitrepositorypattern.di.DaggerRepositoryComponent

/**
 * Created by Shahbaz Hashmi on 2019-10-11.
 */
class MyApplication : Application() {

    lateinit var repositoryComponent: RepositoryComponent
        private set

    override fun onCreate() {
        super.onCreate()

        repositoryComponent = DaggerRepositoryComponent.builder()
            .repositoryModule(RepositoryModule())
            .build()
    }
}