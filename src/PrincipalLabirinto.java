import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;



public class PrincipalLabirinto {	
	public static void main(String[] args) {
		
		Labirinto l = new Labirinto();
		String fileName = Teclado.leString("Digite o nome do arquivo:");
		boolean saidaLabirinto = l.labirinto(fileName);
		File f = new File ("saidaLabirinto.txt");
		FileWriter fw = null;
		try {
			fw = new FileWriter (f);
		} catch (IOException e) {
			System.out.println("Erro ao criar arquivo!");
		}
		PrintWriter out = new PrintWriter (fw);
		if(saidaLabirinto){
			out.println("Existe um caminho para o labirinto");
		}else {
			out.println( "Não existe um caminho para o labirinto");
		}
		out.close();
		System.out.println("O programa concluiu a verificação do labirinto!"
				+"\nVerifique o resultado no arquivo saidaLabirinto.");
	}	
}


