package com.vanka.vegcart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vanka.vegcart.Adapter.ProfileAdapter
import com.vanka.vegcart.Adapter.TournamentAdapter
import com.vanka.vegcart.Model.ListModel
import com.vanka.vegcart.Model.ProfileModel


class Profile : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_profile, container, false)
        var prv = view.findViewById<RecyclerView>(R.id.prv)
        var list = ArrayList<ProfileModel>()
        list.add(ProfileModel(R.drawable.ic_cart_foreground,"cart"))
        list.add(ProfileModel(R.drawable.motorbike,"Delivery"))
        list.add(ProfileModel(R.drawable.location,"Address"))
        list.add(ProfileModel(R.drawable.info,"About Us"))
        list.add(ProfileModel(R.drawable.logout,"Logout"))
        prv.layoutManager = LinearLayoutManager(requireContext())
        prv.adapter = ProfileAdapter(requireContext(),list)
        return view
    }



}