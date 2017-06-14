package util.helpers;

import net._01001111.text.LoremIpsum;

import java.lang.String;
import java.util.Date;
import java.util.Random;

public class RandomStringGenerator {
	private static Random random = new Random((int) new Date().getTime());

	public String getRandomString(int size) {
		StringBuilder builder = new StringBuilder();
		char ch;
		for (int i = 0; i < size; i++) {
			ch = (char) ((int) (Math.floor(26 * random.nextDouble() + 65)));
			ch = Character.toLowerCase(ch);
			if (i % 3 == 0) ch = Character.toUpperCase(ch);
			builder.append(ch);
		}

		return builder.toString();
	}

	public String getRandomWord() {
		return new LoremIpsum().randomWord();
	}

	public String getRandomSentence() {
		return new LoremIpsum().sentence();
	}

	public String getRandomSentences(int howMany) {
		return new LoremIpsum().sentences(howMany);
	}
}
