package com.kbomeisl.androidsvg

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathNode
import androidx.compose.ui.unit.dp
import com.kbomeisl.androidsvg.parsing.PathNodeBuilder
import com.kbomeisl.androidsvg.parsing.SvgParser

class ImageVectorBuilder {

    fun buildImage(pathNodes: List<PathNode>) {
        val image = initImageVectorBuilder()
        for (node in pathNodes) {

        }
    }

    fun initImageVectorBuilder(
        name: String,
        width: Float,
        height: Float,
        viewportWidth: Float,
        viewportHeight: Float
    ): ImageVector.Builder {
        val imageBuilder = ImageVector.Builder(
            defaultWidth = width.dp,
            defaultHeight = height.dp,
            viewportWidth = viewportWidth,
            viewportHeight = viewportHeight
        )
        return imageBuilder
    }

    fun addPathNode(
        imageVector: ImageVector.Builder,
        pathData: List<PathNode>
    ): ImageVector.Builder {
        val imageBuilder = imageVector.addPath(
            pathData = pathData
        )
        return imageBuilder
    }
}