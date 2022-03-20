package com.example.bottomnavwithfragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HorRecyclerAdapter(private val mProductContent: Array<ProductContent>) : RecyclerView.Adapter<HorRecyclerAdapter.ViewHolder>() {
//    private var names = arrayOf(
//        "Sample Product One",
//        "Sample Product Two",
//        "Sample Product Three",
//        "Sample Product Four",
//        "Sample Product Five",
//        "Sample Product Six",
//        "Sample Product Seven",
//        "Sample Product Eight"
//    )
//    private var prices = arrayOf(
//        "234.868",
//        "234.868",
//        "234.868",
//        "234.868",
//        "234.868",
//        "234.868",
//        "234.868",
//        "234.868"
//    )
//    private var images = arrayOf(
//        R.drawable.product,
//        R.drawable.product,
//        R.drawable.product,
//        R.drawable.product,
//        R.drawable.product,
//        R.drawable.product,
//        R.drawable.product,
//        R.drawable.product
//    )

    //item Click listener
    var onItemClick: ((ProductContent)->Unit) ?= null

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tvHorName: TextView = itemView.findViewById(R.id.tv_horizontal_name)
        var tvHorPrice: TextView = itemView.findViewById(R.id.tc_horizontal_price)
        var imgHor: ImageView = itemView.findViewById(R.id.img_horizontal)

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(mProductContent[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HorRecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_horizontal, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: HorRecyclerAdapter.ViewHolder, position: Int) {
        holder.tvHorName.text = mProductContent[position].name
        holder.tvHorPrice.text = mProductContent[position].price
        holder.imgHor.setImageResource(mProductContent[position].image)
    }


    override fun getItemCount(): Int {
        return mProductContent.size
    }
}