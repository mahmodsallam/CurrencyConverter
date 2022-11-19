package com.currency.banktask.presentation

import androidx.lifecycle.Observer
import com.currency.banktask.common.TestCoroutineRule
import com.currency.banktask.repo.CurrencyRepository
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import io.mockk.spyk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class CurrencyViewModelTest {
    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @MockK(relaxed = true)
    private lateinit var repository: CurrencyRepository

    @MockK(relaxed = true)
    private lateinit var viewModel: CurrencyViewModel
    private lateinit var observer: Observer<Any>


    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = CurrencyViewModel(repository)
        observer = spyk()
    }

    @Test
    fun `get symbols test`() {
        viewModel.symbols.observeForever(observer)
        viewModel.getSymbols()
        verify {
            observer.onChanged(any())
        }
        viewModel.symbols.removeObserver(observer)
    }

    @Test
    fun `currency convert test`() {
        viewModel.currencyConvertResult.observeForever(observer)
        viewModel.convertCurrency("AED","EGP","1")
        verify {
            observer.onChanged(any())
        }
        viewModel.symbols.removeObserver(observer)
    }
}