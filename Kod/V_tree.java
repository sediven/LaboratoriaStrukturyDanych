import java.util.LinkedList;
import java.util.List;



public class V_tree {
 Node root;
 List <Integer> listaIndexowWDrzewie;
 	//konstruktory
 	public V_tree()
 	{
 		root = new Node(0.0,-1);
 		listaIndexowWDrzewie=new LinkedList<Integer>();
 	}
 	
 	public V_tree(double val, int in)
 	{
 		listaIndexowWDrzewie=new LinkedList<Integer>();
 		root = new Node(val, in);	
 	}
 	//Metoda wstawiaj�ca je�li stworzyli�my wcze�niej puste drzewo dodaje od razu, je�li nie uruchamiam metode rekurencyjn� insertNode
 	public void insert(int i, double v)
 	{
 		Node n = new Node(i,v);
 		if(listaIndexowWDrzewie.indexOf(i)==-1)
 			listaIndexowWDrzewie.add(i);
 		if(root.index == -1)
 			root = n ;
 		else
 			insertNode(root,n); 			
 	}
 	//rekurencyjna metoda wyszukuj�ca odpowiednie miejsce dla danego wierzcho�ka. Value to w�ze� kt�ry chcemy wstawi�, a node nasz obecnie sprawdzany weze�
 	public void insertNode(Node node, Node value) {
 	
 		if(value.index == node.index)//je�li zajdujemy si� w instniej�cym wierzcho�ki o takim samym indeksie podmieniamy warto�� (tak jak dzieje si� to w wektorach)
 			node.value=value.value;
 		
 		else if (value.index < node.index) //je�li aktualny indeks wi�kszy od naszego, miejsce na nasz nowy wezel jest na lewo
 	        	if (node.left != null)//jesli w wezle na lewo cos jest to uruchamiamy metode insert na tymze we�le
 	        		insertNode(node.left, value);
 	        	else // jak lewy pusty mozemy wstawic nasz nowy wezel
 	        		node.left = value;   
 	    else  // analogicznie jak w przypadku lewego tylko dla wartosci mniejszych ( bo sprawdzilismy juz == i wieksze)
 	        if (node.right != null)
 	            insertNode(node.right, value);
 	        else
 	            node.right = value;
 	     	    
 	}
 	
 	
 	public void sumInsertNode(Node node, Node value){
 		if(value.index == node.index)
 			node.value+=value.value;
 		
 		else if (value.index < node.index)
 	        	if (node.left != null)
 	        		sumInsertNode(node.left, value);
 	        	else 
 	        		node.left = value;   
 	    else  
 	        if (node.right != null)
 	            sumInsertNode(node.right, value);
 	        else
 	            node.right = value;
 	}
 	
 	
 	public double get(int i)//klasa bedaca adapterem klasy getNode2
 	{
 		return getNode2(root,i);
 	}
 	
 	public double getNode2(Node node, int i)//klasa przeszukujaca drzewo do wlasciwego indeksu
 	{
 				
 		if (node == null) return 0; // jesli wejdziemy w wezel pusty zwracamy zero ( w za�o�eniach zadania zosta�o tak ustalone)
 		else if (i < node.index)//jesli szukany indeks mniejszy idziemy w lewo, gdyz w lewym poddrzewie znajduja sie tylko wartosci mniejsze
 			return getNode2(node.left, i);
 		else if (i > node.index)//jesli indeks wiekszy idziemy w prawo
 			 return getNode2(node.right,i); 
 		return node.value;//jesli nie mniejszy, nie wiekszy i nie pusty to musi byc r�wny wiec zwracamy wartosc kryjaca sie pod indeksem
 		
 	}
 	//metoda opisujaca strukture drzewa
	public void drawTree(Node r, int n) {
		if (r == null) return; 
		drawTree(r.left,n); 
		System.out.println("\n W:" +n+" K= " + r.index + " war=" + r.value);
		drawTree(r.right,n);
	}
	public void draw90degTree(Node r , int n){
		if (r == null) return; 
		draw90degTree(r.left,n); 
		System.out.println("\n K:" +n+" W= " + r.index + " war=" + r.value);
		draw90degTree(r.right,n);
	}
	
 	public String toString()
 	{
		return root.toString();
 		
 	}

	public void addAllTo(V_tree m1t,Node actualNode) {
		m1t.sumInsertNode(m1t.root, actualNode);
		if (actualNode.left != null)
     		addAllTo(m1t, actualNode.left);
		if (actualNode.right != null)
     		addAllTo(m1t, actualNode.right);
	}
	
	
}
