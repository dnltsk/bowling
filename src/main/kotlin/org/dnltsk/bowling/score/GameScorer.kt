package org.dnltsk.bowling.score

import org.dnltsk.bowling.Frame
import org.springframework.stereotype.Service

@Service
class GameScorer() {

    fun scoreGame(frames: List<Frame>): Int {
        return frames.map { frame ->
            frame.calculateScore()
        }.sum()
    }


}