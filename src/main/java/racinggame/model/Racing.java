package racinggame.model;

import java.util.Objects;
import java.util.StringJoiner;

import racinggame.model.dto.RacingResultDto;

public class Racing {

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
		cars.moveEachCars();
	}

	public RacingResultDto racingRoundResult(){
		return cars.roundResult();
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
