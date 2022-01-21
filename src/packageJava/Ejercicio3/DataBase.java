package packageJava.Ejercicio3;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;
public class DataBase {
	
	public static void start() {
		Hashtable <String, Integer> products = new Hashtable<String, Integer>();
		int cont = 0;
		String question = JOptionPane.showInputDialog("Desea ingresar productos?").toLowerCase();
		if(question.equals("si")) {
			do {
				String product = JOptionPane.showInputDialog("Indique el producto");
				String quantity = JOptionPane.showInputDialog("Ingrese cantidad");
				int cantidad = Integer.parseInt(quantity);
				products.put(product, cantidad);
				cont++;
				question = JOptionPane.showInputDialog("Desea ingresar productos?");
			}while(question.equals("si")  && cont < 4);
		}else {
			JOptionPane.showMessageDialog(null, "Gracias, vuelva pronto");
		}
		
		choice(products);
	}
	
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
