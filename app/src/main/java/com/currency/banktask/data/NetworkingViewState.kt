package com.task.currency.data.remote

sealed class NetworkingViewState {
    object Loading : NetworkingViewState()
    data class Success(val data: Any) : NetworkingViewState()
    data class Error(val error: Any) : NetworkingViewState()
}