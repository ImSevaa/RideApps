package com.example.rideapps.model

data class User(
    var username : String? = null,
    var password : Int? = null
)

var dataDummy = listOf(
    User (
        username = "rideforfun",
        password = 123456
    )
)