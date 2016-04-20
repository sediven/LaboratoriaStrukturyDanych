import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Matrix {
	int x;
	int y;
	List <V_tree> lista;
	List <Integer> listaIndexow;
	
	public Matrix()
	{
		lista = new LinkedList<V_tree>();
		listaIndexow = new LinkedList<Integer>();
		
	}
	public Matrix(String file)
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
				V_tree tmp;
				int wierszIndex = listaIndexow.indexOf(wiersz);
				
				if(wierszIndex==-1){
					listaIndexow.add(wiersz);
					wierszIndex=listaIndexow.indexOf(wiersz);
					tmp=new V_tree();
					lista.add(null);
				}
				else
					tmp = lista.get(wierszIndex);
				
				
				int kolumna = scanner.nextInt();
				
				double wartosc;
				if(scanner.hasNextDouble()){
					wartosc = scanner.nextDouble();
					tmp.insert(kolumna, wartosc);
				}
				lista.set(wierszIndex,tmp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void sumWith(Matrix m2)
	{
		if( !(x==m2.x) || !(y==m2.y) )
			System.out.println("nieprawidlowy rozmiar tablc");
		else
		{
			//sumujemy
			for(int i =0; i<m2.lista.size();i++)
			{
				//czy mamy wiersz z m2 w m1
				int indexWiersza = listaIndexow.indexOf(m2.listaIndexow.get(i));
				if(indexWiersza==-1)//jesli nie mamy wiersza to
				{
					listaIndexow.add(m2.listaIndexow.get(i));//dodajemy nowy index do listy indexow
					lista.add(m2.lista.get(m2.listaIndexow.indexOf(i)));//dodajemy kolumne
				}
				else//jesli mamy to pod adresem indexWiersza
				{
					V_tree m1t = lista.get(indexWiersza);
					V_tree m2t = m2.lista.get(i);
					//dla wszystkich wierzcholkow dodaje je do obecnego drzewa
					m2t.addAllTo(m1t,m2t.root);
					lista.set(indexWiersza, m1t);
				}
				
			}
		}
		
		
	}
	
	public Matrix isMultiplyBy(Matrix90deg m2) throws Exception
	{
		Matrix wyn = new Matrix();
		if(y!=m2.x)
			return null;
		
		wyn.x=x;
		wyn.y=m2.y;
		for(int i = 0; i <lista.size();i++)
		{
			
			
			//biore wiersz i z macierzy 
			for(int j= 0; j<m2.lista.size();j++)
			{
				double b=0;
				V_tree t1=lista.get(i);
				V_tree t2 = m2.lista.get(j);
			//	System.out.println("w "+i+"k "+j+" b "+b +"\n");
				for(Integer indx:t1.listaIndexowWDrzewie)
				{//dla kazdego indeksu z drzewa t1 szukam  go w drzewie t2
					if(t2.listaIndexowWDrzewie.indexOf(indx)!=-1)
					{
						b+=(t1.get(indx)*t2.get(indx));
				//		System.out.println("w "+ t1.get(indx) + "*k "+t2.get(indx)+"+ ");
					}
					
				}
				//b jest wartoœci¹ naszej komórki
				if(b!=0)
				wyn.Wstaw(i, j, b);
				/*int indexWiersza = wyn.listaIndexow.indexOf(i);
				if(indexWiersza==-1)//jesli nie mamy wiersza to
				{
					V_tree a = new V_tree();
					a.insert(j, b);
					wyn.listaIndexow.add(listaIndexow.get(i));//dodajemy nowy index do listy indexow
					wyn.lista.add(a);//dodajemy kolumne
				}
				else//jesli mamy to pod adresem indexWiersza
				{
					V_tree a = wyn.lista.get(indexWiersza);
					a.insert(j, b);
					lista.set(indexWiersza, a);
				}*/
			//  System.out.println("w "+i+"k "+j+" b "+b +"\n");
			}
			
			
		}
		
		return wyn;
		
	}
	
	public double Pobierz(int a, int b) throws Exception
	  {
	    if (a>=x||b>=y)
	         throw new Exception("Poza Zakresem");
	    
	    else
	    {
	    	int indexWiersza = listaIndexow.indexOf(a);
			if(indexWiersza==-1)//jesli nie mamy wiersza to
				return 0;
			else//jesli mamy to pod adresem indexWiersza
				return lista.get(indexWiersza).get(b);
			
		}
	  }
	public void Wstaw(int a, int b, double val) throws Exception
	{
		if (a>=x||b>=y)
	         throw new Exception("Poza Zakresem");
	    
		int indexWiersza = listaIndexow.indexOf(a);
		if(indexWiersza==-1)//jesli nie mamy wiersza to
		{
			listaIndexow.add(a);//dodajemy nowy index do listy indexow
			V_tree t = new V_tree();
			t.insert(b, val);
			lista.add(t);//dodajemy kolumne
		}
		else//jesli mamy to pod adresem indexWiersza
		{
			V_tree m1t = lista.get(indexWiersza);
			m1t.insert(b, val);
			lista.set(indexWiersza, m1t);
		}
	}
	
	
	public void drawMatrix() {
		System.out.println("\n MACIERZ ["+x+"]["+y+"]    :");
		for(int i = 0; i<lista.size();i++)
			lista.get(i).drawTree(lista.get(i).root, listaIndexow.get(i));
		
	}
	
}
