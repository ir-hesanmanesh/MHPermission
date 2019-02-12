package com.kotlin.smpale.model

import android.app.Activity
import android.app.AlertDialog
import android.view.View
import androidx.lifecycle.ViewModel
import com.kotlin.managerpermission.base.ManagerPermission
import com.kotlin.managerpermission.utils.RequestHelper
import com.kotlin.smpale.ui.MainActivity

class User : ViewModel() {
    val view: Activity? = null
    private var requestcode = 123
    private lateinit var manager: ManagerPermission
    val e: String = RequestHelper().ACCESS_COARSE_LOCATION
    val onclick=View.OnClickListener { alert() }
    lateinit var main:MainActivity
    fun alert() {
        manager = ManagerPermission(main, listOf(e), requestcode)
        manager.checkpermission()
        val builder = AlertDialog.Builder(view)
        builder.setTitle("hello how are you")
        builder.setCancelable(true)
        val create = builder.create()
        create.show()


    }
}