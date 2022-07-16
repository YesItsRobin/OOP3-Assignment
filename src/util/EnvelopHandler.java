package src.util;

import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.cms.CMSAlgorithm;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.jcajce.JceCMSContentEncryptorBuilder;
import org.bouncycastle.cms.jcajce.JceKeyTransRecipientInfoGenerator;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.engines.RSAEngine;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.mail.smime.SMIMEEnvelopedGenerator;
import org.bouncycastle.mail.smime.SMIMEException;
import org.bouncycastle.operator.jcajce.JcaAlgorithmParametersConverter;

import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import javax.mail.internet.MimeBodyPart;

import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.security.spec.MGF1ParameterSpec;

public class EnvelopHandler {

    private static EnvelopHandler envHandler;

    public static EnvelopHandler getInstance(){
        if(envHandler == null){
            envHandler = new EnvelopHandler();
        }
        return envHandler;
    }

    public static MimeBodyPart createEnveloped(
            X509Certificate encryptionCert,
            MimeBodyPart message)
            throws GeneralSecurityException, CMSException, SMIMEException
    {
        SMIMEEnvelopedGenerator envGen = new SMIMEEnvelopedGenerator();

        JcaAlgorithmParametersConverter paramsConverter =
                new JcaAlgorithmParametersConverter();

        AlgorithmIdentifier oaepParams = paramsConverter.getAlgorithmIdentifier(
                PKCSObjectIdentifiers.id_RSAES_OAEP,
                new OAEPParameterSpec("SHA-256",
                        "MGF1", new MGF1ParameterSpec("SHA-256"),
                        PSource.PSpecified.DEFAULT));

        envGen.addRecipientInfoGenerator(
                new JceKeyTransRecipientInfoGenerator(
                        encryptionCert, oaepParams).setProvider("BC"));

        return envGen.generate(message,
                new JceCMSContentEncryptorBuilder(CMSAlgorithm.AES256_CBC)
                        .setProvider("BC")
                        .build());
    }

}
