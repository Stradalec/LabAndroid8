package com.example.labandroid8

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ForecastAdapter(private val diffCallback: ForecastDiffCallback) :
    ListAdapter<ForecastItem, ForecastAdapter.ViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.forecast_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val forecastItem = getItem(position)
        holder.bind(forecastItem)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(forecastItem: ForecastItem) {
            itemView.findViewById<TextView>(R.id.date).text = forecastItem.dt_txt
            itemView.findViewById<TextView>(R.id.temperature).text = forecastItem.main.temp.toString()
            itemView.findViewById<TextView>(R.id.description).text = forecastItem.weather[0].description
        }
    }
}

