package com.mps.think.utility.utils;

import java.util.Date;
import java.util.Random;

import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.KeyGenerators;

public class EncoderDecoder {

	private static Random rand = new Random((new Date()).getTime());

	public static void main(String[] args) throws Exception {
		String st = "secrete";
		//String enc = encrypt(st);
		//System.out.println("Encrypted string :" + enc);
		//System.out.println("Decrypted string :" + decrypt(enc));
		
		final String password = "1";  
		final String salt = "23623";
		TextEncryptor encryptor = Encryptors.text(password, salt);

		//String cipherText = encryptor.encrypt(textToEncrypt);

	//	String decryptedText = encryptor.decrypt(cipherText);
	}

	//public static String encrypt(String str) {
	/*	//BASE64Encoder encoder = new BASE64Encoder();
		//Encoder encode = new Encoder(false, null, 0, false);
		byte[] salt = new byte[8];
		rand.nextBytes(salt);
		return encoder.encode(salt) + encoder.encode(str.getBytes());
	}

	public static String decrypt(String encstr) {
		if (encstr.length() > 12) {
			String cipher = encstr.substring(12);
			BASE64Decoder decoder = new BASE64Decoder();
			try {
				return new String(decoder.decodeBuffer(cipher));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}*/
}
