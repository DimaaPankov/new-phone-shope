package ru.skillbranch.phone_shop.pageradapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.skillbranch.phone_shop.R

class VPAdapter(var viewPagerItemArrayList: ArrayList<ViewPagerItem>) :
    RecyclerView.Adapter<VPAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewpager_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val viewPagerItem = viewPagerItemArrayList[position]
        holder.imageView.load(viewPagerItem.imageID)//.setImageResource(viewPagerItem.imageID)
        holder.tcHeading.text = viewPagerItem.heading
        holder.tvDesc.text = viewPagerItem.description
    }

    override fun getItemCount(): Int {
        return viewPagerItemArrayList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView
        var tcHeading: TextView
        var tvDesc: TextView

        init {
            imageView = itemView.findViewById(R.id.imgHT)
            tcHeading = itemView.findViewById(R.id.tvHTtitle)
            tvDesc = itemView.findViewById(R.id.tvHSsubtitle)
        }
    }
}


