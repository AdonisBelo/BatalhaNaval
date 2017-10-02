import static org.junit.Assert.*;

import org.junit.Test;

public class ServidorTest {
	
	@Test
	public void testInicializarTabuleiro() {
		int[] tabuleiroEsperado = new int[25];
		int[] tabuleiro = new int[25];
		Servidor jogo = new Servidor();
		
		tabuleiroEsperado[0] = 0;
		tabuleiroEsperado[1] = 0;
		tabuleiroEsperado[2] = 0;
		tabuleiroEsperado[3] = 0;
		tabuleiroEsperado[4] = 0;
		
		tabuleiroEsperado[5] = 0;
		tabuleiroEsperado[6] = 0;
		tabuleiroEsperado[7] = 0;
		tabuleiroEsperado[8] = 0;
		tabuleiroEsperado[9] = 0;
		
		tabuleiroEsperado[10] = 0;
		tabuleiroEsperado[11] = 0;
		tabuleiroEsperado[12] = 0;
		tabuleiroEsperado[13] = 0;
		tabuleiroEsperado[14] = 0;
		
		tabuleiroEsperado[15] = 0;
		tabuleiroEsperado[16] = 0;
		tabuleiroEsperado[17] = 0;
		tabuleiroEsperado[18] = 0;
		tabuleiroEsperado[19] = 0;
		
		tabuleiroEsperado[20] = 0;
		tabuleiroEsperado[21] = 0;
		tabuleiroEsperado[22] = 0;
		tabuleiroEsperado[23] = 0;
		tabuleiroEsperado[24] = 0;
		
		tabuleiro = jogo.inicializarTabuleiro(tabuleiro);
		
		for(int i=0; i<tabuleiroEsperado.length; i++){
			assertEquals(tabuleiroEsperado[i], tabuleiro[i]);
		}
		
	}

	@Test
	public void testVerificarAcerto() {
		Servidor jogo = new Servidor();
		
		int linha = 1;
		int coluna = 1;
		int [] tabuleiro = new int[25];
		
		jogo.inicializarTabuleiro(tabuleiro);
		boolean resultado = jogo.verificarAcerto(tabuleiro, linha, coluna);

		assertEquals(false, resultado);
	}
}
