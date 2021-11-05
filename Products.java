package internship.project2;



//Products class contain all the properties of the objects
public class Products {
	int productcode, quantity, price;
	String productname;

	public Products(int productcode, String productname, int quantity, int price) {
		this.productcode = productcode;
		this.productname = productname;
		this.quantity = quantity;
		this.price = price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getProductcode() {
		return productcode;
	}

	public String getProductname() {
		return productname;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getPrice() {
		return price;
	}
	

}
