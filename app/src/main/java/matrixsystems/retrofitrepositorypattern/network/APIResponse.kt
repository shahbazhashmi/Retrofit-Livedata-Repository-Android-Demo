package matrixsystems.retrofitrepositorypattern.network

/**
 * Created by Shahbaz Hashmi on 2019-10-09.
 */
data class APIResponse(val statusCode: Int = 0, val message: String? = null, val data : Any? = null)