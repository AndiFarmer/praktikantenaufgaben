package dateiArbeit;

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WortFinder {

	private HashSet<Character> validWordComponents = new HashSet<>();
	private HashSet<Character> wordSeparators = new HashSet<>();
	
	public WortFinder() {
//		for (char c = 'A'; c <= 'Z' ; c++) {
//			validWordComponents.add(c);
//		}
//		for (char c = 'a'; c <= 'z' ; c++) {
//			validWordComponents.add(c);
//		}
//		for (char c = '0'; c <= '9'; c++) {
//			validWordComponents.add(c);
//		}
//		
//		for (char c = 0; c <= 31; c++) {
//			wordSeparators.add(c);
//		}
//		for (char c = 127; c <= 159; c++) {
//			wordSeparators.add(c);
//		} abgebrochenn wegen besserer Idee
		
	}

	public String swapWords(String fileContent, String deletionWord, String swapWord) {
		swapWord = Matcher.quoteReplacement(swapWord);
		deletionWord = Pattern.quote(deletionWord);
		return fileContent.replaceAll(deletionWord, swapWord);
//		return fileContent.replaceAll(Matcher.quoteReplacement(deletionWord), Matcher.quoteReplacement(swapWord));
	}
}
