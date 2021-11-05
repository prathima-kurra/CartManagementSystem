package internship.project2;

import java.util.List;
import java.util.logging.Logger;

//Validating the user input and throwing the custom exception
public class Validation {
	final Logger logger = Logger.getLogger(Validation.class.toString());
	/*
	 * Validation is done based on the mobile name and the quantity available. If
	 * mobile name or quantity is not available,then custom exception is thrown.
	 */

	public Products validateAndGetProduct(String mobilebrand, int quantity, List<Products> productlist) throws CustomException {

		//boolean flag = false;
		Products obj = null;
		obj=productlist.stream().filter(mobile->mobilebrand.equalsIgnoreCase(mobile.getProductname()) && mobile.getQuantity()>=quantity).findAny().get();
		/*for (Products mobile : productlist) {
			if (mobilebrand.equalsIgnoreCase(mobile.getProductname()) && mobile.getQuantity() >= quantity) {
				obj = mobile;
				flag = true;
				break;
			}

		}*/
		if (obj!=null)
		{
			logger.info(mobilebrand + " is available");
			ProductHelper ph = new ProductHelper();
			// Deducting the quantity and adding the purchased products to the cart
			ph.deduct(obj, quantity);
			return obj;
		}

		else {
			throw new CustomException("Products is not available");
			
		}
	}
}
