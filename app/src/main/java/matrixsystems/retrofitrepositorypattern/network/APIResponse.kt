package matrixsystems.retrofitrepositorypattern.network

import com.google.gson.annotations.SerializedName

/**
 * Created by Shahbaz Hashmi on 2019-10-09.
 */
data class APIResponse(@SerializedName("status") val status: Int = 0, @SerializedName("msg") val msg: String? = null, @SerializedName("data") private val data : Any? = null)