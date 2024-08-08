package com.developer.android.dev.technologia.androidapp.customcalendar

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.developer.android.dev.technologia.androidapp.customcalendar.databinding.CalendarDateLayoutBinding

class CalendarAdapter(
    private val list: ArrayList<CalendarModel>,
    private val dateItemsClickListener: DateItemsClickListener
):RecyclerView.Adapter<CalendarAdapter.ViewHolder>(){

    inner class ViewHolder(var binding: CalendarDateLayoutBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CalendarDateLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        val lp = RecyclerView.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        binding.root.apply {
            layoutParams = lp
        }
        return  ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]
        val day = data.day

        val layout = holder.binding.root

            holder.binding.apply {
            num.text = "$day"

            when(data.state){
                -1 ->{
                    calendarDateLayout.visibility = View.VISIBLE
                }
                0->{
                    num.setTextColor(ContextCompat.getColor(holder.itemView.context,R.color.grey))
                    today.visibility = View.INVISIBLE
                }
                1->{
                    num.setTextColor(ContextCompat.getColor(holder.itemView.context,R.color.green))
                    num.background = ContextCompat.getDrawable(holder.itemView.context,R.drawable.shape_circle_green)
                    today.visibility = View.INVISIBLE
                    layout.setOnClickListener {
                        dateItemsClickListener.onDateClick(data)
                    }
                }

                2->{
                    num.setTextColor(ContextCompat.getColor(holder.itemView.context,R.color.red))
                    num.background = ContextCompat.getDrawable(holder.itemView.context,R.drawable.shape_circle_red)
                    today.visibility = View.INVISIBLE
                    layout.setOnClickListener {
                        dateItemsClickListener.onDateClick(data)
                    }
                }

                3->{
                    num.setTextColor(ContextCompat.getColor(holder.itemView.context,R.color.grey))
                    num.background = ContextCompat.getDrawable(holder.itemView.context,R.drawable.shape_circle_grey)
                    today.visibility = View.INVISIBLE
                    layout.setOnClickListener {
                        dateItemsClickListener.onDateClick(data)
                    }
                }
            }
        }
    }
}