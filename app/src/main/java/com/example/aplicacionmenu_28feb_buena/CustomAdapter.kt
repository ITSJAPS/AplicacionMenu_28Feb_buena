package com.example.aplicacionmenu_28feb_buena

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import java.text.FieldPosition

class CustomAdapter: RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private lateinit var  vistaClick: onItemClickListener

    interface  onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        vistaClick = listener
    }

    //arreglos
    val titles = arrayOf("DUCATII","BMW","BAJAJ","SUSUKI","VENTO","ITALIKA")
    val details= arrayOf("Premium","Alta","Buena","Exelete","Mala","Deplorable")
    val images= intArrayOf(R.drawable.ducati,R.drawable.bmw,R.drawable.bajaj,R.drawable.suzuki,R.drawable.vento,R.drawable.italika)


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout,viewGroup,false)
        return ViewHolder(v,vistaClick)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder,i: Int) {
        viewHolder.itemTitle.text = titles[i]
        viewHolder.itemDetail.text = details[i]
        viewHolder.itemImage.setImageResource(images[i])
    }

    override fun getItemCount(): Int {
        return titles.size
    }



    inner class ViewHolder(itemView: View,listener: onItemClickListener):RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView =itemView.findViewById(R.id.item_image)
        var itemTitle: TextView  = itemView.findViewById(R.id.item_title)
        var itemDetail: TextView  = itemView.findViewById(R.id.item_detal)


        init {
            itemView.setOnClickListener{
                   listener.onItemClick(adapterPosition)
            }
        }

    }

}