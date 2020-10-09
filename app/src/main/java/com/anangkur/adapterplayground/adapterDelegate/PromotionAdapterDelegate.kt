package com.anangkur.adapterplayground.adapterDelegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anangkur.adapterplayground.childAdapter.PromoAdapter
import com.anangkur.adapterplayground.databinding.ItemPromotionBinding
import com.anangkur.adapterplayground.model.DelegateAdapterItem
import com.anangkur.adapterplayground.model.Promotion

class PromotionAdapterDelegate: DelegateAdapter<Promotion, PromotionAdapterDelegate.PromotionViewHolder>(Promotion::class.java) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val binding = ItemPromotionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PromotionViewHolder(binding)
    }

    override fun bindViewHolder(
        model: Promotion,
        viewHolder: PromotionViewHolder,
        payloads: List<DelegateAdapterItem.Payloadable>
    ) {
        viewHolder.bind(model)
    }

    inner class PromotionViewHolder(private val binding: ItemPromotionBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Promotion) {
            val promoAdapter = PromoAdapter()
            binding.recyclerPromo.apply {
                adapter = promoAdapter
                itemAnimator = DefaultItemAnimator()
                layoutManager = LinearLayoutManager(itemView.context, RecyclerView.HORIZONTAL, false)
            }
            promoAdapter.setItems(item.promos)
            binding.tvTitle.text = item.title
            binding.tvAppName.text = item.app.name
            binding.tvAppDeveloper.text = item.app.developer
            binding.tvAppRating.text = item.app.size.toString()
        }
    }
 }