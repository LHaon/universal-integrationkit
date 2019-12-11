package com.zfjh.integrationkit.safeutils;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;

/**
 * Encryption and decryption
 * <p>This class is a general encryption and decryption class.
 * <p>This class is more used for database encryption.
 *
 * @author zjh
 * @date 2019/12/9
 */
public class EncryptUtil {

    /**
     * @param sign     This is the signature used for decryption.
     * @param original Original password string.
     * @return
     */
    public static String encrypt(String sign, String original) {
        StringEncryptor stringEncryptor = createStringEncryptor(sign);
        String result = stringEncryptor.encrypt(original);
        return result;
    }

    public static String decrypt(String sign, String original) {
        StringEncryptor stringEncryptor = createStringEncryptor(sign);
        String result = stringEncryptor.decrypt(original);
        return result;
    }

    private static StringEncryptor createStringEncryptor(String sign) {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setPassword(sign);
        encryptor.setConfig(config);
        return encryptor;
    }
}
