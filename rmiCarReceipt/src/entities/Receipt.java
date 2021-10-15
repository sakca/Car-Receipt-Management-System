package entities;

public class Receipt {

	private int id;
	private int carId;
	private String vendorName;

	public Receipt() {
		// TODO Auto-generated constructor stub
	}

	public Receipt(int id, int carId, String vendorName) {
		super();
		this.id = id;
		this.carId = carId;
		this.vendorName = vendorName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

}
