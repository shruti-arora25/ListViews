package com.example.listviews.WorkManager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.example.listviews.R
import com.example.listviews.databinding.ActivityMainWmBinding
import java.util.concurrent.TimeUnit

class MainActivityWM : AppCompatActivity() {

    lateinit var bind: ActivityMainWmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bind = ActivityMainWmBinding.inflate(layoutInflater)

        setContentView(bind.root)
        bind.apply {

            btn1.setOnClickListener {

                myOneTimeWork()
            }



            btn2.setOnClickListener {

                myPeriodicWork()

            }
        }

    }


    fun myOneTimeWork() {

        val constraints = androidx.work.Constraints.Builder()
            .setRequiredNetworkType(NetworkType.NOT_REQUIRED)
            .setRequiresCharging(true)
            .build()


        val myWorkRequest: WorkRequest = OneTimeWorkRequest.Builder(MyWorker::class.java)
            .setConstraints(constraints)
            .build()


        WorkManager.getInstance(this).enqueue(myWorkRequest)

    }

    fun myPeriodicWork() {

        val constraints = androidx.work.Constraints.Builder()

            .setRequiredNetworkType(NetworkType.NOT_REQUIRED)
            .build()

        val myWorkRequest = PeriodicWorkRequest.Builder(MyWorker::class.java, 15, TimeUnit.MINUTES)
            .setConstraints(constraints)
            .addTag("TAG")
            .build()

        WorkManager.getInstance(this).enqueueUniquePeriodicWork("my_name",ExistingPeriodicWorkPolicy.KEEP,myWorkRequest)

    }


}