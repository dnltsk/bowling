package org.dnltsk.bowling.read

import org.assertj.core.api.Assertions.assertThat
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

}