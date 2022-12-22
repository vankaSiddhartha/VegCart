package com.vanka.vegcart

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.razorpay.Checkout
import org.json.JSONObject


class Love : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_love, container, false)
        var em = view.findViewById<EditText>(R.id.em)
        view.findViewById<Button>(R.id.lov_btn).also {
            it.setOnClickListener {

                startActivity(Intent(activity, Pay::class.java))
            }
        }
        return view
    }






}



