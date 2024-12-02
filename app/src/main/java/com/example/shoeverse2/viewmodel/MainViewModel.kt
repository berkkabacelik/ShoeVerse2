package com.example.shoeverse2.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoeverse2.data.model.Banner
import com.google.firebase.database.FirebaseDatabase

class MainViewModel : ViewModel() {

    private val _banners = MutableLiveData<List<Banner>>()
    val banners: LiveData<List<Banner>> get() = _banners

    init {
        fetchBanners()
    }

    private fun fetchBanners() {
        val database = FirebaseDatabase.getInstance()
        val bannerRef = database.getReference("Banner")

        bannerRef.get().addOnSuccessListener { snapshot ->
            val bannerList = snapshot.children.mapNotNull { it.getValue(Banner::class.java) }
            _banners.value = bannerList
        }.addOnFailureListener {
            Log.e("MainViewModel", "Error fetching banners", it)
        }
    }

    // getBannerImages fonksiyonunu ekledik
    fun getBannerImages(): LiveData<List<Banner>> {
        return banners
    }
}
