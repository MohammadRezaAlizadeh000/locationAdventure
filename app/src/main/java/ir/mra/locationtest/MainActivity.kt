package ir.mra.locationtest

import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    private val requestLocationPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
            if (it.all { it.value }) {
                getLocationPermission()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        getLocationPermission()
    }

    private fun getLocationPermission() {
        if (IsLocationPermissionsGranted) {
            getLastKnownLocation()
        } else {
            requestLocationPermissionLauncher.launch(LocationPermissions)
        }
    }

}