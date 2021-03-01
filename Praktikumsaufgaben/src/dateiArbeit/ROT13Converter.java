package dateiArbeit;

import java.util.ArrayList;
import java.util.HashMap;

public class ROT13Converter {

	private char[] lowercaseAlphabet = new char[26]; //Ohne Umlaute
	private char[] uppercaseAlphabet = new char[26]; //Ohne Umlaute
	
	private HashMap<Character,Character> buchstabenZuordnung = new HashMap<>();
	
	private char[][] buchstabenZuordnungArr = new char[26][2];
	
	public ROT13Converter() {
		for (char c = 'a'; c <= 'z'; c++) {
			this.lowercaseAlphabet[c - 'a'] = c;
		}
		for (char c = 'A'; c <= 'Z'; c++) {
			this.uppercaseAlphabet[c - 'A'] = c;
		}
		
		////////////////////////////////
		for (char c = 'a'; c <= 'z'; c++) {
			this.buchstabenZuordnung.put(c, this.lowercaseAlphabet[((c - 'a') + 13) % 26]);
		}
		for (char c = 'A'; c <= 'Z'; c++) {
			this.buchstabenZuordnung.put(c, this.uppercaseAlphabet[((c - 'A') + 13) % 26]);
		}
		////////////////////////////////
//		int indexBuchstabenZuordnungArr = 0;
		for (int c = 'a', indexBuchstabenZuordnungArr = 0; c <= 'm'; c++, indexBuchstabenZuordnungArr++) {
			buchstabenZuordnungArr[indexBuchstabenZuordnungArr][0] = (char) c;
			buchstabenZuordnungArr[indexBuchstabenZuordnungArr][1] = this.lowercaseAlphabet[((c - 'a') + 13) % 26];
		}
		for (int c = 'A', indexBuchstabenZuordnungArr = 13; c <= 'M'; c++, indexBuchstabenZuordnungArr++) {
			buchstabenZuordnungArr[indexBuchstabenZuordnungArr][0] = (char) c;
			buchstabenZuordnungArr[indexBuchstabenZuordnungArr][1] = this.uppercaseAlphabet[((c - 'A') + 13) % 26];
		}
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
	
//	public String convert(String input) {
//		StringBuffer sb = new StringBuffer();
//		for (int i = 0; i < input.length(); i++) {
//			char c = input.charAt(i);
//			c = this.buchstabenZuordnung.containsKey(c) ? this.buchstabenZuordnung.get(input.charAt(i)) : c ;
//			sb.append(c);
//		}
//		return sb.toString();
//	}
	
	public String convert(String input) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			c = this.searchPartnerLetter(c);
			sb.append(c);
		}
		return sb.toString();
	}
	
	public char searchPartnerLetter(char cInput) {
		for (int i = 0; i < this.buchstabenZuordnungArr.length; i++) {
			for (int j = 0; j < this.buchstabenZuordnungArr[i].length; j++) {
				if (this.buchstabenZuordnungArr[i][j] == cInput) {
					return j == 0 ? this.buchstabenZuordnungArr[i][1] : this.buchstabenZuordnungArr[i][0];
				}
			}
		}
		return cInput;
	}
	
}
