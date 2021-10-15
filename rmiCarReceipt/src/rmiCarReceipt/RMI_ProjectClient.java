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
			System.out.print("    Ho� geldiniz.");
			do {
				System.out.println("   Men�den se�im belirtiniz.");
				System.out.println(" 1-Yeni araba ekle");
				System.out.println(" 2-Yeni fi� olu�tur");
				System.out.println(" 3-ID ile ara� bilgisi g�r�nt�le");
				System.out.println(" 4-Marka ile ara� g�r�nt�le");
				System.out.println(" 5-ID ile fi� g�r�nt�le");
				System.out.println(" 6-Al�c� ad� ile fi� g�r�nt�le");
				System.out.println(" 0-SONLANDIR.");

				System.out.print("      Se�iminiz: ");
				num = scan.nextInt();
				if (num == 1) {

					System.out.println("\n Araba bilgilerini giriniz.");
					System.out.print("\n SER� NO: ");
					int serialNo = carScan.nextInt();
					System.out.print("\n MARKA: ");
					String brand = carScan.next();
					System.out.print("\n MODEL: ");
					String modal = carScan.next();
					System.out.print("\n RENK: ");
					String colour = carScan.next();
					System.out.print("\n YIL: ");
					int year = carScan.nextInt();
					System.out.print("\n A�IRLIK <kg>: ");
					int weight = carScan.nextInt();
					System.out.print("\n F�YAT: ");
					int price = carScan.nextInt();
					server.newCar(serialNo, modal, year, weight, price, colour, brand);
					System.out.println("Ara� kaydedildi.");
				}

				else if (num == 2) {
					System.out.println("\n Fi� bilgilerini giriniz.");
					System.out.print("\n Fi� SER� NO: ");
					int recId = recScan.nextInt();
					System.out.print("\n ARA� SER� NO: ");
					int carId = recScan.nextInt();
					System.out.print("\n �S�M: ");
					String vendorName = recScan.next();
					server.newReceipt(recId, carId, vendorName);
					System.out.println("Fi� olu�turuldu.");

				} else if (num == 3) {
					System.out.println(" ARA� ID: ");
					int carid = carScan.nextInt();
					server.carbySerialNumber(carid);
					break;

				} else if (num == 4) {
					System.out.println("ARA� MARKA:");
					String marka = carScan.next();
					server.carbyBrandName(marka);
					break;

				} else if (num == 5) {
					System.out.println("F�� ID:");
					int rid = carScan.nextInt();
					server.receiptbyID(rid);
					break;

				} else if (num == 6) {
					System.out.println("�S�M:");
					String name = carScan.next();
					server.receiptbyVendorN(name);
					break;

				} else if (num == 0) {

					System.out.println("��k�� yapt�n�z.");
					System.exit(0);
				} else {
					System.out.println("Yanl�� se�im yapt�n�z.");
				}
			} while (num != 0);

		} catch (Exception e) {
			System.out.println("Error the project can not running! ");
			e.printStackTrace();
		}

	}

}
