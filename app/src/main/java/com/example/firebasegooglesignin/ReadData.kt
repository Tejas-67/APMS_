package com.example.firebasegooglesignin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.firebasegooglesignin.databinding.ActivityReadDataBinding
import com.google.firebase.database.*

class ReadData : AppCompatActivity() {

    private lateinit var binding : ActivityReadDataBinding

    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReadDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.readdataBtn.setOnClickListener{
            val userName : String = binding.etusername.text.toString()
            if (userName.isNotEmpty()){

                readData(userName)

            }else{
                Toast.makeText(this, "Please Enter The location", Toast.LENGTH_SHORT).show()
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun readData(showGraph: String) {
        database = FirebaseDatabase.getInstance().getReference("Users").child(showGraph)

//        database.orderByKey().limitToFirst(1).addListenerForSingleValueEvent(object : ValueEventListener{
//            override fun onDataChange(snapshot: DataSnapshot) {
//                if(snapshot.exists()){
//                    val firstChild=snapshot.children.first()
//                    Log.w("APMS", firstChild.value.toString())
//
//                    updateAllViews(data)
//                }
//                else {
//                    Toast.makeText(this@ReadData, "Couldnt fetch data!", Toast.LENGTH_SHORT).show()
//
//                }
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                Log.w("APMS", "Cancelled")
//            }
//
//        })

        //TODO implement this part such that it fetches the first child detail....

        database.child("Time").get().addOnSuccessListener{

            if (it.exists()){

                val latitude = it.child("Latitude").value
                val longitude = it.child("Longitude").value
                val temp = it.child("Temperature").value
                val humidity = it.child("Humidity").value
                val co2 = it.child("CO2").value
                val co = it.child("CO").value
                val so2 = it.child("SO2").value
                val no2 = it.child("NO2").value
                val methane = it.child("Methane").value
                val o3 = it.child("O3").value


                binding.etusername.text?.clear()

                binding.lat.text = latitude.toString()+" °"
                binding.longi.text = longitude.toString()+" °"
                binding.temp.text = temp.toString()+" °C"
                binding.humi.text = humidity.toString()+" %"
                binding.co2.text = co2.toString()+ " ppm"
                binding.co.text = co.toString()+ " ppm"
                binding.so2.text = so2.toString()+ " ppm"
                binding.no2.text = no2.toString()+ " ppm"
                binding.methane.text = methane.toString()+ " ppm"
                binding.o3.text = o3.toString()+ " ppm"

            }else{

                Toast.makeText(this, "Location doesn't exist", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener{

            Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show()

        }
    }


}