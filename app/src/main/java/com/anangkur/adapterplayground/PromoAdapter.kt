package com.anangkur.adapterplayground

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anangkur.adapterplayground.databinding.ItemPromoBinding

class PromoAdapter: RecyclerView.Adapter<PromoAdapter.PromoViewHolder>() {

    private val items = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromoViewHolder {
        val binding = ItemPromoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PromoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PromoViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class PromoViewHolder(private val binding: ItemPromoBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: String) {

        }
    }

    fun setItems(data: List<String>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }
}