package com.vanka.vegcart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.vanka.vegcart.Adapter.TournamentAdapter
import com.vanka.vegcart.Model.ListModel
import java.lang.Exception

class Cart : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       var view = inflater.inflate(R.layout.fragment_cart, container, false)
        var rv = view.findViewById<RecyclerView>(R.id.crv)
        rv.layoutManager = LinearLayoutManager(requireContext())
        getData()
       return view
    }
    private fun getData() {
        FirebaseDatabase.getInstance().getReference("cart").addValueEventListener(object :
            ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var list = ArrayList<ListModel>()
                for (data in snapshot.children) if (snapshot.exists()) {

                    var dataget = data.getValue(ListModel::class.java)

                    list.add(dataget!!)


                }
                try {
                    requireView().findViewById<RecyclerView>(R.id.crv).adapter =  TournamentAdapter(requireContext(),list)
                    TournamentAdapter(requireContext(),list).notifyDataSetChanged()
                }catch (e: Exception){

                }



            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }


}