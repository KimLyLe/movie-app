package com.example.popular_movies_app.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.popular_movies_app.R
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdapter(private val movies: List<MovieItem>, private val onClick: (MovieItem) -> Unit) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false)
        )
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(movies[position])

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener { onClick(movies[adapterPosition]) }
        }

        fun bind(movieItem: MovieItem) {
            Glide.with(context).load(movieItem.getCoverForMovie()).into(itemView.ivMovieCover)
            itemView.tvNumber.text = movieItem.title
        }
    }

}
