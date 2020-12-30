package com.example.android4a.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android4a.R
import com.example.android4a.domain.entity.Episode
import kotlinx.android.synthetic.main.row_layout.view.*

class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    private var myList = emptyList<Episode>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.title_txt.text = "Title: " + myList[position].title.toString()
        holder.itemView.episode_number_txt.text = "Episode: " + myList[position].episode.toString()
        holder.itemView.synopsis_txt.text = "Synopsis: " + myList[position].description.toString()
        holder.itemView.dysney_url.text = "Disneyplus url: " + myList[position].disneyplus_url.toString()
    }

    fun setData(newList: List<Episode>){
        myList = newList
        notifyDataSetChanged()
    }
}