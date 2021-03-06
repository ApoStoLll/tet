package com.ms.tet.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ms.tet.R
import com.ms.tet.data.entities.RecEntity


class RecsAdapter (var items : List<RecEntity>) :
    RecyclerView.Adapter<RecsAdapter.RecordViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordViewHolder
            = RecordViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.record_item, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RecordViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class RecordViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        private val score : TextView = itemView.findViewById(R.id.scores)
        val time : TextView = itemView.findViewById(R.id.times_text)

        fun bind(item : RecEntity){
            //name.text = item.results[0].name.first + " " + item.results[0].name.last
            score.text = item.scoreS
            time.text = item.times
        }
    }

}