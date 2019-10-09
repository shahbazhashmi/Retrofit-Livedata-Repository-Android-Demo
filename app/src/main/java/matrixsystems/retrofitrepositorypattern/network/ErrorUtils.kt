package matrixsystems.retrofitrepositorypattern.network


import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Response
import java.io.IOException


/**
 * Created by Shahbaz Hashmi on 2019-10-09.
 */
object ErrorUtils {

    fun parseError(response: Response<*>): APIError {
        val converter : Converter<ResponseBody, APIError> = ServiceGenerator.retrofit
            .responseBodyConverter(APIError::class.java, arrayOfNulls<Annotation>(0))

        var error: APIError?

        try {
            error = converter.convert(response.errorBody())
            if(error == null) {
                throw IOException("null error body")
            }
        } catch (e: IOException) {
            error = APIError(2, "data not found")
        }

        return error!!
    }

}