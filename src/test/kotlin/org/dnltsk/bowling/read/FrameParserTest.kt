package org.dnltsk.bowling.read

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class FrameParserTest{

    private val parser = FrameParser()

    @Test
    fun `normal frame is detected correctly`() {
        val frame = parser.parseFrame("12")
        assertThat(frame.rolls.first).isEqualTo(1)
        assertThat(frame.rolls.second).isEqualTo(2)
    }

    @Test
    fun `spare frame is detected correctly`() {
        val frame = parser.parseFrame("1/")
        assertThat(frame.rolls.first).isEqualTo(1)
        assertThat(frame.rolls.second).isEqualTo(9)
    }

    @Test
    fun `strike frame is detected correctly`() {
        val frame = parser.parseFrame("X")
        assertThat(frame.rolls.first).isEqualTo(10)
        assertThat(frame.rolls.second).isEqualTo(0)
    }

}