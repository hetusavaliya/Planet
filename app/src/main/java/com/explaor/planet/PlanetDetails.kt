package com.explaor.planet

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PlanetDetails : AppCompatActivity() {
    private lateinit var obj: PlanetData
    private var planetImg: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet_details)

        window.decorView.apply {
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }

        obj = intent.getParcelableExtra("planet")!!
        planetImg = intent.getIntExtra("planetImage", -1)
        setData(obj, planetImg!!)

        val buttonInfo = findViewById<TextView>(R.id.button_info)
        buttonInfo.setOnClickListener {
            val intent = Intent(this, FinalActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setData(obj: PlanetData, planetImg: Int) {
        val titleInfo = findViewById<TextView>(R.id.title_info)
        val distanceInfo = findViewById<TextView>(R.id.distance_info)
        val gravityInfo = findViewById<TextView>(R.id.gravity_info)
        val overviewInfo = findViewById<TextView>(R.id.overview_info)
        val planetImgInfo = findViewById<ImageView>(R.id.planet_img_info)

        titleInfo.text = obj.title
        distanceInfo.text = "${obj.distance} m km"
        gravityInfo.text = "${obj.gravity} m/ss"
        overviewInfo.text = obj.override
        planetImgInfo.setImageResource(planetImg)
    }
}
