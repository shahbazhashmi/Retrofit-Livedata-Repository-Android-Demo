package matrixsystems.retrofitrepositorypattern.network

import matrixsystems.retrofitrepositorypattern.models.LoginRequest
import retrofit2.Call
import retrofit2.http.*


/**
 * Created by Shahbaz Hashmi on 2019-10-09.
 */
interface APIService {

    @POST("MobileAPI/TokenLogin")
    fun doLogin(@Body request : LoginRequest): Call<APIResponse>

}