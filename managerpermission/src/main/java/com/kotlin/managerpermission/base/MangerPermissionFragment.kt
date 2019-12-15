package com.kotlin.managerpermission.base

import android.app.AlertDialog
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity


class MangerPermissionFragment(val fragment: FragmentActivity, val list: List<String>, val code: Int) {
    fun checkpermission() {
        if (isPermissionGranted() != PackageManager.PERMISSION_GRANTED)
            showDialg()
        else
            Toast.makeText(fragment, "Permissions already granted", Toast.LENGTH_SHORT).show()
        isPermissionGranted()
    }

    private fun showDialg() {
        val builder = AlertDialog.Builder(fragment)
        builder.setTitle("Need permission accept")
        builder.setMessage("Some permissions are required to do the task.")
        builder.setPositiveButton("ok", { dialog, which -> requestPermission() })
        builder.setNeutralButton("cancel", null)
        val dialog = builder.create()
        dialog.show()
    }

    private fun requestPermission() {
        val permission = deniedPermission()
        if (ActivityCompat.shouldShowRequestPermissionRationale(fragment, permission))
            Toast.makeText(fragment, "Should show an explanation.", Toast.LENGTH_LONG).show()
        else
            ActivityCompat.requestPermissions(fragment, list.toTypedArray(), code)
    }

    private fun deniedPermission(): String {
        for (permission in list) {
            if (ContextCompat.checkSelfPermission(
                    fragment,
                    permission
                ) == PackageManager.PERMISSION_DENIED
            )
                return permission
        }
        return ""
    }

    private fun isPermissionGranted(): Int {
        var Counter = 0
        for (permission in list) {
            Counter += ContextCompat.checkSelfPermission(fragment, permission)
        }
        return Counter
    }

    fun processPermissionsResult(
        requestcode: Int,
        permission: Array<String>,
        grandResult: IntArray
    ): Boolean {
        var result = 0
        if (grandResult.isNotEmpty()) {
            for (item in grandResult) {
                result += item
            }
        }
        if (result == PackageManager.PERMISSION_GRANTED)
            return true
        return false
    }
}