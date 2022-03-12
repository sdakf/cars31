package com.example.carsapp;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AeiouyTest {

    String text = "Why KeePass?\n" +
            "Today, you have to remember many passwords. You need a password for a lot of websites, your e-mail account, your webserver, network logins, etc. The list is endless. Also, you should use a different password for each account, because if you would use only one password everywhere and someone gets this password, you would have a problem: the thief would have access to all of your accounts.\n" +
            "\n" +
            "KeePass is a free open source password manager, which helps you to manage your passwords in a secure way. You can store all your passwords in one database, which is locked with a master key. So you only have to remember one single master key to unlock the whole database. Database files are encrypted using the best and most secure encryption algorithms currently known (AES-256, ChaCha20 and Twofish). For more information, see the features page.\n" +
            "\n" +
            "Is it really free?\n" +
            "Yes, KeePass is really free, and more than that: it is open source (OSI certified). You can have a look at its full source code and check whether the security features are implemented correctly.\n" +
            "\n" +
            "As a cryptography and computer security expert, I have never understood the current fuss about the open source software movement. In the cryptography world, we consider open source necessary for good security; we have for decades. Public security is always more secure than proprietary security. It's true for cryptographic algorithms, security protocols, and security source code. For us, open source isn't just a business model; it's smart engineering practice.";

    @Test
    void name() {

        extracted(text);
        System.out.println();

    }

    private void extracted(String text1) {
        Map<Character, Long> aeiouyMap = text1.chars().mapToObj(c -> (char) c)
                .filter(x -> x.toString().matches("[AaEeIiOoUuYy]"))
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println(aeiouyMap);
    }
}
