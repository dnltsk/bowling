package org.dnltsk.bowling.read

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.assertj.core.api.Assertions.assertThat
import org.dnltsk.bowling.NormalFrame
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class GameReaderTest {

    @InjectMocks
    private lateinit var reader: GameReader

    @Mock
    private lateinit var fileReader: FileReader

    @Mock
    private lateinit var frameParser: FrameParser

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        //returns three defined frames
        whenever(fileReader.readFile(any())).thenReturn("12 12 12")
        //returns dummy frame
        whenever(frameParser.parseFrame(any())).thenReturn(NormalFrame(1, 2))
    }

    @Test
    fun `parsing a line works correctly`() {
        val frames = reader.readGameFile("dummy-file.txt")
        verify(frameParser, times(2)).parseFrame(any())
        verify(frameParser, times(1)).parseLastFrame(any())
        assertThat(frames).hasSize(3)
    }
}