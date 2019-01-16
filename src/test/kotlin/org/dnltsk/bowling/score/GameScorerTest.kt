package org.dnltsk.bowling.score

import org.assertj.core.api.Assertions.assertThat
import org.dnltsk.bowling.NormalFrame
import org.dnltsk.bowling.SpareFrame
import org.dnltsk.bowling.StrikeFrame
import org.junit.Test

class GameScorerTest {

    private val scorer = GameScorer()

    @Test
    fun `sum one normal frame is calculated correctly`() {
        val frames = listOf(NormalFrame(1, 2))
        val score = scorer.scoreGame(frames)
        assertThat(score).isEqualTo(3)
    }

    @Test
    fun `sum multiple normal frames is calculated correctly`() {
        val frames = listOf(
            NormalFrame(1, 2),
            NormalFrame(1, 2)
        )
        val score = scorer.scoreGame(frames)
        assertThat(score).isEqualTo(6)
    }

    @Test
    fun `complex example produces the correct sum`() {
        val frames = listOf(
            NormalFrame(1, 2),      // 3 (+0)
            SpareFrame(1),  // 10 (+10)
            StrikeFrame(),          // 10 (+10)
            SpareFrame(4),  // 10 (+2)
            NormalFrame(2, 1)       // 3
        )
        val score = scorer.scoreGame(frames)
        assertThat(score).isEqualTo(58)
    }
}