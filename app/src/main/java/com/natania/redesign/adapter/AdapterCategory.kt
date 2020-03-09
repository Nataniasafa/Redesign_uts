package com.natania.redesign.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.natania.redesign.R
import com.natania.redesign.model.ModelCategory
import kotlinx.android.synthetic.main.item_mini.view.*

class AdapterCategory (private val listCategory: ArrayList<ModelCategory>) :
    RecyclerView.Adapter<AdapterCategory.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mini, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listCategory.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
holder.bindlist(listCategory[position])    }
    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
            fun bindlist(category:ModelCategory){
                with(itemView){
                    Glide.with(itemView.context)
                        .load(category.img_category)
                        .apply(RequestOptions().override(500))
                        .into(iv_main_2)

                    tv_name_2.text = category.name_category
                }
            }
    }

}