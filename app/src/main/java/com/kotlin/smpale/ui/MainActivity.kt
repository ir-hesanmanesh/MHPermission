package com.kotlin.smpale.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.smpale.R
import com.kotlin.smpale.model.User

public class MainActivity : AppCompatActivity() {

    /*private lateinit var binding:com.kotlin.smpale.databinding.ActivityMainBinding*/
    private lateinit var viewmodel:User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

}
