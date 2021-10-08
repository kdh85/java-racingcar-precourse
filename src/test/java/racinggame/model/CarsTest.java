package racinggame.model;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

	private List<Car> cars;

	private Cars newCars;

	@BeforeEach
	void setUp() {
		cars = Arrays.asList(
			new Car("a"),
			new Car("b"),
			new Car("c"));
		newCars = new Cars(cars);
	}

	@DisplayName("차들의 콜랙션을 주입하여 차의집합을 생성한다.")
	@Test
	void createCarsTest() {
		assertThat(newCars).isEqualTo(new Cars(cars));
	}
}