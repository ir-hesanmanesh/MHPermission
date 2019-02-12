package com.kotlin.smpale.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.google.android.material.button.MaterialButton
import com.kotlin.smpale.model.User
import com.kotlin.smpale.ui.MainActivity
import com.kotlin.smpale.utils.extenstion.getParentActivity

@BindingAdapter("MutableOnClick")
fun SetOnClick(button: MaterialButton, click: MutableLiveData<Int>?) {
    val parent: AppCompatActivity? = button.getParentActivity()
    if (parent != null && click !=null) {
        click.observe(parent, Observer { on -> button.setOnClickListener { val user:User }})
    }

}


