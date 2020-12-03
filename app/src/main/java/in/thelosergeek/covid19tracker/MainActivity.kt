package `in`.thelosergeek.covid19tracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    lateinit var resultAdapter: ResultAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list.addHeaderView(LayoutInflater.from(this).inflate(R.layout.header,list,false))

        fetchResults()
    }

//        statsbtn.setOnClickListener(View.OnClickListener {
//           val intent = Intent(this,Statistics::class.java)
//            startActivity(intent)


        private fun fetchResults() {
            GlobalScope.launch {
                val response = withContext(Dispatchers.IO) { Client.api.execute() }

                if (response.isSuccessful) {
                    val data = Gson().fromJson(response.body?.string(),Response::class.java)
                    launch(Dispatchers.Main){
                        bindData(data.statewise[0])
                        bindStateWise(data.statewise.subList(1,data.statewise.size))
                    }
                }
            }
        }

    private fun bindStateWise(subList: List<StatewiseItem>) {

        resultAdapter = ResultAdapter(subList)
        list.adapter = resultAdapter
    }

    private fun bindData(data: StatewiseItem) {
        confirmed.text = data.confirmed
        active.text = data.active
        recovered.text = data.recovered
        deceased.text = data.deaths

    }
}
