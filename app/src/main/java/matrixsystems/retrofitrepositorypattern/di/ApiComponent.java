package matrixsystems.retrofitrepositorypattern.di;

import dagger.Component;
import matrixsystems.retrofitrepositorypattern.MainActivity;

import javax.inject.Singleton;

/**
 * Created by Shahbaz Hashmi on 2019-10-11.
 */
@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface ApiComponent {
    void inject(MainActivity activity);
}
