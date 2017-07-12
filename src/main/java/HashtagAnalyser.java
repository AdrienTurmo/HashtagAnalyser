import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HashtagAnalyser {

    public static List<String> retrieve(String text) {
        List<String> hashtags = new ArrayList<>();

        String hashtagRegex = "#(\\w+)([[\\p{Punct}&&[^#]]||[\\s]])*";

        Pattern hashtagPattern = Pattern.compile(hashtagRegex);
        Matcher hashtagMatcher = hashtagPattern.matcher(text);

        while (hashtagMatcher.find()) {
           hashtags.add(hashtagMatcher.group(1));
        }

        return hashtags;
    }

}
