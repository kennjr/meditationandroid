package com.ramanie.mediation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramanie.mediation.ui.theme.ButtonBlue
import com.ramanie.mediation.ui.theme.TextWhite

@Composable
fun FeaturesSection ( features: List<Feature> ){
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "Features", style = MaterialTheme.typography.headlineLarge, modifier = Modifier.padding(
            DEFAULT_PADDING.dp))
        LazyVerticalGrid(columns = GridCells.Fixed(FEATURE_ENTRIES_PER_ROW), modifier = Modifier.fillMaxHeight(),
            // this is the padding for the container not the individual items
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp)
        ){
            items(features.size){
                FeatureItem(feature = features[it])
            }
        }
    }
    
}

@Composable
fun FeatureItem(feature: Feature){
    // the BoxWithConstraints allows us to utilise the width and height of the item
    BoxWithConstraints(modifier = Modifier
        .padding(7.5.dp)
        // the line below will ensure that we've got a square
        .aspectRatio(1f)
        .clip(RoundedCornerShape(ROUNDED_CORNER_RADIUS.dp))
        .background(feature.darkColor)){
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        // we're defining the medium colored path
        // the offset val for the x-axis starts at the origin and the val for the y-axis is dropped from the top by 0.3(30%) to cover 70% of the box's height
        val mediumColoredPoint1 = Offset(x = 0f, y = height.times(0.3f))
        // the offset val for the next x-axis ends 10% from the origin and the val for the y-axis is dropped further from the top by 0.33(33%)
        val mediumColoredPoint2 = Offset(x = width.times(0.1f), y = height.times(0.33f))
        // the offset val for the next x-axis ends 30% from the origin and the val for the y-axis rises from the 0.35 by 0.15(15%) to cover 80% of the box's height
        val mediumColoredPoint3 = Offset(x = width.times(0.3f), y = height.times(0.2f))
        // the offset val for the next x-axis ends 68% from the origin and the val for the y-axis is dropped again from the top(of 0.2) by 0.25(25%) to cover 55% of the box's height
        val mediumColoredPoint4 = Offset(x = width.times(0.68f), y = height.times(0.75f))
        // the offset val for the next x-axis ends 100% from the origin and the val for the y-axis rises from the 0.45 by 0.15(15%) to cover 70% of the box's height
        // we use -height.toFloat() bc the curve back up is too steep
        val mediumColoredPoint5 = Offset(x = width.times(1f), y = -height.toFloat())

        val mediumColorPath = Path().apply {
            // we're moving the pen to the start i.e where it needs to start drawing from
            moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
            linkPathPoints(mediumColoredPoint1, mediumColoredPoint2)
            linkPathPoints(mediumColoredPoint2, mediumColoredPoint3)
            linkPathPoints(mediumColoredPoint3, mediumColoredPoint4)
            linkPathPoints(mediumColoredPoint4, mediumColoredPoint5)
            // then we need to draw a line that'll link the path to the base, so that we can connect it(the wave) to the base, forming a shape that we can draw in
            // we're adding 100f just to ensure that we've reached the bottom of the canvas
            lineTo(width.toFloat().plus(100f), height.toFloat().plus(100f))
            // we're using -100f fpr the width to ensure that we've gotten to the other end of the width
            lineTo(-100f, height.toFloat().plus(100f))
            // the call below will connect the path and the 2 lines we've got below it
            close()

        }

        // we're defining the medium colored path
        // the offset val for the x-axis starts at the origin and the val for the y-axis is dropped from the top by 0.3(30%) to cover 70% of the box's height
        val lightColoredPoint1 = Offset(x = 0f, y = height.times(0.35f))
        // the offset val for the next x-axis ends 10% from the origin and the val for the y-axis is dropped further from the top by 0.35(35%)
        val lightColoredPoint2 = Offset(x = width.times(0.1f), y = height.times(0.38f))
        // the offset val for the next x-axis ends 30% from the origin and the val for the y-axis rises from the 0.35 by 0.15(15%) to cover 80% of the box's height
        val lightColoredPoint3 = Offset(x = width.times(0.3f), y = height.times(0.33f))
        // the offset val for the next x-axis ends 68% from the origin and the val for the y-axis is dropped again from the top(of 0.2) by 0.25(25%) to cover 55% of the box's height
        val lightColoredPoint4 = Offset(x = width.times(0.68f), y = height.toFloat())
        // the offset val for the next x-axis ends 100% from the origin and the val for the y-axis rises from the 0.45 by 0.15(15%) to cover 70% of the box's height
        // we use -height.toFloat() bc the curve back up is too steep
        val lightColoredPoint5 = Offset(x = width.times(1f), y = -height.toFloat().div(3f))

        val lightColorPath = Path().apply {
            // we're moving the pen to the start i.e where it needs to start drawing from
            moveTo(lightColoredPoint1.x, lightColoredPoint1.y)
            linkPathPoints(lightColoredPoint1, lightColoredPoint2)
            linkPathPoints(lightColoredPoint2, lightColoredPoint3)
            linkPathPoints(lightColoredPoint3, lightColoredPoint4)
            linkPathPoints(lightColoredPoint4, lightColoredPoint5)
            // then we need to draw a line that'll link the path to the base, so that we can connect it(the wave) to the base, forming a shape that we can draw in
            // we're adding 100f just to ensure that we've reached the bottom of the canvas
            lineTo(width.toFloat().plus(100f), height.toFloat().plus(100f))
            // we're using -100f fpr the width to ensure that we've gotten to the other end of the width
            lineTo(-100f, height.toFloat().plus(100f))
            // the call below will connect the path and the 2 lines we've got below it
            close()

        }
        Canvas(modifier = Modifier.fillMaxSize()){
            drawPath(mediumColorPath, feature.mediumColor)
            drawPath(lightColorPath, feature.lightColor)
        }
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(DEFAULT_PADDING.dp)){
            Text(text = feature.title, style = MaterialTheme.typography.headlineMedium, lineHeight = 26.sp, modifier = Modifier.align(
                Alignment.TopStart))
            Icon(painter = painterResource(id = feature.iconId), contentDescription = null, modifier = Modifier.align(
                Alignment.BottomStart))
            Text(text = stringResource(id = R.string.start), fontSize = 14.sp, fontWeight = FontWeight.Bold, color = TextWhite, modifier = Modifier
                .align(Alignment.BottomEnd)
                .clip(RoundedCornerShape(ITEM_ROUNDED_CORNER_RADIUS.dp))
                .background(ButtonBlue)
                .padding(all = DEFAULT_PADDING.div(2).dp)
                .clickable { })
        }
    }
}