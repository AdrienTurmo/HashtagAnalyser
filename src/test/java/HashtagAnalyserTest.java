import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @Test
    public void return_text_without_hashtag_sign_for_a_hashtag_followed_by_another_word() throws Exception {
        String text = "#aaa rt";
        List<String> expectedHashtags = Arrays.asList("aaa");

        List<String> hashtags = HashtagAnalyser.retrieve(text);

        assertThat(hashtags).isEqualTo(expectedHashtags);
    }

    @Test
    public void return_multiple_hashtags_separated_by_space() throws Exception {
        String text = "#aaa #rt";
        List<String> expectedHashtags = Arrays.asList("aaa","rt");

        List<String> hashtags = HashtagAnalyser.retrieve(text);

        assertThat(hashtags).isEqualTo(expectedHashtags);
    }

    @Test
    public void return_multiple_hashtags_separated_by_ponctuation() throws Exception {
        String text = "#aaa;#rt,#salut";
        List<String> expectedHashtags = Arrays.asList("aaa","rt","salut");

        List<String> hashtags = HashtagAnalyser.retrieve(text);

        assertThat(hashtags).isEqualTo(expectedHashtags);
    }

    @Test
    public void return_only_hashtags() throws Exception {
        String text = "#aaa salut #non";
        List<String> expectedHashtags = Arrays.asList("aaa","non");

        List<String> hashtags = HashtagAnalyser.retrieve(text);

        assertThat(hashtags).isEqualTo(expectedHashtags);
    }
}