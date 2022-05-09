package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

public class Asserts {
	// Verifica que sean iguales como conjuntos
	public static void iguales(int[] esperado, Set<Integer> obtenido) {
		assertEquals(esperado.length, obtenido.size());

		for (int i = 0; i < esperado.length; ++i)
			assertTrue(obtenido.contains(esperado[i]));
	}

	public static void EqualsDouble(double esperado, double obtenido) {
		assertTrue(esperado == obtenido);
	}
	public static void NotEqualsDouble(double esperado, double obtenido) {
		assertTrue(esperado != obtenido);
	}

	public static void EqualsDoubleArreglo(double[] esperado, double[] obtenido) {
		assertEquals(esperado.length+1, obtenido.length);

		
	}
}