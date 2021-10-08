package racinggame.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Cars {

	private final List<Car> cars;

	public Cars(final List<Car> cars) {
		this.cars = Collections.unmodifiableList(cars);
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		final Cars cars1 = (Cars)o;
		return Objects.equals(cars, cars1.cars);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cars);
	}

	@Override
	public String toString() {
		return "Cars{" +
			"cars=" + cars +
			'}';
	}
}
