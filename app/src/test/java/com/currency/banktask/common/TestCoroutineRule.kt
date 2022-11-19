package com.currency.banktask.common

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.test.*
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

@ExperimentalCoroutinesApi
private val testCoroutineScheduler: TestCoroutineScheduler = TestCoroutineScheduler()

@ExperimentalCoroutinesApi
private val testCoroutineDispatcher: TestDispatcher =
    UnconfinedTestDispatcher(testCoroutineScheduler)

@ExperimentalCoroutinesApi
class TestCoroutineRule : TestRule {
    val dispatcher = testCoroutineDispatcher
    lateinit var scope: TestScope
    override fun apply(base: Statement?, description: Description?) = object : Statement() {
        override fun evaluate() {
            scope = TestScope(dispatcher)
            Dispatchers.setMain(testCoroutineDispatcher)
            base?.evaluate()
            Dispatchers.resetMain()
            scope.cancel()
        }

    }

}
