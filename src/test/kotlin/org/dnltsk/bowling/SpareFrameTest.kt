package org.dnltsk.bowling

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SpareFrameTest {

    @Test
    fun `scoring of spare frames works correctly`() {
        val testCases = listOf(
            Pair(SpareFrame(0), 10),
            Pair(SpareFrame(2), 10),
            Pair(SpareFrame(9), 10)
        )
        testCases.forEachIndexed { i, it ->
            val frame = it.first
            val expectedScore = it.second
            assertThat(frame.calculateScore(null))
                .`as`("issues with testCase $i")
                .isEqualTo(expectedScore)
        }
    }

    @Test
    fun `scoring of spare frames adds a bonus`() {
        val testCases = listOf(
            Pair(NormalFrame(Pair(1, 2)), 11),
            Pair(SpareFrame(4), 14),
            Pair(StrikeFrame(), 20)
        )

        val spareFrame = SpareFrame(3)
        testCases.forEachIndexed { i, testCase ->
            val nextFrame = testCase.first
            val expectedScore = testCase.second
            assertThat(spareFrame.calculateScore(nextFrame))
                .`as`("issues with testCase $i")
                .isEqualTo(expectedScore)
        }
    }

}