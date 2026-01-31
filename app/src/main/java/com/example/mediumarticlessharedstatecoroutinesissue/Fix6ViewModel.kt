package com.example.mediumarticlessharedstatecoroutinesissue


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class Fix6ViewModel : ViewModel() {
    private val _balance = MutableStateFlow(0)

    val balance: StateFlow<Int> = _balance.asStateFlow()

    fun startFlowDeposit() {
        _balance.value = 0

        repeat(1000) {
            viewModelScope.launch(Dispatchers.Default) {
                delay(1)
                _balance.update { currentBalance ->
                    currentBalance + 1
                }
            }
        }
    }
}
