package com.example.chucknorrisapi

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SearchResponse (
    val total : Int,
    val result : List<Jokes>,
     ) : Parcelable