import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HashtagAnalyser {

    public static List<String> retrieve(String text) {
        if (!text.contains("#")) {
            return new ArrayList<>();
        }

        String[] splitText = text.split("#");
        return Arrays.asList(splitText[splitText.length-1]);
    }

}
