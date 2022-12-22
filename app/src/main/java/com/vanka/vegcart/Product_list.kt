package com.vanka.vegcart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.vanka.vegcart.Adapter.TournamentAdapter
import com.vanka.vegcart.Model.ListModel

class Product_list : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)
        var rv = findViewById<RecyclerView>(R.id.prv)
        rv.layoutManager = LinearLayoutManager(this)
        var id = intent.getStringExtra("key")
        Toast.makeText(this, "${id}", Toast.LENGTH_SHORT).show()
        if (id=="1"){
            getData()
        }else if (id == "2"){
            getData2()
        }else{
            getData3()
        }
    }

    private fun getData3() {
        FirebaseDatabase.getInstance().getReference("List").child("Dry Fruits").addValueEventListener(object :
            ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var list = ArrayList<ListModel>()
                for (data in snapshot.children) if (snapshot.exists()) {
                    var dataget = data.getValue(ListModel::class.java)

                    list.add(dataget!!)


                }
               findViewById<RecyclerView>(R.id.prv).adapter =  TournamentAdapter(this@Product_list,list)

                TournamentAdapter(this@Product_list,list).notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }

    private fun getData2() {
        FirebaseDatabase.getInstance().getReference("List").child("Fruits").addValueEventListener(object :
            ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var list = ArrayList<ListModel>()
                for (data in snapshot.children) if (snapshot.exists()) {
                    var dataget = data.getValue(ListModel::class.java)

                    list.add(dataget!!)


                }
                findViewById<RecyclerView>(R.id.prv).adapter =  TournamentAdapter(this@Product_list,list)

                TournamentAdapter(this@Product_list,list).notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }

    private fun getData() {
        FirebaseDatabase.getInstance().getReference("List").child("Vegetable").addValueEventListener(object :
            ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var list = ArrayList<ListModel>()
                for (data in snapshot.children) if (snapshot.exists()) {
                    var dataget = data.getValue(ListModel::class.java)

                    list.add(dataget!!)


                }
                findViewById<RecyclerView>(R.id.prv).adapter =  TournamentAdapter(this@Product_list,list)

                TournamentAdapter(this@Product_list,list).notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }
}
