package com.currency.banktask.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.currency.banktask.R
import com.currency.banktask.data.CurrencyConvResponse
import com.currency.banktask.databinding.FragmentConverterBinding
import com.task.currency.data.remote.NetworkingViewState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConverterFragment : Fragment() {
    private val currencyViewModel: CurrencyViewModel by viewModels()
    private lateinit var binding: FragmentConverterBinding
    private lateinit var fromAdapter: ArrayAdapter<String>
    private lateinit var toAdapter: ArrayAdapter<String>
    private var isToValueChanged = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_converter, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        currencyViewModel.getSymbols()
        currencyViewModel.symbols.observe(viewLifecycleOwner) {
            when (it) {
                is NetworkingViewState.Loading -> {}
                is NetworkingViewState.Success -> {
                    fromAdapter = ArrayAdapter(
                        requireContext(),
                        android.R.layout.simple_spinner_item,
                        it.data as? List<String> ?: emptyList()
                    )
                    toAdapter = ArrayAdapter(
                        requireContext(),
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
        binding.apply {
            etFrom.doAfterTextChanged {
                isToValueChanged = false
                currencyViewModel.convertCurrency(
                    binding.fromSpinner.selectedItem?.toString() ?: "",
                    binding.toSpinner.selectedItem?.toString() ?: "",
                    it?.toString() ?: ""
                )
            }
            etTo.doAfterTextChanged {
                isToValueChanged = true
                currencyViewModel.convertCurrency(
                    binding.fromSpinner.selectedItem?.toString() ?: "",
                    binding.toSpinner.selectedItem?.toString() ?: "",
                    it?.toString() ?: ""
                )
            }
            detailsBtn.setOnClickListener {
                view.findNavController().navigate(R.id.detailsFragment)
            }
        }
        currencyViewModel.currencyConvertResult.observe(viewLifecycleOwner) {
            when (it) {
                is NetworkingViewState.Loading -> {}
                is NetworkingViewState.Success -> {
                    if (!isToValueChanged)
                        binding.etTo.setText((it.data as? CurrencyConvResponse)?.result?.toString())
                    else
                        binding.etFrom.setText((it.data as? CurrencyConvResponse)?.result?.toString())
                }
                is NetworkingViewState.Error -> {}
            }

        }
    }
}