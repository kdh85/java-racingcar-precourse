package racinggame.model;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Round {

	private static final int ROUND_VALUE = 1;
	private static final String MSG_ERROR_MIN_ROUND = String.format("라운드값은 최소 %d부터 가능합니다.", ROUND_VALUE);

	private final int round;

	private final AtomicInteger currentRound = new AtomicInteger();

	public Round(final int round) {
		validationRound(round);
		this.round = round;
	}

	private void validationRound(final int round) {
		if (round < ROUND_VALUE) {
			throw new IllegalArgumentException(MSG_ERROR_MIN_ROUND);
		}
	}

	public void increaseRound() {
		currentRound.incrementAndGet();
	}

	public boolean isMaxRound() {
		return round == currentRound.get();
	}

	public int maxRound() {
		return round;
	}

	public AtomicInteger currentRound(){
		return currentRound;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		final Round round1 = (Round)o;
		return round == round1.round && Objects.equals(currentRound, round1.currentRound);
	}

	@Override
	public int hashCode() {
		return Objects.hash(round, currentRound);
	}

	@Override
	public String toString() {
		return "Round{" +
			"round=" + round +
			", currentRound=" + currentRound +
			'}';
	}
}
