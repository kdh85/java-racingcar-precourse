package racinggame.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import racinggame.model.dto.RacingResultDto;

public class Cars {

	private static final String SPLIT_SEPARATOR = ",";
	private static final String MSG_ERROR_CAR_INDEX = "유효한 차량선택이 아닙니다.";
	private static final int FIRST_CAR_INDEX = 0;
	private static final String MSG_ERROR_DUPLICATE_CAR = "[ERROR] 중복된 차량이름을 사용 할 수 없습니다. 다시 입력해 주세요.";

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

		List<String> splitNames = Arrays.asList(names.split(SPLIT_SEPARATOR));

		validationDuplicateCarNames(splitNames);

		return splitNames;
	}

	private static void validationDuplicateCarNames(final List<String> splitNames) {
		Set<String> duplicateNames = new HashSet<>(splitNames);

		if (isNotSameSize(splitNames, duplicateNames)) {
			throw new IllegalArgumentException(MSG_ERROR_DUPLICATE_CAR);
		}
	}

	private static boolean isNotSameSize(final List<String> splitNames, final Set<String> duplicateNames) {
		return duplicateNames.size() != splitNames.size();
	}

	public void moveEachCars(final List<Integer> movingCarIndex) {

		for (Integer carIndex : movingCarIndex) {
			validationCarIndex(carIndex);
			cars.get(carIndex).moveTheCar();
		}
	}

	private void validationCarIndex(final Integer carIndex) {

		if (carIndex > carCount()) {
			throw new IllegalArgumentException(MSG_ERROR_CAR_INDEX);
		}
	}

	public int carCount() {
		return cars.size();
	}

	public Car maxDistanceCars() {
		Car maxCar = firstCar();

		for (Car car : cars) {
			maxCar = car.maxDistanceCar(maxCar);
		}

		return maxCar;
	}

	private Car firstCar() {
		return cars.get(FIRST_CAR_INDEX);
	}

	public List<Car> sameMaxDistanceCars() {

		List<Car> maxCars = new ArrayList<>();

		for (Car car : cars) {
			addMaxCar(maxCars, car);
		}

		return maxCars;
	}

	private void addMaxCar(final List<Car> maxCars, final Car car) {
		if (car.isSameDistance(maxDistanceCars())) {
			maxCars.add(car);
		}
	}

	public RacingResultDto roundResult() {
		Map<String, Integer> result = new HashMap<>();

		for (Car car : cars) {
			result.put(car.carName(), car.distance());
		}
		return RacingResultDto.from(result);
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