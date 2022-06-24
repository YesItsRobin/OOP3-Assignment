package src.models;

//I am not sure if this is correctly imported?
//I was working on this part in inellij maven at first,
//this was quickest way to migrate.
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.RSAPublicKeyStructure;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.*;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.RSAKeyGenerationParameters;
import org.bouncycastle.crypto.generators.*;
import org.bouncycastle.crypto.params.RSAKeyParameters;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;

/*
I have he feeling that I need create a KeyFactory, that can create either:
- public keys, or private keys. (from bouncy castle)

Then I have to make sure if another encryption package is used.
This KeyFactory has to be altered, but all other classes should not have to change.
I'm not sure how to accomplish this except that
I would have to use Factory and Strategy design pattern combination?
-- Djoï */

public class KeyFactory {
    private static KeyFactory instance = new KeyFactory();

    public static KeyFactory getInstance(){
            return instance;
    }

    private RSAKeyPairGenerator rsaKeyPairGenerator;
    private AsymmetricCipherKeyPair kp;

    private KeyFactory(){
            rsaKeyPairGenerator = new RSAKeyPairGenerator();
            rsaKeyPairGenerator.init(new RSAKeyGenerationParameters(BigInteger.valueOf(0x10001),new SecureRandom(),2048,80));
            kp = rsaKeyPairGenerator.generateKeyPair();
    }

    public AsymmetricCipherKeyPair getKeyPair(){
            return kp;
    }

    public byte[] getPrivateKey() throws IOException {
            RSAKeyParameters params = (RSAKeyParameters)kp.getPrivate();
            RSAPublicKeyStructure struct = new RSAPublicKeyStructure(params.getModulus(),params.getExponent());
            byte[] bytes = struct.toASN1Primitive().getEncoded();

            return bytes;
    }

    public byte[] getPublicKey() throws IOException {
            RSAKeyParameters params = (RSAKeyParameters) kp.getPublic();
            RSAPublicKeyStructure struct = new RSAPublicKeyStructure(params.getModulus(), params.getExponent());
            byte[] bytes = struct.toASN1Primitive().getEncoded();

            return bytes;
    }

    //RSAKeyPairGenerator kpGenerator = new RSAKeyPairGenerator();
    //kpGenerator.getInstance(new SecureRandom,2048);
}

