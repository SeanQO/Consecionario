package model;
import java.util.*;
public class Dealer{
	private final static int NO_SELLERS = 10;
	private final static int PARQUING_ROWS = 10;
	private final static int PARQUING_COLUMS = 5;
	private String name;
	private String nit;
	private double totalEarnings;
	private int noSells;
	private Seller[] sellers;
	private ArrayList<Client> clients;
	private Car[][] parkingLot;
	private ArrayList<Vehicle> vehicles;

	/**
		*Name:Dealer
		*Dealer class constructor.
		*@param name != "".
		*@param nit != "".
		*@param totalEarnings >= 0
		*@param noSells >= 0
	*/
	public Dealer(String name, String nit, double totalEarnings, int noSells) {
		this.name = name;
		this.nit = nit;
		sellers = new Seller[NO_SELLERS];
		parkingLot = new Car[PARQUING_ROWS][PARQUING_COLUMS];
		this.totalEarnings = totalEarnings;
		this.noSells = noSells;		
		vehicles = new ArrayList<Vehicle>();
		clients = new ArrayList<Client>();
		createSellers();
		createClients();
		createVehicles();
	}

	/**
		*Name:createSellers
		*sellers init, initialize all the current dealer sellers
	*/	
	public void createSellers(){
		Seller sOne = new Seller("Nicolas","Garcia","1005368645",0 );
		sellers[0] = sOne;
		Seller sTwo = new Seller("Pedro","Moronta", "1005368645",0 );
		sellers[1] = sTwo;
		Seller sTree = new Seller("David","Perez", "1005368645",0 );
		sellers[2] = sTree;
		Seller sFour = new Seller("Cristian","Tamayo", "1005368645",0 );
		sellers[3] = sFour;
		Seller sFive = new Seller("Sebastian","Salcedo", "1005368645",0 );
		sellers[4] = sFive;
		Seller sSix = new Seller("Juan david","Calle", "1005368645",0 );
		sellers[5] = sSix;
		Seller sSeven = new Seller("Ivan","Marin", "1005368645",0 );
		sellers[6] = sSeven;
		Seller sEight = new Seller("Mariana","Sanchez", "1005368645",0 );
		sellers[7] = sEight;
		Seller sNine = new Seller("Gabriela","Casas", "1005368645",0 );
		sellers[8] = sNine;
		Seller sTen = new Seller("Antonio","Garcia", "1005368645",0 );
		sellers[9] = sTen;
	}

	/**
		*Name:createClients
		*CLients init, initialize all the current dealer Clients
	*/	
	public void createClients(){
		//selerOne
		Client cOne = new Client("Jaime","Quintero","1225978462",sellers[0], "3172458678", "jaimequin432@gmail.com" );
		Client cTwo = new Client("Andrea","Gonzales","1224597862",sellers[0], "3167885425", "andreagon45@gmail.com" );
		Client cTree = new Client("ruth","Ramos", "4551236978", sellers[0],"315426978", "ruthra345@gmail.com" );
		sellers[0].addClient(cOne);
		sellers[0].addClient(cTwo);
		sellers[0].addClient(cTree);
		clients.add(cOne);
		clients.add(cTwo);
		clients.add(cTree);
		//selerTwo
		//selertree
		Client cSix = new Client("Ana","Restrepo", "1445236978",sellers[2], "3164557892", "anare34@gmail.com" );
		sellers[2].addClient(cSix);
		clients.add(cSix);
		//selerFour
		Client cSeven = new Client("Camila","Gutierrez", "1224597862",sellers[3], "3154789654", "cagu25@gmail.com" );
		Client cEight = new Client("Teffa","Marin", "1445978625",sellers[3], "300124897", "tefama06@gmail.com" );
		Client cNine = new Client("Juan","Ortiz", "1234578451",sellers[3], "3174526984", "juor13@gmail.com" );
		Client cTen = new Client("Catalina","Velez", "12245879",sellers[3], "3164521458", "catave12@gmail.com" );		
		sellers[3].addClient(cSeven);
		sellers[3].addClient(cEight);
		sellers[3].addClient(cNine);
		sellers[3].addClient(cTen);
		clients.add(cSeven);
		clients.add(cEight);
		clients.add(cNine);
		clients.add(cTen);
		//selerFive
		//selerSix
		//selerSeven
		Client cThirteen = new Client("Tarantini","Wind", "1226457895",sellers[6], "3167845216", "taranwi56@gmail.com" );
		Client cFourteen = new Client("Giulliana","Restrepo", "32214578749",sellers[6], "3164524789", "marire31@gmail.com" );
		Client cFifteen = new Client("Julian","Ortiz", "1224589756",sellers[6], "3002145697", "julor5@gmail.com" );
		Client cSixteen = new Client("Nicolas","Perez", "1456978125",sellers[6], "315468792", "nicop3@gmail.com" );		
		Client cSeventeen = new Client("Santiago","Gomez", "1245798632",sellers[6], "316148963", "tiagogo7@gmail.com" );		
		sellers[6].addClient(cThirteen);
		sellers[6].addClient(cFourteen);
		sellers[6].addClient(cFifteen);
		sellers[6].addClient(cSixteen);
		sellers[6].addClient(cSeventeen);
		clients.add(cThirteen);
		clients.add(cFourteen);
		clients.add(cFifteen);
		clients.add(cSixteen);
		clients.add(cSeventeen);
		//selerEight
		//sellerNine
		Client cNineTeen = new Client("Valentina","Soto", "4556987265",sellers[8], "3152478915", "vaso12@gmail.com" );
		Client cTwenty = new Client("Juana","Madriñan", "5336978524",sellers[8], "3154268521", "juma99@gmail.com" );		
		sellers[8].addClient(cNineTeen);
		sellers[8].addClient(cTwenty);
		clients.add(cNineTeen);	
		clients.add(cTwenty);	
		//sellerten
	}

	/**
		*Name:createVehicles
		*Vehicles init, initialize all the owned and selled dealers cars
	*/	
	public void createVehicles(){
		Car gc = new GasCar(71700000,"Mazda",2020,1998,0,false,"","sedan",4,false,50,"Premium");
		vehicles.add(gc); 

		Car hc = new HybridCar(96800000,"Kia",2019,1580,22000,true,"DRF-642","Van",4,false,62,"Diesel",false,9);
		vehicles.add(hc);
		sellVehicle(getClients().get(3),hc,12);

		Vehicle m = new Motorcycle(11000000,"Yamaha",2020,250,0,false,"","regular",7.5,"Standart");
		vehicles.add(m);
		getClients().get(5).getInterestedVehicles().add(m);
		getClients().get(6).getInterestedVehicles().add(m);
		getClients().get(7).getInterestedVehicles().add(m);
		
		Vehicle mscoo = new Motorcycle(4000000,"AKT",2020,125,0,true,"ADF-525","regular",15,"scooter");
		vehicles.add(mscoo);
		sellVehicle(getClients().get(8),mscoo,5);
		
		Vehicle mcroo = new Motorcycle(12500000,"kawasaki",2018,261,25000,true,"GRH-196","regular",18,"cross");
		vehicles.add(mcroo);
		getClients().get(9).getInterestedVehicles().add(mcroo);
		
		Car gcvan = new GasCar(220000000,"Mercedes",2020,3700,0,false,"","Van",4,true,70,"Premium");
		vehicles.add(gcvan);
		getClients().get(12).getInterestedVehicles().add(gcvan);
		
		Car ec = new ElectricCar(150000000,"audi",2014,2500,32000,true,"AKL-554","Sedan",2,false,true,16);
		vehicles.add(ec);
		sellVehicle(getClients().get(14),ec,8);
		
	}

	/**
		*Name:getName
		*returns the name of the dealer.
		*@return name.
	*/	
	public String getName() {
		return name;
	}

	/**
		*Name:getNit
		*returns the nit of the dealer.
		*@return nit.
	*/	
	public int getNit() {
		return nit;
	}

	/**
		*Name:getTotalEarnings
		*returns the Total Earnings of the dealer.
		*@return totalEarnings.
	*/	
	public double getTotalEarnings() {
		return totalEarnings;
	}

	/**
		*Name:SetTotalEarnings
		*recives and sets the total earned by the dealer 
		*@param totalEarnings must be in between one and MAX_VALUE. totalEarnings > 0 && totalEarnings <= MAX_VALUE.
	*/
	public void SetTotalEarnings(double totalEarnings) {
		this.totalEarnings = totalEarnings;
	}	

	/**
		*Name:getNoSells
		*returns the Total number of sells of the dealer.
		*@return totalEarnings.
	*/	
	public int getNoSells() {
		return noSells;
	}

	/**
		*Name:setNoSells
		*recives and sets the total number of sells the dealer has made
		*@param totalEarnings must be in between one and MAX_VALUE. totalEarnings > 0 && totalEarnings <= MAX_VALUE.
	*/
	public void SetNoSells(int noSells) {
		this.noSells = noSells;
	}	

	/**
		*Name:getVehicles
		*returns all the vehicles owned by the dealer.
		*@return vehicles.
	*/	
	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}

	/**
		*Name:getSellers
		*returns all the current sellers.
		*@return sellers.
	*/	
	public Seller[] getSellers(){
		return sellers;
	}

	/**
		*Name:getClients
		*returns a list of all the current clients.
		*@return clients.
	*/	
	public ArrayList<Client> getClients(){
		return clients;
	}

	/**
		*Name:getParquingLot
		*returns all the vehicles placed in the parking lot.
		*@return vehicles.
	*/	
	public Car[][] getParkingLot(){
		return parkingLot;
	}

	/**
		*Name:addCarToParkingLot
		*adds a car to the parking lot if there is available place, if not sends a warnign message.
		*@param car != null
		*@return message that displays if the car was added or not.
	*/	
	public String addCarToParkingLot(Car car){
		int model = car.getModel(), cent = 0;
		boolean full = false;
		if (model == 2014) {
			for (int i = 0; i < parkingLot.length ; i++ ) {
				if(parkingLot[i][0] == null){
					parkingLot[i][0] = car;
				}else{
					cent += 1;
				}	
			}

		}else if (model == 2013) {
			for (int i = 0; i < parkingLot.length ; i++ ) {
				if(parkingLot[i][2] == null){
					parkingLot[i][2] = car;
				}else{
					cent += 1;
				}	
			}

		}else if (model == 2012) {
			for (int i = 0; i < parkingLot.length ; i++ ) {
				if(parkingLot[i][3] == null){
					parkingLot[i][3] = car;
				}else{
					cent += 1;
				}	
			}

		}else{
			for (int i = 0; i < parkingLot.length ; i++ ) {
				for (int j = 4; i < parkingLot[0].length ; j++ ) {
					if(parkingLot[i][j] == null){
						parkingLot[i][j] = car;
					}else{
						cent += 1;
					}	
				}
				
			}

		}

		if (cent == (parkingLot.length * parkingLot[0].length)) {
			return "the Vehicle could not be entered to the parking lot."+
					"\nThe parking lot row for "+ model +" model cars is full, extention required. ";

		}else{
			return "Vehicle succesfully added to the parking lot.";
		}

		

	}

	/**
		*Name:sellVehicle
		*sells a vehicle to a client taking in account the given giscount by the user.
		*@param client != null
		*@param discount discount >= 0.
		*@param vehicle != null
	*/	
	public void sellVehicle(Client client, Vehicle vehicle, double discount){
		vehicle.setSelled(true);
		client.getOwnedVehicles().add(vehicle);
		for (Vehicle interestedVehicle : client.getInterestedVehicles() ) {
			if (vehicle.equals(interestedVehicle)) {
				client.getInterestedVehicles().remove(interestedVehicle);
			}
		}
		client.getSellerInCharge().addSell();
		discount = 1.0-(discount/100.0);
		totalEarnings += vehicle.getTotalSalePrice() * discount;

		for (int i = 0 ; i < PARQUING_ROWS; i++ ) {
			for (int j = 0; j < PARQUING_COLUMS; j++ ) {
				if (vehicle.equals(parkingLot[i][j])) {
					parkingLot[i][j] = null;
				}
			}
		}

		Random ran = new Random();
		int soat = 0, tmr = 0;
		if (vehicle.getUsed()) {
			for (Document document : vehicle.getDocuments() ) {
				if (document.getYear() == 2020) {
					if (document instanceof Soat) {
						soat += 1;
					}
					if (document instanceof TMReview) {
						tmr += 1;
					}
				}
			}
			if (soat != 1) {
				int accidentTotalMount = ran.nextInt(2) == 0 
				? ran.nextInt(5000000)+100000
				: 0;
				vehicle.getDocuments().add(new Soat(450000,2020,accidentTotalMount));
			}
			
			if (tmr != 1) {
				vehicle.getDocuments().add(new TMReview(200000,2020,ran.nextInt(150)+50));	
			}

		}else{
			vehicle.getDocuments().add(new Soat(450000,2020,0));
			vehicle.getDocuments().add(new TMReview(200000,2020,ran.nextInt(150)+50));
		}
		

		
		

	}

}