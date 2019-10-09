package matrixsystems.retrofitrepositorypattern.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST


/**
 * Created by Shahbaz Hashmi on 2019-10-09.
 */
interface APIService {

    @POST("/login")
    fun doLogin(username : String, password : String): Call<APIResponse>

}