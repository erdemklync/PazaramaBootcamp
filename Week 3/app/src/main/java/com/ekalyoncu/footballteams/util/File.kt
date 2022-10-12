package com.ekalyoncu.footballteams.util

import android.content.Context
import java.io.InputStream

// https://stackoverflow.com/a/65879428
fun readTeamsJsonData(context: Context): String? {
    val json: String?
    try {
        val  inputStream: InputStream = context.assets.open("teams.json")
        json = inputStream.bufferedReader().use{it.readText()}
    } catch (ex: Exception) {
        ex.printStackTrace()
        return null
    }
    return json
}