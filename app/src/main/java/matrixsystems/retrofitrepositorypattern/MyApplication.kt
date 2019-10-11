package matrixsystems.retrofitrepositorypattern

import android.app.Application
import matrixsystems.retrofitrepositorypattern.di.DIManager

/**
 * Created by Shahbaz Hashmi on 2019-10-11.
 */
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        DIManager.init()
    }
}