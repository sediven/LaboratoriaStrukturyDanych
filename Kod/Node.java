

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
	//metoda opisuj�ca dany w�ze�
	public String opisz(int n)
	{
		String l,r;
		l= (left==null)?"brak":left.opisz(++n);
		r= (right==null)?"brak":right.opisz(++n);
		
		return "  (Level :" + n + " indeks: "+ index + " warto�� :"+ value+ " Lewy: "+l + " Prawy: "+ r + ")  "; 
	}

	
	public String toString()
	{				
		return opisz(0);
	}

	
}
