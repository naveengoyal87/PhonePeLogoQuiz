package com.example.logoquiz.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LogoQuizAdapter(
    private var context: Context?,
    private var suggestSource: ArrayList<String>
) : RecyclerView.Adapter<LogoQuizAdapter.LogoViewHolder>() {

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    class LogoViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

        var textView: TextView = itemview.findViewById(android.R.id.text1)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_1, parent, false)
        return LogoViewHolder(view).apply {
            textView.setOnClickListener {

            }
        }
    }

    override fun onBindViewHolder(holder: LogoViewHolder, position: Int) {
        holder.textView.text = suggestSource[position]
    }

    override fun getItemCount() = suggestSource.size
}