package com.example.listviews.Lists

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.listviews.R
import com.example.listviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    lateinit var userArrayList:ArrayList<User>
     val TAG="ActivityLifecycle"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageId= intArrayOf(
            R.drawable.person1,
            R.drawable.person1,
            R.drawable.person1,
            R.drawable.person1,
            R.drawable.person1,
            R.drawable.person1,
            R.drawable.person1,
            R.drawable.person1,
            R.drawable.person1,
            R.drawable.person1,
            R.drawable.person1,
            R.drawable.person1,
            R.drawable.person1,
            R.drawable.person1,
            R.drawable.person1
        )
        val name= arrayOf("Christropher","Craig","Sergio","Mike","Anelia","Toa","Ivani","Michael")
        val time= arrayOf("2:00","4:00","5:00","8:45","3:00","2:00","4:00","5:00")
        val message= arrayOf("Hello","Are You there?","Busy","Are You Coming","Surprise","I will be there soon","Pls Come ASAP","Tmrw is Holiday")

        userArrayList=ArrayList()
        for (i in name.indices){
            val user= User(name[i],message[i],time[i],imageId[i])
            userArrayList.add(user)
        }
        binding.listView.isClickable=true
        binding.listView.adapter= adapter(this,userArrayList)
        binding.listView.setOnItemClickListener { parent, view, position, id ->
            val name = name[position]
            val imageId=imageId[position]
            val mesage=message[position]
            val time=time[position]
            val i= Intent(this, UserActivity::class.java)


            i.putExtra("name",name)
            i.putExtra("imageId",imageId)
            i.putExtra("mesage",mesage)
            startActivity(i)

        }
        Log.d(TAG, "onCreate")



        binding.btn.setOnClickListener{
            val i=Intent(this, SecondScreen::class.java)
            startActivity(i)
        }



    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }





}