package com.example.bottomnavwithfragment.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomnavwithfragment.ProductContent
import com.example.bottomnavwithfragment.ProductdetailActivity
import com.example.bottomnavwithfragment.R
import com.example.bottomnavwithfragment.VerRecyclerAdapter

class SearchFragment : Fragment() {

    private val adapter_vertical = VerRecyclerAdapter(DashbroadFragment.mProductView)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var rcv_vertical = view.findViewById<RecyclerView>(R.id.rcv_search_vertical)
        rcv_vertical.adapter = adapter_vertical
        rcv_vertical.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)

        //onclickitem
        adapter_vertical.onItemClick = { productContent ->
            val intent = Intent(activity, ProductdetailActivity::class.java)
            intent.putExtra("idKey", productContent.id)
            startActivity(intent)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }
}