package racinggame.view;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ResultView {

	private static final String MSG_RESULT_TITLE = "실행 결과";
	private static final String PROGRESS_BAR = "-";
	private static final String MSG_WINNER = "최종 우승자는 %s 입니다.";

	public static void printResultTitle() {
		System.out.println(MSG_RESULT_TITLE);
	}

	public static void printRacingProgress(final Map<String, Integer> racingResult) {

		for (String carName : racingResult.keySet()) {
			System.out.println(carName + " : " + printRacingBar(racingResult.get(carName)));
		}
		System.out.println();
	}

	private static String printRacingBar(final int moveDistance) {
		StringBuilder progressBar = new StringBuilder();

		AtomicInteger distance = new AtomicInteger();

		while (distance.getAndIncrement() < moveDistance) {
			progressBar.append(PROGRESS_BAR);
		}

		return progressBar.toString();
	}

	public static void printWinner(final String winner) {
		System.out.printf((MSG_WINNER) + "%n", winner);
	}
}
