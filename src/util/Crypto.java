package src.util;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.*;

import org.bouncycastle.jcajce.io.CipherInputStream;
import org.bouncycastle.jcajce.io.CipherOutputStream;
import org.bouncycastle.util.io.Streams;

public class Crypto {

    public static void crypt() throws
            NoSuchAlgorithmException,
            NoSuchProviderException,
            NoSuchPaddingException,
            InvalidKeyException,
            IOException,
            InvalidAlgorithmParameterException
    {
        // Text Input to Encrypt and Decrypt
        String body = "You will now have a number of threads running decryption. Whenever one is ready, have it put the results in the Collection which in the end is shown on the screen. Use the Observable Design Pattern (or rather the Observable Cascade) to update the GUI anytime a message has been finished.";
        System.out.println("BODY: " + body);
        //String to Byte before encrypting
        byte[] input = body.getBytes();
        System.out.println("as byte: " + input);

        // Generate Test Key
        KeyGenerator kGen = KeyGenerator.getInstance("AES", "BC");
        SecretKey key = kGen.generateKey();

        // Create Cipher
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding", "BC");
        //Set Cipher to encrypt using key
        cipher.init(Cipher.ENCRYPT_MODE, key);
        AlgorithmParameters ivParams = cipher.getParameters();

        // ENCRYPT text
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        CipherOutputStream cOut = new CipherOutputStream(bOut, cipher);
        cOut.write(input);
        cOut.close();
        byte[] encrypted = bOut.toByteArray();
        System.out.println("encrypted: " + encrypted);
        //Byte to String after decrypting
        String encryptedBody = new String(encrypted);
        System.out.println("encrypted body: " + encryptedBody);

        //Set Cipher to decrypt using encrypt params??
        cipher.init(Cipher.DECRYPT_MODE, key, ivParams);

        // DECRYPT ciphered text
        ByteArrayInputStream bIn = new ByteArrayInputStream(encrypted);
        CipherInputStream cIn = new CipherInputStream(bIn, cipher);
        byte[] decrypted = Streams.readAll(cIn);
        System.out.println("decrypted: " + decrypted);
        //Byte to String after decrypting
        String decryptedBody = new String(decrypted);
        System.out.println("decrypted body: " + decryptedBody);
        //done



    }
}

