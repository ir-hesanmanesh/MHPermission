package com.kotlin.managerpermission.utils


import android.os.Build
import androidx.annotation.RequiresApi
 class RequestHelper{
    val camera:String = android.Manifest.permission.CAMERA
    val SEND_SMS:String = android.Manifest.permission.SEND_SMS
    val ACCESS_COARSE_LOCATION:String = android.Manifest.permission.ACCESS_COARSE_LOCATION
    val ACCESS_NETWORK_STATE:String = android.Manifest.permission.ACCESS_NETWORK_STATE
    val ACCESS_FINE_LOCATION:String = android.Manifest.permission.ACCESS_FINE_LOCATION
    val ACCESS_WIFI_STATE:String = android.Manifest.permission.ACCESS_WIFI_STATE
    val ACCOUNT_MANAGER:String = android.Manifest.permission.ACCOUNT_MANAGER
    @RequiresApi(Build.VERSION_CODES.O)
    val ANSWER_PHONE_CALLS:String = android.Manifest.permission.ANSWER_PHONE_CALLS
    @RequiresApi(Build.VERSION_CODES.M)
    val ACCESS_NOTIFICATION_POLICY:String = android.Manifest.permission.ACCESS_NOTIFICATION_POLICY
    val ADD_VOICEMAIL:String = android.Manifest.permission.ADD_VOICEMAIL
    val WRITE_APN_SETTINGS:String = android.Manifest.permission.WRITE_APN_SETTINGS
    val WRITE_EXTERNAL_STORAGE:String = android.Manifest.permission.WRITE_EXTERNAL_STORAGE
    val READ_EXTERNAL_STORAGE:String = android.Manifest.permission.READ_EXTERNAL_STORAGE
    val BIND_NOTIFICATION_LISTENER_SERVICE:String = android.Manifest.permission.BIND_NOTIFICATION_LISTENER_SERVICE
    val BLUETOOTH:String = android.Manifest.permission.BLUETOOTH
    val READ_SMS:String = android.Manifest.permission.READ_SMS
    val BROADCAST_SMS:String = android.Manifest.permission.BROADCAST_SMS
    val RECEIVE_SMS:String = android.Manifest.permission.RECEIVE_SMS
    val WRITE_SETTINGS:String = android.Manifest.permission.WRITE_SETTINGS
    val SYSTEM_ALERT_WINDOW:String = android.Manifest.permission.SYSTEM_ALERT_WINDOW

}