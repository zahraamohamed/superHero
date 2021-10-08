package com.example.superhero.ui.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.superhero.R
import com.example.superhero.databinding.ItemHeroBinding
import com.example.superhero.model.responce.Result
import com.example.superhero.model.responce.SuperheroResponce


class HeroAdapter(private val heroList: List<Result>)
    : BaseAdapter<Result>(heroList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_hero,parent,false)
        return HeroHolder(itemView)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val currentHero = heroList[position]
        if (holder is HeroHolder ) bindData(holder , currentHero)

    }
    private fun bindData(holder:HeroHolder,result:Result){
        holder.binding.apply {
            heroName.text = result.name
            Glide.with(root.context).load(result.image?.url)
                .into(heroImage)
        }
    }


    class HeroHolder(itemView: View) :BaseViewHolder(itemView) {
        val binding = ItemHeroBinding.bind(itemView)
    }




}