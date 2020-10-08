package com.anangkur.adapterplayground

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anangkur.adapterplayground.databinding.ItemAppBinding
import com.anangkur.adapterplayground.model.App

class AppAdapter: RecyclerView.Adapter<AppAdapter.AppViewHolder>() {

    private val items = ArrayList<App>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        val binding = ItemAppBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AppViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class AppViewHolder(private val binding: ItemAppBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: App) {
            binding.tvTitle.text = data.name
            binding.tvSize.text = "${data.size} MB"
        }
    }

    fun setItems(data: List<App>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }
}