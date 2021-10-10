package racinggame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicInteger;

import nextstep.utils.Randoms;

public class Racing {

	private static final int START_NUMBER = 0;
	private static final int END_NUMBER = 9;
	private static final int MOVABLE_NUMBER = 4;
	private static final String WINNER_SEPARATOR = ", ";

	private final Round round;

	private final Cars cars;

	public Racing(final String names, final int round) {
		this(new Cars(names), new Round(round));
	}

	public Racing(final Cars cars, final Round round) {
		this.round = round;
		this.cars = cars;
	}

	public void play() {
		cars.moveEachCars(choiceMovingCars());
	}

	private List<Integer> choiceMovingCars() {
		List<Integer> moveCarIndex = new ArrayList<>();

		AtomicInteger index = new AtomicInteger();

		while (index.intValue() < cars.carCount()) {
			addMovingCar(moveCarIndex, index.getAndIncrement());
		}

		return moveCarIndex;
	}

	private void addMovingCar(final List<Integer> moveCarIndex, final int carIndex) {
		if (isMovable()) {
			moveCarIndex.add(carIndex);
		}
	}

	private boolean isMovable() {
		return Randoms.pickNumberInRange(START_NUMBER, END_NUMBER) >= MOVABLE_NUMBER;
	}

	public Map<String,Integer> racingResult(){
		return cars.result();
	}

	public boolean isContinue() {
		if(!round.isMaxRound()){
			round.increaseRound();
			return true;
		}
		return false;
	}

	public String winner(){
		StringJoiner joiner = new StringJoiner(WINNER_SEPARATOR);

		for (Car car : cars.sameMaxDistanceCars()) {
			joiner.add(car.carName());
		}

		return joiner.toString();
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		final Racing racing = (Racing)o;
		return round == racing.round && Objects.equals(cars, racing.cars);
	}

	@Override
	public int hashCode() {
		return Objects.hash(round, cars);
	}

	@Override
	public String toString() {
		return "Racing{" +
			"round=" + round +
			", cars=" + cars +
			'}';
	}
}
