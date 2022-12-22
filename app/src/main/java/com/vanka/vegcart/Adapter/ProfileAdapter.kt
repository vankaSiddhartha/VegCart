package com.vanka.vegcart.Adapter

import android.content.Context
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.RecyclerView
import com.vanka.vegcart.Model.ProfileModel
import com.vanka.vegcart.R

class ProfileAdapter(var content:Context,var list: ArrayList<ProfileModel>):RecyclerView.Adapter<ProfileAdapter.ViewHolder>() {
    class ViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){
      var Pname = itemview.findViewById<TextView>(R.id.ptext)
        var image = itemview.findViewById<ImageView>(R.id.pimg)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.p_list,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      holder.Pname.text = list[position].name
        holder.image.setImageResource(list[position].image!!)
    }

    override fun getItemCount(): Int {
     return list.size
    }
}