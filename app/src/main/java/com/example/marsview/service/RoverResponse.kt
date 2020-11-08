package com.example.marsview.service

data class RoverResponse(
    val rovers: List<RoverItem>
) {
    class RoverItem(
        name: String,
        landing_date: String,
        launch_date: String
    )
}