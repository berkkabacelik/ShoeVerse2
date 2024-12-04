package com.example.shoeverse2.data.model

data class Items(
    val title: String = "",          // Ürün başlığı
    val description: String = "",    // Ürün açıklaması
    val price: Int = 0,             // Ürün fiyatı
    val rating: Double = 0.0,        // Ürün derecelendirmesi
    val size: List<String> = listOf(),  // Ürün beden listesi
    val picUrl: List<String> = listOf() // Resim URL'leri
)
