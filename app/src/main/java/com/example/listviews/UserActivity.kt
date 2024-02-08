package com.example.listviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listviews.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {
    private lateinit var binding:ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name=intent.getStringExtra("name")
        val imageId=intent.getIntExtra("imageId",R.drawable.person1)
        val mssg=intent.getStringExtra("mesage")

        binding.imageView.setImageResource(imageId)
        binding.name.text=name
        binding.Mesage.text=mssg
    }
}