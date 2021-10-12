package racinggame.model;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.model.dto.RacingResultDto;

class CarsTest {

	private Cars newCars;

	@BeforeEach
	void setUp() {
		List<Car> cars = Arrays.asList(
			new Car("a"),
			new Car("b"),
			new Car("c"));
		newCars = new Cars(cars);
	}

	@DisplayName("차들의 콜랙션을 주입하여 차의집합을 생성한다.")
	@Test
	void createCarsTest() {
		assertThat(newCars).isEqualTo(new Cars("a,b,c"));
	}

	@DisplayName("최대거리인 자동차와 동일한 거리의 차들을 반환한다.")
	@Test
	void sameDistanceCarsTest() {

		List<Car> maxCars = newCars.sameMaxDistanceCars();

		assertThat(maxCars).containsExactly(
			new Car("a", 0),
			new Car("b", 0),
			new Car("c", 0)
		);
	}

	@DisplayName("주행결과를 차량과 이동거리로 반환한다.")
	@Test
	void getResultTest() {

		newCars.sameMaxDistanceCars();

		RacingResultDto result = newCars.roundResult();

		assertAll(
			() -> assertThat(result.getMoveDistance("a")).isEqualTo(0),
			() -> assertThat(result.getMoveDistance("b")).isEqualTo(0),
			() -> assertThat(result.getMoveDistance("c")).isEqualTo(0)
		);
	}

	@DisplayName("입력되는 차랑명칭의 중복이 발생하면 에러가 반환된다.")
	@Test
	void validationDuplicateTest() {
		assertThatThrownBy(
			()-> new Cars("a,b,a")
		).isInstanceOf(IllegalArgumentException.class);
	}
}