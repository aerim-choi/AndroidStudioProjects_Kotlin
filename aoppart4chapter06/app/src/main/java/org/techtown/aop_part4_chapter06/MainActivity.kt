package org.techtown.aop_part4_chapter06
import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.View

import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.CancellationTokenSource
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import org.techtown.aop_part4_chapter06.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var fusedLocationProviderClient:FusedLocationProviderClient
    private var cancellationTokenSource:CancellationTokenSource?=null

    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val scope=MainScope()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initVariables()
        requestLocationPermissions()

    }

    override fun onDestroy(){
        super.onDestroy()
        cancellationTokenSource?.cancel()
        scope.cancel()
    }

    @SuppressLint("MissingPermission")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        val locationPermissionGranted=
            requestCode== REQUEST_ACCESS_LOCATION_PERMISSIONS&&
                    grantResults[0]== PackageManager.PERMISSION_GRANTED

        if(!locationPermissionGranted){
            finish()
        }else{
            cancellationTokenSource=CancellationTokenSource()

            fusedLocationProviderClient.getCurrentLocation(
                LocationRequest.PRIORITY_HIGH_ACCURACY,
                cancellationTokenSource!!.token
            ).addOnSuccessListener { location ->
                TextView.text = "${location.latitude},${location.longitude}"
            }
        }
    }

    private fun initVariables(){
        fusedLocationProviderClient=LocationServices.getFusedLocationProviderClient(this)
    }
    //????????????
    private fun requestLocationPermissions() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            ),
            REQUEST_ACCESS_LOCATION_PERMISSIONS
        )
    }
    companion object{
        private const val REQUEST_ACCESS_LOCATION_PERMISSIONS=100
    }
}