package com.example.inovantsolutionstask.home.ui.adapters

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.inovantsolutionstask.databinding.ItemColorBinding
import com.example.inovantsolutionstask.home.utils.BindingViewHolder
import com.example.inovantsolutionstask.home.utils.Utils
import com.example.inovantsolutionstask.R
import com.squareup.picasso.Picasso


internal class ColorAdapter(private val activity: Activity, items: ArrayList<String>) : RecyclerView.Adapter<BindingViewHolder<ItemColorBinding>>() {

    private var items: ArrayList<String> = arrayListOf()

    init {
        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<ItemColorBinding> {
        return BindingViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_color, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BindingViewHolder<ItemColorBinding>, position: Int) {
        val color = items[position]

        Picasso.get().load(color)
            .into(holder.binding.ivColor)
//        setViewWidth(holder.binding.llServicesHome, holder.binding.rlImageContainer, activity)
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return items.size
    }



    @SuppressLint("NotifyDataSetChanged")
//    fun setFilter(arrayList: ArrayList<Color>?) {
//        items = ArrayList<Color>().apply {
//            addAll(arrayList!!)
//        }
//        notifyDataSetChanged()
//    }

    private fun setViewWidth(mainLayout: View, imageLayout: View, context: Context) {
        var width = Utils.getScreenWidth(context as Activity)
        width -= Utils.dpToPx(100, context)
        width = (width / 4)
//        width = (width / 3) - dpToPx(15, context)
        if (width > 0) {
            var layoutParams = mainLayout.layoutParams
            if (layoutParams == null) {
                layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, width)
            } else {
                layoutParams.width = width
            }
            mainLayout.layoutParams = layoutParams

            val layoutParams1 = imageLayout.layoutParams
            if (layoutParams1 != null) {
                layoutParams1.width = width - 3
//                layoutParams1.height = width - 3
                imageLayout.layoutParams = layoutParams1
            }
        }
    }

}