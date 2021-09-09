package com.example.crudphp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(
        val notes:ArrayList<NoteModel.Data>,
        val Listener: OnAdapterListener,
        ):RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
            LayoutInflater.from(parent.context)
                    .inflate(R.layout.layout_note ,parent, false)
    )
    override fun onBindViewHolder(holder: NoteAdapter.ViewHolder, position: Int) {
     val data = notes[position]
        holder.textNote.text =  data.note
        holder.itemView.setOnClickListener {
            Listener.onUpdate(data)
        }
        holder.imageDelete.setOnClickListener {
            Listener.onDelete(data)
        }


    }



    override fun getItemCount() = notes.size


    class ViewHolder(view:View):RecyclerView.ViewHolder(view) {
        val textNote = view.findViewById<TextView>(R.id.textNote)
        val imageDelete= view.findViewById<ImageView>(R.id.delete)


    }
    public fun setData(data: List<NoteModel.Data>){
        notes.clear()
        notes.addAll(data)
        notifyDataSetChanged()
    }

    interface OnAdapterListener{
        fun onUpdate( note: NoteModel.Data)
        fun onDelete( note: NoteModel.Data)

    }
}