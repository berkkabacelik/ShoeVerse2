package com.example.shoeverse2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoeverse2.data.model.Category
import com.google.firebase.database.FirebaseDatabase

class CategoryViewModel : ViewModel() {

    private val _categories = MutableLiveData<List<Category>>()
    val categories: LiveData<List<Category>> get() = _categories

    init {
        fetchCategories()
    }

    private fun fetchCategories() {
        val database = FirebaseDatabase.getInstance()
        val categoryRef = database.getReference("Category")

        categoryRef.get().addOnSuccessListener { snapshot ->
            val categoryList = snapshot.children.mapNotNull { it.getValue(Category::class.java) }
            _categories.value = categoryList
        }.addOnFailureListener {
            // Hata durumunda loglama veya kullanıcıya bilgi verilebilir
        }
    }
}
