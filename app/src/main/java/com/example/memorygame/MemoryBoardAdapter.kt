package com.example.memorygame

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.min

class MemoryBoardAdapter(private val context: Context, private val numPieces: Int) :
        RecyclerView.Adapter<MemoryBoardAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(position: Int){
            //Currently blank
        }
    }

    companion object {
        private const val MARGINS = 10
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val cardWidth = parent.width/2 - (2*MARGINS)
        val cardHeight = parent.height/4 - (2*MARGINS)
        val cardSize = min(cardHeight,cardWidth)
        val view = LayoutInflater.from(context).inflate(R.layout.memory_card,parent,false)
        val layoutParams = view.findViewById<CardView>(R.id.memoryCard).layoutParams as ViewGroup.MarginLayoutParams
        layoutParams.width = cardSize
        layoutParams.height = cardSize
        layoutParams.setMargins(MARGINS, MARGINS, MARGINS, MARGINS)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount() = numPieces
}
