package com.example.advweek4_kp_c.util

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import com.example.advweek4_kp_c.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

fun createNotificationChannel(context: Context, importance: Int, showBadge: Boolean, name: String, description: String) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channelId = "${context.packageName}-$name"
        val channel = NotificationChannel(channelId, name, importance)
        channel.description = description
        channel.setShowBadge(showBadge)

        val manager = context.getSystemService(NotificationManager::class.java)
        manager.createNotificationChannel(channel)

    }
}



fun ImageView.loadImage(url: String?, progressBar: ProgressBar) {
    Picasso.get().load(url).resize(400, 400).centerCrop().error(R.drawable.baseline_error_24)
        .into(this, object : Callback {
            override fun onSuccess() {
                progressBar.visibility = View.GONE
            }

            override fun onError(e: Exception?) {
                TODO("Not yet implemented")
            }

        })

}

@BindingAdapter("android:imageUrl", "android:progressBar")
fun loadPhotoURL(view: ImageView, url: String, pd:ProgressBar){
    view.loadImage(url,pd)
}