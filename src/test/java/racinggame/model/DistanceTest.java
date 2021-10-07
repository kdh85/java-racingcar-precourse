package racinggame.model;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DistanceTest {

	private Distance distance;

	@BeforeEach
	void setUp() {
		distance = new Distance(0);
	}

	@DisplayName("기본거리 0이 할당된 초기값 거리를 생성한다.")
	@Test
	void createDistanceTest() {
		assertThat(distance).isEqualTo(new Distance());
	}

	@DisplayName("기본거리값이 0 미만인 경우 에러가 발생한다.")
	@Test
	void validationDistanceTest() {
		assertThatThrownBy(
			() -> new Distance(-1)
		).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("거리가 1만큼 이동한다.")
	@ParameterizedTest
	@CsvSource(value = {"1|1", "2|2", "3|3"}, delimiter = '|')
	void moveDistanceTest(int maxCount, int maxDistance) {
		for (int count = 0; count < maxCount; count++) {
			distance.moveForward();
		}
		assertThat(distance).isEqualTo(new Distance(maxDistance));
	}

	@DisplayName("거리를 비교하여 더 큰값을 반환한다.")
	@Test
	void maxDistanceTest() {
		distance.moveForward();
		assertThat(distance.maxDistance(new Distance())).isEqualTo(distance);
	}
}