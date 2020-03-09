package com.natania.redesign.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.natania.redesign.R
import com.natania.redesign.model.ModelVirus
import kotlinx.android.synthetic.main.item_row.view.*

class AdapterVirus(private val listVirus: ArrayList<ModelVirus>) :
    RecyclerView.Adapter<AdapterVirus.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listVirus.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindlist(listVirus[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindlist(virus: ModelVirus) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(virus.img)
                    .apply(RequestOptions().override(500))
                    .into(iv_main)

                tv_name.text = virus.name
                tv_price.text = virus.price
            }
        }

    }

}

