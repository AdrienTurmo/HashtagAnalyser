import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HashtagAnalyserTest {

    @Test
    public void return_nothing_if_empty_string() throws Exception {
        String text = "";

        List<String> hashtags = HashtagAnalyser.retrieve(text);

        assertThat(hashtags).isEmpty();
    }

    @Test
    public void return_nothing_if_no_hashtag() throws Exception {
        String text = "abc";

        List<String> hashtags = HashtagAnalyser.retrieve(text);

        assertThat(hashtags).isEmpty();
    }

    @Test
    public void return_text_without_hashtag_sign_for_text_only_one_hashtag() throws Exception {
        String text = "#abc";
        List<String> expectedHashtags = Arrays.asList("abc");

        List<String> hashtags = HashtagAnalyser.retrieve(text);

        assertThat(hashtags).isEqualTo(expectedHashtags);
    }

    @Test
    public void return_text_without_hashtag_sign_for_another_hashtag() throws Exception {
        String text = "#bca";
        List<String> expectedHashtags = Arrays.asList("bca");

        List<String> hashtags = HashtagAnalyser.retrieve(text);

        assertThat(hashtags).isEqualTo(expectedHashtags);
    }

    @Test
    public void return_text_without_hashtag_sign_for_a_hashtag_with_something_in_from_of_it() throws Exception {
        String text = "a#aaa";
        List<String> expectedHashtags = Arrays.asList("aaa");

        List<String> hashtags = HashtagAnalyser.retrieve(text);

        assertThat(hashtags).isEqualTo(expectedHashtags);
    }
}