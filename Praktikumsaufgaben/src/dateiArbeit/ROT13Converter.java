package dateiArbeit;

import java.util.HashMap;

public class ROT13Converter {

	private static char[] lowercaseAlphabet = new char[26]; //Ohne Umlaute
	private static char[] uppercaseAlphabet = new char[26]; //Ohne Umlaute
	
	private static HashMap<Character,Character> buchstabenZuordnung = new HashMap<>();
	
	private static char[][] buchstabenZuordnungArr = new char[26][2];
	
	private static ROT13Converter singleton = null;
	
	static { // ausgeführt wenn das erste mal ausgeführt -> static initializer
		
	}
	
	private ROT13Converter() {
		for (char c = 'a'; c <= 'z'; c++) {
			ROT13Converter.lowercaseAlphabet[c - 'a'] = c;
		}
		for (char c = 'A'; c <= 'Z'; c++) {
			ROT13Converter.uppercaseAlphabet[c - 'A'] = c;
		}
		
		////////////////////////////////
		for (char c = 'a'; c <= 'z'; c++) {
			ROT13Converter.buchstabenZuordnung.put(c, ROT13Converter.lowercaseAlphabet[((c - 'a') + 13) % 26]);
		}
		for (char c = 'A'; c <= 'Z'; c++) {
			ROT13Converter.buchstabenZuordnung.put(c, ROT13Converter.uppercaseAlphabet[((c - 'A') + 13) % 26]);
		}
		////////////////////////////////
		for (int c = 'a', indexBuchstabenZuordnungArr = 0; c <= 'm'; c++, indexBuchstabenZuordnungArr++) {
			ROT13Converter.buchstabenZuordnungArr[indexBuchstabenZuordnungArr][0] = (char) c;
			ROT13Converter.buchstabenZuordnungArr[indexBuchstabenZuordnungArr][1] = ROT13Converter.lowercaseAlphabet[((c - 'a') + 13) % 26];
		}
		for (int c = 'A', indexBuchstabenZuordnungArr = 13; c <= 'M'; c++, indexBuchstabenZuordnungArr++) {
			ROT13Converter.buchstabenZuordnungArr[indexBuchstabenZuordnungArr][0] = (char) c;
			ROT13Converter.buchstabenZuordnungArr[indexBuchstabenZuordnungArr][1] = ROT13Converter.uppercaseAlphabet[((c - 'A') + 13) % 26];
		}
	}
	
	public static ROT13Converter getInstance() {
		if (ROT13Converter.singleton == null) {
			ROT13Converter.singleton = new ROT13Converter();
		}
		return ROT13Converter.singleton;
	}
	
//	public String convert(String input) {
//		StringBuffer sb = new StringBuffer();
//		for (int i = 0; i < input.length(); i++) {
//			char c = input.charAt(i);
//			if (c >= 'A' && c <= 'Z') {
//				sb.append(this.uppercaseAlphabet[((c - 'A') + 13) % 26]);
//			}
//			else if (c >= 'a' && c <= 'z') {
//				sb.append(this.lowercaseAlphabet[((c - 'a') + 13) % 26]);
//			}
//			else {
//				sb.append(c);
//			}
//		}
//		return sb.toString();
//	}
	
	public String convert(String input) throws IllegalArgumentException {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < input.length(); i++) {
			Character c = input.charAt(i);
//			c = ROT13Converter.buchstabenZuordnung.containsKey(c) ? ROT13Converter.buchstabenZuordnung.get(input.charAt(i)) : c ;
			c = ROT13Converter.buchstabenZuordnung.get(input.charAt(i));
			if (c == null) {
				throw new IllegalArgumentException("ungültiger Buchstabe '" + input.charAt(i) + "'");
			}
			sb.append(c);
		}
		return sb.toString();
	}
	
//	public String convert(String input) {
//		StringBuffer sb = new StringBuffer();
//		for (int i = 0; i < input.length(); i++) {
//			char c = input.charAt(i);
//			c = this.searchPartnerLetter(c);
//			sb.append(c);
//		}
//		return sb.toString();
//	}
//	
//	private char searchPartnerLetter(char cInput) {
//		for (int i = 0; i < ROT13Converter.buchstabenZuordnungArr.length; i++) {
//			for (int j = 0; j < ROT13Converter.buchstabenZuordnungArr[i].length; j++) {
//				if (ROT13Converter.buchstabenZuordnungArr[i][j] == cInput) {
//					return j == 0 ? ROT13Converter.buchstabenZuordnungArr[i][1] : ROT13Converter.buchstabenZuordnungArr[i][0];
//				}
//			}
//		}
//		return cInput;
//	}
	
}
