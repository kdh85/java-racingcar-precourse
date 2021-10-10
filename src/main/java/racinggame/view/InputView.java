package racinggame.view;

import nextstep.utils.Console;

public class InputView {

	public static String inputData(String message){
		System.out.println(message);
		return Console.readLine();
	}
}