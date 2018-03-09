import java.util.Arrays;

public class Tester {
	public static void main(String[] args) throws Exception {
		  String toEncrypt = "FOOBAR";

		  NewEncrypter encrypter = new NewEncrypter();

		  byte[] encryptedByteArray = encrypter.encrypt(toEncrypt);
		  System.out.println("encryptedByteArray:" + Arrays.toString(encryptedByteArray));

		  String decoded = new String(encryptedByteArray, "UTF-16");
		  System.out.println("decoded:" + decoded);

		  byte[] encoded = decoded.getBytes("UTF-16");
		  System.out.println("encoded:" + Arrays.toString(encoded));

		  String decryptedText = encrypter.decrypt(encryptedByteArray); // NOT the "encoded" value!
		  System.out.println("decryptedText:" + decryptedText);
		}
}
