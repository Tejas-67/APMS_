package com.example.firebasegooglesignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.akki.circlemenu.CircleMenu
import com.akki.circlemenu.OnCircleMenuItemClicked
import androidx.annotation.NonNull
import androidx.core.view.get
import com.example.firebasegooglesignin.databinding.ActivityDashboardBinding
import com.example.firebasegooglesignin.databinding.ActivityMainBinding
import com.ramotion.circlemenu.CircleMenuView

class DashboardActivity : AppCompatActivity(), OnCircleMenuItemClicked {
    private lateinit var binding: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.circleMenu.setOnMenuItemClickListener(this)


//        binding.levelsImageButton.setOnClickListener {
//            startActivity(Intent(this@DashboardActivity,ReadData::class.java))
//        }
//        binding.infoImageButton.setOnClickListener {
//            startActivity(Intent(this@DashboardActivity,Info1Activity::class.java))
//        }
//        binding.profileImageButton.setOnClickListener {
//            startActivity(Intent(this@DashboardActivity,ProfileActivity::class.java))
//        }
//        binding.statsImageButton.setOnClickListener {
//            startActivity(Intent(this@DashboardActivity,StatisticsLocationSearch::class.java))
//        }
    }

    override fun onMenuItemClicked(id: Int){

        when(id){
            R.drawable.gassesimg-> startActivity(Intent(this@DashboardActivity, ReadData::class.java))
            R.drawable.infoimg-> startActivity(Intent(this@DashboardActivity, Info1Activity::class.java))
            R.drawable.profileimg-> startActivity(Intent(this@DashboardActivity, ProfileActivity::class.java))
            R.drawable.statsimage-> startActivity(Intent(this@DashboardActivity, StatisticsLocationSearch::class.java))
        }
    }

}