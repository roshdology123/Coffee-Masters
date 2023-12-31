package com.example.coffeemasters

class Product(var id: Int , var name: String, price: Double , var image: String){
    val imageUrl get() = "https://coffeemasters.azurewebsites.net/images/$image"
}
class Category(var name: String, products: MutableList<Product>)

class ItemInCart(var product:Product, quantity : Int)