package com.cs4520.assignment1

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProductListFragment : Fragment() {

    /*
    productsDataset is a list of products where each product is a listOf(name, type, expiryDate, price)
    convert the productsDataset to a list of Product objects
    */

    /*
    */

    private val data = productsDataset.map {
        val productName : String = it[0] as String
        //val productType : String = it[1] as String
        val productExpiryDate : String? = it[2] as String?
        val productPrice = it[3] as Int

        if (it[1] == "Food") {
            Product.FoodProduct(productName, productExpiryDate, productPrice)
        } else {
            Product.EquipmentProduct(productName, productPrice)
        }
    }

    private var productsAdapter = ProductAdapter(data)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_product_list, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.productRecyclerView)
        recyclerView.adapter = productsAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        return view
    }

    /*
override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_product_list, container, false)
        return view
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_product_list, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.productRecyclerView)
        recyclerView.adapter = productsAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        return view
    }
    */
}