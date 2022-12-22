package com.vanka.vegcart.Adapter

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.vanka.vegcart.Detail
import com.vanka.vegcart.Model.ListModel
import com.vanka.vegcart.R

class TournamentAdapter(var context: Context, var list:ArrayList<ListModel>): RecyclerView.Adapter<TournamentAdapter.ViewHolder>(){
    class ViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

         holder.itemView.findViewById<TextView>(R.id.pname).text = list[position].name
        holder.itemView.findViewById<TextView>(R.id.price).text =list[position].price
        Glide.with(context).load(list[position].link).listener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show()
                return false
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {

                return false
            }
        }).into(holder.itemView.findViewById(R.id.list_image))
        holder.itemView.setOnClickListener {
            var intent = Intent(context,Detail::class.java)
            intent.putExtra("dis",list[position].dis)
            intent.putExtra("name",list[position].name)
            intent.putExtra("price",list[position].price)
            intent.putExtra("link",list[position].link)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return  list.size
    }
}

