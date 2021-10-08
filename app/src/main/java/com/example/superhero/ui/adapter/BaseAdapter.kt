package com.example.superhero.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T>(private val list:List<T>):
    RecyclerView.Adapter<BaseAdapter.BaseViewHolder>() {

    override fun getItemCount(): Int = list.size

    abstract class BaseViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){}

}