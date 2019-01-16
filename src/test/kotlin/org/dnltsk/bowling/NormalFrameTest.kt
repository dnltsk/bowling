package org.dnltsk.bowling

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class NormalFrameTest {

    @Test
    fun `scoring of normal frames works correctly`() {
        val testCases = listOf(
            Pair(NormalFrame(Pair(0, 0)), 0),
            Pair(NormalFrame(Pair(1, 2)), 3),
            Pair(NormalFrame(Pair(6, 3)), 9)
        )
        testCases.forEachIndexed { i, it ->
            val frame = it.first
            val expectedScore = it.second
            assertThat(frame.calculateScore())
                .`as`("issues with testCase $i")
                .isEqualTo(expectedScore)
        }
    }
}