package rmiCarReceipt;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import entities.Car;
import entities.Receipt;

public class RMI_ProjectServer extends UnicastRemoteObject implements RMI_ProjectInterface {

	public RMI_ProjectServer() throws RemoteException {
		super();
	}

	public static void main(String[] args) throws RemoteException, AlreadyBoundException {

		try {
			RMI_ProjectServer crServer = new RMI_ProjectServer();
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.bind("CarReceiptServer", crServer);
			System.out.println("Project is running and ready..");

		} catch (Exception e) {
			System.out.println("Proje yürütülemedi. " + e);
		}

	}

	@Override
	public void newCar(int serialNo, String modal, int year, int weight, int price, String colour, String brand)
			throws IOException {
		carList.add(new Car(serialNo, modal, year, weight, price, colour, brand));

		File file = new File("cars.txt");
		if (!file.exists()) {
			file.createNewFile();
		}

		FileWriter fwriter = new FileWriter(file, false);
		BufferedWriter bwriter = new BufferedWriter(fwriter);

		for (int i = 0; i < carList.size(); i++) {
			bwriter.write(carList.get(i).getSerialNo() + " ");
			bwriter.write(carList.get(i).getBrand() + " ");
			bwriter.write(carList.get(i).getModal() + " ");
			bwriter.write(carList.get(i).getColour() + " ");
			bwriter.write(carList.get(i).getYear() + " ");
			bwriter.write(carList.get(i).getWeight() + " ");
			bwriter.write(carList.get(i).getPrice() + " ");

			System.out.println("\n");

		}
		bwriter.close();

	}

	@Override
	public void newReceipt(int id, int carId, String vendorName) throws IOException {
		receiptList.add(new Receipt(id, carId, vendorName));

		File file = new File("receipts.txt");
		if (!file.exists()) {
			file.createNewFile();
		}

		FileWriter fwriter = new FileWriter(file, false);
		BufferedWriter bwriter = new BufferedWriter(fwriter);

		for (int i = 0; i < receiptList.size(); i++) {
			bwriter.write(receiptList.get(i).getId() + " ");
			bwriter.write(receiptList.get(i).getCarId() + " ");
			bwriter.write(receiptList.get(i).getVendorName() + " ");
		}

		bwriter.close();

	}

	@Override
	public void carbySerialNumber(int serialNo) throws RemoteException {
		for (int i = 0; i < carList.size(); i++) {
			if (serialNo == carList.get(i).getSerialNo()) {
				System.out.println("Araç id: " + carList.get(i).getSerialNo());
				System.out.println("Marka: " + carList.get(i).getBrand());
				System.out.println("Model:" + carList.get(i).getModal());
				System.out.println("Renk: " + carList.get(i).getColour());
				System.out.println("Yýl: " + carList.get(i).getYear());
				System.out.println("Aðýrlýk: " + carList.get(i).getWeight());
				System.out.println("Fiyat: " + carList.get(i).getPrice());
				System.out.println("  Araba bilgileri id bilgisine göre listelendi.");
			}
		}

	}

	@Override
	public void carbyBrandName(String brand) throws RemoteException {

		for (int i = 0; i < carList.size(); i++) {
			String tempBrand = carList.get(i).getBrand();

			if (brand.compareTo(tempBrand) == 0) {
				System.out.println("Araç id: " + carList.get(i).getSerialNo());
				System.out.println("Marka: " + carList.get(i).getBrand());
				System.out.println("Model:" + carList.get(i).getModal());
				System.out.println("Renk: " + carList.get(i).getColour());
				System.out.println("Yýl: " + carList.get(i).getYear());
				System.out.println("Aðýrlýk: " + carList.get(i).getWeight());
				System.out.println("Fiyat: " + carList.get(i).getPrice());
				System.out.println("  Araba bilgileri markaya göre listelendi.");
			}
		}

	}

	@Override
	public void receiptbyID(int id) throws RemoteException {

		for (int i = 0; i < receiptList.size(); i++) {
			if (id == receiptList.get(i).getId()) {
				System.out.println("Fiþ id: " + receiptList.get(i).getId());
				System.out.println("Araç id: " + receiptList.get(i).getCarId());
				System.out.println("Ýsim: " + receiptList.get(i).getVendorName());
				System.out.println("Fiyat: " + carList.get(receiptList.get(i).getCarId()).getPrice());
				System.out.println("  Fiþ id bilgisine göre listelendi.");

			}
		}

	}

	@Override
	public void receiptbyVendorN(String customer) throws RemoteException {
		for (int i = 0; i < receiptList.size(); i++) {
			String tempName = receiptList.get(i).getVendorName();

			if (customer.compareTo(tempName) == 0) {
				System.out.println("Fiþ id: " + receiptList.get(i).getId());
				System.out.println("Araç id: " + receiptList.get(i).getCarId());
				System.out.println("Ýsim: " + receiptList.get(i).getVendorName());
				System.out.println("Fiyat: " + carList.get(receiptList.get(i).getCarId()).getPrice());
				System.out.println("  Fiþ isim bilgisine göre listelendi.");
			}
		}
	}

}
