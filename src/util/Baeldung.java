package src.util;

import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.cms.*;
import org.bouncycastle.cms.jcajce.JceCMSContentEncryptorBuilder;
import org.bouncycastle.cms.jcajce.JceKeyTransRecipientInfoGenerator;
import org.bouncycastle.operator.OutputEncryptor;
import org.bouncycastle.operator.jcajce.JcaAlgorithmParametersConverter;

import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.security.spec.MGF1ParameterSpec;

public class Baeldung {

    private static Baeldung b;

    public static Baeldung getInstance(){
        if(b == null){
            b = new Baeldung();
        }
        return b;
    }

    public static byte[] encrypt(String input, X509Certificate receiverCert) throws
            CertificateEncodingException,
            CMSException,
            IOException, InvalidAlgorithmParameterException {

        byte[] encryptedData = null;
        byte[] data = input.getBytes();

        CMSEnvelopedDataGenerator envelopedGenerator = new CMSEnvelopedDataGenerator();

        JcaAlgorithmParametersConverter paramsConverter = new JcaAlgorithmParametersConverter();
        OAEPParameterSpec oaepSpec = new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT);

        AlgorithmIdentifier algorithmIdentifier;
        algorithmIdentifier = paramsConverter.getAlgorithmIdentifier(PKCSObjectIdentifiers.id_RSAES_OAEP, oaepSpec);
        JceKeyTransRecipientInfoGenerator recipent = new JceKeyTransRecipientInfoGenerator(receiverCert, algorithmIdentifier).setProvider("BC");

        envelopedGenerator.addRecipientInfoGenerator(recipent);
        CMSTypedData msg = new CMSProcessableByteArray(data);
        OutputEncryptor encryptor
                = new JceCMSContentEncryptorBuilder(CMSAlgorithm.AES128_CBC)
                .setProvider("BC").build();
        CMSEnvelopedData cmsEnvelopedData = envelopedGenerator
                .generate(msg,encryptor);
        encryptedData = cmsEnvelopedData.getEncoded();

        /*
        CMSEnvelopedData envelopedData;
        envelopedData = envelopedGenerator.generate(
                new CMSProcessableByteArray(encodedSignedData),
                new JceCMSContentEncryptorBuilder(CMSAlgorithm.AES128_CBC).setProvider("BC").build()
        )*/
        /*
        if (null != data && null != encryptionCertificate) {
            CMSEnvelopedDataGenerator cmsEnvelopedDataGenerator
                    = new CMSEnvelopedDataGenerator();

            JceKeyTransRecipientInfoGenerator jceKey
                    = new JceKeyTransRecipientInfoGenerator(encryptionCertificate);
            cmsEnvelopedDataGenerator.addRecipientInfoGenerator(jceKey);
            CMSTypedData msg = new CMSProcessableByteArray(data);
            OutputEncryptor encryptor
                    = new JceCMSContentEncryptorBuilder(CMSAlgorithm.AES128_CBC)
                    .setProvider("BC").build();
            CMSEnvelopedData cmsEnvelopedData = cmsEnvelopedDataGenerator
                    .generate(msg,encryptor);
            encryptedData = cmsEnvelopedData.getEncoded();
        }
        */
        return encryptedData;
    }

}
