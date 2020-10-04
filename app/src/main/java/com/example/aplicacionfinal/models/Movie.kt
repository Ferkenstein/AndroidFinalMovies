package com.example.aplicacionfinal.models

import com.google.gson.annotations.SerializedName

class Movie {
    @SerializedName("original_title")
    var title:String = ""
    @SerializedName("poster_path")
    var image:String = ""
    var overview:String = ""
}