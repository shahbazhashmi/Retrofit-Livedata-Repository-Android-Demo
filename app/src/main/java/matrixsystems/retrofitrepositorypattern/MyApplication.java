package matrixsystems.retrofitrepositorypattern;

import android.app.Application;
import matrixsystems.retrofitrepositorypattern.di.RepositoryComponent;
import matrixsystems.retrofitrepositorypattern.di.RepositoryModule;
import matrixsystems.retrofitrepositorypattern.di.DaggerRepositoryComponent;

/**
 * Created by Shahbaz Hashmi on 2019-10-11.
 */
public class MyApplication extends Application {

    private RepositoryComponent mRepositoryComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mRepositoryComponent = DaggerRepositoryComponent.builder()
                .repositoryModule(new RepositoryModule())
                .build();
    }

    public RepositoryComponent getRepositoryComponent() {
        return mRepositoryComponent;
    }
}