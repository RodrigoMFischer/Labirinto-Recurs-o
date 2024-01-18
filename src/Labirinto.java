import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class Labirinto {
		
	public boolean labirinto(String fileName){
		char[][] lab = carregaLabirinto(fileName);
		if(lab == null) return false;
		return labirinto(lab, 0, 0);
	}
	
	private boolean labirinto(char[][] lab, int linha, int coluna){
		if(linha < 0 || linha >= lab.length ||
				coluna < 0 || coluna >= lab[linha].length) return false;
		if (lab[linha][coluna] == 'D') return true;
		if (lab[linha][coluna] == 'X' || lab[linha][coluna] == '*' ) return false;
		if (lab[linha][coluna] == ' ')lab[linha][coluna] = '*';
		return labirinto(lab, linha + 1, coluna) || labirinto(lab, linha - 1, coluna) ||
				labirinto(lab, linha, coluna + 1) || labirinto(lab, linha, coluna - 1);
	}

	public char[][] carregaLabirinto(String fileName){
		char[][] lab = null;
		try {			
			FileReader fr = new FileReader(fileName);
			BufferedReader in = new BufferedReader(fr);
			int linha = Integer.parseInt(in.readLine());
			int coluna = Integer.parseInt(in.readLine());
			lab = new char[linha][coluna];
			
			for (int i = 0; i < lab.length; i++) {
				String line = in.readLine();				
				for (int j = 0; j < lab[i].length; j++) {
					lab[i][j] = line.charAt(j);					
				}
			}
			in.close();
			
						
		} catch (FileNotFoundException e) {
			String file = Teclado.leString("Erro no nome do arquivo! Digite novamente: ");
			lab = carregaLabirinto(file);
			
		} catch (IOException e){
			e.printStackTrace();
			System.out.println("Erro no nome do arquivo");
		}		
		return lab;
	}
}
