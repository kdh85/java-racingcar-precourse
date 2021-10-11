package racinggame.service;

import racinggame.model.Racing;
import racinggame.model.dto.RacingResultDto;

public class RacingService {

	public RacingResultDto playRacingResult(final Racing racing){
		racing.play();
		return racing.racingRoundResult();
	}
}
