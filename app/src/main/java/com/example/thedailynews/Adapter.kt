package com.example.thedailynews

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.layout_item.view.*

class Adapter(var context: Context?, var modelClassArrayList: ArrayList<ModelClass>): RecyclerView.Adapter<Adapter.ViewHolder>(){
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        holder.itemView.apply {
            cardView.setOnClickListener{
               Intent(context, webView::class.java).also {
                   it.putExtra("url",modelClassArrayList.get(position).url)
                   context.startActivity(it)
               }
            }

            author.text = modelClassArrayList.get(position).author
            mainheading.text = modelClassArrayList.get(position).title
            Glide.with(context)
                .load(modelClassArrayList.get(position).urlToImage)
                .into(imageView)

            shareNews.setOnClickListener{
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT,"${modelClassArrayList.get(position).title} \n Author: ${modelClassArrayList.get(position).author} \n Link: ${modelClassArrayList.get(position).url}")
                val chooser = Intent.createChooser(intent,"Share With")
                context.startActivity(chooser)
            }

        }
    }



    override fun getItemCount(): Int {
        return modelClassArrayList.size
    }

}