import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {
	
	public boolean verificarAcerto(int [] tabuleiro, int linha, int coluna) {
		int casa = 5*linha;
		casa+=coluna;
		if(tabuleiro[casa]==2) {
			tabuleiro[casa]=3;
			return true;
		}else if(tabuleiro[casa]!=3){
			tabuleiro[casa]=1;
			return false;
		}
		return false;
	}
	
	public void enviarTabuleiro(int [] tabuleiro, PrintStream out) {
		String linha = "1";
		for(int i=0; i<tabuleiro.length; i++) {
			if(tabuleiro[i]==3){
				linha+="\t"+"X";
			}else if(tabuleiro[i]==1) {
				linha+="\t"+"*";
			}else{
				linha+="\t"+"~";
			}
			if((i+1)%5==0) {
				out.println(linha);
				linha = ((i/5)+2)+"";
			}
		}
	}
	
	public int[] inicializarTabuleiro(int[] tabuleiro) {
		
		for(int i=0; i<tabuleiro.length; i++) {
			tabuleiro[i] = 0;
		}		
		return tabuleiro;
	}
	
	public int[] inserirNavios(int[] tabuleiro){
		
		int navio1 = (int) (Math.random() * (24-0));
		int navio2 = (int) (Math.random() * (24-0));
		
		while(navio1 == navio2) {
			navio2 = (int) (Math.random() * (24-0));
		}
		
		int navio3 = (int) (Math.random() * (24-0));
		
		while(navio3 == navio1 && navio3 == navio2) {
			navio3 = (int) (Math.random() * (24-0));
		}
		
		tabuleiro[navio1] = 2;
		tabuleiro[navio2] = 2;
		tabuleiro[navio3] = 2;
		
		return tabuleiro;
	}

	public static void main(String[] args) throws IOException {
		
		ServerSocket servidor = new ServerSocket(12345);
        Socket cliente = servidor.accept();
        InputStream input = cliente.getInputStream();
        OutputStream output = cliente.getOutputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(input));
        PrintStream out = new PrintStream(output);
        
        Servidor jogo = new Servidor();
        int acertos = 0;
        int [] tabuleiro = new int[25];
        jogo.inicializarTabuleiro(tabuleiro);
        jogo.inserirNavios(tabuleiro);
        
        while(true) {
        	jogo.enviarTabuleiro(tabuleiro, out);
        	
        	int linha = Integer.parseInt(in.readLine())-1;
        	int coluna = Integer.parseInt(in.readLine())-1;
        	
        	boolean acertou = jogo.verificarAcerto(tabuleiro, linha, coluna);
        	
        	if(acertou==true) {
        		acertos++;
        		if(acertos == 3) {
            		out.println("FIM");
            		break;
            	}
        		out.println("Você Acertou!");
        		
        	}else {
        		out.println("Você errou! Tente novamente");
        	}
        }
        in.close();
        out.close();
        cliente.close();
        servidor.close();
	}

}