package com.ramanie.mediation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ramanie.mediation.ui.theme.AquaBlue
import com.ramanie.mediation.ui.theme.ButtonBlue
import com.ramanie.mediation.ui.theme.DeepBlue

@Composable
fun BottomNav(navOptions: List<BottomNavContent>, modifier: Modifier = Modifier,
              activeHighLightColor: Color = ButtonBlue, activeTextColor: Color = Color.White,
              inactiveTextColor: Color = AquaBlue, initialSelectedItemIndex: Int = 0
               ) {

    var selectedItemIndex = remember {
        mutableStateOf(initialSelectedItemIndex)
    }
    Row(horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically, modifier = modifier
        .fillMaxWidth()
        .background(
            DeepBlue
        )
        .padding(DEFAULT_PADDING.dp)) {
        navOptions.forEachIndexed{ index, bottomNavItem ->  
            BottomNavItem(item = bottomNavItem, isSelected = selectedItemIndex.value == index,
                activeHighLightColor = activeHighLightColor, activeTextColor = activeTextColor, inactiveTextColor = inactiveTextColor) {
                selectedItemIndex.value = index
            }
        }
    }

}

@Composable
fun BottomNavItem(item: BottomNavContent, isSelected: Boolean,
                  activeHighLightColor: Color = ButtonBlue, activeTextColor: Color = Color.White,
                  inactiveTextColor: Color = AquaBlue, clickEvent: () -> Unit){
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable { clickEvent() }) {
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(ROUNDED_CORNER_RADIUS.dp))
                .background(if (isSelected) activeHighLightColor else Color.Transparent)
                .padding(10.dp)){
            Icon(painter = painterResource(id = item.iconId), contentDescription = item.title,
                tint = if (isSelected) activeTextColor else inactiveTextColor, modifier = Modifier.size(20.dp))
        }
        Text(text = item.title, color = if (isSelected) activeTextColor else inactiveTextColor)
    }
}

data class BottomNavContent(
    val title: String,
    @DrawableRes val iconId: Int
)