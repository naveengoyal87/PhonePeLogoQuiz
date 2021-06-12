package com.example.logoquiz.data.model

data class LogoResponse(

    var logoList: List<LogoModel>? = null
)

data class LogoModel(
    var imgUrl: String,

    var name: String

)