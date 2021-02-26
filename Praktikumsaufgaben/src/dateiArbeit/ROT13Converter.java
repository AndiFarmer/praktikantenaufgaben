package dateiArbeit;

import java.util.HashMap;

public class ROT13Converter {

	char[] alphabet new char[52]; //Ohne Umlaute
	char[][] zuordnung = new char[26][2]; // 13 Upper- und 13 Downcase Buchstabenzuordnungen -> 56 Buchstaben
	
	public ROT13Converter() {
		
		for (int i = 0; i < 26; i++) {
			for (int j = 0; i < this.zuordnung[i].length; i++) {
				this.zuordnung[i][j] = 
			}
		}
	}
	
	public String convert(String input) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < input.length(); i++) {
			sb.append(input.charAt(i));
		}
	}
}
