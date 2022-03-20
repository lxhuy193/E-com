package com.example.bottomnavwithfragment.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomnavwithfragment.*
import com.smarteist.autoimageslider.SliderView

class DashbroadFragment : Fragment() {
    companion object {
        var mProductView = arrayOf<ProductContent>(
            ProductContent(0, "Sample Product One", "234.868", R.drawable.product),
            ProductContent(1, "Sample Product Two", "234.868", R.drawable.product),
            ProductContent(2, "Sample Product Three", "234.868", R.drawable.product),
            ProductContent(3, "Sample Product Four", "234.868", R.drawable.product),
            ProductContent(4, "Sample Product Five", "234.868", R.drawable.product),
            ProductContent(5, "Sample Product Six", "234.868", R.drawable.product),
            ProductContent(6, "Sample Product Seven", "234.868", R.drawable.product),
            ProductContent(7, "Sample Product Eight", "234.868", R.drawable.product),
        )
    }

    //    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter_vertical = VerRecyclerAdapter(mProductView)
    private var adapter_horizontal = HorRecyclerAdapter(mProductView)
    private var adapter_slider = MySliderImgAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        var rv_horizontal = view.findViewById<RecyclerView>(R.id.recycler_horizontal)
        rv_horizontal.adapter = adapter_horizontal
        rv_horizontal.layoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
        //onclickitem
        adapter_horizontal.onItemClick = { productContent ->
            Log.d("TAG", productContent.name)
            val intent = Intent(activity, ProductdetailActivity::class.java)
            intent.putExtra("idKey", productContent.id)

            activity?.startActivity(intent)

        }

        var rv_vertical = view.findViewById<RecyclerView>(R.id.recycler_vertical)
        rv_vertical.adapter = adapter_vertical
        rv_vertical.layoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        //onclickitem
        adapter_vertical.onItemClick = { productContent ->
            Log.d("TAG2", productContent.name)
            val intent = Intent(activity, ProductdetailActivity::class.java)
            intent.putExtra("idKey", productContent.id)

            activity?.startActivity(intent)
        }

        //SET IMAGE SLIDER
        var imgSlider = view.findViewById<SliderView>(R.id.imageSlider)
        imgSlider.setSliderAdapter(adapter_slider)
        imgSlider.isAutoCycle = true
        imgSlider.startAutoCycle()

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashbroad, container, false)

        //
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.appbar_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.nav_noti) {
            Toast.makeText(activity, "Clicked notifications", Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }

}