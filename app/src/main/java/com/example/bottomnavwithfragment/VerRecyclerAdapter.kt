package com.example.bottomnavwithfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VerRecyclerAdapter(private val mProductContent: Array<ProductContent>) : RecyclerView.Adapter<VerRecyclerAdapter.ViewHolder>() {

    var onItemClick: ((ProductContent)->Unit) ?= null

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvVerName: TextView = itemView.findViewById(R.id.tv_vertical_name)
        var tvVerPrice: TextView = itemView.findViewById(R.id.tc_vertical_price)
        var imgVer: ImageView = itemView.findViewById(R.id.img_vertical)

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(mProductContent[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VerRecyclerAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.card_vertical, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: VerRecyclerAdapter.ViewHolder, position: Int) {
        holder.tvVerName.text = mProductContent[position].name
        holder.tvVerPrice.text = mProductContent[position].price
        holder.imgVer.setImageResource(mProductContent[position].image)
    }

    override fun getItemCount(): Int {
        return mProductContent.size
    }

}