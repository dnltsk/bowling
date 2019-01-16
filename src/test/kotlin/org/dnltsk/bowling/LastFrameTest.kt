package org.dnltsk.bowling

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class LastFrameTest{

    @Test
    fun `scoring of last frames are correct`() {
        val testCases = listOf(
            Pair(LastFrame(NormalFrame(1,2), 0), 3),
            Pair(LastFrame(SpareFrame(2), 0), 10),
            Pair(LastFrame(SpareFrame(2), 5), 15),
            Pair(LastFrame(StrikeFrame(), 0), 10),
            Pair(LastFrame(StrikeFrame(), 5), 15)
        )
        testCases.forEachIndexed { i, it ->
            val frame = it.first
            val expectedScore = it.second
            assertThat(frame.calculateScore(null))
                .`as`("issues with testCase $i")
                .isEqualTo(expectedScore)
        }
    }

}