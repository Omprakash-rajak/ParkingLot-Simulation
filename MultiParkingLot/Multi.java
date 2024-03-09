package MultiParkingLot;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class main {

	private static List admins = new LinkedList();
	private static List users = new LinkedList();
	private static boolean adminAccountCreated = false;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		main m = new main();
		while (true) {
			System.out.println("1. Create Admin Account");
			System.out.println("2. Create User Account");

			System.out.println("3. Login as Admin");
			System.out.println("4. Login as User");
			System.out.println("5. Exit");
			System.out.print("Choose an option: ");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				
				if (!adminAccountCreated) {
					m.createAdmin(scanner);
					adminAccountCreated = true;
				} else {
					System.out.println("Admin account already exists!");
				}
				break;
			case 2:
				m.createUser(scanner);
				break;
			case 3:
				m.adminLogin(scanner);
				break;
			case 4:
				m.userLogin(scanner);
				break;
			case 5:
				System.out.println("Exiting...");
				return;
			default:
				System.out.println("Invalid option!");
			}
		}
	}

	private void createAdmin(Scanner scanner) {
		System.out.print("Enter admin username: ");
		String adminname = scanner.nextLine();

		String NumReg = "[a-z0-9]+@[a-zA-Z]+\\.[a-z]{3}";
		Pattern pattern = Pattern.compile(NumReg);
		Matcher matcher = pattern.matcher(adminname);

		if (matcher.matches()) {
			System.out.println("true");
			admins.add(adminname);
		} else {
			System.out.println(" the admin name must follow the pattern ");
			System.out.println("op@gmail.com");
			createAdmin(scanner);
			return;
		}

		System.out.print("Enter admin password: ");
		String password = scanner.nextLine();
		String NumRe = "[a-z0-9]{6}";
		Pattern p = Pattern.compile(NumRe);
		Matcher m = p.matcher(password);
		if (m.matches()) {
			admins.add(password);

		} else {
			System.out.println(" the admin password must follow the pattern ");
			System.out.println(" sample pattern : op1458");
			createAdmin(scanner);
			return;
		}

		System.out.println("Admin account created successfully!");
	}

	private void createUser(Scanner scanner) {
		System.out.print("Enter user username: ");
		String username = scanner.nextLine();

		String NumReg = "[a-z0-9]+@[a-zA-Z]+\\.[a-z]{3}";
		Pattern pattern = Pattern.compile(NumReg);
		Matcher matcher = pattern.matcher(username);
		if (matcher.matches()) {
			users.add(username);
		} else {
			System.out.println(" the username must follow the pattern ");
			System.out.println(" sample pattern :  om@gmail.com");
			createUser(scanner);
			return;
		}

		System.out.print("Enter user password: ");
		String password = scanner.nextLine();
		String NumRe = "[a-z0-9]{6}";
		Pattern p = Pattern.compile(NumRe);
		Matcher m = p.matcher(password);
		if (m.matches()) {
			users.add(password);

		} else {
			System.out.println(" the admin password must follow the pattern ");
			System.out.println(" sample pattern  :  op1458");
			createUser(scanner);
			return;
		}

		System.out.println("User account created successfully!");
	}

	private void adminLogin(Scanner scanner) {
		main m = new main();
		System.out.print("Enter admin username: ");
		String username = scanner.nextLine();

		System.out.print("Enter admin password: ");
		String password = scanner.nextLine();

		if (admins.contains(username) && admins.contains(password)) {
			System.out.println("Admin login successful!");
			m.adminOptions();

		} else {
			System.out.println("Invalid admin username or password! or you are not created user");
		}
	}

	private void userLogin(Scanner scanner) {
		main m = new main();
		System.out.print("Enter user username: ");
		String username = scanner.nextLine();

		System.out.print("Enter user password: ");
		String password = scanner.nextLine();

		if (users.contains(username) && users.contains(password)) {
			System.out.println("User login successful!");
			// Add user functionality here
			userOptions();
		} else {
			System.out.println("Invalid user username or password! or you are not created admin ");
		}

	}

	public void adminOptions() {
		main m = new main();

		Scanner scanner = new Scanner(System.in);
		MultipleParkingLot multipleparkinglot = new MultipleParkingLot();
		List<ParkingLot> listofparkinglot = new ArrayList<>();
		System.out.println("How Many parking lot you want to create");
		int size = scanner.nextInt();
		System.out.println("Enter the s");
		System.out.println("Enter the slots for all type of vehical");
		for (int i = 0; i < size; i++) {

			System.out.println("Enter Slots for 2 wheel ,four wheeler and Heavy vehical");
			int TwoWheel = scanner.nextInt();
			// System.out.println("Enter Slots for four wheel");
			int FourWheel = scanner.nextInt();
			// System.out.println("Enter Slots for Heavy Vehicle");
			int HeavyWheeel = scanner.nextInt();
			ParkingLot parkinglot = new ParkingLot(TwoWheel, FourWheel, HeavyWheeel);
			listofparkinglot.add(parkinglot);

		}
		multipleparkinglot.setParkinglot(listofparkinglot);

		while (true) {
			System.out.println("\n1. Park Vehicle");
			System.out.println("2. Unpark Vehicle");
			System.out.println("3. View Current Occupancy Details");
			System.out.println("4. view all the parked vehical details");
			// System.out.println("5 .User login");

			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			String choice = scanner.next();

			switch (choice) {
			case "1":
				System.out.println("Enter parking lot number");
				int lot = scanner.nextInt();
				String NumReg = "[a-z]{2}[0-9]{2}[a-z]{2}[0-9]{4}";
				Pattern pattern = Pattern.compile(NumReg);
				System.out.println("Enter vehicle size : ");
				System.out.print("For two Wheel Enter 2W : ");
				System.out.print("For two Wheel Enter 4W : ");
				System.out.print("For two Wheel Enter HW : ");

				String vehicleSize = scanner.next();
				System.out.print("Enter vehicle number: ");

				String vehicleNumber = scanner.next();

				Matcher matcher = pattern.matcher(vehicleNumber);
				if (matcher.matches()) {

					Vehicle vehicle = new Vehicle(vehicleNumber, vehicleSize);
					listofparkinglot = multipleparkinglot.getParkinglot();
					ParkingLot parkinglot = listofparkinglot.get(lot - 1);
					double ticketnumber = parkinglot.parkVehicle(vehicle);

					if (ticketnumber != -1) {
						System.out.println("Vehicle parked successfully with ticket number : " + ticketnumber);
						// + slotNumber + vehicle.ticket.getIntime());
						// System.out.println("slot Number : " + slotNumber);
						System.out.println("In time" + vehicle.ticket.getIntime());
						System.out.println("Out Time " + vehicle.ticket.getOuttime());

					} else {
						System.out.println("No available slots for this vehicle type.");
					}
					break;
				} else {
					System.out.println(" please enter  valid Vehical Number");
					break;
				}
			case "2":

				System.out.print("Enter Ticket number to unpark: ");

				double ticketnumber = Double.parseDouble(scanner.next());
				System.out.println("Enter the parking lot from which you want to unpark your vehicle");
				int lot1 = scanner.nextInt();
				listofparkinglot = multipleparkinglot.getParkinglot();
				ParkingLot parkinglot = listofparkinglot.get(lot1);
				DateTimeFormatter time = DateTimeFormatter.ofPattern("yy-mm-dd  HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();

				Vehicle unparkedVehicle = parkinglot.unparkVehicle(ticketnumber);
				if (unparkedVehicle != null) {
					System.out.println("Vehicle with number " + unparkedVehicle.getNumber()
							+ " unparked from Ticket Number " + ticketnumber + "   in Time :   "
							+ unparkedVehicle.ticket.getIntime() + "  out time : " + now);
				} else {
					System.out.println("Slot is empty or invalid slot number.");

				}
				break;

			case "3":
				// System.out.println("Enter in which lot you want to check current occupancy");
				// int lot2 = scanner.nextInt();
				for (int i = 0; i < listofparkinglot.size(); i++) {
					listofparkinglot = multipleparkinglot.getParkinglot();
					ParkingLot parkinglot2 = listofparkinglot.get(i);

					System.out.println(parkinglot2.currentOccupancyDetails(i));
				}
				break;
			case "4":
				// System.out.println("Enter in which lot your want to see ticket details");
				// int lot3 = scanner.nextInt();
				for (int i = 0; i < listofparkinglot.size(); i++) {
					listofparkinglot = multipleparkinglot.getParkinglot();
					ParkingLot parkinglot3 = listofparkinglot.get(i);
					parkinglot3.ticketDetails(i);
				}
				break;
			//case "5":
			//m.userLogin(scanner);
			//break;

			case "6":
				System.out.println("Exiting...");
				return;
			default:
				System.out.println("Invalid choice. Please try again.");
			}

		}
	}

	public void userOptions() {
		MultipleParkingLot multipleparkinglot = new MultipleParkingLot();
		main m = new main();
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("\n1. Park Vehicle");
			System.out.println("2. Unpark Vehicle");
			System.out.println("3. View Current Occupancy Details");

			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			String choice = scanner.next();

			switch (choice) {
			case "1":
				try {
					System.out.println("Enter parking lot number");
					int lot = scanner.nextInt();
					String NumReg = "[a-z]{2}[0-9]{2}[a-z]{2}[0-9]{4}";
					Pattern pattern = Pattern.compile(NumReg);
					System.out.println("Enter vehicle size : ");
					System.out.print("For two Wheel Enter 2W : ");
					System.out.print("For two Wheel Enter 4W : ");
					System.out.print("For two Wheel Enter HW : ");

					String vehicleSize = scanner.next();
					System.out.print("Enter vehicle number: ");

					String vehicleNumber = scanner.next();

					Matcher matcher = pattern.matcher(vehicleNumber);
					if (matcher.matches()) {

						Vehicle vehicle = new Vehicle(vehicleNumber, vehicleSize);
						List<ParkingLot> listofparkinglot = multipleparkinglot.getParkinglot();
						ParkingLot parkinglot = listofparkinglot.get(lot - 1);
						double ticketnumber = parkinglot.parkVehicle(vehicle);

						if (ticketnumber != -1) {
							System.out.println("Vehicle parked successfully with ticket number : " + ticketnumber);
							// + slotNumber + vehicle.ticket.getIntime());
							// System.out.println("slot Number : " + slotNumber);
							System.out.println("In time" + vehicle.ticket.getIntime());
							System.out.println("Out Time " + vehicle.ticket.getOuttime());

						} else {
							System.out.println("No available slots for this vehicle type.");
						}
						break;
					} else {
						System.out.println(" please enter  valid Vehical Number");

					}
					break;
				} catch (Exception e) {

					System.out.println("slots not available ask admin ");
					m.adminLogin(scanner);

				}

				// System.out.println("If you wannt to park your vehical you have to ask
				// admin");
				// adminLogin(scanner);

			case "2":
				try {
					System.out.print("Enter Ticket number to unpark: ");

					double ticketnumber = Double.parseDouble(scanner.next());
					System.out.println("Enter the parking lot from which you want to unpark your vehicle");
					int lot1 = scanner.nextInt();
					List<ParkingLot> listofparkinglot = multipleparkinglot.getParkinglot();
					ParkingLot parkinglot = listofparkinglot.get(lot1);
					DateTimeFormatter time = DateTimeFormatter.ofPattern("yy-mm-dd  HH:mm:ss");
					LocalDateTime now = LocalDateTime.now();

					Vehicle unparkedVehicle = parkinglot.unparkVehicle(ticketnumber);
					if (unparkedVehicle != null) {
						System.out.println("Vehicle with number " + unparkedVehicle.getNumber()
								+ " unparked from Ticket Number " + ticketnumber + "   in Time :   "
								+ unparkedVehicle.ticket.getIntime() + "  out time : " + now);
					} else {
						System.out.println("Slot is empty or invalid slot number.");

					}
					break;
				} catch (Exception e) {
					System.out.println("slots not available ask admin ");
					m.adminLogin(scanner);
				}
			case "3":
				try {
					System.out.println("enter in Which lot You Vehical is parked");
					int lot = scanner.nextInt();
					List<ParkingLot> listofparkinglot = multipleparkinglot.getParkinglot();
					ParkingLot parkinglot3 = listofparkinglot.get(lot);
					parkinglot3.ticketDetails(lot);
					break;
				} catch (Exception e) {
					System.out.println("vehical  is not there");
				}

			default:
				System.out.println("Invalid choice. Please try again.");
			}

		}

	}
}