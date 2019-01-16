package org.dnltsk.bowling

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class StrikeFrameTest {

    @Test
    fun `scoring of strike frames works correctly`() {
        val frame = StrikeFrame()
        assertThat(frame.calculateScore(null)).isEqualTo(10)
    }

    @Test
    fun `scoring of strike frames adds a bonus`() {
        val testCases = listOf(
            Pair(NormalFrame(1, 2), 13),
            Pair(SpareFrame(4), 20),
            Pair(StrikeFrame(), 20),
            Pair(LastFrame(NormalFrame(1,2),0), 13),
            Pair(LastFrame(NormalFrame(1,2),5), 13)
        )

        val strikeFrame = StrikeFrame()
        testCases.forEachIndexed { i, testCase ->
            val nextFrame = testCase.first
            val expectedScore = testCase.second
            assertThat(strikeFrame.calculateScore(nextFrame))
                .`as`("issues with testCase $i")
                .isEqualTo(expectedScore)
        }
    }

}