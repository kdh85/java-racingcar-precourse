package racinggame.view;

import java.util.concurrent.atomic.AtomicInteger;

import racinggame.model.dto.RacingResultDto;

public class ResultView {

	private static final String MSG_RESULT_TITLE = "실행 결과";
	private static final String PROGRESS_BAR = "-";
	private static final String MSG_WINNER = "최종 우승자는 %s 입니다.";
	private static final String NAME_BAR_SEPARATOR = " : ";

	public static void printResultTitle() {
		System.out.println(MSG_RESULT_TITLE);
	}

	public static void printRacingProgress(final RacingResultDto racingResultDto) {

		for (String carName : racingResultDto.getCarName()) {
			System.out.println(carName + NAME_BAR_SEPARATOR + printRacingBar(racingResultDto.getMoveDistance(carName)));
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
		System.out.printf((MSG_WINNER) + System.lineSeparator(), winner);
	}
}
