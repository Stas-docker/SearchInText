package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static List<String> getWordsFromString(final String text, final String startLetters) {
        final List<String> words = new ArrayList<>();
        final Pattern pattern = convertStringIntoPattern(startLetters);
        final Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;
    }

    private static Pattern convertStringIntoPattern(final String letters) {
        if (letters == null || letters.isBlank()) {
            throw new IllegalArgumentException("Prefix cannot be null or empty");
        }
        final String regex = "\\b" + Pattern.quote(letters) + "\\w*";
        return Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CHARACTER_CLASS);
    }
}
