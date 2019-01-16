package org.dnltsk.bowling.score

import org.dnltsk.bowling.Frame
import org.springframework.stereotype.Service

@Service
class GameScorer {

    fun scoreGame(frames: List<Frame>): Int {
        return frames.mapIndexed { i, frame ->
            if (i + 1 < frames.size) {
                frame.calculateScore(frames[i + 1])
            } else {
                frame.calculateScore(null)
            }
        }.sum()
    }


}