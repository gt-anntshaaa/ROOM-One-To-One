package com.application.multipletable.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.application.multipletable.data.local.entity.Users
import com.application.multipletable.databinding.ItemBinding

class CustomAdapter(private val listener: OnItemClickListener) : ListAdapter<Users, CustomAdapter.ViewHolder>(Diffcalback){
    companion object{
        private val Diffcalback = object : DiffUtil.ItemCallback<Users>(){
            override fun areItemsTheSame(oldItem: Users, newItem: Users): Boolean {
                return oldItem.userId == newItem.userId
            }

            override fun areContentsTheSame(oldItem: Users, newItem: Users): Boolean {
                return oldItem == newItem
            }

        }
    }
    inner class ViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(user: Users){
            binding.tvEmail.text = user.email
            binding.tvUsername.text = user.username
            binding.root.setOnClickListener {
                listener.onClick(user.userId)
            }
            binding.root.setOnLongClickListener {
                listener.onLongClick(user.userId)
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

//class CustomAdapter<T>(val context: Context, private val t: List<T>, private val listener: OnItemClickListener) : RecyclerView.Adapter<CustomAdapter<T>.ViewHolder<T>>(){
//    inner class ViewHolder<T>(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root){
//        fun bind(t: T, id: Int){
//            if (t is Users){
//                binding.tvEmail.text = t.email
//                binding.tvUsername.text = t.username
//                binding.root.setOnClickListener {
//                    t.id = id
//                    listener.onClick(t.id)
//                }
//            }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<T> {
//        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return ViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder<T>, position: Int) {
//        val item = t[position]
//
//        if (item is Users) {
//            holder.bind(item, position)
//            //Log.d("TES", "onBindViewHolder: ${item.username}")
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return when (t) {
//            is List<*> -> (t as List<*>).size
//            else -> 0
//        }
//    }
//}


