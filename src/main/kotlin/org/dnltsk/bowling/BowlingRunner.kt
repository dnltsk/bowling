package org.dnltsk.bowling

import org.dnltsk.bowling.read.GameReader
import org.dnltsk.bowling.score.GameScorer
import org.dnltsk.bowling.write.ScoreWriter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Service

@Service
class BowlingRunner : CommandLineRunner {

    @Autowired
    private lateinit var reader: GameReader

    @Autowired
    private lateinit var scorer: GameScorer

    @Autowired
    private lateinit var writer: ScoreWriter

    override fun run(vararg args: String?) {
        if(args.isEmpty()){
            throw IllegalArgumentException("path to game must be set, e.g. folder/game.txt")
        }
        val game = reader.readGameFile(args[0]!!)
        val score = scorer.scoreGame(game)
        writer.writeScore(score)
    }

}