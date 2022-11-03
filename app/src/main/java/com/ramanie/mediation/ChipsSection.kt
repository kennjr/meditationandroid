package com.ramanie.mediation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.ramanie.mediation.ui.theme.*

@Composable
fun ChipsSection(chips: List<String>){
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }

    // a lazyRow is a row that's scrollable and also lazily loads the items in it
    LazyRow{
        items(chips.size){ index: Int ->
//            chip(value = item, index = index, isLast = , clickEvent = {  }, selectedIndex = selectedChip)
            Box(contentAlignment = Alignment.Center, modifier = if (index == 0) Modifier
                .padding(start = 5.dp, end = 0.dp, top = 2.5.dp, bottom = 2.5.dp)
                .clickable { selectedChipIndex = 0 }
                .clip(
                    RoundedCornerShape(ROUNDED_CORNER_RADIUS.dp)
                )
                .background(if (index == selectedChipIndex) ButtonBlue else DarkerButtonBlue)
            else if (index > 0 && index < chips.size) Modifier
                .padding(horizontal = 5.dp, vertical = 2.5.dp)
                .clickable { selectedChipIndex = index }
                .clip(
                    RoundedCornerShape(ROUNDED_CORNER_RADIUS.dp)
                )
                .background(if (index == selectedChipIndex) ButtonBlue else DarkerButtonBlue)
            else Modifier
                .padding(start = 0.dp, end = 5.dp, top = 2.5.dp, bottom = 2.5.dp)
                .clickable { selectedChipIndex = index }
                .clip(
                    RoundedCornerShape(ROUNDED_CORNER_RADIUS.dp)
                )
                .background(if (index == selectedChipIndex) ButtonBlue else DarkerButtonBlue)
            ) {
                Text(text = chips[index], color = TextWhite)
            }
        }
    }
}

@Composable
fun chip(value: String, index: Int, isLast: Boolean, clickEvent: () -> Unit, selectedIndex: Int){
    Box(contentAlignment = Alignment.Center, modifier = if (index == 0) Modifier
        .padding(start = 5.dp, end = 0.dp, top = 2.5.dp, bottom = 2.5.dp)
        .clickable { clickEvent() }
        .clip(
            RoundedCornerShape(ROUNDED_CORNER_RADIUS.dp)
        )
        .background(if (index == selectedIndex) ButtonBlue else DarkerButtonBlue)
        else if (index > 0 && !isLast) Modifier
        .padding(horizontal = 5.dp, vertical = 2.5.dp)
        .clickable { clickEvent() }
        .clip(
            RoundedCornerShape(ROUNDED_CORNER_RADIUS.dp)
        )
        .background(if (index == selectedIndex) ButtonBlue else DarkerButtonBlue)
        else Modifier
        .padding(start = 0.dp, end = 5.dp, top = 2.5.dp, bottom = 2.5.dp)
        .clickable { clickEvent() }
        .clip(
            RoundedCornerShape(ROUNDED_CORNER_RADIUS.dp)
        )
        .background(if (index == selectedIndex) ButtonBlue else DarkerButtonBlue)
    ) {
        Text(text = value, color = TextWhite)
    }
}
