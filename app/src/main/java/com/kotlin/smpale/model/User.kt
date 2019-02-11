package com.kotlin.smpale.model

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.view.View
import androidx.lifecycle.ViewModel
import com.kotlin.smpale.utils.extenstion.getParentActivity

class User : ViewModel() {
    val view: View? = null
    fun alert() {

        val builder = AlertDialog.Builder(view?.getParentActivity())
        builder.setTitle("hello how are you")
        builder.setCancelable(true)
        val create = builder.create()
        create.show()

    }
}