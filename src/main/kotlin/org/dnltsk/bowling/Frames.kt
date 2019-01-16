package org.dnltsk.bowling

interface Frame {
    fun calculateScore(nextFrame: Frame?): Int
    fun getSpareBonus(): Int
    fun getStrikeBonus(): Int
}

class NormalFrame(private val rolls: Pair<Int, Int>) : Frame {

    override fun calculateScore(nextFrame: Frame?): Int {
        return rolls.first + rolls.second
    }

    override fun getSpareBonus(): Int {
        return rolls.first
    }

    override fun getStrikeBonus(): Int {
        return rolls.first + rolls.second
    }

}

class SpareFrame(private val firstRoll: Int) : Frame {

    override fun calculateScore(nextFrame: Frame?): Int {
        return 10 + (nextFrame?.getSpareBonus() ?: 0)
    }

    override fun getSpareBonus(): Int {
        return firstRoll
    }

    override fun getStrikeBonus(): Int {
        return 10
    }

}

class StrikeFrame : Frame {

    override fun calculateScore(nextFrame: Frame?): Int {
        return 10 + (nextFrame?.getStrikeBonus() ?: 0)
    }

    override fun getSpareBonus(): Int {
        return 10
    }

    override fun getStrikeBonus(): Int {
        return 10
    }

}