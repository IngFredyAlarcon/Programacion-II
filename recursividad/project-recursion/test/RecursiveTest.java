import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RecursiveTest {

    @Test
    public void sumTest() {
        int n = 5, esperado = 15;
        int resultadoObtenido = 0;
        Recursive r = new Recursive();
        resultadoObtenido = r.sumToN(n);
        assertEquals(esperado, resultadoObtenido);
    }
}
