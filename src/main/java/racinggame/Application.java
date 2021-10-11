package racinggame;

import racinggame.controller.RacingController;
import racinggame.model.Cars;
import racinggame.model.Racing;
import racinggame.model.Round;
import racinggame.view.InputView;
import racinggame.view.ResultView;

public class Application {

	private static final String MSG_INSERT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String MSG_INSERT_MAX_ROUND = "시도할 회수는 몇회인가요?";

	public static void main(String[] args) {

		Racing racing = new Racing(createCars(), createRound());

		ResultView.printResultTitle();

		RacingController racingController = new RacingController();

		while (racing.isContinue()) {
			ResultView.printRacingProgress(racingController.playRacing(racing));
		}

		ResultView.printWinner(racing.winner());
	}

	private static Cars createCars() {
		Cars cars;

		do {
			cars = tryCreateCars();
		} while (cars == null);

		return cars;
	}

	private static Cars tryCreateCars() {
		Cars cars = null;

		try {
			cars = new Cars(InputView.inputData(MSG_INSERT_CAR_NAMES));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		return cars;
	}

	private static Round createRound() {
		Round round;

		do {
			round = tryCreateRound();
		} while (round == null);

		return round;
	}

	private static Round tryCreateRound() {
		Round round = null;

		try {
			round = new Round(InputView.inputData(MSG_INSERT_MAX_ROUND));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		return round;
	}

}
