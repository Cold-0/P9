package com.cold0.realestatemanager.screens

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat
import com.cold0.realestatemanager.BuildConfig
import com.cold0.realestatemanager.screens.photoviewer.PhotoViewerActivity

object ScreensUtils {
    fun openPhotoViewerActivity(context: Context, photo: String) {
        val intent = Intent(context, PhotoViewerActivity::class.java).apply {
            putExtra("img", photo)
        }
        ContextCompat.startActivity(context, intent, ActivityOptions.makeSceneTransitionAnimation(context as Activity).toBundle())
    }

    fun formatApiRequestGeoapify(
        width: Int = 400,
        height: Int = 400,
        localisation: String = "-74.005157,40.710785",
        apiKey: String = BuildConfig.GEOAPIFY_KEY,
    ): String {
        return "https://maps.geoapify.com/v1/staticmap" +
                "?style=osm-bright-grey" +
                "&width=$width&height=$height" +
                "&center=lonlat:$localisation" +
                "&zoom=16.4226&pitch=44" +
                "&marker=lonlat:$localisation;color:%23ff0000;size:medium" +
                "&apiKey=$apiKey"
    }
}