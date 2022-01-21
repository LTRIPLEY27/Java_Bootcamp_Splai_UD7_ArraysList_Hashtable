package packageJava.Ejercicio3;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;
public class DataBase {
	
	public static void start() {
	Hashtable <String, Integer> products = new Hashtable <String, Integer> ();
		int cont = 0;
		//String question = JOptionPane.showInputDialog("Desea ingresar productos?");
		for(int i = 0; i <= 3; i++) {
		//if(question.equals("si")) {
			//do {
				String product = JOptionPane.showInputDialog("Indique el producto");
				String quantity = JOptionPane.showInputDialog("Ingrese cantidad");
				int cantidad = Integer.parseInt(quantity);
				products.put(product, cantidad);
				//products.put("chocolate", 8);
				//products.put("helado", 8);
				//cont++;
			//}while(cont < 3);
		}choice(products);
		//}else {
			JOptionPane.showMessageDialog(null, "Gracias, vuelva pronto");
		}	
	//}
	
	public static void choice(Hashtable <String, Integer> products) {
		String choice = JOptionPane.showInputDialog("Indique opcion: \n1. Buscar producto  \n2. Ver lista de productos");
		int choices = Integer.parseInt(choice);
		switch(choices) {
			case 1:
				String product = JOptionPane.showInputDialog("Indique el producto?").toLowerCase();
				searchHash(product, products);
				break;
			case 2:
				printData(products);
				break;
			default:
				break;
		}
	}
	public static void searchHash(String product, Hashtable <String, Integer> products) {
		System.out.println(products.get(product));
	}
	
	public static void printData(Hashtable <String, Integer> products) {
		Enumeration <Integer> elemento = products.elements();
		Enumeration <String> keys = products.keys();
		while(elemento.hasMoreElements() && keys.hasMoreElements()) {
			System.out.println("Producto = " + keys.nextElement() + "\nCantidad = " + elemento.nextElement());
		}

	}
}