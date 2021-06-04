package com.project.androidApp.ui

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.project.androidApp.R
import com.project.androidApp.databinding.ActivityMainBinding
import com.project.androidApp.util.Constants
import com.vmadalin.easypermissions.EasyPermissions
import com.vmadalin.easypermissions.dialogs.SettingsDialog
import dagger.hilt.android.AndroidEntryPoint


class MainActivity : AppCompatActivity(), EasyPermissions.PermissionCallbacks {

    private var permissions = arrayOf(
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION
    )

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val navControler = findNavController(R.id.navHostFragment)
        binding.bottomNavigationView.setupWithNavController(navControler)


        if (checkPermission(permissions)) {
            binding.bottomNavigationView.visibility = View.VISIBLE
        } else {
            binding.bottomNavigationView.visibility = View.GONE
            requestPermission(permissions)
        }
    }

    fun checkPermission(permission: Array<String>) = EasyPermissions.hasPermissions(
        this,
        *permissions
    )


    fun requestPermission(permission: Array<String>) {
        EasyPermissions.requestPermissions(
            this,
            "The permission is required to use the app!",
            Constants.PERMISSION_REQUEST_CODE,
            *permissions
        )
    }

    override fun onPermissionsDenied(requestCode: Int, perms: List<String>) {
        if (EasyPermissions.permissionPermanentlyDenied(this, perms.first())) {
            SettingsDialog.Builder(this).build().show()
        }
    }

    override fun onPermissionsGranted(requestCode: Int, perms: List<String>) {
        binding.bottomNavigationView.visibility = View.VISIBLE
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null

    }
}
