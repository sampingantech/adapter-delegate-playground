package com.anangkur.adapterplayground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anangkur.adapterplayground.adapterDelegate.BannerAdapterDelegate
import com.anangkur.adapterplayground.adapterDelegate.CampaignAdapterDelegate
import com.anangkur.adapterplayground.adapterDelegate.FeaturedAdapterDelegate
import com.anangkur.adapterplayground.adapterDelegate.PromotionAdapterDelegate
import com.anangkur.adapterplayground.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel
    private val adapter by lazy {
        MainCompositeAdapter.Builder()
            .add(BannerAdapterDelegate())
            .add(CampaignAdapterDelegate())
            .add(FeaturedAdapterDelegate())
            .add(PromotionAdapterDelegate())
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
        setupAdapter()
        observeViewModel()
        viewModel.createDummyDisplayableItems()
    }

    private fun setupViewModel() {
        viewModel = MainViewModel()
    }

    private fun setupAdapter() {
        binding.recyclerMain.apply {
            adapter = this@MainActivity.adapter
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
            itemAnimator = DefaultItemAnimator()
        }
    }

    private fun observeViewModel() {
        viewModel.apply {
            displayableItems.observe(this@MainActivity, {
                adapter.submitList(it)
            })
        }
    }
}