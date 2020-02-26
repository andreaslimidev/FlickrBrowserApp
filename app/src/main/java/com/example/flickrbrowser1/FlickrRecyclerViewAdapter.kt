package com.example.flickrbrowser1

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class FlickrImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var thumbnail: ImageView = view.findViewById(R.id.thumbnail)
    var title: TextView = view.findViewById(R.id.title)
}

class FlickrRecyclerViewAdapter(private var photoList: List<Photo>) : RecyclerView.Adapter<FlickrImageViewHolder>() {
    private val TAG = "FlickrRecyclerViewAdapt"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlickrImageViewHolder {
        // called by layout manager when new view is needed
        Log.d(TAG, "new view requested")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.browse, parent, false)
        return FlickrImageViewHolder(view)
    }

    fun loadNewData(newPhotos : List<Photo>) {
        photoList = newPhotos
        notifyDataSetChanged() // tells recyclerView that data has changed and must refresh
    }

    fun getPhoto(position: Int) : Photo? {
        return if (photoList.isNotEmpty()) photoList[position] else null
    }

    override fun getItemCount(): Int {
        return if(photoList.isNotEmpty()) photoList.size else 0
    }

    override fun onBindViewHolder(holder: FlickrImageViewHolder, position: Int) {
        // called by layoutmanager when it wants new data in existing view
        val photoItem = photoList[position]
        Picasso.get().load(photoItem.image)
            .error(R.drawable.placeholder)
            .placeholder(R.drawable.placeholder)
            .into(holder.thumbnail)

        holder.title.text = photoItem.title
    }
}