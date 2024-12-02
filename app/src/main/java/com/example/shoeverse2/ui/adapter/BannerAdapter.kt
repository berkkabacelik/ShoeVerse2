package com.example.shoeverse2.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shoeverse2.R
import com.example.shoeverse2.data.model.Banner
import com.example.shoeverse2.databinding.ItemBannerBinding
import com.google.android.material.imageview.ShapeableImageView

class BannerAdapter : RecyclerView.Adapter<BannerAdapter.BannerViewHolder>() {

    private var banners: List<Banner> = emptyList()

    fun submitList(newBanners: List<Banner>) {
        banners = newBanners
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val binding = ItemBannerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BannerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        val banner = banners[position]
        Glide.with(holder.itemView.context)
            .load(banner.url)
            .into(holder.binding.bannerImageView)
    }

    override fun getItemCount(): Int = banners.size

    class BannerViewHolder(val binding: ItemBannerBinding) : RecyclerView.ViewHolder(binding.root)
}
