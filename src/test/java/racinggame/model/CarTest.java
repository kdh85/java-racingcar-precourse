package racinggame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

	private Car car;

	@BeforeEach
	void setUp() {
		car = new Car("car");
	}

	@DisplayName("차를 처음 생성할때 거리0인 차객체를 생성한다.")
	@Test
	void createCarTest() {
		assertThat(car).isEqualTo(new Car(new CarName("car"),new Distance(0)));
	}
}