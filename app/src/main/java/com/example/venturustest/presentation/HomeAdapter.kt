package com.example.venturustest.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.venturustest.R
import com.example.venturustest.components.HorizontalTextIconView
import com.example.venturustest.data.GalleryItem
import com.squareup.picasso.Picasso

class HomeAdapter: RecyclerView.Adapter<HomeViewHolder>() {

    private val data = mutableListOf<GalleryItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder( LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_card_view, parent, false) )
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setData(items: List<GalleryItem>) {
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }

}


class HomeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind(item: GalleryItem) {

        val imageView = itemView.findViewById<ImageView>(R.id.iv_banner)

        Picasso.get().load(item.urlImage).into(imageView)

        itemView.findViewById<HorizontalTextIconView>(R.id.top_component).setValue(item.points)
        itemView.findViewById<HorizontalTextIconView>(R.id.comment_component).setValue(item.qtdComments)
        itemView.findViewById<HorizontalTextIconView>(R.id.eye_component).setValue(item.views)
    }
}