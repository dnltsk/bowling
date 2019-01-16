package org.dnltsk.bowling

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class StrikeFrameTest {

    @Test
    fun `scoring of strike frames works correctly`() {
        val frame = StrikeFrame()
        assertThat(frame.calculateScore()).isEqualTo(10)
    }

}