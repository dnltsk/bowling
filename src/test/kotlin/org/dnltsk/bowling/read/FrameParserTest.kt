package org.dnltsk.bowling.read

import org.assertj.core.api.Assertions.assertThat
import org.dnltsk.bowling.LastFrame
import org.dnltsk.bowling.NormalFrame
import org.dnltsk.bowling.SpareFrame
import org.dnltsk.bowling.StrikeFrame
import org.junit.Test

class FrameParserTest {

    private val parser = FrameParser()

    @Test
    fun `normal frame is detected correctly`() {
        val frame = parser.parseFrame("12")
        assertThat(frame).isInstanceOf(NormalFrame::class.java)
    }

    @Test
    fun `spare frame is detected correctly`() {
        val frame = parser.parseFrame("1/")
        assertThat(frame).isInstanceOf(SpareFrame::class.java)
    }

    @Test
    fun `strike frame is detected correctly`() {
        val frame = parser.parseFrame("X")
        assertThat(frame).isInstanceOf(StrikeFrame::class.java)
    }

    @Test
    fun `last frame is detected correctly`() {
        val testCases = listOf(
            Pair("01", 1),
            Pair("12", 3),
            Pair("0/0", 10),
            Pair("0/5", 15),
            Pair("0/X", 20),
            Pair("XX", 20)
        )
        testCases.forEachIndexed { i, it ->
            val frameString = it.first
            val expectedScore = it.second
            val frame = parser.parseLastFrame(frameString)
            assertThat(frame)
                .`as`("issues with testCase $i")
                .isInstanceOf(LastFrame::class.java)

            assertThat(frame.calculateScore(null))
                .`as`("issues with testCase $i")
                .isEqualTo(expectedScore)
        }
    }

}