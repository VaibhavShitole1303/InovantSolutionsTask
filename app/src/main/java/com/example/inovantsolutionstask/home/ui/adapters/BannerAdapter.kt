package com.example.inovantsolutionstask.home.ui.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.inovantsolutionstask.databinding.ItemBannerBinding
import com.example.inovantsolutionstask.home.model.Banner
import com.example.inovantsolutionstask.home.utils.BindingViewHolder
import com.squareup.picasso.Picasso


internal class BannerAdapter(items: ArrayList<String>) :
    RecyclerView.Adapter<BindingViewHolder<ItemBannerBinding>>() {
    private var items: ArrayList<String> = arrayListOf()
    private var selectBannerListener: SelectBannerListener? = null

    init {
        this.items = items
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BindingViewHolder<ItemBannerBinding> {
        return BindingViewHolder(
            LayoutInflater.from(parent.context).inflate(com.example.inovantsolutionstask.R.layout.item_banner, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BindingViewHolder<ItemBannerBinding>, position: Int) {
        val item = items[position]

        Picasso.get().load(item)
            .into(holder.binding.ivBanner)

        holder.binding.selectBannerListener = selectBannerListener
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    interface SelectBannerListener {
        fun onBannerSelected(banner: Banner?)
    }
}