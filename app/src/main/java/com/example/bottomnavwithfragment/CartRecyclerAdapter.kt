package com.example.bottomnavwithfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class CartRecyclerAdapter : RecyclerView.Adapter<CartRecyclerAdapter.ViewHolder>() {
    private var names = arrayOf(
        "Sample Product One",
        "Sample Product Two",
        "Sample Product Three",
        "Sample Product Four",
        "Sample Product Five",
        "Sample Product Six",
        "Sample Product Seven",
        "Sample Product Eight"
    )
    private var prices = arrayOf(
        "234.868",
        "234.868",
        "234.868",
        "234.868",
        "234.868",
        "234.868",
        "234.868",
        "234.868"
    )
    private var images = arrayOf(
        R.drawable.product,
        R.drawable.product,
        R.drawable.product,
        R.drawable.product,
        R.drawable.product,
        R.drawable.product,
        R.drawable.product,
        R.drawable.product
    )

    inner class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){
        var tvCartName = itemView.findViewById<TextView>(R.id.tv_cart_name)
        var tvCartPrice = itemView.findViewById<TextView>(R.id.tv_cart_price)
        var imgCart = itemView.findViewById<ImageView>(R.id.img_cart)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CartRecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_cart,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartRecyclerAdapter.ViewHolder, position: Int) {
        holder.tvCartName.text = names[position]
        holder.tvCartPrice.text = prices[position]
        holder.imgCart.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return names.size
    }
}