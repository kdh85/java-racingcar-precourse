package racinggame.model;

import java.util.Objects;

public class Car {

	private final CarName carName;

	private final Distance distance;

	public Car(final String carName) {
		this(new CarName(carName), new Distance());
	}

	public Car(final CarName carName, final Distance distance) {
		this.carName = carName;
		this.distance = distance;
	}

	public void moveTheCar() {
		distance.moveForward();
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		final Car car = (Car)o;
		return Objects.equals(carName, car.carName) && Objects.equals(distance, car.distance);
	}

	@Override
	public int hashCode() {
		return Objects.hash(carName, distance);
	}

	@Override
	public String toString() {
		return "Car{" +
			"carName=" + carName +
			", distance=" + distance +
			'}';
	}
}