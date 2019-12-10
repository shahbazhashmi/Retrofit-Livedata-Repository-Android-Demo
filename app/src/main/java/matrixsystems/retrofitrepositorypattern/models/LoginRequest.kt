package matrixsystems.retrofitrepositorypattern.models
import android.annotation.SuppressLint
import android.os.Parcelable

import kotlinx.android.parcel.Parcelize

import com.google.gson.annotations.SerializedName


/**
 * Created by Shahbaz Hashmi on 2019-12-10.
 */
@SuppressLint("ParcelCreator")
@Parcelize
data class LoginRequest(
    @SerializedName("email")
    var email: String? = "",
    @SerializedName("lang")
    var lang: String? = "",
    @SerializedName("lat")
    var lat: String? = "",
    @SerializedName("password")
    var password: String? = "",
    @SerializedName("source")
    var source: String? = ""
) : Parcelable