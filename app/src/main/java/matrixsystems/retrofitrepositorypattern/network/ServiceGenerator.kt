package matrixsystems.retrofitrepositorypattern.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Shahbaz Hashmi on 2019-10-09.
 */
object ServiceGenerator {

    private val BASE_URL = "http://cubictreesmart.com/API/"

    const val NETWORK_TIMEOUT = 30L;

    private val builder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())

    var retrofit = builder.build()


    private val logging by lazy {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        logging
    }

    private val httpClient = OkHttpClient.Builder()
        .connectTimeout(NETWORK_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(NETWORK_TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(NETWORK_TIMEOUT, TimeUnit.SECONDS)

    @JvmStatic
    fun <S> createService(
        serviceClass: Class<S>
    ): S {
        if (!httpClient.interceptors().contains(logging)) {
            httpClient.addInterceptor(logging)
            builder.client(httpClient.build())
            retrofit = builder.build()
        }

        return retrofit.create(serviceClass)
    }

}