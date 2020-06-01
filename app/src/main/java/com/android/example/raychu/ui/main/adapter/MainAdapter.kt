package com.android.example.raychu.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.example.raychu.R
import com.android.example.raychu.data.model.response.breed
import kotlinx.android.synthetic.main.item_layout.view.*

class MainAdapter(private val breeds: ArrayList<breed>,
                  private val listener: (breed) -> Unit) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(breeds: breed) {
            itemView.apply {
                textViewDogName.text = breeds.name
                textViewDogType.text = breeds.lifeSpan
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))

    override fun getItemCount(): Int = breeds.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(breeds[position])
        holder.itemView.setOnClickListener { listener(breeds[position]) }
    }

    fun addUsers(breeds: List<breed>) {
        this.breeds.apply {
            clear()
            addAll(breeds)
        }

    }
}