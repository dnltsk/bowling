package org.dnltsk.bowling

interface Frame{
    fun calculateScore(): Int
}

class NormalFrame(val rolls: Pair<Int, Int>) : Frame{

    override fun calculateScore(): Int {
        return rolls.first + rolls.second
    }

}

class SpareFrame(val firstRoll: Int) : Frame{

    override fun calculateScore(): Int {
        return 10
    }

}

class StrikeFrame() : Frame{

    override fun calculateScore(): Int {
        return 10
    }

}