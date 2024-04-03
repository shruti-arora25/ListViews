package com.example.listviews.Lists

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.listviews.R

class SecondScreen : AppCompatActivity() {
    val TAG="ACtivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)
        Log.d(TAG,"OnCraeteSecond")


        supportFragmentManager.beginTransaction().replace(R.id.frameLay, BlankFragment()).commit()


    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStartSecond")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResumeSecond")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPauseSecond")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStopSecond")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroySecond")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestartSecond")
    }

}