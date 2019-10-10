package matrixsystems.retrofitrepositorypattern.repositories

import matrixsystems.retrofitrepositorypattern.network.APIResponse
import matrixsystems.retrofitrepositorypattern.network.APIService
import matrixsystems.retrofitrepositorypattern.network.NetworkCall

/**
 * Created by Shahbaz Hashmi on 2019-10-09.
 */
class LoginRepository(var apiService: APIService){
    fun doLogin(username: String, password : String) = NetworkCall<APIResponse>().makeCall(apiService.doLogin(username, password))
}