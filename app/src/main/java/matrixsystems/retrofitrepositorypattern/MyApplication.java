package matrixsystems.retrofitrepositorypattern;

import android.app.Application;
import matrixsystems.retrofitrepositorypattern.di.ApiComponent;
import matrixsystems.retrofitrepositorypattern.di.ApiModule;
import matrixsystems.retrofitrepositorypattern.di.AppModule;
import matrixsystems.retrofitrepositorypattern.di.DaggerApiComponent;

/**
 * Created by Shahbaz Hashmi on 2019-10-11.
 */
public class MyApplication extends Application {

    private ApiComponent mApiComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApiComponent = DaggerApiComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule())
                .build();
    }

    public ApiComponent getNetComponent() {
        return mApiComponent;
    }
}