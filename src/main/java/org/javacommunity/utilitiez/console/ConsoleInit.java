package org.javacommunity.utilitiez.console;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Christian Luzzetti
 * @created 2021/11/26 - 19:55
 */

public class ConsoleInit {

    private static ResourceBundle messages = ResourceBundle.getBundle("messages", Locale.getDefault());

    public static void main(String[] args) {
        throw new IllegalArgumentException(messages.getString("exception.unsupported.not-implemented"));
    }

}
