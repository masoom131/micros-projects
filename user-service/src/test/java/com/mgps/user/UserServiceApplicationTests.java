package com.mgps.user;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

	/*@Autowired
	private RatingService ratingService;*/

	@Test
	void contextLoads() {
	}


	/*@Test
	void createRating() {
		ResponseEntity<Rating> ratingSave = ratingService.createRating(
			Rating.builder().rating(10).uid("").hid("").feedback("created using feign client!.").build()
		);

		System.out.println("new rating created!.");
	}*/
}
