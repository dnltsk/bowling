package org.dnltsk.bowling

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SpareFrameTest{

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
            assertThat(frame.calculateScore())
                .`as`("issues with testCase $i")
                .isEqualTo(expectedScore)
        }
    }

}