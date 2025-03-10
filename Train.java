import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class Train {
    /**
     * Attributes
     */
    private FuelType fuelType;
    private double fuelCapacity;
    private int nCars;
    private int passengerCapacity;
    private Engine engine;
    private ArrayList<Car> cars;
    public int manifestCallCount=0;
    /**
     * Constructor
     * @param fuelType
     * @param fuelCapacity
     * @param nCars
     * @param passengerCapacity
     */
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity){
        this.nCars=nCars;
        this.passengerCapacity=passengerCapacity;
        this.engine=new Engine(fuelType,fuelCapacity,fuelCapacity);
        this.cars=new ArrayList<Car>();
        //initialize all the cars in ArrayList
        for (int i=0;i<nCars;i++){
            ArrayList<Passenger> passengers=new ArrayList<Passenger>();
            Car c=new Car(passengers,passengerCapacity);
            this.cars.add(c);
        }
    }
    /**
     * Getter method getEngine()
     * @param none
     * @return engine type
     */
    public Engine getEngine(){
        return this.engine;
    }
    /**
     * Getter method getCar(int i)
     * @param int i, the index of the car
     * @return the Car object
     */
    public Car getCar(int i){
        Car car=this.cars.get(i);
        return car;
    }
    /**
     * getter method getMaxCapacity()
     * @return int max, the max number of passengers on all cars
     */
    public int getMaxCapacity(){
        int max=this.nCars * this.passengerCapacity;
        return max;
    }
    /**
     * getter method seatsRemaining()
     * @return int remain, total number of seats remaining on all cars
     */
    public int seatsRemaining(){
        int remain=0;
        for (int i=0;i<this.cars.size();i++){
            remain+=this.cars.get(i).seatsRemaining();
        }
        return remain;
    }
    /**
     * printManifest()
     * print all the passengers and car numbers
     */
    public void printManifest(){
        for (int i=1;i<this.nCars+1;i++){
            System.out.println("Car"+i+": ");
            this.manifestCallCount++;
            this.getCar(i-1).printManifest();
        } 
    }
    /**
     * boardTrain(Passenger p)
     * @param p, Passenger object
     */
    public void boardTrain(Passenger p){
        if (this.seatsRemaining()>0){
            // create scanner object to get user input
            Scanner input=new Scanner(System.in);
            Boolean onBoard=false;
            while(onBoard==false){
                // get user int input
                System.out.println("Which train do you want to board: ");
                int i=input.nextInt();
                // check if car full
                if (this.getCar(i-1).seatsRemaining()==0 || i>this.nCars){
                    System.out.println("The current choice is unavailable.");
                }
                else{
                    // call addPassenger method from Car class
                    this.cars.get(i-1).addPassenger(p);
                    onBoard=true;
                }
            }
            input.close();
        }
        else{
            System.out.println("Car currently full.");
        }
    }
    /**
     * getOffTrain(Passenger p)
     * @param p
     */
    public void getoffTrain(Passenger p){
        Boolean removed=false;
        int i=0;
        while (removed==false){ // iterate through cars to check from which the passenger need to be removed
            Car car=this.getCar(i);
            removed=car.removePassenger(p);
            i++;
        }
    }
    /**
     * main method
     * @param args
     */
    public static void main(String[] args){
        // create new train object
        Train myTrain=new Train(FuelType.ELECTRIC,50.0,3,2);
        Scanner inputStr1=new Scanner(System.in);
        // take passenger 1
        System.out.println("What is your name: ");
        String name1=inputStr1.nextLine();
        Passenger p1=new Passenger(name1);
        inputStr1.close();
        myTrain.boardTrain(p1);
        // take passenger 2
        Scanner inputStr2=new Scanner(System.in);
        System.out.println("What is your name: ");
        String name2=inputStr2.nextLine();
        Passenger p2=new Passenger(name2);
        inputStr2.close();
        myTrain.boardTrain(p2);
        // take passenger 3
        Scanner inputStr3=new Scanner(System.in);
        System.out.println("What is your name: ");
        String name3=inputStr3.nextLine();
        Passenger p3=new Passenger(name3);
        inputStr3.close();
        myTrain.boardTrain(p3);
        // print the current passengers on board, test if successfully added
        myTrain.printManifest();
        // randomly travels a distance int (0,7), test engine.refuel()
        Random rand=new Random();
        int stops=rand.nextInt(7);
        System.out.println(stops);
        for(int i=0;i<stops;i++){
            if(myTrain.engine.go()==true){
                myTrain.engine.go();
                System.out.println("Going...");
            }
            else{
                System.out.println("Refueling...");
                myTrain.engine.refuel();
                myTrain.engine.go();
                System.out.println("Going...");
            }
        }
        System.out.println("Here we are!");
        // test if passenger successfully removed 
        myTrain.getoffTrain(p1);
        myTrain.printManifest();
    }
}



