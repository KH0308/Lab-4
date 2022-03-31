package servertext;

public class TextGenerator {

	public String getCurrentText() {

		String currentText = "Hello, Im Using Eclipse";
		String length = String.valueOf(count(currentText));

		return length;
	}

	public static int count(String currentText) {
		if (currentText == null || currentText.isEmpty()) {
			return 0;
		}
		String[] words = currentText.split("\\s+");
		return words.length;
	}
}