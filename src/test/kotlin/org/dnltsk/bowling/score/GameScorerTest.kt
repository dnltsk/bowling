package org.dnltsk.bowling.score

import org.assertj.core.api.Assertions.assertThat
import org.dnltsk.bowling.Frame
import org.junit.Test

class GameScorerTest {

    private val scorer = GameScorer()

    @Test
    fun `sum one normal frame is calculated correctly`() {
        val frames = listOf(Frame(Pair(1,2)))
        val score = scorer.scoreGame(frames)
        assertThat(score).isEqualTo(3)
    }

    @Test
    fun `sum multiple normal frames is calculated correctly`() {
        val frames = listOf(Frame(Pair(1,2)), Frame(Pair(1,2)))
        val score = scorer.scoreGame(frames)
        assertThat(score).isEqualTo(6)
    }
}