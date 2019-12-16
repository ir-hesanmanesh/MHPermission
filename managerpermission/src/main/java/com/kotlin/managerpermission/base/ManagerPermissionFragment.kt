package com.kotlin.managerpermission.base

import android.app.AlertDialog
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment


class ManagerPermissionFragment(val fragment: Fragment, val list: List<String>, val code: Int):Fragment() {


    fun checkpermission() {
        if (isPermissionGranted() != PackageManager.PERMISSION_GRANTED)
            showDialg()
        else
            Toast.makeText(fragment.context, "Permissions already granted", Toast.LENGTH_SHORT).show()
        isPermissionGranted()
    }

    private fun showDialg() {
        val builder = AlertDialog.Builder(fragment.context)
        builder.setTitle("Need permission accept")
        builder.setMessage("Some permissions are required to do the task.")
        builder.setPositiveButton("ok", { dialog, which -> requestPermission() })
        builder.setNeutralButton("cancel", null)
        val dialog = builder.create()
        dialog.show()
    }

    private fun requestPermission() {
        val permission = deniedPermission()
        if (shouldShowRequestPermissionRationale(fragment.activity!!.parent, permission))
            Toast.makeText(fragment.context, "Should show an explanation.", Toast.LENGTH_LONG).show()
        else
            requestPermissions(fragment.activity!!.parent, list.toTypedArray(), code)

    }

    private fun deniedPermission(): String {
        for (permission in list) {
            if (ContextCompat.checkSelfPermission(
                    fragment.context!!.applicationContext,
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
            Counter += ContextCompat.checkSelfPermission(fragment.context!!.applicationContext, permission)
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