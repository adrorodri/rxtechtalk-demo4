package com.adrorodri.techtalkrx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adrorodri.techtalkrx.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewModel.myRandomNumber.subscribe ({
            binding.tvRandomNumber.text = it.toString()
        }, {
            binding.tvRandomNumber.text = "ERROR! ${it.message}"
        })
    }
}