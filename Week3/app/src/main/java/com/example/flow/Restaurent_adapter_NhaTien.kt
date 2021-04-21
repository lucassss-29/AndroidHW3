package com.example.flow

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Restaurent_adapter_NhaTien : RecyclerView.Adapter<Restaurent_adapter_NhaTien.ViewHolder>(){
    //RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var data : List<Restaurant> = listOf()
    set(value){
        field = value
        notifyDataSetChanged()
    }

    /**
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        var layoutInflater  = LayoutInflater.from(parent.context)
        var view = layoutInflater.inflate(R.layout.restaurant_item_view, parent, false)
        return ViewHodler(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = data[position]
        holder.tvTitle.text = item.name
        holder.tvDescription.text = item.address
        holder.imgRestaurent.setImageResource(item.avatar)
    }

    override fun getItemCount(): Int {
        return data.size
    }
    **/


    class ViewHolder(val itemView : View) : RecyclerView.ViewHolder(itemView){
        val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        val tvDescription = itemView.findViewById<TextView>(R.id.tvDescription)
        val imgRestaurent = itemView.findViewById<ImageView>(R.id.imgRestaurant)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layoutInflater  = LayoutInflater.from(parent.context)
        var view = layoutInflater.inflate(R.layout.restaurant_item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.tvTitle.text = item.name
        holder.tvDescription.text = item.address
        holder.imgRestaurent.setImageResource(item.avatar)
    }

    override fun getItemCount(): Int {
        return data.size
    }


}