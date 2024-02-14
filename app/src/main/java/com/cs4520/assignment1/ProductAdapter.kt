package com.cs4520.assignment1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/* ProductAdapter is a RecyclerView adapter that displays a list of products */
// product data is in a file Dataset.kt
class ProductAdapter(private val productList: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productImageView: ImageView = itemView.findViewById(R.id.productTypeImage)
        val productNameTextView: TextView = itemView.findViewById(R.id.productName)
        val productPriceTextView: TextView = itemView.findViewById(R.id.productPrice)
        val productExpiryDateTextView: TextView = itemView.findViewById(R.id.expiryDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.productImageView.setImageResource(
            when (product.type) {
                "Food" -> R.drawable.food
                "Equipment" -> R.drawable.equipment
                else -> R.drawable.ic_launcher_foreground
            }
        )
        holder.productNameTextView.text = product.name
        holder.productPriceTextView.text = "$${product.price}"

        if (product is Product.FoodProduct) {
            holder.productExpiryDateTextView.text = product.expiryDate
            // set background color to #FFD965 if it's food
            holder.itemView.setBackgroundResource(R.color.yellow)
        } else {
            holder.productExpiryDateTextView.text = ""
            holder.itemView.setBackgroundResource(R.color.red)
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }


}