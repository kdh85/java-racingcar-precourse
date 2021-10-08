package racinggame.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Cars {

	private static final String SPLIT_SEPARATOR = ",";

	private final List<Car> cars;

	public Cars(final String names) {
		this.cars = Collections.unmodifiableList(createNewCars(names));
	}

	public Cars(final List<Car> cars) {
		this.cars = Collections.unmodifiableList(cars);
	}

	private List<Car> createNewCars(final String names) {
		List<Car> newCars = new ArrayList<>();

		for (String carName : splitNames(names)) {
			newCars.add(new Car(carName));
		}
		return newCars;
	}

	private static List<String> splitNames(final String names) {
		return Arrays.asList(names.split(SPLIT_SEPARATOR));
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
