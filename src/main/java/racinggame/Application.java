package racinggame;

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

		while (racing.isContinue()) {
			racing.play();

			ResultView.printRacingProgress(racing.racingResult());
		}

		ResultView.printWinner(racing.winner());
	}

	private static Cars createCars() {
		Cars cars = null;

		while (cars == null) {
			try {
				cars = new Cars(InputView.inputData(MSG_INSERT_CAR_NAMES));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
		return cars;
	}

	private static Round createRound() {
		Round round = null;

		while (round == null) {
			try {
				round = new Round(InputView.inputData(MSG_INSERT_MAX_ROUND));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
		return round;
	}

}
