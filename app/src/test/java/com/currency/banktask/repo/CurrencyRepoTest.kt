package com.currency.banktask.repo

import com.currency.banktask.common.TestCoroutineRule
import com.currency.banktask.data.CurrencyConvResponse
import com.task.currency.data.remote.CurrencyRemoteDS
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class CurrencyRepoTest {
    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @MockK
    private lateinit var currencyRemoteDataSource: CurrencyRemoteDS

    @MockK
    private lateinit var sut: CurrencyRepository

    private var symbolsList = mutableListOf<String>()


    private var currencyConvResponse: CurrencyConvResponse = CurrencyConvResponse(
        "String", true,
        info = CurrencyConvResponse.Info(1.0, 2022 - 11 - 18),
        CurrencyConvResponse.Query(1, "AED", "EGP"), 11.0, true
    )

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        sut = CurrencyRepository(currencyRemoteDataSource)
    }

    @Test
    fun `symbols should return empty list in case of there is no symbols returned`() {
        testCoroutineRule.scope.runTest {
            coEvery { sut.getSymbols() } returns symbolsList
        }
        Assert.assertEquals(symbolsList, emptyList<String>())
    }

    @Test
    fun `symbols should return symbols list in case of the symbols not empty`() {
        testCoroutineRule.scope.runTest {
            coEvery { sut.getSymbols() } returns symbolsList
        }
        Assert.assertEquals(symbolsList, emptyList<String>())
    }

    @Test
    fun `should get symbols return list of string represent symbols`() {
        testCoroutineRule.scope.runTest {
            symbolsList.add("AED")
            coEvery { sut.getSymbols() } returns symbolsList
        }
        Assert.assertNotEquals(symbolsList.size, 0)
    }

    @Test
    fun `currency convert from and two should return given values`() {
        testCoroutineRule.scope.runTest {
            coEvery {
                sut.convertCurrency(
                    from = "AED",
                    to = "EGP",
                    "5"
                )
            } returns currencyConvResponse
        }
    }
}