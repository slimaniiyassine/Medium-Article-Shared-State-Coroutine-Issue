package com.example.mediumarticlessharedstatecoroutinesissue

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.fragment.compose.AndroidFragment
import com.example.mediumarticlessharedstatecoroutinesissue.ui.theme.MediumArticlesSharedStateCoroutinesIssueTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MediumArticlesSharedStateCoroutinesIssueTheme {
                var currentScreen by remember { mutableStateOf("Issue") }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    Column {
                        Surface(
                            color = Color(0xFFECEFF1),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .horizontalScroll(rememberScrollState())
                                    .padding(top = 48.dp, bottom = 16.dp, start = 8.dp, end = 8.dp),
                                horizontalArrangement = Arrangement.Start
                            ) {
                                NavButton("Issue") { currentScreen = "Issue" }
                                NavButton("Blocking") { currentScreen = "Blocking" }
                                NavButton("Atomics") { currentScreen = "Atomics" }
                                NavButton("Confined") { currentScreen = "Confined" }
                                NavButton("Mutex") { currentScreen = "Mutex" }
                                NavButton("Semaphore") { currentScreen = "Semaphore" }
                                NavButton("FlowUpdate") { currentScreen = "FlowUpdate" }
                                NavButton("Actor") { currentScreen = "Actor" }
                                NavButton("Functional") { currentScreen = "Functional" }
                            }
                        }

                        when (currentScreen) {
                            "Issue" -> AndroidFragment<RaceConditionFragment>(Modifier.weight(1f))
                            "Blocking" -> AndroidFragment<Fix1Fragment>(Modifier.weight(1f))
                            "Atomics" -> AndroidFragment<Fix2Fragment>(Modifier.weight(1f))
                            "Confined" -> AndroidFragment<Fix3Fragment>(Modifier.weight(1f))
                            "Mutex" -> AndroidFragment<Fix4Fragment>(Modifier.weight(1f))
                            "Semaphore" -> AndroidFragment<Fix5Fragment>(Modifier.weight(1f))
                            "FlowUpdate" -> AndroidFragment<Fix6Fragment>(Modifier.weight(1f))
                            "Actor" -> AndroidFragment<Fix7Fragment>(Modifier.weight(1f))
                            "Functional" -> AndroidFragment<Fix8Fragment>(Modifier.weight(1f))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun NavButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF36454F)),
        modifier = Modifier.padding(horizontal = 4.dp)
    ) {
        Text(text, color = Color.White, style = MaterialTheme.typography.labelSmall)
    }
}
