package internship.project2;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ProductHelper {
	 public  List<Products> productlist = new ArrayList<>();

	Logger logger = Logger.getLogger(ProductHelper.class.getName());

	// adddata()---Creating objects for each data having different properties and
	// adding objects to productlist
	// Map<String,Integer> CartMap=new HashMap<>();
	
	public List<Products> adddata(int productcode, String productname, int quantity, int price) {
		Products p = new Products(productcode, productname, quantity, price);
		productlist.add(p);
		return productlist;
	}

	// Printing the products available in the store
	public void printdata() {
		System.out.println("Mobiles with their costs");
		System.out.println("-----------------------------------");
		
		productlist.stream().forEach(mobile->System.out.println(mobile.getProductname()+"    "+mobile.getPrice()));
		/*for (Products mobile : productlist) {
			System.out.println(mobile.getProductname() + "    " + mobile.getPrice());
		}*/
	}

	// Validating based on the mobile and quantity available
	public Products validate(String mobilebrand, int quantity) {
		try {
			return new Validation().validateAndGetProduct(mobilebrand, quantity, productlist);

		} catch (CustomException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return null;
		}
	}

	// Deducting the quantity after the user purchases the mobile
	public void deduct(Products obj, int quantity) {
		obj.setQuantity(obj.getQuantity() - quantity);
		// System.out.println(obj.getquantity());

	}

	
}
