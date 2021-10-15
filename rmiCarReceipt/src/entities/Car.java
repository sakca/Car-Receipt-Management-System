package entities;

public class Car {

	private int serialNo;
	private String modal;
	private int year;
	private int weight;
	private int price;
	private String colour;
	private String brand;

	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(int serialNo, String modal, int year, int weight, int price, String colour, String brand) {
		super();
		this.serialNo = serialNo;
		this.modal = modal;
		this.year = year;
		this.weight = weight;
		this.price = price;
		this.colour = colour;
		this.brand = brand;
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public String getModal() {
		return modal;
	}

	public void setModal(String modal) {
		this.modal = modal;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

}
