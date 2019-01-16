package org.dnltsk.bowling

interface Frame {
    fun calculateScore(nextFrame: Frame?): Int
    fun getSpareBonus(): Int
    fun getStrikeBonus(): Int
}

class NormalFrame(private val firstRoll: Int, private val secondRoll: Int) : Frame {

    override fun calculateScore(nextFrame: Frame?): Int {
        return firstRoll + secondRoll
    }

    override fun getSpareBonus(): Int {
        return firstRoll
    }

    override fun getStrikeBonus(): Int {
        return firstRoll + secondRoll
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