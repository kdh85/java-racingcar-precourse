package racinggame.model.dto;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class RacingResultDto {

	private final Map<String, Integer> racingResult;

	private RacingResultDto(final Map<String, Integer> racingResult) {
		this.racingResult = Collections.unmodifiableMap(racingResult);
	}

	public static RacingResultDto from(final Map<String, Integer> result) {
		return new RacingResultDto(result);
	}

	public Map<String, Integer> getRacingResult() {
		return racingResult;
	}

	public Set<String> getCarName(){
		return racingResult.keySet();
	}

	public int getMoveDistance(final String carName){
		return racingResult.get(carName);
	}
}
