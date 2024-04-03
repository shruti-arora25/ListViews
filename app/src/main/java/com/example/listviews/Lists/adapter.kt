package com.example.listviews.Lists

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.listviews.R
import com.example.listviews.databinding.ListViewBinding

class adapter(private val context:Activity,private val arrayList:ArrayList<User>):ArrayAdapter<User>(context,
    R.layout.list_view,arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ListViewBinding.inflate(LayoutInflater.from(context), parent, false)
        val user=getItem(position)

        if (user != null) {
            binding.name.text=user.name
            binding.image.setImageResource(user.ImageId)
            binding.mssg.text=user.msg
            binding.time.text=user.time
        }


            return binding.root

    }

}