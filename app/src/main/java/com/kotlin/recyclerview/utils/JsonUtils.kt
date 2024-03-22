package com.kotlin.recyclerview.utils

object JsonUtils {
    fun getJson(path: String): String {
        val inputStream = JsonUtils::class.java.classLoader.getResourceAsStream(path)
        val s = inputStream.bufferedReader().use { it.readText() }
        return s
    }
}