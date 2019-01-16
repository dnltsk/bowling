package org.dnltsk.bowling

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BowlingApplicationTests {

	@Test
	fun contextLoads() {
		assertThat(true).isTrue()
	}

}

