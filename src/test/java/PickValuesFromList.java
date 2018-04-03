import static java.util.stream.Stream.of;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Objects;
import java.util.stream.IntStream;

import org.junit.Test;

public class PickValuesFromList {

    @Test
    public void findFirstNonNull() throws Exception {
        assertThat( of(null, null, "s").filter(Objects::nonNull).findFirst().get(), is("s"));
        assertThat( of(null, "b", "s").filter(Objects::nonNull).findFirst().get(), is("b"));
        assertThat( of("1", null, "s").filter(Objects::nonNull).findFirst().get(), is("1"));

    }

    @Test
    public void findMax() throws Exception {
      assertThat(  IntStream.of(1, 4, 2, 3).max().getAsInt(), is(4));
      assertThat(  IntStream.of(1, 4, 2, 4).max().getAsInt(), is(4));
      assertThat(  IntStream.of(1, 4, 2, 3).min().getAsInt(), is(1));
      assertThat(  IntStream.of(1, 4, 2, 3).count(), is(4L));

    }

}
