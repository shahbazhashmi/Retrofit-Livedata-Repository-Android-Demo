package matrixsystems.retrofitrepositorypattern.network

/**
 * Created by Shahbaz Hashmi on 2019-10-09.
 */
class LoginRepository(var apiService: APIService){
    fun doLogin(username: String, password : String) = NetworkCall<APIResponse>().makeCall(apiService.doLogin(username, password))
}