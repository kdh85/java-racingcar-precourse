package racinggame.model;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}