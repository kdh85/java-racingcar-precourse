package racinggame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

	private Car car;

	@BeforeEach
	void setUp() {
		car = new Car("car");
	}

	@DisplayName("차를 처음 생성할때 거리0인 차객체를 생성한다.")
	@Test
	void createCarTest() {
		assertThat(car).isEqualTo(new Car(new CarName("car"), new Distance(0)));
	}

	@DisplayName("차가 이동할때 거리객체 이동 메세지를 전달하면 거리1만큼 이동된다.")
	@Test
	void moveTheCarTest() {
		car.moveTheCar();
		assertThat(car).isEqualTo(new Car(new CarName("car"), new Distance(1)));
	}

	@DisplayName("차량생성시 중복된 차량이름이 입력시 판별값을 반환한다.")
	@ParameterizedTest
	@CsvSource(value = {"car|true", "cars|false"}, delimiter = '|')
	void duplicateCarTest(String name, boolean isSame) {
		assertThat(car.isSameName(new Car(name))).isEqualTo(isSame);
	}

	@DisplayName("차객체간 이동거리를 비교하여 더 멀리간 차를 반환한다.")
	@Test
	void maxDistanceCarTest() {
		car.moveTheCar();
		Car targetCar = new Car("car1");

		assertThat(car.maxDistanceCar(targetCar)).isEqualTo(car);
	}
}