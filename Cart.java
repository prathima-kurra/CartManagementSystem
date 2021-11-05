package internship.project2;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

//Cart contains all the products purchased by the user
public class Cart {
	Logger logger = Logger.getLogger(Cart.class.getName());

	// adding the productname and quantity by using map data structure
	// adding product name and the quantity the user purchased to the cart
	
     Map<String,Integer> CartMap=new HashMap<>(); 
    
    int cost=0;
    void addproducts(Products obj,int quantity) {
    	if (CartMap.containsKey(obj.getProductname()))
			CartMap.put(obj.getProductname(), CartMap.get(obj.getProductname()) + quantity);
		else
			CartMap.put(obj.getProductname(), quantity);
    	//System.out.println("Purchased items till now:"+CartMap);
        cost=cost+quantity*obj.getPrice();
        //System.out.println("Bill till now:"+cost);
       
    }
    
}
