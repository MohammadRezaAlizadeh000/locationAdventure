package ir.mra.locationtest

import android.app.Activity
import android.location.Location
import android.util.Log
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.tasks.CancellationTokenSource

fun Activity.getLastKnownLocation() {
    val fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
    fusedLocationClient.getCurrentLocation(
        Priority.PRIORITY_HIGH_ACCURACY,
        CancellationTokenSource().token
    ).addOnSuccessListener { location: Location? ->
        toast("${location?.latitude} - ${location?.longitude}")
        Log.d("CURRENT_LOCATION", "${location?.latitude} - ${location?.longitude}")
    }
}