package com.ramanie.mediation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun GreetingsSection(name: String = "Kenn"){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                DEFAULT_PADDING.dp
            )
    ) {
        Column(verticalArrangement = Arrangement.SpaceAround) {
            Text(text = stringResource(id = R.string.greeting_string, name),
                style = MaterialTheme.typography.headlineMedium)
            Text(text = stringResource(id = R.string.greeting_msg),
                style = MaterialTheme.typography.bodyLarge)
        }
        Icon(painter = painterResource(id = R.drawable.ic_search),
            contentDescription = stringResource(id = R.string.search_icon_content_description),
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}