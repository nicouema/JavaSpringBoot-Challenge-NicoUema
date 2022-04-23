package com.alkemy.disneyAPI;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest
@ComponentScan("com.alkemy.disneyAPI.repositories")
@EntityScan("com.alkemy.disneyAPI.classes")
class DisneyApiApplicationTests {

	@Test
	void contextLoads() {
	}

}
