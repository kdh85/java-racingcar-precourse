package racinggame.model;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

	@DisplayName("이동할 차량을 선택받으면 해당차량만 움직이고 이동거리를 비교하여 결과를 확인한다.")
	@Test
	void movingEachCarsTest() {
		newCars.moveEachCars(Collections.singletonList(1));
		assertThat(newCars.maxDistanceCars()).isEqualTo(new Car(new CarName("b"), new Distance(1)));
	}
}