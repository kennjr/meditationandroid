package com.ramanie.mediation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ramanie.mediation.ui.theme.*

@Composable
fun HomeScreen(){
    Box(modifier = Modifier
        .background(DeepBlue)
        .fillMaxSize()){
        Column {
            GreetingsSection(name = "The Yoyo")
            ChipsSection(chips = listOf("first", "second", "third", "fourth", "fifth", "sixth"))
            CurrentMeditation(currentMeditation = "Daily meditation")
            FeaturesSection(
                features = listOf(
                    Feature(
                        title = "Sleep meditation",
                        R.drawable.ic_headphone,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ),
                    Feature(
                        title = "Tips for sleeping",
                        R.drawable.ic_videocam,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),
                    Feature(
                        title = "Night island",
                        R.drawable.ic_headphone,
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3
                    ),
                    Feature(
                        title = "Calming sounds",
                        R.drawable.ic_headphone,
                        Beige1,
                        Beige2,
                        Beige3
                    )
                )
            )
        }
        BottomNav(navOptions = listOf(
            BottomNavContent("Home", R.drawable.ic_home),
            BottomNavContent("Meditate", R.drawable.ic_bubble),
            BottomNavContent("Sleep", R.drawable.ic_moon),
            BottomNavContent("Music", R.drawable.ic_music),
            BottomNavContent("Profile", R.drawable.ic_profile)), modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}