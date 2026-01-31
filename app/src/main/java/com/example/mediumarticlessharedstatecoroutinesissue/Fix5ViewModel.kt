package com.example.mediumarticlessharedstatecoroutinesissue

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withPermit

class Fix5ViewModel : ViewModel() {
    private val semaphore = Semaphore(permits = 1)

    var balance by mutableIntStateOf(0)
        private set

    fun startSemaphoreDeposit() {
        balance = 0

        repeat(1000) {
            viewModelScope.launch(Dispatchers.Default) {
                delay(1)

                semaphore.withPermit {
                    balance += 1
                }
            }
        }
    }
}
