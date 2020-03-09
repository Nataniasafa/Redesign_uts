package com.natania.redesign.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.natania.redesign.R
import com.natania.redesign.model.ModelTerlaris
import com.natania.redesign.model.ModelVirus
import kotlinx.android.synthetic.main.item_row.view.*

class AdapterTerlaris(private val listTerlaris: ArrayList<ModelTerlaris>) :
    RecyclerView.Adapter<AdapterTerlaris.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listTerlaris.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindlist(listTerlaris[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindlist(terlaris: ModelTerlaris) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(terlaris.img_terlaris)
                    .apply(RequestOptions().override(500))
                    .into(iv_main)

                tv_name.text = terlaris.name_terlaris
                tv_price.text = terlaris.price_terlaris
            }
        }

    }

}
