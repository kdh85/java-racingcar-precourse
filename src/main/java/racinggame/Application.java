package racinggame;

import racinggame.model.Racing;
import racinggame.view.InputView;
import racinggame.view.ResultView;

public class Application {

	private static final String MSG_INSERT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String MSG_INSERT_MAX_ROUND = "시도할 회수는 몇회인가요?";

	public static void main(String[] args) {
		
		String names = InputView.inputData(MSG_INSERT_CAR_NAMES);
		String maxRound = InputView.inputData(MSG_INSERT_MAX_ROUND);

		Racing racing = new Racing(toInt(maxRound), names);

		ResultView.printResultTitle();

		while (racing.isContinue()) {
			racing.play();

			ResultView.printRacingProgress(racing.racingResult());
		}

		ResultView.printWinner(racing.winner());
	}

	private static int toInt(final String maxRound) {
		return Integer.parseInt(maxRound);
	}
}
