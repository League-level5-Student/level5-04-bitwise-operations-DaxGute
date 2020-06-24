package _03_Printing_Binary;

public class BinaryPrinter {
	//Complete the methods below so they print the passed in parameter in binary.
	//Use bit shifting and bit masking to print the binary numbers.
	//Do not use the Integer.toBinaryString method!
	//Don't be afraid to use the methods that are already complete to finish the others.
	//Create a main method to test your methods.
	
	public void printByteBinary(byte b) {
		String byteBinary = "";
		int currentPlace = b;
		do {
			if (currentPlace % 2 == 1) {
				byteBinary = "1"+byteBinary;
			}else {
				byteBinary = "0"+byteBinary;
			}
			currentPlace = currentPlace >> 1;
			
		}while (currentPlace > 0);
		for (int i = 0; i < 8-byteBinary.length(); i++) {
			byteBinary = "0" + byteBinary;
		}
		System.out.println(byteBinary);
	}
	
	public void printShortBinary(short s) {
		String shortBinary = "";
		int currentPlace = s;
		do {
			if (currentPlace % 2 == 1) {
				shortBinary = "1"+shortBinary;
			}else {
				shortBinary = "0"+shortBinary;
			}
			currentPlace = currentPlace >> 1;
			
		}while (currentPlace > 0);
		for (int i = 0; i < 16-shortBinary.length(); i++) {
			shortBinary = "0" + shortBinary;
		}
		System.out.println(shortBinary);
	}
	
	public void printIntBinary(int i) {
		String intBinary = "";
		int currentPlace = i;
		do {
			if (currentPlace % 2 == 1) {
				intBinary = "1"+intBinary;
			}else {
				intBinary = "0"+intBinary;
			}
			currentPlace = currentPlace >> 1;
			
		}while (currentPlace > 0);
		for (int j = 0; j < 32-intBinary.length(); j++) {
			intBinary = "0" + intBinary;
		}
		System.out.println(intBinary);
	}
	
	public void printLongBinary(long l) {
		String shortBinary = "";
		long currentPlace = l;
		do {
			if (currentPlace % 2 == 1) {
				shortBinary = "1"+shortBinary;
			}else {
				shortBinary = "0"+shortBinary;
			}
			currentPlace = currentPlace >> 1;
			
		}while (currentPlace > 0);
		for (int i = 0; i < 64-shortBinary.length(); i++) {
			shortBinary = "0" + shortBinary;
		}
		System.out.println(shortBinary);
	}
	public static void main(String[] args) {
		BinaryPrinter p = new BinaryPrinter();
		byte a = 8;
		p.printByteBinary(a);
		short b = 8;
		p.printShortBinary(b);
		int c = 8;
		p.printIntBinary(c);
		long d = 8;
		p.printLongBinary(d);
	}
}
