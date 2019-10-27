package matrixsystems.retrofitrepositorypattern.di

import matrixsystems.retrofitrepositorypattern.di.RepositoryComponent
import matrixsystems.retrofitrepositorypattern.di.RepositoryModule
import matrixsystems.retrofitrepositorypattern.di.DaggerRepositoryComponent

/**
 * Created by Shahbaz Hashmi on 2019-10-11.
 */
object DIManager {

    lateinit var repositoryComponent: RepositoryComponent
        private set


    fun init() {
        repositoryComponent = DaggerRepositoryComponent.builder()
            .build()
    }

}