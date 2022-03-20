package com.example.bottomnavwithfragment.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomnavwithfragment.CartRecyclerAdapter
import com.example.bottomnavwithfragment.R

class CartFragment : Fragment() {
    private var adapter_cart = CartRecyclerAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cartRecycleView = view.findViewById<RecyclerView>(R.id.cart_recycleview_vertical)
        cartRecycleView.adapter = adapter_cart
        cartRecycleView.layoutManager = LinearLayoutManager(view.context,LinearLayoutManager.VERTICAL,false)
    }
}