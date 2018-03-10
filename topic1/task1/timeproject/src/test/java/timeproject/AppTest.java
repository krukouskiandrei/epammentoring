package timeproject;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;


public class AppTest {

    private ByteArrayOutputStream baos = new ByteArrayOutputStream();
    private PrintStream ps = new PrintStream(baos);

    @Before
    public void setup() {
        System.setOut(ps);
    }

    @Test
    public void shouldPrintTimeToConsole() {
        App.main(new String[] {});

        assertThat(output(), containsString("The current local time is"));
    }

    @Test
    public void shouldPrintHelloToConsole() {
        App.main(new String[] {});

        assertThat(output(), containsString("Hello"));
    }

    private String output() {
        return new String(baos.toByteArray(), StandardCharsets.UTF_8);
    }

}
