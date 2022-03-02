package com.example.aplicacionmenu_28feb_buena.view

import android.app.admin.DevicePolicyManager
import android.content.Context
import com.example.aplicacionmenu_28feb_buena.model.UserData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacionmenu_28feb_buena.R



class UserAdapter(val c: Context, val userList: ArrayList<UserData>):RecyclerView.Adapter<UserAdapter.UserViewHolder>(){


    inner class UserViewHolder(val v: View):RecyclerView.ViewHolder(v){
        val name = v.findViewById<TextView>(R.id.item_title)
        val nbNum = v.findViewById<TextView>(R.id.item_detal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v =inflater.inflate(R.layout.card_layout,parent,false)
        return UserViewHolder(v)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val newList= userList[position]
        holder.name.text = newList.userName
        holder.nbNum.text = newList.userMb
    }

    override fun getItemCount(): Int {
        return userList.size
    }


}