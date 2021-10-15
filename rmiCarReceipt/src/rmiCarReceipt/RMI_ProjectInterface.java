package rmiCarReceipt;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import entities.Car;
import entities.Receipt;

public interface RMI_ProjectInterface extends Remote {

	public void newCar(int serialNo, String modal, int year, int weight, int price, String colour, String brand)
			throws RemoteException, IOException;

	public void newReceipt(int id, int carId, String vendorName) throws RemoteException, IOException;// yeni fatura

	public void carbySerialNumber(int serialNo) throws RemoteException;// seri numaras�na g�re araba

	public void carbyBrandName(String brand) throws RemoteException;// marka ismine g�re araba

	public void receiptbyID(int ID) throws RemoteException;// ID g�re fatura sorgulama

	public void receiptbyVendorN(String customer) throws RemoteException;// musteriye g�re fatura sorgulama

	ArrayList<Car> carList = new ArrayList<>();
	ArrayList<Receipt> receiptList = new ArrayList<>();
}
