package packageJava.Ejercicio2;
/**@author isabel Calzadilla
 * Ejercicio 2 - UD7: CONTROL FLUJO DE VENTAS
 * **/
import java.util.*;
public class Ejercicio2_ControlFluxApp {
	//final Scanner ASK = new Scanner(System.in); *** PREGUNTAR PORQUE NO APLICA LA CONSTANTE DE ÁMBITO GLOBAL COMO SCANNER ???????????? ***
	public static void main(String[] args) {
		/*2
Crea una aplicación que gestione el flujo de ventas de una
caja de supermercado El programa guardara la cantidades del
carrito de compra dentro de una lista Mostrará por pantalla la
siguiente informacion
•
IVA aplicado 21 o 4
•
precio total bruto y precio mas IVA
•
Numero de artículos comprados
•
Cantidad pagada
•
Cambio a devolver al cliente*/

		getList();
	}

	
	public static double giveChange(int payment, double calculateTotal) {// MÉTODO QUE CALCULA EL CAMBIO A DEVOLVER
		Scanner ask = new Scanner(System.in);

		return payment - calculateTotal;
	}
	
	public static double calculateTotal(int countProducts, double totalPrice) {// MÉTODO QUE CALCULA EL TOTAL A PAGAR
	
		double saleQuantity = 0;
		
		saleQuantity = countProducts * totalPrice;
		
		return saleQuantity;
	}
	
	public static double optionIVA(int product) {// MÉTODO QUE ESTABLECE EL PORCENTAJE DE IVA
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

	public static double price_with_tax(double price, double optioIVA) {//MÉTODO QUE ESTABLECE EL PRECIO CON IVA INCLUIDO
		double totalPrice = price + price * optioIVA;
		
		return totalPrice;
	}
	
	public static void getList() {// MÉTODO QUE INICIA EL PROGRAMA Y ESTABLECE LOS VALORES A LLENAR EN EL ARRAY
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
				System.out.println("Indique la cantidad de productos para totalizar?");
				int countProducts = ask.nextInt();
				System.out.println("Indique la cantidad de dinero a abonar?");
				int payment = ask.nextInt(); 
				
				//LLAMADO A LOS MÉTODOS
				
				car.add(optionIVA(product));//MÉTODO ELIGE IVA
				car.add(price);//PRECIO
				car.add((price_with_tax(price, optionIVA(product))));//MÉTODO QUE ESTABLECE EL PRECIO CON IVA
				car.add((calculateTotal(countProducts, price_with_tax(price, optionIVA(product)))));// MÉTODO QUE TOTALIZA LA CANTIDAD A PAGAR
				car.add((giveChange(payment, calculateTotal(countProducts, price_with_tax(price, optionIVA(product))))));// MÉTODO QUE ESTABLECE LA CANTIDAD DE VUELTO
				printList(car);
				System.out.println("Desea realizar la compra ?");
				question = ask.next(); 
			}while(question != "no");
		} else {
			System.out.println("Hasta pronto...");
		}

	}
	
	public static void printList(List <Double> car) {// MÉTODO PARA IMPRIMIR EL ARRAYLIST CON CADA VALOR
		
			System.out.println("EL IVA aplicado es = " + car.get(0));
			System.out.println("EL precio bruto  es = " + car.get(1));
			System.out.println("EL precio total con IVA es = " + car.get(2));
			System.out.println("La cantidad a pagar es = " + car.get(3));
			System.out.println("El vuelto de su pago es = " + car.get(4));
	}
}
