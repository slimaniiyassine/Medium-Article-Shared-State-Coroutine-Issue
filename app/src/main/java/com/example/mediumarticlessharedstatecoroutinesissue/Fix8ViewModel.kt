package com.example.mediumarticlessharedstatecoroutinesissue

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Fix8ViewModel : ViewModel() {
    var balance by mutableIntStateOf(0)
        private set

    fun startFunctionalDeposit() {
        balance = 0

        viewModelScope.launch {
            val deferredResults = (1..1000).map {
                async(Dispatchers.Default) {
                    delay(1)
                    1
                }
            }
            val resultsList = deferredResults.awaitAll()
            val total = resultsList.sum()
            balance = total
        }
    }
}
