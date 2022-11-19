package com.currency.banktask.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.currency.banktask.repo.CurrencyRepository
import com.task.currency.data.remote.NetworkingViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrencyViewModel @Inject constructor(private val usersRepository: CurrencyRepository) :
    ViewModel() {
    val symbols = MutableLiveData<NetworkingViewState>()
    val currencyConvertResult = MutableLiveData<NetworkingViewState>()
    fun getSymbols(): LiveData<NetworkingViewState> {
        val result = MutableLiveData<NetworkingViewState>()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                symbols.postValue(NetworkingViewState.Loading)
                symbols.postValue(NetworkingViewState.Success(usersRepository.getSymbols()))
            } catch (e: java.lang.Exception) {
                symbols.postValue(NetworkingViewState.Error(e.message.toString()))
            }
        }
        return result
    }

    fun convertCurrency(from: String, to: String, amount: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                currencyConvertResult.postValue(NetworkingViewState.Loading)
                currencyConvertResult.postValue(
                    NetworkingViewState.Success(
                        usersRepository.convertCurrency(
                            from,
                            to,
                            amount
                        )
                    )
                )
            } catch (e: java.lang.Exception) {
                currencyConvertResult.postValue(NetworkingViewState.Error(e.message.toString()))
            }
        }
    }
}