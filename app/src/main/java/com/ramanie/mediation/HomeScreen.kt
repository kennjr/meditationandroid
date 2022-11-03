package com.ramanie.mediation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramanie.mediation.ui.theme.DeepBlue

@Composable
fun HomeScreen(){
    Box(modifier = Modifier
        .background(DeepBlue)
        .fillMaxSize()){
        Column {
            GreetingsSection(name = "The Yoyo")
            ChipsSection(chips = listOf("first", "second", "third", "fourth", "fifth", "sixth"))

        }
    }
}