package matrixsystems.retrofitrepositorypattern.di;

import dagger.Module;
import dagger.Provides;
import matrixsystems.retrofitrepositorypattern.network.APIService;
import matrixsystems.retrofitrepositorypattern.network.ServiceGenerator;
import matrixsystems.retrofitrepositorypattern.repositories.LoginRepository;

import javax.inject.Singleton;

/**
 * Created by Shahbaz Hashmi on 2019-10-11.
 */
@Module
public class ApiModule {

    @Provides
    @Singleton
    LoginRepository provideLoginRepository() {
        return new LoginRepository(ServiceGenerator.createService(APIService.class));
    }

}
