package com.example.apicalls.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apicalls.R
import com.example.apicalls.data.model.GotCharacter

class GotAdapter(

) : RecyclerView.Adapter<GotAdapter.ViewHolder>() {

    private var dataset = listOf<GotCharacter>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name : TextView = view.findViewById(R.id.got_name_text)
        val family: TextView = view.findViewById(R.id.got_family_text)
        val title : TextView = view.findViewById(R.id.got_title_text)

    }

    fun submitList (newlist: List<GotCharacter>){

        dataset = newlist
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.got_item, parent, false)

        return ViewHolder(itemLayout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = dataset[position]

        holder.name.text = character.fullName
        holder.family.text = character.family
        holder.title.text = character.title
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}