package by.epam.subota.forms.util;

import java.security.SecureRandom;
import java.util.Base64;

public class SecureRandomString {

    public String getSecureRandomString(int length) {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[length];
        random.nextBytes(bytes);
        Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();
        String secureRandomString = encoder.encodeToString(bytes);
        return secureRandomString.substring(0, length);
    }
}
