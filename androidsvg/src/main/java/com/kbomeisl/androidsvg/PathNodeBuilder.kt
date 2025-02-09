package com.kbomeisl.androidsvg.parsing

import androidx.compose.ui.graphics.vector.PathNode

object PathNodeBuilder {
    /**
     * A wrapper around the ImageVector PathNode class with methods to create
     * PathNodes from string data parsed from the path tag of SVGs
     */

    fun buildLineNode(x: Float, y: Float): PathNode {
        val lineTo = PathNode.LineTo(
            x = x,
            y = y
        )
        return lineTo
    }

    fun buildMoveTo(x: Float, y: Float): PathNode {
        val moveTo = PathNode.MoveTo(
            x = x,
            y = y
        )
        return moveTo
    }

    fun buildVerticalLine(y: Float): PathNode {
        val verticalTo = PathNode.VerticalTo(
            y = y
        )
        return verticalTo
    }

    fun buildHorizontalLine(x: Float): PathNode {
        val horizontalTo = PathNode.HorizontalTo(
            x = x
        )
        return horizontalTo
    }

    fun BuildClosePath(): PathNode {
        return PathNode.Close
    }

    fun relativeHorizontal(dx: Float): PathNode {
        val relativeHorizontal = PathNode.RelativeHorizontalTo(
            dx = dx
        )
        return relativeHorizontal
    }

    fun buildRelativeVertical(dy: Float): PathNode {
        val relativeVertical = PathNode.RelativeVerticalTo(
            dy = dy
        )
        return relativeVertical
    }

    fun buildRelativeLineTo(dx: Float, dy: Float): PathNode {
        val relativeLineTo = PathNode.RelativeLineTo(
            dx = dx,
            dy = dy
        )
        return relativeLineTo
    }

    fun buildCubicCurve(
        x1: Float,
        y1: Float,
        x2: Float,
        y2: Float,
        x3: Float,
        y3: Float
    ): PathNode {
        val cubicCurve = PathNode.CurveTo(
            x1 = x1,
            y1 = y1,
            x2 = x2,
            y2 = y2,
            x3 = x3,
            y3 = y3
        )
        return cubicCurve
    }

    fun buildQuadraticCurve(
        x1: Float,
        y1: Float,
        x2: Float,
        y2: Float,
    ): PathNode {
        val quadraticCurve = PathNode.QuadTo(
            x1 = x1,
            y1 = y1,
            x2 = x2,
            y2 = y2
        )
        return quadraticCurve
    }

    fun buildRelativeCubicCurve(
        dx1: Float,
        dy1: Float,
        dx2: Float,
        dy2: Float,
        dx3: Float,
        dy3: Float
    ): PathNode {
        val relativeCubicCurve = PathNode.RelativeCurveTo(
            dx1 = dx1,
            dy1 = dy1,
            dx2 = dx2,
            dy2 = dy2,
            dx3 = dx3,
            dy3 = dy3
        )
        return relativeCubicCurve
    }

    fun buildRelativeQuadraticCurve(
        dx1: Float,
        dy1: Float,
        dx2: Float,
        dy2: Float,
    ): PathNode {
        val relativeQuadraticCurve = PathNode.RelativeQuadTo(
            dx1 = dx1,
            dy1 = dy1,
            dx2 = dx2,
            dy2 = dy2
        )
        return relativeQuadraticCurve
    }

    fun buildArc(
        rx: Float,
        ry: Float,
        xAxisRotation: Float,
        largeArcFlag: Boolean,
        sweepFlag: Boolean,
        x: Float,
        y: Float
    ): PathNode {
        val arc = PathNode.ArcTo(
            horizontalEllipseRadius = rx,
            verticalEllipseRadius = ry,
            theta = xAxisRotation,
            isMoreThanHalf = sweepFlag,
            isPositiveArc = largeArcFlag,
            arcStartX = x,
            arcStartY = y
        )
        return arc
    }

    fun buildRelativeArc(
        rx: Float,
        ry: Float,
        xAxisRotation: Float,
        largeArcFlag: Boolean,
        sweepFlag: Boolean,
        dx: Float,
        dy: Float
    ): PathNode {
        val arc = PathNode.RelativeArcTo(
            horizontalEllipseRadius = rx,
            verticalEllipseRadius = ry,
            theta = xAxisRotation,
            isMoreThanHalf = sweepFlag,
            isPositiveArc = largeArcFlag,
            arcStartDx = dx,
            arcStartDy = dy
        )
        return arc
    }

    fun buildReflectionCubicCurve(x1: Float, y1: Float, x2: Float, y2: Float): PathNode {
        val reflectedCubicCurve = PathNode.ReflectiveCurveTo(
            x1 = x1,
            y1 = y1,
            x2 = x2,
            y2 = y2
        )
        return reflectedCubicCurve
    }

    fun buildRelativeReflectiveCubicCurve(dx1: Float, dy1: Float, dx2: Float, dy2: Float): PathNode {
        val relativeReflectedCubicCurve = PathNode.RelativeReflectiveCurveTo(
            dx1 = dx1,
            dy1 = dy1,
            dx2 = dx2,
            dy2 = dy2
        )
        return relativeReflectedCubicCurve
    }

    fun buildReflectedQuadCurve(x: Float, y: Float): PathNode {
        val reflectedQuad = PathNode.ReflectiveQuadTo(
            x = x,
            y = y
        )
        return reflectedQuad
    }

    fun buildRelativeReflectedQuadCurve(dx: Float, dy: Float): PathNode {
        val relativeReflectedQuad = PathNode.RelativeReflectiveQuadTo(
            dx = dx,
            dy = dy
        )
        return relativeReflectedQuad
    }
}