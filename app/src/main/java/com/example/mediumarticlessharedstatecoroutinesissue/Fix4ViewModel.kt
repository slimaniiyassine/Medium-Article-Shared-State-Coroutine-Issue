package com.example.mediumarticlessharedstatecoroutinesissue

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class Fix4ViewModel : ViewModel() {
    private val mutex = Mutex()

    var balance by mutableIntStateOf(0)
        private set

    fun startMutexDeposit() {
        balance = 0

        repeat(1000) {
            viewModelScope.launch(Dispatchers.Default) {
                delay(1)
                mutex.withLock {
                    balance += 1
                }
            }
        }
    }
}
