package matrixsystems.retrofitrepositorypattern.network

import retrofit2.Call
import retrofit2.http.*


/**
 * Created by Shahbaz Hashmi on 2019-10-09.
 */
interface APIService {

    @POST("/login")
    @FormUrlEncoded
    fun doLogin(@Field("username") username : String, @Field("password") password : String): Call<APIResponse>

}