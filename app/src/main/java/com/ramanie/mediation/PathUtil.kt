package com.ramanie.mediation

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path


fun Path.linkPathPoints(from: Offset, to: Offset){
    quadraticBezierTo(from.x, from.y,
        // the code below is what will smoothen the curve, the best way to get the smooth
        // curve we're looking for is to take the 2 points that we wanna link, add them up then divide their sum by 2f
        kotlin.math.abs(from.x.plus(to.x)).div(2f),
        kotlin.math.abs(from.y.plus(to.y)).div(2f)
    )
}