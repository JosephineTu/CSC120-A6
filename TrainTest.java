import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class TrainTest {


    private Train myTrain;
    /**
     * setUp()
     * @param none
     * @return none
     */
    @Before
    // Constructs a train before each test
    public void setUp(){
        myTrain=new Train(FuelType.STEAM,50.0,3,2);
    }
    // Engine Tests
    /**
     * testEngineConstructor()
     * @param none
     * @return none
     */
    @Test
    public void testEngineConstructor() {
        assertEquals(FuelType.STEAM,myTrain.getEngine().getFuelType());
        assertEquals(50.0,myTrain.getEngine().getCurrentFuel(),0.001);
        assertEquals(50.0, myTrain.getEngine().getMaxFuel(),0.001);
    }

    @Test
    public void testEngineGo() {
        // Test if the go returns a true value (only returns true when there is fuel left)
        Engine engine=myTrain.getEngine();
        assertTrue(engine.go());
    }

    // Car Tests
    @Test
    public void testCarAddPassenger() {
        Passenger p=new Passenger("A");
        assertTrue(myTrain.getCar(0).addPassenger(p));
    }

    @Test
    public void testCarRemovePassenger() {
        Passenger p=new Passenger("B");
        assertFalse(myTrain.getCar(0).removePassenger(p));
    }

    // Passenger Tests
    @Test
    public void testPassengerBoardCarWithSpace() {
        Car a=new Car(new ArrayList<Passenger>(),1);
        Passenger p=new Passenger("A");
        p.boardCar(a);
        assertEquals(1, a.passengersOnBoard.size());
        assertTrue(a.passengersOnBoard.contains(p));
    }

    @Test(expected=ArrayIndexOutOfBoundsException.class)
    // Test if an exception is thrown 
    public void testPassengerBoardCarFull() {
        Car a=new Car(new ArrayList<Passenger>(),0);
        Passenger p=new Passenger("A");
        p.boardCar(a);
    }

    // Train Tests
    @Test
    // Most of the train attributes are tested in engine. This makes sure that the train is constructed.
    public void testTrainConstructor() {
        assertNotNull(myTrain);
    }

    @Test
    public void testTrainPassengerCount() {
        int m=myTrain.getMaxCapacity();
        int r=myTrain.seatsRemaining();
        int c=m-r;
        assertSame(0,c);
    }

    @Test
    public void testTrainGetCar() {
        // Test if attributes of the Car object is same as expected.
        Car c=new Car(new ArrayList<Passenger>(),2);
        Car trainCar=myTrain.getCar(0);
        assertEquals(c.passengersOnBoard,trainCar.passengersOnBoard);
        assertEquals(c.getCapacity(),trainCar.getCapacity());
    }
    @Test
    public void testTrainPrintManifest() {
        myTrain.printManifest();
        // Creates a printManifest counter that counts the iteration in train.java, test if the number of iterations is correct.
        assertEquals(3,myTrain.manifestCallCount);
    }

}
