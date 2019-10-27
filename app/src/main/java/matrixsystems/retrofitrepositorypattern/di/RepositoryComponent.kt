package matrixsystems.retrofitrepositorypattern.di

import android.app.Application
import dagger.Component

import javax.inject.Singleton

/**
 * Created by Shahbaz Hashmi on 2019-10-11.
 */
@Singleton
@Component(modules = [RepositoryModule::class])
interface RepositoryComponent {
    fun inject(appContext: Application)
}
