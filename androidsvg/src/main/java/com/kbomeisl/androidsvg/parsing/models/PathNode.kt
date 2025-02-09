package com.kbomeisl.androidsvg.parsing.models

import androidx.compose.ui.graphics.Color

data class PathNode(
    val fill: Color,
    val stroke: Color,
    val strokeLinecap: StrokeLinecap,
    val strokeWidth: Float,
    val strokeLinejoin: StrokeLineJoin,
    val strokeDashArray: List<Int>
)
