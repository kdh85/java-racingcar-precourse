package racinggame.model;

import java.util.Objects;

public class CarName {

	private static final int MAX_CAR_NAME_LENGTH = 5;
	private static final String MSG_ERROR_NAME_LENGTH = String.format("차량이름은 최대 %d글자까지 가능합니다.", MAX_CAR_NAME_LENGTH);
	private static final String MSG_ERROR_EMPTY_NAME = "차량이름이 비었습니다. 이름을 입력해주세요.";

	private final String carName;

	public CarName(final String carName) {
		validationCarName(carName);
		this.carName = carName;
	}

	private void validationCarName(final String carName) {
		if (carName == null || carName.isEmpty()) {
			throw new IllegalArgumentException(MSG_ERROR_EMPTY_NAME);
		}

		if (carName.length() > MAX_CAR_NAME_LENGTH) {
			throw new IllegalArgumentException(MSG_ERROR_NAME_LENGTH);
		}
	}

	public boolean isSameName(final CarName carName) {
		return this.equals(carName);
	}

	public String name() {
		return carName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		CarName carName1 = (CarName)o;
		return Objects.equals(carName, carName1.carName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(carName);
	}

	@Override
	public String toString() {
		return "CarName{" +
			"carName='" + carName + '\'' +
			'}';
	}
}
