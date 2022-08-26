package com.example.secondscreen.presentation.adapter

import android.media.Image
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.secondscreen.databinding.RvitemBinding

class ImagesAdapter: ListAdapter<String, ImagesAdapter.ImagesViewHolder>(GalleryItemDiffCall()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolder {
        return ImagesViewHolder(
            RvitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ImagesViewHolder(private val binding: RvitemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(image: String){
            binding.imageItem.load(image)
        }
    }
}

class GalleryItemDiffCall : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String) = oldItem == newItem

    override fun areContentsTheSame(oldItem: String, newItem: String) =
        oldItem == newItem
}