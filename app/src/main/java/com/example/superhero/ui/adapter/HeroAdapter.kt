package com.example.superhero.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.superhero.R
import com.example.superhero.databinding.ItemHeroBinding
import com.example.superhero.model.responce.Result
import com.example.superhero.ui.IHomeListener

class HeroAdapter(private val heroList: List<Result>, listener: IHomeListener) :
    BaseAdapter<Result>(heroList, listener) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_hero, parent, false)
        return HeroHolder(itemView)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val currentHero = heroList[position]
        if (holder is HeroHolder) bindData(holder, currentHero)

    }

    @SuppressLint("SetTextI18n")
    private fun bindData(holder: HeroHolder, result: Result) {
        holder.binding.apply {
            fullName.text = result.name
            name.text = result.biography?.fullName
            strength.text = "${result.powerstats?.strength}/100"
            speed.text = "${result.powerstats?.speed}/100"
            power.text = "${result.powerstats?.power}/100"

            Glide.with(root.context).load(result.image?.url)
                .placeholder(R.drawable.elev_shape)
                .into(heroImage)

            cardRecycler.setOnClickListener {
                listener.onClickItem(data = result)

            }
        }
    }

    class HeroHolder(itemView: View) : BaseViewHolder(itemView) {
        val binding = ItemHeroBinding.bind(itemView)
    }
}