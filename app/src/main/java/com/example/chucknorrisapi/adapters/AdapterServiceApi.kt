package com.example.chucknorrisapi.adapters

import com.example.chucknorrisapi.ValueListOfCategories
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonReader
import com.squareup.moshi.ToJson
import java.lang.StringBuilder

internal class AdapterServiceApi {
    @FromJson
    fun fromJson(reader: JsonReader) : ValueListOfCategories {
        val listOfCategories = mutableListOf<String>()

        reader.beginArray()

        while (reader.hasNext()){
            listOfCategories.add(reader.nextString())
        }
        reader.endArray()
        return ValueListOfCategories(listOfCategories.toList())
    }

    @ToJson
    fun toJson(list: ValueListOfCategories) : String {
        val stringBuilder = StringBuilder()

        list.categories.forEach {
            stringBuilder.append("\"")
            stringBuilder.append(it)
            stringBuilder.append("\"")
            stringBuilder.append(",")
        }
        stringBuilder.dropLast(1)

        return "$stringBuilder]"
    }
}