package com.kbomeisl.androidsvg.parsing

import android.content.Context
import android.util.Xml
import androidx.compose.ui.graphics.Color
import com.kbomeisl.androidsvg.parsing.models.SVG
import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParserFactory
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.security.KeyStore.Entry
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.xpath.XPathConstants
import javax.xml.xpath.XPathFactory

object SvgParser {
    private val ns: String? = null

    @Throws(IOException::class, XmlPullParserException::class)
    fun parse(inputStream: InputStream) {
        inputStream.use { iStream ->
            val parser: XmlPullParser = Xml.newPullParser()
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false)
            parser.setInput(iStream, null)
            parser.nextTag()
            return parseSvg(parser)
        }
    }

    @Throws(IOException::class, XmlPullParserException::class)
    fun parseSvg(parser: XmlPullParser) {
        var fill: String? = ""
        var height: String? = ""
        var width: String? = ""
        var name: String = ""
        val paths = mutableListOf<String>()
        var viewportWidth = 0f
        var viewportHeight = 0f
        parser.require(XmlPullParser.START_TAG, null, "svg")
        while (parser.next() != XmlPullParser.END_TAG) {
            fill = parser.getAttributeValue(null,"fill")
            height = parser.getAttributeValue(null, "height")
            width = parser.getAttributeValue(null, "width")
            name = parser.getAttributeValue(null, "id")
            val viewBox = parser.getAttributeValue(null, "viewBox")
            val boxDimensions = viewBox.split(" ")
            viewportWidth = boxDimensions.get(2).toFloat() - boxDimensions.get(0).toFloat()
            viewportHeight = boxDimensions.get(3).toFloat() - boxDimensions.get(1).toFloat()
            if (parser.eventType != XmlPullParser.START_TAG) {
                continue
            }
            if (parser.name == "path") {
                paths.add(parsePath(parser))
            }
        }
        width?.let { w ->
            height?.let { h ->
                val svg = SVG(
                    name = name ?: "",
                    width = w.toFloat(),
                    height = h.toFloat(),
                    viewportWidth = viewportWidth,
                    viewportHeight = viewportHeight
                )
            }
        }
    }

    @Throws(IOException::class, XmlPullParserException::class)
    fun parsePath(parser: XmlPullParser): String {
        parser.require(XmlPullParser.START_TAG,null, "path")
        val path = parseText(parser)
        parser.require(XmlPullParser.END_TAG,null,"path")
        return path
    }

    @Throws(IOException::class, XmlPullParserException::class)
    fun parseText(parser: XmlPullParser): String {
        var text = ""
        if (parser.next() == XmlPullParser.TEXT) {
            text = parser.text
            parser.nextTag()
        }
        return text
    }

    @Throws(IOException::class, XmlPullParserException::class)
    fun skipTag(parser: XmlPullParser) {
        if (parser.eventType != XmlPullParser.START_TAG) {
            throw IllegalStateException()
        }
        var depth = 1
        while (depth != 0) {
            when (parser.next()) {
                XmlPullParser.END_TAG -> depth--
                XmlPullParser.START_TAG -> depth++
            }
        }
    }
}