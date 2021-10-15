package rmiCarReceipt;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;

import entities.Car;
import entities.Receipt;

public class RMI_ProjectClient {

	private static Scanner scan = null;
	private static Scanner carScan = null;
	private static Scanner recScan = null;
	private static RMI_ProjectInterface server;

	static ArrayList<Car> cars;
	ArrayList<Receipt> receipts;

	public RMI_ProjectClient() {
	}

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		try {

			Registry registry = LocateRegistry.getRegistry("localhost", 1099);
			server = (RMI_ProjectInterface) registry.lookup("CarReceiptServer");

			scan = new Scanner(System.in);
			carScan = new Scanner(System.in);
			recScan = new Scanner(System.in);
			int num;
			System.out.print("    Hoþ geldiniz.");
			do {
				System.out.println("   Menüden seçim belirtiniz.");
				System.out.println(" 1-Yeni araba ekle");
				System.out.println(" 2-Yeni fiþ oluþtur");
				System.out.println(" 3-ID ile araç bilgisi görüntüle");
				System.out.println(" 4-Marka ile araç görüntüle");
				System.out.println(" 5-ID ile fiþ görüntüle");
				System.out.println(" 6-Alýcý adý ile fiþ görüntüle");
				System.out.println(" 0-SONLANDIR.");

				System.out.print("      Seçiminiz: ");
				num = scan.nextInt();
				if (num == 1) {

					System.out.println("\n Araba bilgilerini giriniz.");
					System.out.print("\n SERÝ NO: ");
					int serialNo = carScan.nextInt();
					System.out.print("\n MARKA: ");
					String brand = carScan.next();
					System.out.print("\n MODEL: ");
					String modal = carScan.next();
					System.out.print("\n RENK: ");
					String colour = carScan.next();
					System.out.print("\n YIL: ");
					int year = carScan.nextInt();
					System.out.print("\n AÐIRLIK <kg>: ");
					int weight = carScan.nextInt();
					System.out.print("\n FÝYAT: ");
					int price = carScan.nextInt();
					server.newCar(serialNo, modal, year, weight, price, colour, brand);
					System.out.println("Araç kaydedildi.");
				}

				else if (num == 2) {
					System.out.println("\n Fiþ bilgilerini giriniz.");
					System.out.print("\n FiÞ SERÝ NO: ");
					int recId = recScan.nextInt();
					System.out.print("\n ARAÇ SERÝ NO: ");
					int carId = recScan.nextInt();
					System.out.print("\n ÝSÝM: ");
					String vendorName = recScan.next();
					server.newReceipt(recId, carId, vendorName);
					System.out.println("Fiþ oluþturuldu.");

				} else if (num == 3) {
					System.out.println(" ARAÇ ID: ");
					int carid = carScan.nextInt();
					server.carbySerialNumber(carid);
					break;

				} else if (num == 4) {
					System.out.println("ARAÇ MARKA:");
					String marka = carScan.next();
					server.carbyBrandName(marka);
					break;

				} else if (num == 5) {
					System.out.println("FÝÞ ID:");
					int rid = carScan.nextInt();
					server.receiptbyID(rid);
					break;

				} else if (num == 6) {
					System.out.println("ÝSÝM:");
					String name = carScan.next();
					server.receiptbyVendorN(name);
					break;

				} else if (num == 0) {

					System.out.println("Çýkýþ yaptýnýz.");
					System.exit(0);
				} else {
					System.out.println("Yanlýþ seçim yaptýnýz.");
				}
			} while (num != 0);

		} catch (Exception e) {
			System.out.println("Error the project can not running! ");
			e.printStackTrace();
		}

	}

}
