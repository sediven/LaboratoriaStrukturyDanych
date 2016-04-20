

public class Node {
	double value;
	int index;
	Node left;
	Node right;
	
	
	//konstruktory
	public Node(double x, int i)
	{
		value=x;
		index = i;
		left = null;
		right = null;
	}
	public Node(int i, double x)
	{
		value=x;
		index = i;
		left = null;
		right = null;
	}
	//metoda opisuj¹ca dany wêze³
	public String opisz(int n)
	{
		String l,r;
		l= (left==null)?"brak":left.opisz(++n);
		r= (right==null)?"brak":right.opisz(++n);
		
		return "  (Level :" + n + " indeks: "+ index + " wartoœæ :"+ value+ " Lewy: "+l + " Prawy: "+ r + ")  "; 
	}

	
	public String toString()
	{				
		return opisz(0);
	}

	
}
