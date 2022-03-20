package com.example.bottomnavwithfragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomnavwithfragment.fragments.CartFragment
import com.example.bottomnavwithfragment.fragments.DashbroadFragment

class ProductdetailActivity : AppCompatActivity() {
    //recyclerView
    private var adapter_horizontal = HorRecyclerAdapter(DashbroadFragment.mProductView)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productdetail)
        var rv_horizontal = findViewById<RecyclerView>(R.id.rcv_detail)
        rv_horizontal.adapter = adapter_horizontal
        rv_horizontal.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        //INTENT
        val intent = getIntent()
        val id: Int = intent.getIntExtra("idKey", 1)

        val detailName = findViewById<TextView>(R.id.tv_detail_name)
        val detailPrice = findViewById<TextView>(R.id.tv_detail_price)
        val detailImage = findViewById<ImageView>(R.id.img_productdetail)

        detailName.text = DashbroadFragment.mProductView[id].name
        detailPrice.text = DashbroadFragment.mProductView[id].price
        detailImage.setImageResource(DashbroadFragment.mProductView[id].image)

        //add to cart btn
//        val addCartBtn = findViewById<ImageButton>(R.id.btn_detail_addtocart)
//        val cartFragment: CartFragment = CartFragment()
//        addCartBtn.setOnClickListener {
//            supportFragmentManager.beginTransaction().replace(com.google.android.material.R.id.container, cartFragment)
//                .commit()
//        }

        //back button
        val backBtn = findViewById<ImageButton>(R.id.btn_detail_back)
        backBtn.setOnClickListener {
            finish()
        }

    }
}