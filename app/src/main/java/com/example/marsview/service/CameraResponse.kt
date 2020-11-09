package com.example.marsview.service

data class CameraResponse(
    val rover : RoverRespuesta
) {
    class RoverRespuesta(
        val cameras: List<CameraItem>
    ) {
        class CameraItem(
            var full_name: String
        ) {

        }
    }
}