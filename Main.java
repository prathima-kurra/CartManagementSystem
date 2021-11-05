package internship.project2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
	public static void main(String args[]) throws Exception {
		final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
		BufferedReader objReader=null;
		
		Map<String, Integer> CartMap = new HashMap<>(); 
		ProductHelper ph = new ProductHelper();
		try {
			Cart cart=new Cart();
			String strCurrentLine;
            objReader = new BufferedReader(new FileReader("Inputfile.txt"));

			   while ((strCurrentLine = objReader.readLine()) != null) {
				   String[] words=strCurrentLine.split(",");
				   int productcode = Integer.parseInt(words[0]);
					String productname = words[1];
					int quantity = Integer.parseInt(words[2]);
					int price = Integer.parseInt(words[3]);
					ph.adddata(productcode, productname, quantity, price);
			   }
			   
			   ph.printdata();
			
			Scanner sc1 = new Scanner(System.in);
			char choice = 'N';
             
			// Taking input from the user
			try {
			do {
				logger.info("Enter the mobile:");
				String mobilebrand = sc1.next();
				logger.info("Enter the quantity:");
				int quantity = sc1.nextInt();
				Products product =ph.validate(mobilebrand, quantity);
				if(product!=null)
				cart.addproducts(product, quantity);
				System.out.println("Do you want to continue?");
				logger.info("Press y/Y if you want to continue");
				choice = sc1.next().charAt(0);
			} while (choice == 'y' || choice == 'Y');
			sc1.close();
			}catch(InputMismatchException e) {
				System.out.println("Please enter valid input");
			}
			// When the user choice is not yes then cart items and total bill is printed
			logger.info("Thank you for shopping");
			logger.info("Products purchased:");
			CartMap=cart.CartMap;
			for(Map.Entry<String, Integer> cartitems:CartMap.entrySet()) {
				logger.info(cartitems.getKey()+" "+cartitems.getValue());
			}
			logger.info("Total bill:"+cart.cost);
			//ph.generatebill();
		}catch(FileNotFoundException e) {
			System.out.println("File is not found!!");
		}
		catch(NumberFormatException e) {
			System.out.println("File format is incorrect");
		}
	}
}
