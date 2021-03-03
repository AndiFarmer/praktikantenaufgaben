package dateiArbeit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ROT13ConverterTest {

	ROT13Converter testROT13Converter = null;
	
	@Test
	void testConvert() {
		String editedFileContent = this.testROT13Converter.convert("testString");
		Assertions.assertEquals("grfgFgevat", editedFileContent);
	}

	@Test
	void testConvert2() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {String editedFileContent = this.testROT13Converter.convert("12");}); // lambda ausdruck
	}
	

	@Test
	void testConvert3() {
		Assertions.assertDoesNotThrow(() -> {String editedFileContent = this.testROT13Converter.convert("abc");}); // lambda ausdruck
	}

//	@Test
//	void testConvert4() {
//		String editedFileContent;
//		try {
//			editedFileContent = this.testROT13Converter.convert("1");
//		} catch (IllegalArgumentException e) {
//			e.printStackTrace();
//			Assertions.assertTrue(false, "Laufzeitfehler aufgetreten");
//		}
//		Assertions.assertTrue(true);
//	}
	
	@BeforeEach
	public void getConverter() { // vor jeder anderen Methode ausgeführt
		this.testROT13Converter = ROT13Converter.getInstance();
	}
	
	@BeforeAll
	public static void setUpAll() { // einmal am ganz am Anfang vor jeder anderen Methode ausgeführt
		
	}
	
//	@AfterEach
//	...
//	
//	@AfterAll
//	... //zB beim Datenbank schließen
}
