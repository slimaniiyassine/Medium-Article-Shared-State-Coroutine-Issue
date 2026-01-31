package com.example.mediumarticlessharedstatecoroutinesissue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mediumarticlessharedstatecoroutinesissue.ui.theme.MediumArticlesSharedStateCoroutinesIssueTheme

class Fix3Fragment : Fragment() {

    private val viewModel: Fix3ViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                MediumArticlesSharedStateCoroutinesIssueTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = Color(0xFFFFC107)
                    ) {
                        Fix3Screen(viewModel)
                    }
                }
            }
        }
    }
}

@Composable
fun Fix3Screen(viewModel: Fix3ViewModel) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Fixed Balance (LimitedParallelism(1)): $${viewModel.balance}",
            style = MaterialTheme.typography.bodyLarge
        )

        Button(
            onClick = { viewModel.startConfinedDeposit() },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF36454F)
            ),
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Start LimitedParallelism(1) Deposit ($1,000)")
        }
    }
}
