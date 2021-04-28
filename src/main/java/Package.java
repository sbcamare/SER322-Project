
public class Package {

	private String toFirstName;
	private String toLastName;
	private String toAddress;
	private String packageType;
	private String shippingSpeed;
	private int dimensions;
	private double weight;
	
	public Package(String firstName, String lastName, String toAddress, String type, String speed, int dimensions, double weight ) {
		this.toFirstName = firstName;
		this.toLastName = lastName;
		this.toAddress = toAddress;
		this.packageType = type;
		this.shippingSpeed = speed;
		this.dimensions = dimensions;
		this.weight = weight;
	}
	
	public String getFirstName() {
		return this.toFirstName;
	}
	
	public String getLasttName() {
		return this.toLastName;
	}
	
	public String getToAddress() {
		return this.toAddress;
	}
	
	public String getPackageType() {
		return this.packageType;
	}
	
	public String getShippingSpeed() {
		return this.shippingSpeed;
	}
	
	public int getDimensions() {
		return this.dimensions;
	}
	
	public double getWeight() {
		return this.weight;
	}
}
