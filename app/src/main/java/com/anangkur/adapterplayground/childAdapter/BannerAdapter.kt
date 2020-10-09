package com.anangkur.adapterplayground.childAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anangkur.adapterplayground.databinding.ItemBannerBinding
import com.anangkur.adapterplayground.model.Banner

class BannerAdapter: RecyclerView.Adapter<BannerAdapter.BannerViewHolder>() {

    private val items = ArrayList<Banner>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val binding = ItemBannerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BannerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class BannerViewHolder(private val binding: ItemBannerBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Banner) {
            binding.tvTitle.text = data.title
            binding.tvSubTitle.text = data.subTitle
            binding.tvDescription.text = data.description
        }
    }

    fun setItems(data: List<Banner>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }
}