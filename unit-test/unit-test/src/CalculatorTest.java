import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.asertEquals;

public class CalculatorTest {

    @Test
    void testSumar() {
        Calculator c1 = new Calculator();
        int resultado = c1.sum(2, 3);
        assertEquals(5, resultado, "La suma debe ser 5");
    }
}
