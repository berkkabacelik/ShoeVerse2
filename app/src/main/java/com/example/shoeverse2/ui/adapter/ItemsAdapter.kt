package com.example.shoeverse2.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shoeverse2.data.model.Items
import com.example.shoeverse2.databinding.ItemProductBinding

class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ItemsViewHolder>() {

    private val itemList = mutableListOf<Items>()

    fun submitList(newItems: List<Items>) {
        itemList.clear()
        itemList.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size

    class ItemsViewHolder(private val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Items) {
            binding.title.text = item.title
            binding.price.text = "$${item.price}"
            binding.rating.text = "Rating: ${item.rating}"
            Glide.with(binding.root.context)
                .load(item.picUrl.firstOrNull()) // İlk resmi gösteriyoruz
                .into(binding.productImage)
        }
    }
}
