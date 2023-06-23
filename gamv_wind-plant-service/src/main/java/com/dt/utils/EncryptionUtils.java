package com.dt.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class EncryptionUtils {

    private static final Logger logger = LoggerFactory.getLogger(EncryptionUtils.class);

    // public static String encryptPassword(String password) throws Exception {
    //
    // if (logger.isDebugEnabled()) {
    // logger.debug("Executing encryptPassword(password) ->");
    // }
    //
    // try {
    // StrongPasswordEncryptor strongPasswordEncryptor = new StrongPasswordEncryptor();
    // return strongPasswordEncryptor.encryptPassword(password);
    // } catch (Exception e) {
    // logger.error("Exception in encryptPassword(password) - " + e);
    // return null;
    // }
    // }
    //
    // public static boolean checkPassword(String normalPassword, String encryptedPassword)
    // throws Exception {
    //
    // if (logger.isDebugEnabled()) {
    // logger.debug("Executing checkPassword(normalPassword, encryptedPassword) ->");
    // }
    //
    // try {
    // StrongPasswordEncryptor strongPasswordEncryptor = new StrongPasswordEncryptor();
    // return strongPasswordEncryptor.checkPassword(normalPassword, encryptedPassword);
    // } catch (Exception e) {
    // logger.error("Exception in checkPassword(normalPassword, encryptedPassword) - " + e);
    // return false;
    // }
    // }

    public static String makeMD5String(String p_str) {

        if (logger.isDebugEnabled()) {
            logger.debug("Executing makeMD5String(String) ->");
        }

        try {
            byte[] hash = MessageDigest.getInstance("MD5")
                            .digest(p_str.getBytes(StandardCharsets.UTF_8));
            StringBuilder l_hex = new StringBuilder(hash.length * 2);
            for (byte b : hash) {
                if ((b & 0xFF) < 0x10)
                    l_hex.append("0");
                l_hex.append(Integer.toHexString(b & 0xFF));
            }
            return l_hex.toString();
        } catch (Exception e) {
            logger.error("Exception in makeMD5String(String) - " + e);
            return null;
        }
    }

    public static boolean checkMD5Password(String normalPassword, String encryptedPassword) {

        if (logger.isDebugEnabled()) {
            logger.debug("Executing checkMD5Password(normalPassword, encryptedPassword) ->");
        }

        try {
            return makeMD5String(normalPassword).equals(encryptedPassword);
        } catch (Exception e) {
            logger.error("Exception in checkMD5Password(normalPassword, encryptedPassword) - " + e);
            return false;
        }
    }

    public static String makeMD5String(byte[] bytes) {

        if (logger.isDebugEnabled()) {
            logger.debug("Executing makeMD5String(byte[]) ->");
        }

        try {
            byte[] hash = MessageDigest.getInstance("MD5").digest(bytes);
            StringBuilder l_hex = new StringBuilder(hash.length * 2);
            for (byte b : hash) {
                if ((b & 0xFF) < 0x10)
                    l_hex.append("0");
                l_hex.append(Integer.toHexString(b & 0xFF));
            }
            return l_hex.toString();
        } catch (Exception e) {
            logger.error("Exception in makeMD5String(byte[]) - " + e);
            return null;
        }
    }
}
