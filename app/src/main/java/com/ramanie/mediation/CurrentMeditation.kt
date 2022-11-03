package com.ramanie.mediation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ramanie.mediation.ui.theme.ButtonBlue
import com.ramanie.mediation.ui.theme.LightRed
import com.ramanie.mediation.ui.theme.TextWhite

@Composable
fun CurrentMeditation( bg_color: Color = LightRed, currentMeditation: String, meditationDuration: String = "Meditation • 3-10 mins" ){
    Row(horizontalArrangement = Arrangement.SpaceBetween,modifier = Modifier
        .padding(horizontal = DEFAULT_PADDING.dp, vertical = DEFAULT_PADDING.times(2).dp)
        .clip(RoundedCornerShape(ROUNDED_CORNER_RADIUS.dp))
        .background(bg_color)
        .padding(horizontal = DEFAULT_PADDING.dp, vertical = DEFAULT_PADDING.times(2).dp)
        .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically ) {
        Column(verticalArrangement = Arrangement.SpaceAround, horizontalAlignment = Alignment.Start) {
            Text(text = currentMeditation)
            Text(text = meditationDuration, style = MaterialTheme.typography.bodyLarge, color = TextWhite)
        }
        Box( contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(ButtonBlue)
                .padding(10.dp)){
            Icon(painter = painterResource(id = R.drawable.ic_play),
                tint = Color.White,
                contentDescription = stringResource(id = R.string.play_icon_content_description),
                modifier = Modifier.size(16.dp))
        }
    }
}