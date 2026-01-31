package com.example.mediumarticlessharedstatecoroutinesissue

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.atomic.AtomicInteger

class Fix2ViewModel : ViewModel() {
    private val atomicBalance = AtomicInteger(0)

    var balance by mutableIntStateOf(0)
        private set

    fun startAtomicDeposit() {
        atomicBalance.set(0)
        balance = 0

        repeat(1000) {
            viewModelScope.launch(Dispatchers.Default) {
                delay(1)
                val newBalance = atomicBalance.incrementAndGet()

                balance = newBalance

            }
        }
    }
}
