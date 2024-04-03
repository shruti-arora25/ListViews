package com.example.listviews.WorkManager

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationManagerCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.listviews.R

class MyWorker(context:Context, workerParameters: WorkerParameters):Worker(context,workerParameters) {
    companion object {
        const val CHANNEL_ID="channel_id"
        const val NOTIFICATION=1
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun doWork(): Result {

        Log.d("TAG--------->","Success")

        showNtfcn()
        return Result.success()

    }

    @SuppressLint("MissingPermission")
    @RequiresApi(Build.VERSION_CODES.O)


    private fun showNtfcn(){

        val intent=Intent(applicationContext,MainActivityWM::class.java).apply {
            flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

        }

        var pendingIntent=PendingIntent.getActivity(applicationContext,0,intent,
            PendingIntent.FLAG_IMMUTABLE)

        val ntfcn= Notification.Builder(applicationContext, CHANNEL_ID)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("New Task Title")
            .setContentText("SubContent")
            .setPriority(Notification.PRIORITY_MAX)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelName = "channel name"
            val channeldesc = "channel description"
            val channelImp = NotificationManager.IMPORTANCE_HIGH


            val chanel = NotificationChannel(CHANNEL_ID, channelName, channelImp).apply {
                description = channeldesc
            }

            val notificationManager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(chanel)

        }


        with(NotificationManagerCompat.from(applicationContext)){
            notify(NOTIFICATION, ntfcn.build())



        }



    }


}