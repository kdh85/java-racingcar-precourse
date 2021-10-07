package racinggame.model;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {

	private CarName carName;

	@BeforeEach
	void setUp() {
		carName = new CarName("car");
	}

	@DisplayName("문자열을 입력받아 이름을 생성한다.")
	@Test
	void createNameTest() {
		assertThat(carName).isEqualTo(new CarName("car"));
	}

	@DisplayName("차이름이 5글자를 초과하면 에러가 발생한다.")
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {"carOne"})
	void validationCarNameTest(String name) {
		assertThatThrownBy(
			() -> new CarName(name)
		).isInstanceOf(IllegalArgumentException.class);
	}
}