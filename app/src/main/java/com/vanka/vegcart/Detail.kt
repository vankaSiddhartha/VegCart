package com.vanka.vegcart

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.os.ResultReceiver
import android.util.Log
import android.widget.*
import com.bumptech.glide.Glide
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.FirebaseDatabaseKtxRegistrar
import com.google.firebase.ktx.Firebase
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import com.vanka.vegcart.Model.ListModel
import org.json.JSONObject

class Detail() : AppCompatActivity(){

override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        var dis = intent.getStringExtra("dis")
        var price = intent.getStringExtra("price")
        var name = intent.getStringExtra("Name")
        var link = intent.getStringExtra("link")
        var image = findViewById<ImageView>(R.id.image)
        var disr = findViewById<TextView>(R.id.dis)
        var namer = findViewById<TextView>(R.id.pd_name)
        disr.text = dis
        namer.text = name
        Glide.with(this).load(link).into(image)
        findViewById<Button>(R.id.addFav).setOnClickListener {
            var data = ListModel(name,price,link,dis)
            FirebaseDatabase.getInstance().getReference("cart").push().setValue(data).addOnSuccessListener {
                Toast.makeText(this, "sucessfull", Toast.LENGTH_SHORT).show()
            }
        }
        findViewById<Button>(R.id.addFav2).setOnClickListener {

            }
        }
    private fun payment(em: EditText) {

        val activity: Activity = this
        val co = Checkout()
        co.setKeyID("rzp_live_aDpVlvx0FhK4Hk")


        try {
            val options = JSONObject()
            options.put("name", "Razorpay Corp")
            options.put("description", "Demoing Charges")
            //You can omit the image option to fetch the image from the dashboard
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.jpg")
            options.put("theme.color", "#3399cc");
            options.put("currency", "INR");
            options.put("amount", em.text.toString()+"00")//pass amount in currency subunits


            val prefill = JSONObject()
            prefill.put("email", "siddharthavanka68@gmail.com")
            prefill.put("contact", "8008649368")

            options.put("prefill", prefill)
            co.open(this, options)
        } catch (e: Exception) {
            Toast.makeText(activity, "Error in payment: " + e.message, Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }

  


}
