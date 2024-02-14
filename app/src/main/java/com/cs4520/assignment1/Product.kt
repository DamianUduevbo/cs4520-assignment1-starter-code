package com.cs4520.assignment1

sealed class Product(val name: String, val price: Int, val type: String) {
    class FoodProduct(name: String, val expiryDate: String?, price: Int)
        : Product(name, price, "Food")
    class EquipmentProduct(name: String, price: Int)
        : Product(name, price, "Equipment")
}
