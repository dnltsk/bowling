package org.dnltsk.bowling

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class NormalFrameTest {

    private val testCases = listOf(
        Pair(NormalFrame(0, 0), 0),
        Pair(NormalFrame(1, 2), 3),
        Pair(NormalFrame(6, 3), 9)
    )

    @Test
    fun `scoring of normal frames works correctly`() {
        testCases.forEachIndexed { i, it ->
            val frame = it.first
            val expectedScore = it.second
            assertThat(frame.calculateScore(null))
                .`as`("issues with testCase $i")
                .isEqualTo(expectedScore)
        }
    }

    @Test
    fun `scoring of normal frames doesn't use any bonus`() {
        val nextFrames = listOf(
            NormalFrame(1, 2),
            SpareFrame(1),
            StrikeFrame()
        )

        val normalFrame = NormalFrame(1, 2)
        val expectedScore = 3
        nextFrames.forEachIndexed { i, nextFrame ->
            assertThat(normalFrame.calculateScore(nextFrame))
                .`as`("issues with testCase $i")
                .isEqualTo(expectedScore)
        }
    }

}