package `in`.thelosergeek.covid19tracker

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import okhttp3.Request
import okhttp3.OkHttpClient
import org.json.JSONObject

object Client {
    private val OkHttpClient = OkHttpClient()

    private val request = Request.Builder().url("https://api.covid19india.org/data.json").build()

    val api = OkHttpClient.newCall(request)
//
//    val obj = JSONObject(response)
//
//    val gson = GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()
//
//    val user = gson.fromJson<User>(response,User::class.java)
//
//    val dailyconfirmed = obj.getString("dailyconfirmed")




}