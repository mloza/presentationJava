package pl.edu.pk.wieik.pwj.presentation.model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Klasa obiektu tworzącego hash 128 bitowy w postaci Stringa hexadecymalnego.
 *
 */
public class MD5 {
	/**
	 * Hashuje podany tekst w postaci niezakodowanej.
	 * @param plaintext
	 * @throws NoSuchAlgorithmException 
	 */
	public MD5(String plaintext) throws NoSuchAlgorithmException {
		MessageDigest md5Creator = MessageDigest.getInstance("MD5");
		byte[] digest = md5Creator.digest(plaintext.getBytes());
		BigInteger bigInt = new BigInteger(1, digest);
		hash = bigInt.toString(16);
	}
	
	@Override
	public String toString() {
		return hash;
	}
	
	String hash;
}
