package org.codewar.string;

import org.codewar.EncryptString;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class EncryptStringTests {

    @Autowired
    EncryptString encryptString;

    @Test
    public void testEncrypt() {
        // assertEquals("expected", "actual");
        assertEquals("This is a test!", EncryptString.encrypt("This is a test!", 0));
        assertEquals("hsi  etTi sats!", EncryptString.encrypt("This is a test!", 1));
        assertEquals("s eT ashi tist!", EncryptString.encrypt("This is a test!", 2));
        assertEquals(" Tah itse sits!", EncryptString.encrypt("This is a test!", 3));
        assertEquals("This is a test!", EncryptString.encrypt("This is a test!", 4));
        assertEquals("This is a test!", EncryptString.encrypt("This is a test!", -1));
        assertEquals("hskt svr neetn!Ti aai eyitrsig", EncryptString.encrypt("This kata is very interesting!", 1));
    }

    @Test
    public void testDecrypt() {
        // assertEquals("expected", "actual");
        assertEquals("This is a test!", EncryptString.decrypt("This is a test!", 0));
        assertEquals("This is a test!", EncryptString.decrypt("hsi  etTi sats!", 1));
        assertEquals("This is a test!", EncryptString.decrypt("s eT ashi tist!", 2));
        assertEquals("This is a test!", EncryptString.decrypt(" Tah itse sits!", 3));
        assertEquals("This is a test!", EncryptString.decrypt("This is a test!", 4));
        assertEquals("This is a test!", EncryptString.decrypt("This is a test!", -1));
        assertEquals("This kata is very interesting!", EncryptString.decrypt("hskt svr neetn!Ti aai eyitrsig", 1));
    }

    @Test
    public void testNullOrEmpty() {
        // assertEquals("expected", "actual");
        assertEquals("", EncryptString.encrypt("", 0));
        assertEquals("", EncryptString.decrypt("", 0));
        assertEquals(null, EncryptString.encrypt(null, 0));
        assertEquals(null, EncryptString.decrypt(null, 0));
    }

}