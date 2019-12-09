package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> product = new ArrayList<>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.println("Product # " + i + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char c = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			if(c == 'i') {
				System.out.print("Customs fee: ");
				double customFee = sc.nextDouble();
				Product prod = new ImportedProduct(name, price, customFee);
				product.add(prod);
			}
			else if(c == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				Product prod = new UsedProduct(name, price, manufactureDate);
				product.add(prod);
			}
			else if(c == 'c') {
				Product prod = new Product(name, price);
				product.add(prod);
			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS");
		for(Product p : product) {
			System.out.println(p.priceTag());
		}

	}

}
