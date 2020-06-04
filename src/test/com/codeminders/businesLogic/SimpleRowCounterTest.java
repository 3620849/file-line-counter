package com.codeminders.businesLogic;

import com.codeminders.businesLogic.SimpleRowCounter;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class SimpleRowCounterTest {
    private PrintStream sysOut;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        sysOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testCountRows() throws Exception {
        String path = "src/test/resources/MyDir";
        File file = new File(path);
        String absolutePath = file.getAbsolutePath();
        new SimpleRowCounter().countRows(absolutePath);

        assertThat(outContent.toString(), containsString("root : 8"));
    }
}
