package org.dnltsk.bowling.read

import org.dnltsk.bowling.*
import org.springframework.stereotype.Service

@Service
class FrameParser {

    fun parseFrame(frame: String): Frame {
        return if (frame.length == 1 && frame == "X") {
            StrikeFrame()
        } else {
            if (frame.endsWith("/")) {
                val firstRoll = frame[0].toString().toInt()
                SpareFrame(firstRoll)
            } else {
                NormalFrame(frame[0].toString().toInt(), frame[1].toString().toInt())
            }
        }
    }

    fun parseLastFrame(frame: String): Frame {
        if (frame.length == 3) {
            val bonusRoll = parseBonusRoll(frame, 2)
            return LastFrame(
                SpareFrame(frame[0].toString().toInt()),
                bonusRoll)
        } else if (frame.length == 2)
            if (frame[0] == 'X') {
                val bonusRoll = parseBonusRoll(frame, 1)
                return LastFrame(
                    StrikeFrame(),
                    bonusRoll)
            }
        return LastFrame(
            NormalFrame(frame[0].toString().toInt(), frame[1].toString().toInt()),
            0)
    }

    private fun parseBonusRoll(frame: String, indexOf: Int): Int {
        val value = frame[indexOf].toString()
        return if (value == "X") {
            10
        } else {
            value.toInt()
        }

    }

}