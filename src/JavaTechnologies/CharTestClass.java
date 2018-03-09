package JavaTechnologies;

public class CharTestClass {
	
	public static void main (String [] args) {
		
		char t = 'a';
		char t1 = 66;
		
		Print("String is: "+t);
		Print("String is: "+(++t));
		Print("String is: "+(t1+20));
		
		Print(isUpperCase('Z'));
		Print(isLowerCase('v'));
		Print(isDigitCase('5'));
		Print(getSumCase('1','a'));
		
	}

	// printer
	static void Print(Object value) {
		System.out.println(value);
	}
	
	// boolean check upper case letter
	static boolean isUpperCase(char chr) {
		boolean isCase = false;
		if(chr >=65 && chr <= 90 ) {
			isCase = true;
		}
		return isCase;
	}

	// boolean check upper case letter
	static boolean isLowerCase(char chr) {
		boolean isCase = false;
		if(chr >=97 && chr <=122) {
			isCase = true;
		}
		return isCase;
	}
	
	// boolean check upper case letter
	static boolean isDigitCase(char chr) {
		boolean isCase = false;
		if(chr >=48 && chr <= 57 ) {
			isCase = true;
		}
		return isCase;
	}
	
	// sum of char letters
	static int getSumCase(char chr1, char chr2) {
		return (chr1+chr2);
	}
	
}
