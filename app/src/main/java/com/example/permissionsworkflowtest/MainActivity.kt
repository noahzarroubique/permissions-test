package com.example.permissionsworkflowtest

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
			!= PackageManager.PERMISSION_GRANTED) {
			// If not, request the permission
			ActivityCompat.requestPermissions(this,
				arrayOf(Manifest.permission.CAMERA),
				Companion.CAMERA_PERMISSION_REQUEST_CODE
			)
		}
		else {
			Log.d("PERMISSION", "Permission already grated")
		}
	}

	companion object {
		private const val CAMERA_PERMISSION_REQUEST_CODE = 1001
	}
}