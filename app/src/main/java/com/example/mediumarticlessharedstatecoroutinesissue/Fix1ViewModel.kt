package com.example.mediumarticlessharedstatecoroutinesissue

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Fix1ViewModel : ViewModel() {
    private val lock = Any()
    var balance by mutableIntStateOf(0)
        private set

    fun startBlockingDeposit() {
        balance = 0
        repeat(1000) {
            viewModelScope.launch(Dispatchers.Default) {
                delay(1)
                synchronized(lock) {
                    balance += 1
                }
            }
        }
    }
}
