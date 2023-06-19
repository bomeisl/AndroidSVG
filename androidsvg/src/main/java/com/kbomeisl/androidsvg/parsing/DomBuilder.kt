package com.kbomeisl.androidsvg.parsing

import android.content.Context
import org.w3c.dom.Document
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory

class DomBuilder(private val context: Context) {

    fun getDocumentFromAssets(fileName: String): Document {
        val inputStream = context.assets.open(fileName)
        val documentBuilder = getDocumentBuilder()
        return documentBuilder.parse(inputStream)
    }

    private fun getDocumentBuilder(): DocumentBuilder {
        return DocumentBuilderFactory.newInstance().newDocumentBuilder()
    }

}