package test.cave;

import com.cave.Main;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class MainTest {
    Scanner mockScanner ;
    @Before
    public void setUp() throws Exception {
        mockScanner = mock(Scanner.class);
    }

    @Test
    public void hint_inputAsyes_returnsNormalAnswer() {
        when(mockScanner.nextLine()).thenReturn("yes");
        String result =  Main.hint(mockScanner);
        assertTrue(result.startsWith("Somewhere nearby is Colossal Cave"));
    }
    @Test
    public void hint_inputAsYES_returnsNormalAnswer() {
        when(mockScanner.nextLine()).thenReturn("YES");
        String result =  Main.hint(mockScanner);
        assertTrue(result.startsWith("Somewhere nearby is Colossal Cave"));
    }

    @Test
    public void hint_inputAsNo_returnsNormalAnswer() {
        when(mockScanner.nextLine()).thenReturn("No");
        String result =  Main.hint(mockScanner);
        assertTrue(result.isEmpty());
    }

}