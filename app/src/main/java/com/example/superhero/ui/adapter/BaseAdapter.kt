package com.example.superhero.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.superhero.ui.ITransferData

abstract class BaseAdapter<T>(private val list:List<T>, val listener:ITransferData):
    RecyclerView.Adapter<BaseAdapter.BaseViewHolder>() {

    override fun getItemCount(): Int = list.size

    abstract class BaseViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){}

}