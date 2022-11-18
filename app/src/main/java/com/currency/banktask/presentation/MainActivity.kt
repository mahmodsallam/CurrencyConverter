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
class MainActivity : AppCompatActivity() {
    private val currencyViewModel: CurrencyViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var fromAdapter: ArrayAdapter<String>
    private lateinit var toAdapter: ArrayAdapter<String>
    private var isToValueChanged = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        currencyViewModel.getSymbols()
        currencyViewModel.symbols.observe(this) {
            when (it) {
                is NetworkingViewState.Loading -> {}
                is NetworkingViewState.Success -> {
                    fromAdapter = ArrayAdapter(
                        this,
                        android.R.layout.simple_spinner_item,
                        it.data as? List<String> ?: emptyList()
                    )
                    toAdapter = ArrayAdapter(
                        this,
                        android.R.layout.simple_spinner_item,
                        it.data as? List<String> ?: emptyList()
                    )
                    fromAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    toAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    binding.fromSpinner.adapter = fromAdapter
                    binding.toSpinner.adapter = toAdapter
                }
                is NetworkingViewState.Error -> {}
            }
        }
        binding.etFrom.doAfterTextChanged {
            isToValueChanged = false
            currencyViewModel.convertCurrency(
                binding.fromSpinner.selectedItem.toString(),
                binding.toSpinner.selectedItem.toString(),
                it.toString()
            )
        }
        binding.etTo.doAfterTextChanged {
            isToValueChanged = true
            currencyViewModel.convertCurrency(
                binding.fromSpinner.selectedItem.toString(),
                binding.toSpinner.selectedItem.toString(),
                it.toString()
            )
        }
        currencyViewModel.currencyConvertResult.observe(this, Observer {
            when (it) {
                is NetworkingViewState.Loading -> {}
                is NetworkingViewState.Success -> {
                    if (!isToValueChanged)
                        binding.etTo.setText((it.data as? CurrencyConvResponse)?.result.toString())
                    else
                        binding.etFrom.setText((it.data as? CurrencyConvResponse)?.result.toString())
                }
                is NetworkingViewState.Error -> {}
            }

        })
    }
}