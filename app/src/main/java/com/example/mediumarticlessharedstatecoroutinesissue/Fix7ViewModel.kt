package com.example.mediumarticlessharedstatecoroutinesissue

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

sealed class BalanceAction {
    object Increment : BalanceAction()
}


class Fix7ViewModel : ViewModel() {
    var balance by mutableIntStateOf(0)
        private set

    private val actionChannel = Channel<BalanceAction>(Channel.UNLIMITED)

    init {
        viewModelScope.launch {
            for (action in actionChannel) {
                when (action) {
                    is BalanceAction.Increment -> {
                        balance++
                    }
                }
            }
        }
    }

    fun startActorDeposit() {
        balance = 0
        repeat(1000) {
            viewModelScope.launch(Dispatchers.Default) {
                delay(1)
                actionChannel.send(BalanceAction.Increment)
            }
        }
    }
}
