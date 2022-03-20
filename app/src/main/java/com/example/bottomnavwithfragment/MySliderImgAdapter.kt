package com.example.bottomnavwithfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.smarteist.autoimageslider.SliderView
import com.smarteist.autoimageslider.SliderViewAdapter
import com.squareup.picasso.Picasso

class MySliderImgAdapter() : SliderViewAdapter<MySliderImgAdapter.MyViewHolder>() {
    private var sliderItemsArray = ArrayList<Int>()
    init {
        sliderItemsArray.add(R.drawable.slider1)
        sliderItemsArray.add(R.drawable.slider2)
        sliderItemsArray.add(R.drawable.slider3)
        sliderItemsArray.add(R.drawable.slider4)
        sliderItemsArray.add(R.drawable.slider5)
    }
//    private var mSliderItems = ArrayList<String>()
//
//        fun renewItems (sliderItems: ArrayList<String>){
//        mSliderItems = sliderItems
//        notifyDataSetChanged()
//    }
//
//    fun addItem(sliderItem : String) {
//        mSliderItems.add(sliderItem)
//        notifyDataSetChanged()
//    }


    inner class MyViewHolder(view: View) : ViewHolder(view) {
        val imageSlider = view.findViewById<ImageView>(R.id.imageSlider)
    }

    override fun getCount(): Int {
        return sliderItemsArray.size
    }

    override fun onCreateViewHolder(parent: ViewGroup): MyViewHolder {
        val inflate: View =
            LayoutInflater.from(parent.context).inflate(R.layout.image_holder, parent, false)
        return MyViewHolder(inflate)
    }

    override fun onBindViewHolder(viewHolder: MyViewHolder, position: Int) {
//        viewHolder.imageSlider.setImageResource(mSliderItems[position].toInt())
        Picasso.get().load(sliderItemsArray[position]).fit().into(viewHolder.imageSlider)
    }
}