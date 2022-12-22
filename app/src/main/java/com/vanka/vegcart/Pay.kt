package com.vanka.vegcart

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.razorpay.Checkout
import com.razorpay.PaymentData
import org.json.JSONObject
import com.razorpay.PaymentResultListener

class Pay : AppCompatActivity(),PaymentResultListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay)
        findViewById<Button>(R.id.pay_p).setOnClickListener {
            payment(findViewById(R.id.em))
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

    override fun onPaymentSuccess(p0: String?) {
        Toast.makeText(this, "Sucess", Toast.LENGTH_SHORT).show()
    }

    override fun onPaymentError(errorCode: Int, response: String?) {
        try {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            Log.e("st","${errorCode}+${response}")
        }catch (e:Exception)
        {

        }

    }


}