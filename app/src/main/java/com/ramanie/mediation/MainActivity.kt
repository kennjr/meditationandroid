package com.ramanie.mediation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ramanie.mediation.ui.theme.MediationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MediationTheme {
                // A surface container using the 'background' color from the theme
                HomeScreen()
            }
        }
    }
}