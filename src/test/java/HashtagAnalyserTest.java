import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HashtagAnalyserTest {

    @Test
    public void return_nothing_if_empty_string() throws Exception {
        List<String> expectedHashtags = Arrays.asList("");
        String text = "";

        List<String> hashtags = HashtagAnalyser.retrieve(text);

        assertThat(hashtags).isEqualTo(expectedHashtags);
    }
}