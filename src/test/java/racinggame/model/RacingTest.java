package racinggame.model;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingTest {

	@DisplayName("경주를 실행하여 결과값이 0 또는 1이 반환되는지 확인한다.")
	@Test
	void createRacingResultTest() {
		Racing racing = new Racing(1, "a,b,c");
		racing.play();

		assertThat(racing.racingResult()).containsValues(0, 1);
	}
}