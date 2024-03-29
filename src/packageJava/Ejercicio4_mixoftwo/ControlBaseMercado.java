package packageJava.Ejercicio4_mixoftwo;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**@author isabel Calzadilla
 * Ejercicio 4 - UD7: BASE DE DATOS
 * **/
public class ControlBaseMercado {
	
	public static void createInventary() {
		Scanner ask = new Scanner(System.in);
		Hashtable <String, Integer> products = new Hashtable <String, Integer> ();
		for(int i = 0; i <= 3; i++) {
				String product = JOptionPane.showInputDialog("Indique el producto");
				String quantity = JOptionPane.showInputDialog("Ingrese cantidad");
				int cantidad = Integer.parseInt(quantity);
				products.put(product, cantidad);
		}
		
		choice(products);
		}	
	
	public static void choice(Hashtable <String, Integer> products) {
		String choice = JOptionPane.showInputDialog("Indique opcion: \n1. Comprar producto  \n2. Ver lista de productos");//\n3. Comprar producto
		int choices = Integer.parseInt(choice);
		switch(choices) {
			case 1:
				String product = JOptionPane.showInputDialog("Indique el producto a comprar?").toLowerCase();
				if(searchHash(product, products)) {
					String productCont = JOptionPane.showInputDialog("Indique la cantidad a comprar?").toLowerCase();
					int countProducts = Integer.parseInt(productCont);
					getList(countProducts);
					eliminaProducto(product, products, countProducts);
				}else {
					JOptionPane.showConfirmDialog(null, "producto no encontrado en nuestro dep�sito");
				}
				break;
			case 2:
				printData(products);
				break;
			case 3:
				break;
			default:
				String elige = JOptionPane.showInputDialog("Debe de ingresar una opcion v�lida");
				break;
		}
	}

	public static void eliminaProducto(String product, Hashtable <String, Integer> products, int countProducts) {
		Enumeration <Integer> elemento = products.elements();
		Enumeration <String> keys = products.keys();
		while(keys.hasMoreElements()) {
			if(products.containsKey(product)) {
				products.put(product, -countProducts);
			}
		}
	}
	
	public static boolean searchHash(String product, Hashtable <String, Integer> products) {

		boolean response = false;
		if(products.get(product) != null) {// EL PRODUCTO SE ENCUENTRA EN EL INVENTARIO
			response = true;
		}
		return response;
	}
	
	public static void printData(Hashtable <String, Integer> products) {
		Enumeration <Integer> elemento = products.elements();
		Enumeration <String> keys = products.keys();
		System.out.println("La lista de productos son = \n");
		while(elemento.hasMoreElements() && keys.hasMoreElements()) {
			System.out.println("Producto = " + keys.nextElement() + "\nCantidad = " + elemento.nextElement());
		}
	}
	
	public static double giveChange(int payment, double calculateTotal) {// M�TODO QUE CALCULA EL CAMBIO A DEVOLVER
		Scanner ask = new Scanner(System.in);

		return payment - calculateTotal;
	}
	
	public static double calculateTotal(int countProducts, double totalPrice) {// M�TODO QUE CALCULA EL TOTAL A PAGAR
	
		double saleQuantity = 0;
		
		saleQuantity = countProducts * totalPrice;
		
		return saleQuantity;
	}
	
	public static double optionIVA(int product) {// M�TODO QUE ESTABLECE EL PORCENTAJE DE IVA
		double optionIVA = 0; 

		if(product == 4) {
			optionIVA = 0.04;
		} else if(product == 21) {
			optionIVA = 0.21;
		} else {
			System.out.println("Debe de elegir una de las opciones descritas");
		}
		
		return optionIVA;
	}

	public static double price_with_tax(double price, double optioIVA) {//M�TODO QUE ESTABLECE EL PRECIO CON IVA INCLUIDO
		double totalPrice = price + price * optioIVA;
		
		return totalPrice;
	}
	
	public static void getList(int countProducts) {// M�TODO QUE INICIA EL PROGRAMA Y ESTABLECE LOS VALORES A LLENAR EN EL ARRAY
		Scanner ask = new Scanner(System.in);
		List <Double> car = new ArrayList <>();
		
		System.out.println("Desea realizar la compra ?");
		String question = ask.next(); 
		
		if(question.equals("si")) {
			do {
				System.out.println("Indique el IVA a aplicar = 4 o 21 % ");
				int product = ask.nextInt();
				System.out.println("Indique el precio del producto para aplicar IVA = ");
				double price = ask.nextInt();
				System.out.println("Indique la cantidad de dinero a abonar?");
				int payment = ask.nextInt(); 
				
				//LLAMADO A LOS M�TODOS
				
				car.add(optionIVA(product));//M�TODO ELIGE IVA
				car.add(price);//PRECIO
				car.add((price_with_tax(price, optionIVA(product))));//M�TODO QUE ESTABLECE EL PRECIO CON IVA
				car.add((calculateTotal(countProducts, price_with_tax(price, optionIVA(product)))));// M�TODO QUE TOTALIZA LA CANTIDAD A PAGAR
				car.add((giveChange(payment, calculateTotal(countProducts, price_with_tax(price, optionIVA(product))))));// M�TODO QUE ESTABLECE LA CANTIDAD DE VUELTO
				printList(car);
				System.out.println("Desea realizar la compra ?");
				question = ask.next(); 
			}while(question != "no");
		} else {
			System.out.println("Hasta pronto...");
		}

	}
	
	public static void printList(List <Double> car) {// M�TODO PARA IMPRIMIR EL ARRAYLIST CON CADA VALOR
		
			System.out.println("EL IVA aplicado es = " + car.get(0));
			System.out.println("EL precio bruto  es = " + car.get(1));
			System.out.println("EL precio total con IVA es = " + car.get(2));
			System.out.println("La cantidad a pagar es = " + car.get(3));
			System.out.println("El vuelto de su pago es = " + car.get(4));
	}
}
