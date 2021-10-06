package com.example.superhero.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.superhero.R
import com.example.superhero.databinding.ItemHeroBinding
import com.example.superhero.model.responce.SuperheroResponce

class HeroAdapter(private val heroList: List<SuperheroResponce>) : RecyclerView.Adapter<HeroAdapter.HeroHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_hero,parent,false)
        return HeroHolder(itemView)
    }

    override fun onBindViewHolder(holder: HeroHolder, position: Int) {
        val currentHero = heroList[position].results?.get(position)
        holder.binding.apply {
            heroName.text = currentHero?.name
            Glide.with(root.context).load(currentHero?.image?.url).into(heroImage)
        }
    }
    override fun getItemCount(): Int = heroList.size

    class HeroHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemHeroBinding.bind(itemView)
    }
}