package com.example.logoquiz.data.model

data class GameState(
    var questionsCount: Int = 0,
    var score: Int = 0,
    var currentQuestion: Int = 0
)