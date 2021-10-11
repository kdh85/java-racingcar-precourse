package racinggame.controller;

import racinggame.model.Racing;
import racinggame.model.dto.RacingResultDto;
import racinggame.service.RacingService;

public class RacingController {

	private final RacingService racingService;

	public RacingController() {
		this.racingService = new RacingService();
	}

	public RacingResultDto playRacing(final Racing racing){
		return racingService.playRacingResult(racing);
	}
}
