package com.example.shoeverse2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoeverse2.data.model.Items
import com.google.firebase.database.FirebaseDatabase

class ItemsViewModel : ViewModel() {

    private val _items = MutableLiveData<List<Items>>()
    val items: LiveData<List<Items>> get() = _items

    init {
        fetchItems()
    }

    private fun fetchItems() {
        val database = FirebaseDatabase.getInstance()
        val itemsRef = database.getReference("Items")

        itemsRef.get().addOnSuccessListener { snapshot ->
            val itemList = snapshot.children.mapNotNull { it.getValue(Items::class.java) }
            _items.value = itemList
        }.addOnFailureListener { exception ->
            // Log hata mesajını burada yazabilirsiniz
            exception.printStackTrace()
        }
    }
}
