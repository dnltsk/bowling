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

        return frameStrings.mapIndexed { i, it ->
            if (i + 1 < frameStrings.size) {
                frameParser.parseFrame(it)
            }else{
                frameParser.parseLastFrame(it)
            }
        }
    }
}

@Service
class FileReader {

    fun readFile(filename: String): String {
        val firstLine = File(filename).readLines()[0]
        println("Game:  $firstLine")
        return firstLine
    }

}


