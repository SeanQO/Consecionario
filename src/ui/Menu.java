package ui;
import model.*;
import java.util.*;
public class Menu{
	private final static String ASTERISK = "*******************";
	private final static int REGISTER_VEHICLE = 1;
	private final static int REGISTER_CLIENT = 2;
	private final static int SELL_VEHICLE = 3;
	private final static int VEHICLE_CATALOG = 4;
	private final static int CLIENTS_WISH_LIST = 5;
	private final static int CLIENTS_OWNED_VEHICLES = 6;
	private final static int PARKING_LOT = 7;
	private final static int EXIT = 0;
	private Scanner in;
	private Dealer dealer;
	/**
		*Name:Menu
		*Menu class constructor.creates the instance of the Scanner, in. and the principal class (Ship) instance, the pirate.
	*/
	public Menu() {
		in = new Scanner(System.in);
		dealer = new Dealer("Autos Cali", "6468461", 0, 0);
	}

/*
	**************************************************tools*********************************************************
*/
	/**
		*Name:showWellcome
		*it shows a wellcome message for the begining of the program.
	*/
	public void showWellcome(){
		System.out.println(ASTERISK);
		System.out.println("****Wellcome!****");
	}

	/**
		*Name: showPrincipalMenu
		*it shows the pricipal menu interface.
	*/
	public void showPrincipalMenu(){
		System.out.println(ASTERISK);
		System.out.println("**PRINCIPAL MENU***");
		System.out.println(ASTERISK);
		System.out.println("1.Register vehicle");
		System.out.println("2.Register new client");
		System.out.println("3.Sell vehicle");
		System.out.println("4.Vehicle catalog");
		System.out.println("5.Clients wish list");
		System.out.println("6.Clients owned vehicles.");
		System.out.println("7.Parking lot");
		System.out.println("0.Exit.");
	}

	/**
		*Name:readInt
		*it read an integer number and returns that number.
		*@return option
	*/
	public int readInt() {
		int option = in.nextInt();
		in.nextLine();
		return option;
	}

	/**
		*Name: readDouble
		*it read a double number and returns that number.
		*@return option
	*/
	public double readDouble() {
		double option = in.nextDouble();
		in.nextLine();
		return option;
	}

	/**
		*Name: readDouble
		*it read a double number and returns that number.
		*@return option
	*/
	public boolean readBoolean() {
		String option ="";
		boolean value = false;
		boolean checked = false;
		option = in.nextLine();
		do{
			if (option.equalsIgnoreCase("true") || option.equalsIgnoreCase("false") ) {
				value = Boolean.parseBoolean(option.toLowerCase());
				checked = true;
			}else{
				System.out.println(ASTERISK);
				System.out.println("Invalid option. the number must be: ¨true¨ or ¨false¨");
				option = in.nextLine();
			}

		}while(!checked);
		return value;
	}

	/**
		*Name: pressEnterToContinue.
		*shows a message to press enter, reads any input. 
	*/
	public void pressEnterToContinue() {
		System.out.println(ASTERISK);
		System.out.println("Press enter to continue. ");
		String any = in.nextLine();
	}

	/**
		*Name: checkOption.
		*checks if an number given is in between other two numbers, if its not, shows an error message,
		*and then gives a trut value dependig if the number given meets the conditions.
		*@param option != null.
		*@param min != null.
		*@param max != null.
		*@return checked.
	*/
	public double checkOption(double option,double min, double max) {
		boolean checked = false;
		do{
			if(option >= min && option <= max){
			checked = true; 	
			}else{
				System.out.println(ASTERISK);
				System.out.println("Invalid option. the number must be in between: "+ (int)min +" and "+ (int)max);
				option = readDouble();
			}
		}while(!checked);

		return option;
	}

	/**
		*Name: selectClient.
		*displays a list of the current clients names and ids,
		*then reads an option that represents a client and returns that selected client
		*@return Client.
	*/
	public Client selectClient(){
		System.out.println(ASTERISK);
		System.out.println("Selec client");
		System.out.println(ASTERISK);
		for (int i = 0; i < dealer.getClients().size(); i++ ) {
			System.out.println((i+1)+"."+dealer.getClients().get(i).getName()+" ID: "+dealer.getClients().get(i).getId());
		}
		int option = readInt();
		option = (int) checkOption(option,1,dealer.getClients().size());
		return dealer.getClients().get(option-1);
	}

/*
	**************************************************all options*********************************************************
*/

	/**
		*Name: runOption.
		*with a swich loop, runs all the options avalible in the interface menu, depending what option the user wants to use.
		*<b> thePirate object from Ship class, must be already defined.
		*@param option != null.
	*/
	public void runOption(int option) {
		switch (option) {
			case REGISTER_VEHICLE:
				runOptionregisterVehicle();
				break;

			case REGISTER_CLIENT:
				runOptionregisterClient();
				break;

			case SELL_VEHICLE:
				runOptionSellVehicle();
				break;

			case VEHICLE_CATALOG:
				runOptionVehicleCatalog();
				break;

			case CLIENTS_WISH_LIST:
				runOptionClientWishList();
				break;

			case CLIENTS_OWNED_VEHICLES:
				runOptionClientOwnedVehicles();
				break;

			case PARKING_LOT:
				runOptionParkingLot();
				break;
			case EXIT:
				System.out.println(ASTERISK);
				System.out.println("**COME BACK SOON! :)*");
				System.out.println(ASTERISK);
				break;
			default:
				System.out.println(ASTERISK);
				System.out.println("Invalid option.");
		}
	}

/*
	**************************************************option register vehicle*********************************************************
*/

	/**
		*Name: runOptionRegisterVehicle.
		*ask for a type of vehicle to add, and then runs the method to add the specific type of vehicle
	*/
	public void runOptionregisterVehicle(){
		int option = 0;
		do{
			System.out.println(ASTERISK);
			System.out.println("which type of vehicle do you wish to add?:");
			System.out.println("1.motorcycle 2.Gasoline car 3.Electric car 4.Hybrid car 0.Exit");
			option = readInt();
			switch (option) {
				case 1:
					dealer.getVehicles().add(getNewMotorcycle());
					break;
				case 2:
					dealer.getVehicles().add(getNewGasCar());
					break;
				case 3:
					dealer.getVehicles().add(getNewElecCar());
					break;
				case 4:
					dealer.getVehicles().add(getNewHybridCar());
					break;
				default:
					System.out.println(ASTERISK);
					System.out.println("Invalid option.");
			}
			
			if(option != 0){
				System.out.println(ASTERISK);
				System.out.println("vehicle succesfully added");
			}

		}while(option != 0);
	}

	/**
		*Name: carGoesToParkingLot.
		*check if a given car fills the conditions to  be adde in to the parking lot
		*@param car != null.
		*@return goesToParkinglot.
	*/
	public boolean carGoesToParkinglot(Car car){
		int model = car.getModel();
		boolean used = car.getUsed();
		boolean goesToParkinglot = false;
		
		if (used && (model < 2015)) {
			goesToParkinglot = true;
		}
		return goesToParkinglot;
	}

	/**
		*Name: vehicleDocumentsList.
		*displays a list of all the documents generated for a vehicle.
		*@param vehicle != null.
	*/
	public void vehicleDocumentsList(Vehicle vehicle){
		if (vehicle.getUsed()) {
			if (vehicle.getDocuments().size() == 0) {
				System.out.println(ASTERISK);
				System.out.println("The vehicle doesnt have any old or current documents");
				pressEnterToContinue();

			}else{
				System.out.println(ASTERISK);
				System.out.println("The vehicle list of documents:");
				for (int i = 0; i < vehicle.getDocuments().size() ; i++ ) {
					System.out.println(vehicle.getDocuments().get(i).documentsInfo());
				}
				pressEnterToContinue();
			}
			
		}

	}

	/**
		*Name: getNewMotorcycle.
		*reads all the information needed to create a motorcycle, and creates a motorcycle, and then returns this motorcycle.
		*@return newMotorcycle.
	*/
	public Motorcycle getNewMotorcycle() {
		System.out.println(ASTERISK);
		System.out.println("Enter the motorcycle base price:");
		double basePrice = readDouble();

		System.out.println(ASTERISK);
		System.out.println("Enter the motorcycle brand:");
		String brand = in.nextLine();

		System.out.println(ASTERISK);
		System.out.println("Enter the motorcycle model:");
		int model = readInt();

		System.out.println(ASTERISK);
		System.out.println("Enter the motorcycle displacement:");
		double displacement = readDouble();

		System.out.println(ASTERISK);
		System.out.println("Enter the motorcycle mileage:");
		int mileage = readInt();

		System.out.println(ASTERISK);
		System.out.println("Enter the motorcycle use state:");
		System.out.println("type: - true - if used");
		System.out.println("type: - false - if new");
		boolean used = readBoolean();

		String plate = "";
		if (used) {
			System.out.println(ASTERISK);
			System.out.println("Enter the motorcycle plate:");
			plate = in.nextLine();	
		}

		System.out.println(ASTERISK);
		System.out.println("Enter the motorcycle gas type:");
		System.out.println("1.Premium 2.Regular 3.Diesel");
		int gasIntType = readInt();
		gasIntType = (int) checkOption(gasIntType,1,3);
		String gasType = "";
		switch (gasIntType) {
			case 1:
				gasType = "Premium";
				break;
			case 2:
				gasType = "Regular";
				break;
			case 3:
				gasType = "Diesel";
		}

		System.out.println(ASTERISK);
		System.out.println("Enter the motorcycle tank capacity:");
		double tankCapacity = readDouble();

		System.out.println(ASTERISK);
		System.out.println("Enter the motorcycle type:");
		System.out.println("1.Standard 2.Sport 3.Scooter 4.Cross");
		int motorcycleIntType = readInt();
		motorcycleIntType = (int) checkOption(motorcycleIntType,1,4);
		String motorcycleType = "";
		switch (motorcycleIntType) {
			case 1:
				motorcycleType = "Standart";
				break;
			case 2:
				motorcycleType = "Sport";
				break;
			case 3:
				motorcycleType = "Scooter";
				break;
			case 4:
				motorcycleType = "Cross";
				break;
		}

		Motorcycle newMotorcycle = new Motorcycle(basePrice, brand, model, displacement, mileage, used, 
										plate, gasType, tankCapacity,
										motorcycleType);
		vehicleDocumentsList(newMotorcycle);
		return newMotorcycle;
	}

	/**
		*Name: getNewGasCar.
		*reads all the information needed to create a gas car, then creates it, and return the created gas car.
		*@return newGasCar.
	*/
	public GasCar getNewGasCar() {
		System.out.println(ASTERISK);
		System.out.println("Enter the car base price:");
		double basePrice = readDouble();

		System.out.println(ASTERISK);
		System.out.println("Enter the car brand:");
		String brand = in.nextLine();

		System.out.println(ASTERISK);
		System.out.println("Enter the car model:");
		int model = readInt();

		System.out.println(ASTERISK);
		System.out.println("Enter the car displacement:");
		double displacement = readDouble();

		System.out.println(ASTERISK);
		System.out.println("Enter the car mileage:");
		int mileage = readInt();

		System.out.println(ASTERISK);
		System.out.println("Enter the car use state:");
		System.out.println("type: - true - if used");
		System.out.println("type: - false - if new");
		boolean used = readBoolean();

		String plate = "";
		if (used) {
			System.out.println(ASTERISK);
			System.out.println("Enter the car plate:");
			plate = in.nextLine();	
		}
		
		System.out.println(ASTERISK);
		System.out.println("Enter the car number of doors");
		int noDoors = readInt();

		System.out.println(ASTERISK);
		System.out.println("Enter the car polarized state:");
		System.out.println("type: - true - if polarized");
		System.out.println("type: - false - if not polarized");
		boolean polarized = readBoolean();

		System.out.println(ASTERISK);
		System.out.println("Enter the car tank capacity:");
		double tankCapacity = readDouble();

		System.out.println(ASTERISK);
		System.out.println("Enter the car gas type");
		System.out.println("1.Premium 2.Regular 3.Diesel");
		int gasIntType = readInt();
		gasIntType =  (int) checkOption(gasIntType,1,3);
		String gasType = "";
		switch (gasIntType) {
			case 1:
				gasType = "Premium";
				break;
			case 2:
				gasType = "Regular";
				break;
			case 3:
				gasType = "Diesel";
		}

		System.out.println(ASTERISK);
		System.out.println("Enter the car type");
		System.out.println("1.Sedan 2.Van");
		int carIntType = readInt();
		carIntType = (int) checkOption(carIntType,1,3);
		String carType = "";
		switch (carIntType) {
			case 1:
				carType = "Sedan";
				break;
			case 2:
				carType = "Van";
				break;
		}
		GasCar newGasCar = new GasCar(basePrice, brand, model, displacement, mileage, used, plate, 
										carType, noDoors, polarized, 
										tankCapacity, gasType);
		if (carGoesToParkinglot(newGasCar)) {
			System.out.println(ASTERISK);
			System.out.println(dealer.addCarToParkingLot(newGasCar));
		}

		vehicleDocumentsList(newGasCar);
		return newGasCar;
	}

	/**
		*Name: getNewElecCar.
		*reads all the information needed to create an electric car, and creates this car, and then returns the created electric car.
		*@return newElecCar.
	*/
	public ElectricCar getNewElecCar() {
		System.out.println(ASTERISK);
		System.out.println("Enter the car base price:");
		double basePrice = readDouble();

		System.out.println(ASTERISK);
		System.out.println("Enter the car brand:");
		String brand = in.nextLine();

		System.out.println(ASTERISK);
		System.out.println("Enter the car model:");
		int model = readInt();

		System.out.println(ASTERISK);
		System.out.println("Enter the car displacement:");
		double displacement = readDouble();

		System.out.println(ASTERISK);
		System.out.println("Enter the car mileage:");
		int mileage = readInt();

		System.out.println(ASTERISK);
		System.out.println("Enter the car use:");
		System.out.println("type: - true - if used");
		System.out.println("type: - false - if new");
		boolean used = readBoolean();

		String plate = "";
		if (used) {
			System.out.println(ASTERISK);
			System.out.println("Enter the car plate:");
			plate = in.nextLine();	
		}

		System.out.println(ASTERISK);
		System.out.println("Enter the car type");
		System.out.println("1.Sedan 2.Van");
		int carIntType = readInt();
		carIntType = (int) checkOption(carIntType,1,3);
		String carType = "";
		switch (carIntType) {
			case 1:
				carType = "Sedan";
				break;
			case 2:
				carType = "Van";
				break;
		}

		System.out.println(ASTERISK);
		System.out.println("Enter the car number of doors");
		int noDoors = readInt();

		System.out.println(ASTERISK);
		System.out.println("Enter the car polarized state:");
		System.out.println("type: - true - if polarized");
		System.out.println("type: - false - if not polarized");
		boolean polarized = readBoolean();

		System.out.println(ASTERISK);
		System.out.println("Enter the car fast charging state:");
		System.out.println("type: - true - if it has fast charging");
		System.out.println("type: - false - if it doesnt have fast charging");
		boolean fastCharger = readBoolean();

		System.out.println(ASTERISK);
		System.out.println("Enter the car battery life:");
		double batteryLife = readDouble();

		ElectricCar newElecCar = new ElectricCar(basePrice, brand, model, displacement, mileage, used, plate,
										carType,noDoors, polarized,
										fastCharger, batteryLife);

		if (carGoesToParkinglot(newElecCar)) {
			System.out.println(ASTERISK);
			System.out.println(dealer.addCarToParkingLot(newElecCar));
		}

		vehicleDocumentsList(newElecCar);
		return newElecCar;
	}

	/**
		*Name: getNewHybridCar.
		*reads all the information needed to create a hybrid car, and creates this car, and then returns the created hybrid car.
		*@return newElecCar.
	*/
	public HybridCar getNewHybridCar() {
		System.out.println(ASTERISK);
		System.out.println("Enter the car base price:");
		double basePrice = readDouble();

		System.out.println(ASTERISK);
		System.out.println("Enter the car brand:");
		String brand = in.nextLine();

		System.out.println(ASTERISK);
		System.out.println("Enter the car model:");
		int model = readInt();

		System.out.println(ASTERISK);
		System.out.println("Enter the car displacement:");
		double displacement = readDouble();

		System.out.println(ASTERISK);
		System.out.println("Enter the car mileage:");
		int mileage = readInt();

		System.out.println(ASTERISK);
		System.out.println("Enter the car use:");
		System.out.println("type: - true - if used");
		System.out.println("type: - false - if new");
		boolean used = readBoolean();

		String plate = "";
		if (used) {
			System.out.println(ASTERISK);
			System.out.println("Enter the car plate:");
			plate = in.nextLine();	
		}

		System.out.println(ASTERISK);
		System.out.println("Enter the car type");
		System.out.println("1.Sedan 2.Van");
		int carIntType = readInt();
		carIntType = (int) checkOption(carIntType,1,3);
		String carType = "";
		switch (carIntType) {
			case 1:
				carType = "Sedan";
				break;
			case 2:
				carType = "Van";
				break;
		}

		System.out.println(ASTERISK);
		System.out.println("Enter the car number of doors");
		int noDoors = readInt();

		System.out.println(ASTERISK);
		System.out.println("Enter the car polarized state:");
		System.out.println("type: - true - if polarized");
		System.out.println("type: - false - if not polarized");
		boolean polarized = readBoolean();

		System.out.println(ASTERISK);
		System.out.println("Enter the car tank capacity:");
		double tankCapacity = readDouble();

		System.out.println(ASTERISK);
		System.out.println("Enter the car gas type");
		System.out.println("1.Premium 2.Regular 3.Diesel");
		int gasIntType = readInt();
		gasIntType = (int) checkOption(gasIntType,1,3);
		String gasType = "";
		switch (gasIntType) {
			case 1:
				gasType = "Premium";
				break;
			case 2:
				gasType = "Regular";
				break;
			case 3:
				gasType = "Diesel";
		}

		System.out.println("Enter the car fast charging state:");
		System.out.println("type: - true - if it has fast charging");
		System.out.println("type: - false - if it doesnt have fast charging");
		boolean fastCharger = readBoolean();

		System.out.println(ASTERISK);
		System.out.println("Enter the car battery life:");
		double batteryLife = readDouble();

		HybridCar newHybridCar = new HybridCar(basePrice, brand, model, displacement, mileage, used, plate,
										carType,noDoors, polarized, 
										tankCapacity, gasType, fastCharger, batteryLife);

		if (carGoesToParkinglot(newHybridCar)) {
			System.out.println(ASTERISK);
			System.out.println(dealer.addCarToParkingLot(newHybridCar));
		}

		vehicleDocumentsList(newHybridCar);

		return newHybridCar;
	}

/*
	**************************************************option register Client*********************************************************
*/
	/**
		*Name: runOptionRegisterClient.
		*ask if the user wants to create a new client, and then runs the selected option
	*/
	public void runOptionregisterClient(){
		int option = 0;
		do{
			System.out.println(ASTERISK);
			System.out.println("Register options:");
			System.out.println("1.Register Client 0. Exit");
			option = readInt();
			switch (option) {
				case 1:
					registerClient();
					break;
				case 0:
					System.out.println(ASTERISK);
					System.out.println("Operation completed.");
					break;
				default:
					System.out.println(ASTERISK);
					System.out.println("Invalid option.");
			}
		}while(option != 0);
	}

	/**
		*Name: getNewHybridCar.
		*displays all the sellers and show wich are available, ask to select a seller to be in charge of the client and then call a method to create a client
		*@return newElecCar.
	*/
	public void registerClient(){
		int unavalibleSellers = 0;
		System.out.println(ASTERISK);
		System.out.println("Select a seller to be in charge of the client: ");
		for (int i = 0; i < dealer.getSellers().length; i++) {
			if (dealer.getSellers()[i].getNumberOfClients() != 5) {
				System.out.println((i+1)+"."+dealer.getSellers()[i].getName()+". in charge of: "+dealer.getSellers()[i].getNumberOfClients()+" clients");	
			}else{
				System.out.println("Unavailable"+"."+dealer.getSellers()[i].getName()+". in charge of: "+dealer.getSellers()[i].getNumberOfClients()+" clients");
				unavalibleSellers += 1;
			}
		}

		if (unavalibleSellers == 10) {
			System.out.println(ASTERISK);
			System.out.println("Sorry, there is not any available seller at the moment.");
		}else{
			int option = readInt();
			option = (int) checkOption(option,1,dealer.getSellers().length);
			if (dealer.getSellers()[option-1].getNumberOfClients() == 5) {
				System.out.println(ASTERISK);
				System.out.println("Seller Unavailable. Pelase select an other one.");

			}else{
				Client client = newClient(dealer.getSellers()[option-1]);
				dealer.getSellers()[option-1].addClient(client);
				dealer.getClients().add(client);
				System.out.println(ASTERISK);
				System.out.println("Client succesfully added.");
			}
			
		}
		
	}

	/**
		*Name: newClient.
		*ask for all the needed infomation to create a new client, creates this client, and returns it.
		*@param seller != null, the seller must have available space for a new client
		*@return client.
	*/
	public Client newClient(Seller seller){
		System.out.println(ASTERISK);
		System.out.println("Enter the clients name:");
		String name = in.nextLine();
		System.out.println("Enter the clients lastname: ");
		String lastname = in.nextLine();
		System.out.println("Enter de clients id:");
		String id = in.nextLine();
		System.out.println("Enter the clients phone number: ");
		String phoneNumber = in.nextLine();
		System.out.println("Enter the clients emal: ");
		String email = in.nextLine();
		Client client = new Client(name, lastname, id, seller, phoneNumber, email);
		return client;
	}
/*
	************************************************** sell vehicle *********************************************************
*/
	/**
		*Name: runOptionSellVehicle.
		*displays all the vehicles owned by the dealer, lets the user selec one of them,
		*and then lets the user add a discount to the sell of this vehicle,
		*lets the user select a cliet, and then sells the selected vehicle to the selected client, with the selected discunt 
	*/
	public void runOptionSellVehicle(){
		System.out.println(ASTERISK);
		System.out.println("Select a vehicle to sell");
		System.out.println("- type the given index number to select a vehicle.");
		int c = 0;
		for (int i = 0; i < dealer.getVehicles().size(); i++ ) {
			if (!dealer.getVehicles().get(i).getSelled()) {
				System.out.println("**** index: "+(i+1)+" *****");		
				System.out.println("-Brand: "+dealer.getVehicles().get(i).getBrand());	
				System.out.println("-Model: "+dealer.getVehicles().get(i).getModel());	
				System.out.println("-Total sale price: "+dealer.getVehicles().get(i).getTotalSalePrice());	
				c += 1;		
			}			
		}

		if (c == 0) {
			System.out.println(ASTERISK);
			System.out.println("No available vehicles to sell");
			pressEnterToContinue();
		}else{
			int option = readInt();
			option = (int)checkOption(option, 1, dealer.getVehicles().size());
			if (dealer.getVehicles().get(option-1).getSelled()) {
			System.out.println(ASTERISK);
			System.out.println("No available vehicles with the selected index, please select one of the shown.");
			}else{
				System.out.println(ASTERISK);
				System.out.println("Enter the discount you whish to make to this sell.");
				System.out.println("-Enter the percentage of discount(0 for no discount, 100 sell for free)");
				double discount = readDouble();
				if (!dealer.getVehicles().get(option-1).getUsed()) {
					System.out.println(ASTERISK);
					System.out.println("Enter the vehicles new plate.");
					String plate = in.nextLine();
					dealer.getVehicles().get(option-1).setPlate(plate);
				}
				Client buyer = selectClient();
				dealer.sellVehicle(buyer,dealer.getVehicles().get(option-1),discount);
				selledInfo(buyer,dealer.getVehicles().get(option-1));
			}	
		} 

		
	}

	/**
		*Name: selledInfo.
		*Displays the confirmation of a sell, showing the buyer and the vehicle bougth
		*@param client != null.
		*@param vehicle != null. must have a valid plate. must be already selled.
	*/
	public void selledInfo(Client client, Vehicle vehicle){
		System.out.println(ASTERISK);
		System.out.println("The client "+client.getName()+" ID: "+client.getId());
		System.out.println("has bought the vehicle "+vehicle.getBrand()+" plate:"+vehicle.getPlate());
	}

/*
	************************************************** vehicle catalog *********************************************************
*/
	/**
		*Name: runOptionVehicleCatalog.
		*lets the user select a especific category to display a certain type of vehicle, then shows all the vehicles that are in that category.
	*/
	public void runOptionVehicleCatalog(){
		int option = 0;
		do{
			System.out.println(ASTERISK);
			System.out.println("Select a category to search a vehicle");
			System.out.println("1.All");
			System.out.println("2.motorcycle");
			System.out.println("3.Gas cars");
			System.out.println("4.Electric Cars");
			System.out.println("5.Hybrid");	
			System.out.println("0.Exit");
			option = readInt();
			switch (option) {
				case 1:
					System.out.println(ASTERISK);
					showVehicles();
					pressEnterToContinue();
					break;
				case 2:
					System.out.println(ASTERISK);
					showMotorcycles();
					pressEnterToContinue();
					break;
				case 3:
					System.out.println(ASTERISK);
					showgasCars();
					pressEnterToContinue();
					break;
				case 4:
					System.out.println(ASTERISK);
					showElectricCars();
					pressEnterToContinue();
					break;
				case 5:
					System.out.println(ASTERISK);
					showHybridCars();
					pressEnterToContinue();
					break;
				case 0:
					System.out.println(ASTERISK);
					System.out.println("Operation completed.");
					break;
				default:
					System.out.println(ASTERISK);
					System.out.println("Invalid option.");
			}

		}while(option != 0);
		
	}

	/**
		*Name: showUsedVehicles.
		*displays a message to select if show used/new vehicles or both.
		*then reads the option, and returns it.
		*@return option
	*/
	public int showUsedVehicles(){
		System.out.println(ASTERISK);
		System.out.println("show:");
		System.out.println("1.Only used 2.Only new 3.Both");
		int option = readInt();
		option = (int) checkOption(option,1,3);
		return option;
	}

	/**
		*Name: showVehicles.
		*displays all the vehicles of the dealer.
	*/
	public void showVehicles(){
		for (Vehicle vehicle : dealer.getVehicles() ) {
			System.out.println(ASTERISK);
			System.out.println(vehicle.vehicleInfo());
		}
	}

	/**
		*Name: showMotorcycles.
		*displays motorcycles that are on the dealers list, that have a specific caracteristic used/new or both.
	*/
	public void showMotorcycles(){
		switch (showUsedVehicles()) {
			case 1:
				for (Vehicle vehicle : dealer.getVehicles() ) {
					if(vehicle.getUsed() && vehicle instanceof Motorcycle){
						System.out.println(ASTERISK);
						System.out.println(vehicle.vehicleInfo());
					}
					
				}
				break;
			case 2:
				for (Vehicle vehicle : dealer.getVehicles() ) {
					if(!vehicle.getUsed() && vehicle instanceof Motorcycle){
						System.out.println(ASTERISK);
						System.out.println(vehicle.vehicleInfo());
					}
					
				}
				break;
			case 3:
				for (Vehicle vehicle : dealer.getVehicles() ) {
					if(vehicle instanceof Motorcycle){
						System.out.println(ASTERISK);
						System.out.println(vehicle.vehicleInfo());
					}
					
				}
				break;
		}
		
	}

	/**
		*Name: showGasCars.
		*displays gas cars that are on the dealers list, that have a specific caracteristic used/new or both.
	*/
	public void showgasCars(){
		switch (showUsedVehicles()) {
			case 1:
				for (Vehicle vehicle : dealer.getVehicles() ) {
					if(vehicle.getUsed() && vehicle instanceof GasCar){
						System.out.println(ASTERISK);
						System.out.println(vehicle.vehicleInfo());
					}
					
				}
				break;
			case 2:
				for (Vehicle vehicle : dealer.getVehicles() ) {
					if(!vehicle.getUsed() && vehicle instanceof GasCar){
						System.out.println(ASTERISK);
						System.out.println(vehicle.vehicleInfo());
					}
					
				}
				break;
			case 3:
				for (Vehicle vehicle : dealer.getVehicles() ) {
					if(vehicle instanceof GasCar){
						System.out.println(ASTERISK);
						System.out.println(vehicle.vehicleInfo());
					}
					
				}
				break;
		}
	}

	/**
		*Name: showElectricCars.
		*displays Electric cars that are on the dealers list, that have a specific caracteristic used/new or both.
	*/
	public void showElectricCars(){
		switch (showUsedVehicles()) {
			case 1:
				for (Vehicle vehicle : dealer.getVehicles() ) {
					if(vehicle.getUsed() && vehicle instanceof ElectricCar){
						System.out.println(ASTERISK);
						System.out.println(vehicle.vehicleInfo());
					}
					
				}
				break;
			case 2:
				for (Vehicle vehicle : dealer.getVehicles() ) {
					if(!vehicle.getUsed() && vehicle instanceof ElectricCar){
						System.out.println(ASTERISK);
						System.out.println(vehicle.vehicleInfo());
					}
					
				}
				break;
			case 3:
				for (Vehicle vehicle : dealer.getVehicles() ) {
					if(vehicle instanceof ElectricCar){
						System.out.println(ASTERISK);
						System.out.println(vehicle.vehicleInfo());
					}
					
				}
				break;
		}
	}

	/**
		*Name: showHybridCars.
		*displays hybrid cars that are on the dealers list, that have a specific caracteristic used/new or both.
	*/
	public void showHybridCars(){
		switch (showUsedVehicles()) {
			case 1:
				for (Vehicle vehicle : dealer.getVehicles() ) {
					if(vehicle.getUsed() && vehicle instanceof HybridCar){
						System.out.println(ASTERISK);
						System.out.println(vehicle.vehicleInfo());
					}
					
				}
				break;
			case 2:
				for (Vehicle vehicle : dealer.getVehicles() ) {
					if(!vehicle.getUsed() && vehicle instanceof HybridCar){
						System.out.println(ASTERISK);
						System.out.println(vehicle.vehicleInfo());
					}
					
				}
				break;
			case 3:
				for (Vehicle vehicle : dealer.getVehicles() ) {
					if(vehicle instanceof HybridCar){
						System.out.println(ASTERISK);
						System.out.println(vehicle.vehicleInfo());
					}
					
				}
				break;
		}
	}

/*
	**************************************************Client WishList*********************************************************
*/
	/**
		*Name: runOptionClientWishList.
		*lests the user select a client and then shows an option to either, add a vehicle to the wish list, or to display all the vehicles in the wishlist
	*/
	public void runOptionClientWishList(){
		int option = 0;
		Client client = selectClient();
		do{ 
			System.out.println(ASTERISK);
			System.out.println("Select an option:");
			System.out.println("1.Add vehicle to wish list 2.Report of wish list 0.Exit");
			option = readInt();
			switch(option){
				case 1:
					addVehicleToWishList(client);
					break;
				case 2:
					showReportOfClientWishList(client);
					break;
				case 0:
					System.out.println(ASTERISK);
					System.out.println("Operation completed.");
					break;
				default:
					System.out.println(ASTERISK);
					System.out.println("Invalid option.");

			}
		}while(option != 0);
		
	}

	/**
		*Name: addVehicleToWishList.
		*displays all the vehicles, and lets the user select a vehicle to add to the given clients wish list, then andds the selected vehicle to the client wish list.
		*@param client != null.
	*/
	public void addVehicleToWishList(Client client){
		System.out.println(ASTERISK);
		int c = 0;
		for (int i = 0; i < dealer.getVehicles().size(); i++ ) {
			if (!dealer.getVehicles().get(i).getSelled() && ! client.getInterestedVehicles().contains(dealer.getVehicles().get(i))) {
				System.out.println("**** index: "+(i+1)+" *****");		
				System.out.println("-Brand: "+dealer.getVehicles().get(i).getBrand());	
				System.out.println("-Model: "+dealer.getVehicles().get(i).getModel());	
				System.out.println("-Total sale price: "+dealer.getVehicles().get(i).getTotalSalePrice());	
				c += 1;		
			}			
		}

		if (c == 0) {
			System.out.println(ASTERISK);
			System.out.println("No available vehicles to add to the wish list");
			System.out.println("Take in to account that the vehicles that are allready in your wish list will not be displayed");
			pressEnterToContinue();
		}else{
			int option = readInt();
			option = (int)checkOption(option, 1, dealer.getVehicles().size());
			if (dealer.getVehicles().get(option-1).getSelled()) {
			System.out.println(ASTERISK);
			System.out.println("No available vehicles with the selected index, please select one of the shown.");
			}else{
				client.getInterestedVehicles().add(dealer.getVehicles().get(option-1));
				System.out.println("Vehicle succesfully added to the wish list");
			}	
		} 

	}

	/**
		*Name: showReportOfClientWishList.
		*displays all the vehicles in the clients wish list.
		*@param client != null. the client wishLis must have al least one vehicle
	*/
	public void showReportOfClientWishList(Client client){
		for (Vehicle vehicle : client.getInterestedVehicles() ) {
			System.out.println(ASTERISK);
			System.out.println(vehicle.vehicleInfo());
		}
		pressEnterToContinue();
	}
/*
	**************************************************parking lot*********************************************************
*/
	/**
		*Name: runOptionClientOwnedVehicles.
		*displays all the clients and lets the user select one of then to show all the owned vehicles of that client.
	*/
	public void runOptionClientOwnedVehicles(){
		int option = 0;
		do{
			System.out.println(ASTERISK);
			System.out.println("1.Select a client 0.Exit");
			option = readInt();
			switch (option) {
				case 1:
					Client client = selectClient();
			
					if (client.getOwnedVehicles().get(0) != null) {
						for (Vehicle vehicle : client.getOwnedVehicles() ) {
							System.out.println(ASTERISK);
							System.out.println(vehicle.vehicleInfo());
						}	
						pressEnterToContinue();
					}else{
						System.out.println(ASTERISK);
						System.out.println("The selected client hasnt buy any vehicles.");
					}
					break;
				case 0:
					System.out.println(ASTERISK);
					System.out.println("Operation completed.");
					break;
				default:
					System.out.println(ASTERISK);
					System.out.println("Invalid option.");
			}
			
		}while(option != 0);
		
		
	}
/*
	**************************************************parking lot*********************************************************
*/
	/*
		*Name: runOptionParkingLot.
		*displays all the vehicles in the parking lot.
	*/
	public void runOptionParkingLot(){
		int cent = 0;
		for (Car[] arrayCars : dealer.getParkingLot() ) {
			for ( Car car : arrayCars ) {
				if (car != null) {
					System.out.println(ASTERISK);
					car.vehicleInfo();	
				}else{
					cent += 1;
				}
			}
		}

		if (cent == dealer.getParkingLot().length * dealer.getParkingLot()[0].length) {
			System.out.println(ASTERISK);
			System.out.println("The parking lot is currently empty");
			pressEnterToContinue();
		}
	}
/*
	**************************************************Start Porgram*********************************************************
*/

	/**
		*Name: startProgram.
		*shows a wellcome message, then shows the principal menu, reads the option selected, and runs that option,
		*repeats until the user selects exit in the pricipal menu
	*/
	public void startProgram() {
		showWellcome();
		int option;
		do{
			showPrincipalMenu();
			option = readInt();
			runOption(option);
		}while(option != EXIT);
	}

}