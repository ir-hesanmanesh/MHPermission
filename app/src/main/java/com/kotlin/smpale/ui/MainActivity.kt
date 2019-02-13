package com.kotlin.smpale.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.managerpermission.base.ManagerPermission
import com.kotlin.managerpermission.utils.RequestHelper
import com.kotlin.smpale.R
import kotlinx.android.synthetic.main.activity_main.*

public class MainActivity : AppCompatActivity() {

    private var Requester = 123
    private lateinit var manager: ManagerPermission
    val e: String = RequestHelper().ACCESS_COARSE_LOCATION
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn.setOnClickListener { btn ->
            manager = ManagerPermission(this, listOf(e), Requester)
            manager.checkpermission()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            Requester -> {
                val ispermissionGrand= manager.processPermissionsResult(requestCode, permissions, grantResults)
                if (ispermissionGrand){
                    // Do the task now
                    Toast.makeText(this@MainActivity, "Permissions granted.", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@MainActivity, "Permissions denied.", Toast.LENGTH_SHORT).show()

                }
            }
        }
    }
}


