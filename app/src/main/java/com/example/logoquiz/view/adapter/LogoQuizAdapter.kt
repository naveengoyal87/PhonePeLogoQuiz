package com.example.logoquiz.view.adapter

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LogoQuizAdapter(private var context: Context?,
private var suggestSource: ArrayList<String>
) : RecyclerView.Adapter<LogoQuizAdapter.LogoViewHolder>() {
//    override fun getCount(): Int {
//        return suggestSource.size
//    }
//
//    override fun getItem(position: Int): Any {
//        return suggestSource[position]
//    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }



//    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        val button: Button
//        if (convertView == null) {
//            if (suggestSource[position] == "null") {
//                button = Button(context)
//                button.layoutParams = AbsListView.LayoutParams(85, 85)
//                button.setPadding(8, 8, 8, 8)
//                button.setBackgroundColor(Color.WHITE)
//            } else {
//                button = Button(context)
//                button.layoutParams = AbsListView.LayoutParams(85, 85)
//                button.setPadding(8, 8, 8, 8)
//                button.setBackgroundColor(Color.WHITE)
//                button.setTextColor(Color.BLUE)
//                button.text = suggestSource[position]
//
//            }
//        } else button = convertView as Button
//        return button
//    }


    class LogoViewHolder(itemview: View): RecyclerView.ViewHolder(itemview) {

        var textView: TextView = itemview.findViewById(android.R.id.text1)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false)
        return LogoViewHolder(view).apply {
            textView.setOnClickListener{

            }
        }
    }

    override fun onBindViewHolder(holder: LogoViewHolder, position: Int) {
        holder.textView.text = suggestSource[position]
    }

    override fun getItemCount() = suggestSource.size
}