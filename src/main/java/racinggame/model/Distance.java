package racinggame.model;

import java.util.Objects;

public class Distance {

	private static final int MIN_DISTANCE = 0;
	private static final String MSG_ERROR_MIN_DISTANCE = String.format("입력가능한 거리값은 %d이상 부터 입니다.", MIN_DISTANCE);

	private int distance;

	public Distance() {
		this(MIN_DISTANCE);
	}

	public Distance(int distance) {
		validationDistance(distance);
		this.distance = distance;
	}

	private void validationDistance(int distance) {
		if (distance < MIN_DISTANCE) {
			throw new IllegalArgumentException(MSG_ERROR_MIN_DISTANCE);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Distance distance1 = (Distance)o;
		return distance == distance1.distance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(distance);
	}

	@Override
	public String toString() {
		return "Distance{" +
			"distance=" + distance +
			'}';
	}

}