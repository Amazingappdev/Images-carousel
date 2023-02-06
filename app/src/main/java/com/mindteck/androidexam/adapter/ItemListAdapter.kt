package com.mindteck.androidexam.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mindteck.androidexam.R
import com.mindteck.androidexam.model.ItemListModel

class ItemListAdapter (private var itemListModelArrayList: ArrayList<ItemListModel>): RecyclerView.Adapter<ItemListAdapter.ItemViewHolder>() {
    // on below line we are passing variables as course list and context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_listadapter, parent, false)
        return ItemViewHolder(view)
    }
    // method for filtering our recyclerview items.
    fun filterList(filterlist: ArrayList<ItemListModel>) {
        // below line is to add our filtered
        // list in our course array list.
        itemListModelArrayList = filterlist
        // below line is to notify our adapter
        // as change in recycler view data.
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        // on below line we are setting data to our text view and our image view.
        holder.itemNameTv.text = itemListModelArrayList.get(position).itemName
        holder.itemIV.setImageResource(itemListModelArrayList.get(position).itemImage)
    }

    override fun getItemCount(): Int {
        // on below line we are returning
        // our size of our list
        return itemListModelArrayList.size
    }
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // on below line we are initializing our course name text view and our image view.
        val itemNameTv: TextView = itemView.findViewById(R.id.itemNameTv)
        val itemIV: ImageView = itemView.findViewById(R.id.itemIV)
    }

}