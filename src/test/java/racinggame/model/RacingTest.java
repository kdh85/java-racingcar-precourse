package racinggame.model;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RacingTest {

	@DisplayName("경주를 실행하여 결과값이 0 또는 1이 반환되는지 확인한다.")
	@Test
	void createRacingResultTest() {
		Racing racing = new Racing(1, "a,b,c");
		racing.play();

		assertThat(racing.racingResult()).anySatisfy(
			(name, distance) -> {
				assertThat(distance).isGreaterThanOrEqualTo(0);
				assertThat(distance).isLessThanOrEqualTo(1);
			});
	}

	@DisplayName("입력한 라운드값과 현재 라운드값이 동일한지 확인한다.")
	@ParameterizedTest
	@CsvSource(value = {"1|3|true", "3|3|false"}, delimiter = '|')
	void isContinueTest(int targetRound, int maxRound, boolean isMaxRound) {
		Racing racing = new Racing(maxRound, "a,b,c");

		for (int currentRound = 0; currentRound < targetRound; currentRound++) {
			racing.isContinue();
		}

		assertThat(racing.isContinue()).isEqualTo(isMaxRound);
	}
}