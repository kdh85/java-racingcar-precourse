package racinggame.model;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RoundTest {
	private Round round;

	@BeforeEach
	void setUp() {
		round = new Round(1);
	}

	@DisplayName("정상적으로 라운드값이 증가되는지 확인한다.")
	@Test
	void increaseRound() {
		round.increaseRound();

		assertThat(round.currentRound().intValue()).isEqualTo(1);
	}

	@DisplayName("1 미만의 값으로 라운드가 생성되면 에러가 발생한다.")
	@Test
	void validationRound() {
		assertThatThrownBy(
			() -> new Round(0)
		).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("현재의 라운드값이 총 라운드값과 같은지 비교한다.")
	@ParameterizedTest
	@CsvSource(value = {"1|false", "2|true"}, delimiter = '|')
	void isMaxRound(int maxRound, boolean isMaxRoundCount) {

		AtomicInteger roundCount = new AtomicInteger();

		while (roundCount.incrementAndGet() < maxRound) {
			round.increaseRound();
		}

		assertThat(round.isMaxRound()).isEqualTo(isMaxRoundCount);
	}

	@DisplayName("입력받은 최대 라운드값을 반환한다.")
	@Test
	void maxRound() {
		assertThat(round.maxRound()).isEqualTo(1);
	}

	@DisplayName("문자열 카운트값을 검증하여 숫자 외의 문자가 입력되면 에러가 반환된다.")
	@ParameterizedTest
	@CsvSource(value = {"a", "A", "아", "!"})
	void validationStringValueTest(String count) {
		assertThatThrownBy(
			() -> new Round(count)
		).isInstanceOf(NumberFormatException.class);
	}
}