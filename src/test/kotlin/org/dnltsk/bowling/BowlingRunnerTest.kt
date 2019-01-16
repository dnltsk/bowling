package org.dnltsk.bowling

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.dnltsk.bowling.read.GameReader
import org.dnltsk.bowling.score.GameScorer
import org.dnltsk.bowling.write.ScoreWriter
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BowlingRunnerTest{

    @InjectMocks
    private lateinit var runner: BowlingRunner

    @Mock
    private lateinit var reader: GameReader

    @Mock
    private lateinit var scorer: GameScorer

    @Mock
    private lateinit var writer: ScoreWriter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun `missing path throws exception`() {
        assertThatThrownBy {
            runner.run()
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `source file name is forwarded to GameReader`() {
        runner.run("/sample.txt")
        verify(reader).readGameFile("/sample.txt")
    }

    @Test
    fun `game is forwarded to GameScorer`() {
        val sampleGame = emptyList<Frame>()
        whenever(reader.readGameFile(any())).thenReturn(sampleGame)
        runner.run("dummy-file")
        verify(scorer).scoreGame(eq(sampleGame))
    }

    @Test
    fun `score are forwarded to ScoreWriter`() {
        val sampleScore = 0
        whenever(scorer.scoreGame(any())).thenReturn(sampleScore)
        runner.run("dummy-file")
        verify(writer).writeScore(eq(sampleScore))
    }


}