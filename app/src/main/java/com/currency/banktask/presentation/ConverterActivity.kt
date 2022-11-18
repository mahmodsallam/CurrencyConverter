package com.currency.banktask.presentation

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.currency.banktask.R
import com.currency.banktask.databinding.ActivityMainBinding
import com.currency.banktask.data.CurrencyConvResponse
import com.task.currency.data.remote.NetworkingViewState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConverterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
}