package matrixsystems.retrofitrepositorypattern.network

/**
 * Created by Shahbaz Hashmi on 2019-10-09.
 */
class Resource<T> private constructor(val status: Resource.Status, val data: T?, val apiError:APIError?) {
    enum class Status {
        SUCCESS, ERROR, LOADING
    }
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }
        fun <T> error(apiError: APIError?): Resource<T> {
            return Resource(Status.ERROR, null, apiError)
        }
        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }
}