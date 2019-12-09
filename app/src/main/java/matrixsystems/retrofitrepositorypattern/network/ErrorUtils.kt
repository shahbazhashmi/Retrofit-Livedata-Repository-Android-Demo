package matrixsystems.retrofitrepositorypattern.network


import android.text.TextUtils
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Response
import java.io.IOException


/**
 * Created by Shahbaz Hashmi on 2019-10-09.
 */
object ErrorUtils {

    val ERROR_TEXT = "something went wrong !!!"

    fun getError() : APIError = APIError(420, ERROR_TEXT)

    fun parseError(response: Response<*>): APIError {
        val converter : Converter<ResponseBody, APIError> = ServiceGenerator.retrofit
            .responseBodyConverter(APIError::class.java, arrayOfNulls<Annotation>(0))

        var error: APIError? = null

        try {
            if(response.errorBody() != null) {
                error = converter.convert(response.errorBody()!!)
            }
            if(error == null || TextUtils.isEmpty(error.message)) {
                throw IOException("null error body")
            }
        } catch (e: Exception) {
            e.printStackTrace()
            error = APIError(404, ERROR_TEXT)
        }

        return error!!
    }

}