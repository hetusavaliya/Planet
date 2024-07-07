package com.explaor.planet

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val planetList: List<PlanetData>) : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val planetImg: ImageView = itemView.findViewById(R.id.planet_img)
        val galaxy: TextView = itemView.findViewById(R.id.galaxy)
        val distance: TextView = itemView.findViewById(R.id.distance)
        val gravity: TextView = itemView.findViewById(R.id.gravity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.view, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return planetList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val planet = planetList[position]
        var dummyImage: Int? = null

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, PlanetDetails::class.java)
            intent.putExtra("planet",planetList[position])
            intent.putExtra("planetImage",dummyImage)
            holder.itemView.context.startActivity(intent)
        }

        holder.title.text = planet.title
        holder.galaxy.text = planet.galaxy
        holder.distance.text = "${planet.distance} m km"
        holder.gravity.text = "${planet.gravity} m/ss"

        dummyImage = when (planet.title?.toLowerCase()) {
            "mars" -> R.drawable.mars
            "neptune" -> R.drawable.neptune
            "earth" -> R.drawable.earth
            "moon" -> R.drawable.moon
            "venus" -> R.drawable.venus
            "jupiter" -> R.drawable.jupiter
            "saturn" -> R.drawable.saturn
            "uranus" -> R.drawable.uranus
            "mercury" -> R.drawable.mercury
            "sun" -> R.drawable.sun
            else -> null
        }

        dummyImage?.let {
            holder.planetImg.setImageResource(it)
        }
    }
}
