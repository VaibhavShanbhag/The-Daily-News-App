package com.example.thedailynews

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.businessfragment.*
import kotlinx.android.synthetic.main.businessfragment.*
import kotlinx.android.synthetic.main.homefragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BusinessFragment: Fragment(){
    val api: String = "cc14586d925f451d838347dfebcd93e7"
    lateinit var modelClassArrayList: ArrayList<ModelClass>
    val country: String = "in"
    val category: String = "business"
    lateinit var adapter: Adapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v: View = inflater.inflate(R.layout.businessfragment,null)

        modelClassArrayList = ArrayList<ModelClass>()
        adapter = Adapter(context,modelClassArrayList)
        recyclerviewbusiness?.adapter = adapter
        recyclerviewbusiness?.layoutManager = LinearLayoutManager(context)
        findNews()

        return v
    }

    private fun findNews() {
        val news = NewsService.newsInstance.getCategoryNews(country,category,100,api)
        news.enqueue(object : Callback<MainNews> {
            override fun onResponse(call: Call<MainNews>, response: Response<MainNews>) {
                if (response.isSuccessful){
                    response.body()?.articles?.let { modelClassArrayList.addAll(it) }
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<MainNews>, t: Throwable) {

            }

        })



    }

}