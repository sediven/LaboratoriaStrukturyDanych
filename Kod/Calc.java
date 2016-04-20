
public class Calc {//glowna metoda testujaca

	public static void main(String[] args) throws Exception {
	
		//wczytuje sciezka znak sciezka
		// na potrzeby testowania robie to tutaj, z Stringiem input postepuje tak jak z wczytaniem argumentow 
		String input = "C:\\Users\\ja\\workspace\\V_tree\\src\\macierz x C:\\Users\\ja\\workspace\\V_tree\\src\\m2";
		String a[] = input.split(" ");
		if(a[1].equals("x"))
			mno¿enie(a[0],a[2]);
		else
			if(a[1].equals("+"))
				dodawanie(a[0],a[2]);
			else
				System.out.println("Komenda nieznana");
				
		
	}

private static void dodawanie(String s, String s2) {
		// TODO Auto-generated method stub
		Matrix m = new Matrix(s);
		m.drawMatrix();
		System.out.println("Dodac");
		Matrix m2= new Matrix(s2);
		m2.drawMatrix();
		System.out.println("=");
		m.sumWith(m2);
		m.drawMatrix();
		}

private static void mno¿enie(String s, String s2) throws Exception {
	// TODO Auto-generated method stub
	Matrix m = new Matrix(s);
	m.drawMatrix();
	System.out.println("RAZY");
	Matrix90deg m2 = new Matrix90deg(s2);
	m2.drawMatrix();
	System.out.println("=");
	Matrix m4 = m.isMultiplyBy(m2);
	if(m4!=null)
		m4.drawMatrix();
	else
		System.out.println("Mnozenie macierzy niemozliwe, Wymiary nieprawidlowe");
}

}
