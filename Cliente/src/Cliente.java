import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws IOException {
		
		Socket client = new Socket("127.0.0.1",12345);
        InputStream input = client.getInputStream();
        OutputStream output = client.getOutputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(input));
        PrintStream out = new PrintStream(output);
        Scanner teclado = new Scanner(System.in);

		while(true) {
			System.out.println("\t1 \t2 \t3 \t4 \t5");
			System.out.println();
			System.out.println(in.readLine());
			System.out.println(in.readLine());
			System.out.println(in.readLine());
			System.out.println(in.readLine());
			System.out.println(in.readLine());
			
			System.out.println("Digite a Linha: ");
			String linha = teclado.next();
			System.out.println("Digite a Coluna: ");
			String coluna = teclado.next();
			out.println(linha);
			out.println(coluna);
			
			String mensagem = in.readLine();
			System.out.println(mensagem);
			if(mensagem.equals("FIM")) {
				break;
			}
		}
		in.close();
        out.close();
        client.close();
	}

}