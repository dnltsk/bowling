package org.dnltsk.bowling.write

import org.springframework.stereotype.Service

@Service
class ScoreWriter{

    fun writeScore(score: Int){
        println()
        println("Score: $score")
        println()
    }

}