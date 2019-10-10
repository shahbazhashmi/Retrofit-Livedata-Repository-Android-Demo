package matrixsystems.retrofitrepositorypattern.di;

import dagger.Component;
import matrixsystems.retrofitrepositorypattern.MainActivity;

import javax.inject.Singleton;

/**
 * Created by Shahbaz Hashmi on 2019-10-11.
 */
@Singleton
@Component(modules = {RepositoryModule.class})
public interface RepositoryComponent {
    void inject(MainActivity activity);
}
