package com.example.thedailynews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.entertainmentfragment.*
import kotlinx.android.synthetic.main.homefragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EntertainmentFragment: Fragment() {
    val api: String = "cc14586d925f451d838347dfebcd93e7"
    lateinit var modelClassArrayList: ArrayList<ModelClass>
    val country: String = "in"
    val category: String = "entertainment"
    lateinit var adapter: Adapter
    lateinit var recyclerViewEntertainment: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v: View = inflater.inflate(R.layout.entertainmentfragment,null)

        recyclerViewEntertainment = v.findViewById(R.id.recyclerviewentertainment)
        modelClassArrayList = ArrayList<ModelClass>()
        recyclerViewEntertainment.layoutManager = LinearLayoutManager(context)
        adapter = Adapter(context,modelClassArrayList)
        recyclerViewEntertainment.adapter = adapter

        findNews()

        return v
    }

    private fun findNews() {
        val news = NewsService.newsInstance.getCategoryNews(country, category,100,api)
        news.enqueue(object : Callback<MainNews> {
            override fun onResponse(call: Call<MainNews>, response: Response<MainNews>) {
                if (response.isSuccessful){
                    modelClassArrayList.addAll(response.body()?.articles!!)
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<MainNews>, t: Throwable) {

            }

        })



    }


}