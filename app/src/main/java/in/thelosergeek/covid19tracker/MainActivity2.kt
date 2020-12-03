package `in`.thelosergeek.covid19tracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        stat.setOnClickListener {
             startActivity(Intent(this,MainActivity::class.java))

        }




        //fetchResults()

//        val OkHttpClient = OkHttpClient()
//
//        val request = Request.Builder().url("https://api.covid19india.org/data.json").build()
//
//        GlobalScope.launch(Dispatchers.Main) {
//            val response = OkHttpClient.newCall(request).execute().body?.string()
//
//
//            val obj = JSONObject(response)
//
//            val gson =
//                GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
//                    .create()
//
//            val user = gson.fromJson<Response>(response, Response::class.java)
//
//            val dailyconfirmed = obj.getString("deaths")
//
//            Log.i("Daily confirmed", obj.getString("dailyconfirmed"))
//            Log.i("Dail","$(dailyconfirmed)")


    }

//    private fun fetchResults() {
//        GlobalScope.launch {
//            val response = withContext(Dispatchers.IO) { Client.api.execute() }
//
//            if (response.isSuccessful) {
//                Log.i("Response", "$response")
//            }
//        }
//    }
}