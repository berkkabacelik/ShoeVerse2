package com.example.shoeverse2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoeverse2.R
import com.example.shoeverse2.databinding.FragmentMainBinding
import com.example.shoeverse2.ui.adapter.BannerAdapter


class MainFragment : Fragment(R.layout.fragment_main) {

    // Binding ve ViewModel
    private lateinit var binding: FragmentMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Binding başlatma
        binding = FragmentMainBinding.bind(view)

        // ViewModel başlatma
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        // Banner'ı başlatmak için gerekli işlemler
        setupBanner()


    }

    // Banner'ı başlatmak ve veriyi Firebase'den alıp ViewPager2'ye bağlamak
    private fun setupBanner() {
        val bannerAdapter = BannerAdapter()
        binding.viewPagerBanner.adapter = bannerAdapter

        // Firebase'den banner verilerini alıp adapter'e gönderiyoruz
        viewModel.getBannerImages().observe(viewLifecycleOwner) { bannerList ->
            bannerAdapter.submitList(bannerList)
        }
    }


}

