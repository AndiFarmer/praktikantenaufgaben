package dateiArbeit;

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WortFinder {

	private static WortFinder singleton = null;
	
	private WortFinder() {
		
	}

	public String swapWords(String fileContent, String deletionWord, String swapWord) {
		swapWord = Matcher.quoteReplacement(swapWord);
		deletionWord = Pattern.quote(deletionWord);
		return fileContent.replaceAll(deletionWord, swapWord);
	}
	
	public static WortFinder getInstance() {
		if (WortFinder.singleton == null) {
			WortFinder.singleton = new WortFinder();
		}
		return WortFinder.singleton;
	}
}
