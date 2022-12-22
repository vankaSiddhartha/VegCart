package com.vanka.vegcart

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.vanka.vegcart.Adapter.TournamentAdapter
import com.vanka.vegcart.Model.ListModel
import java.lang.Exception
import androidx.recyclerview.widget.ListAdapter as ListAdapter


class Home : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_home, container, false)
        var rv = view.findViewById<RecyclerView>(R.id.hrv)
        rv.layoutManager = LinearLayoutManager(requireContext()
        )
        getData()
        var vege = view.findViewById<Button>(R.id.veg).also {
            it.setOnClickListener{
                var intent = Intent(requireContext(),Product_list::class.java)
               intent.putExtra("key","1");
                startActivity(intent)
            }
        }
        var fru = view.findViewById<Button>(R.id.fruit).also {
            it.setOnClickListener{
                var intent = Intent(requireContext(),Product_list::class.java)
                intent.putExtra("key","2");
                startActivity(intent)
            }
        }
        var dry = view.findViewById<Button>(R.id.dry).also {
            it.setOnClickListener{
                var intent = Intent(requireContext(),Product_list::class.java)
                intent.putExtra("key","3");
                startActivity(intent)
            }
        }


        return view
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
                  try {
                      requireView().findViewById<RecyclerView>(R.id.hrv).adapter =  TournamentAdapter(requireContext(),list)
                      TournamentAdapter(requireContext(),list).notifyDataSetChanged()
                  }catch (e:Exception){

                  }



            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }


}