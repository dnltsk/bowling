package org.dnltsk.bowling.read

import org.dnltsk.bowling.Frame
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.io.File

@Service
class GameReader {

    @Autowired
    private lateinit var fileReader: FileReader

    @Autowired
    private lateinit var frameParser: FrameParser

    fun readGameFile(filename: String): List<Frame> {
        val gameString = fileReader.readFile(filename)
        val frameStrings = gameString.split(" ")
        return frameStrings.map(frameParser::parseFrame)
    }

}

@Service
class FileReader {

    fun readFile(filename: String): String {
        return File(filename).readLines()[0]
    }

}

@Service
class FrameParser {

    fun parseFrame(frame: String): Frame {
        return if (frame.length == 1 && frame.equals("X")) {
            Frame(Pair(10, 0))
        } else {
            if (frame.endsWith("/")) {
                val firstRoll = frame[0].toString().toInt()
                Frame(Pair(firstRoll, 10 - firstRoll))
            } else {
                Frame(Pair(frame[0].toString().toInt(), frame[1].toString().toInt()))
            }
        }
    }

}
