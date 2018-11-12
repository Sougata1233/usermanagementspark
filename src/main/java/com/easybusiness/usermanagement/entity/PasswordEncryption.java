package com.easybusiness.usermanagement.entity;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Formatter;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import org.springframework.beans.factory.annotation.Autowired;


public class PasswordEncryption {

	/*private static final String UNICODE_FORMAT = "UTF8";
    public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
    private KeySpec ks;
    private SecretKeyFactory skf;
    private Cipher cipher;
    byte[] arrayBytes;
    private String myEncryptionKey;
    private String myEncryptionScheme;
    SecretKey key;
    
	public PasswordEncryption() throws Exception{
		
		myEncryptionKey = "Sls";
        myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
        arrayBytes = this.myEncryptionKey.getBytes(UNICODE_FORMAT);
        ks = new DESedeKeySpec(arrayBytes);
        skf = SecretKeyFactory.getInstance(myEncryptionScheme);
        cipher = Cipher.getInstance(myEncryptionScheme);
        key = skf.generateSecret(ks);
	}
    
    
	public String encrypt(String unencryptedString) {
        String encryptedString = null;
        try {
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] plainText = unencryptedString.getBytes(UNICODE_FORMAT);
            byte[] encryptedText = cipher.doFinal(plainText);
            encryptedString = new String(Base64.encodeBase64(encryptedText));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedString;
    }
	
	public String decrypt(String encryptedString) {
        String decryptedText=null;
        try {
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] encryptedText = Base64.decodeBase64(encryptedString);
            byte[] plainText = cipher.doFinal(encryptedText);
            decryptedText= new String(plainText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decryptedText;
    }*/
	
	/*public String encryptPassword(String password) {
		String sha1 = "";
		try {
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(password.getBytes());
			sha1 = byteToHex(crypt.digest());
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return sha1;
	}


	private static String byteToHex(byte[] hash) {
		Formatter formatter = new Formatter();
		for(byte b : hash) {
			formatter.format("%02x", hash);
		}
		String result = formatter.toString();
		formatter.close();
		return result;
	}*/
	
	/*public String encryptPassword(String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(password.getBytes());
		
		byte byteData[] = md.digest();
		
		//convert byte to hex
		StringBuffer sb = new StringBuffer();
		for(int i = 0 ; i < byteData.length ; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		
		String hexdata = sb.toString();
		return hexdata;
		
	}*/
	
	
	//generating public and private key
	/*KeyPair keyPair = buildKeyPair();
	PublicKey pubKey = keyPair.getPublic();
	PrivateKey privateKey = keyPair.getPrivate();*/
    
	
	/*public KeyPair buildKeyPair() {
		final int keySize = 2048;
		KeyPairGenerator kpg = null;
		try {
			kpg = KeyPairGenerator.getInstance("RSA");
			kpg.initialize(keySize);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return kpg.genKeyPair();
	}


	public byte[] decrypt(PrivateKey privateKey, byte[] encrypted) {
		Cipher cipher = null;
		try {
			try {
				cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		} catch (NoSuchPaddingException e2) {
			e2.printStackTrace();
		}
		try {
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
		} catch (InvalidKeyException e1) {
			e1.printStackTrace();
		}
		byte[] cip = null;
		try {
			try {
				cip = cipher.doFinal(encrypted);
			} catch (IllegalBlockSizeException e) {
				e.printStackTrace();
			}
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return cip;
	}


	public static byte[] encrypt(PublicKey publicKey, byte[] string){
		Cipher cipher = null;
		try {
			cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		} catch (NoSuchAlgorithmException e2) {
			e2.printStackTrace();
		} catch (NoSuchPaddingException e2) {
			e2.printStackTrace();
		}
		try {
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		} catch (InvalidKeyException e1) {
			e1.printStackTrace();
		}
		byte[] cip = null;
		try {
			try {
				cip =  cipher.doFinal(string);
			} catch (IllegalBlockSizeException e) {
				e.printStackTrace();
			}
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		
		return cip;
	}*/

	
	
	
	
	
}
