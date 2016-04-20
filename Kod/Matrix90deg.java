import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Matrix90deg {
	int x;
	int y;
	List <V_tree> lista;
	List <Integer> listaIndexow;
	
	
	public Matrix90deg(String file)
	{
		lista = new LinkedList<V_tree>();
		listaIndexow = new LinkedList<Integer>();
		Scanner scanner;
		try {
			scanner = new Scanner(new File(file));
			x=scanner.nextInt();
			y=scanner.nextInt();
			
			while(scanner.hasNextInt()){

				int wiersz = scanner.nextInt();
				
				int kol = scanner.nextInt();
				V_tree tmp;
				int kolIndex = listaIndexow.indexOf(kol);
				
				if(kolIndex==-1){
					listaIndexow.add(kol);
					kolIndex=listaIndexow.indexOf(kol);
					tmp=new V_tree();
					lista.add(null);
				}
				else
					tmp = lista.get(kolIndex);
				
				
				
				double wartosc;
				if(scanner.hasNextDouble()){
					wartosc = scanner.nextDouble();
					tmp.insert(wiersz, wartosc);
				}
				lista.set(kolIndex,tmp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public void drawMatrix() {
		System.out.println("\n MACIERZ["+x+"]["+y+"]    :");
		for(int i = 0; i<lista.size();i++)
			lista.get(i).draw90degTree(lista.get(i).root, listaIndexow.get(i));
		
	}
	
}
