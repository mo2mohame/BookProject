package com.asigment1.bookuidesign

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookAdapter(val data: List<Book>) : RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        val bookImage= view.findViewById<ImageView>(R.id.book_img)
        val bookName = view.findViewById<TextView>(R.id.book_name)
        val authName = view.findViewById<TextView>(R.id.auth_name)
        val ratingContainer = view.findViewById<LinearLayout>(R.id.rating_container)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ViewHolder(layoutInflater)
    }

    override fun getItemCount(): Int {
        return data.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = data[position]
        holder.bookImage.setImageResource(data.image)
        holder.bookName.text = data.bookDesc
        holder.authName.text = data.author

        holder.ratingContainer.removeAllViews()

        val fullStars = data.rating.toInt()
        val hasHalfStar = (data.rating % 1) >= 0.5
        
        for (i in 1..fullStars) {
            val star = ImageView(holder.view.context).apply {
                layoutParams = LinearLayout.LayoutParams(12.dpToPx(holder.view.context), 12.dpToPx(holder.view.context)).apply {
                    marginEnd = 4.dpToPx(holder.view.context)
                }
                setImageResource(R.drawable.star_filled)
            }
            holder.ratingContainer.addView(star)
        }

        if (hasHalfStar) {
            val halfStar = ImageView(holder.view.context).apply {
                layoutParams = LinearLayout.LayoutParams(12.dpToPx(holder.view.context), 12.dpToPx(holder.view.context)).apply {
                    marginEnd = 4.dpToPx(holder.view.context)
                }
                setImageResource(R.drawable.star_half)
            }
            holder.ratingContainer.addView(halfStar)
        }

        val totalStars = 5
        val starsToFill = totalStars - fullStars - if (hasHalfStar) 1 else 0
        for (i in 1..starsToFill) {
            val emptyStar = ImageView(holder.view.context).apply {
                layoutParams = LinearLayout.LayoutParams(12.dpToPx(holder.view.context), 12.dpToPx(holder.view.context)).apply {
                    marginEnd = 4.dpToPx(holder.view.context)
                }
                setImageResource(R.drawable.star_empty)
            }
            holder.ratingContainer.addView(emptyStar)
        }
    }

    private fun Int.dpToPx(context: Context): Int {
        return (this * context.resources.displayMetrics.density).toInt()
    }
}