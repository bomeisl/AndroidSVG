package com.kbomeisl.androidsvg.parsing

import android.content.Context
import com.kbomeisl.androidsvg.parsing.models.Tag
import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import java.io.BufferedReader
import java.io.InputStream
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.xpath.XPathConstants
import javax.xml.xpath.XPathFactory

class SvgParser(private val context: Context) {

    fun parseSvg(fileName: String): List<Any?> {
        val domBuilder = DomBuilder(context)
        val dom = domBuilder.getDocumentFromAssets(fileName)
        val nodeList = getNodes(dom = dom, tag = "path")
        val nodeData = parseNodeList(nodeList)
        return nodeData
    }

    fun getNodes(dom: Document, tag: String, attribute: String? = null): NodeList {
        val nodeDataList = mutableListOf<Any?>()
        return dom.getElementsByTagName("path") as NodeList
    }

    fun getStringExpression(
        tag: String,
        id: String? = null,
        className: String? = null,
        attribute: String? = null
    ): String {
        val stringBuilder = StringBuilder("//${tag}")
        if (id != null) {
            stringBuilder.append("[@id='$id']")
        }
        if (className != null) {
            stringBuilder.append("[@class='$className']")
        }
        if (attribute != null) {
            stringBuilder.append("/@$attribute")
        }
        return stringBuilder.toString()
    }

    fun parseNodeList(
        nodeList: NodeList
    ): List<Any?> {
        val nodeDataList = mutableListOf<String>()
        for (n in 0..nodeList.length-1) {
            val attributes = nodeList.item(n).attributes
            for (n in 0..attributes.length-1) {
                nodeDataList.add(attributes.item(n).nodeValue)
            }
        }
        return nodeDataList
    }

//    fun processElementNode(elementNode: Node): String? {
//        if (elementNode.hasChildNodes()) {
//            parseNodeList(elementNode.childNodes)
//        }
//        if (elementNode.hasAttributes()) {
//            processAttributeNode(elementNode)
//        }
//        return elementNode.nodeValue
//    }

//    fun processTextNode(textNode: Node): String {
//        return textNode.textContent
//    }

//    fun processAttributeNode(
//        attributeNode: Node
//    ): List<Pair<String, String?>> {
//        val attributes = mutableListOf<Pair<String, String?>>()
//        if (attributeNode.hasAttributes()) {
//            val attribute = attributeNode.attributes
//            attributeList.forEach {
//                val attrKey = it
//                val attrValue = attribute.getNamedItem(it)?.nodeValue
//                attributes.add((attrKey to attrValue))
//            }
//            if (attributeNode.hasChildNodes()) {
//                parseNodeList(attributeNode.childNodes)
//            }
//        }
//        return attributes.toList()
//    }

}