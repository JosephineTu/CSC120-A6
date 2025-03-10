public class Passenger{
    /**
     * Attributes
     */
    public String name;
    /**
     * Constructor
     * @param name
     */
     public Passenger(String name) {
        this.name = name;
    }
    /**
     * 
     * @param c
     * @throws ArrayIndexOutOfBoundsException
     */
    
    public void tryBoard(Car c) throws ArrayIndexOutOfBoundsException{
        if (!c.addPassenger(this)){
            throw new ArrayIndexOutOfBoundsException("Error: Car is full.");
        }
    }
    /**
     * boardCar
     * @param Car c
     * @return none
     */
    public void boardCar(Car c){
        try {
            this.tryBoard(c);
        }
        catch (ArrayIndexOutOfBoundsException e){
            throw e;
        }
        }
    public void tryGetOff(Car c) throws NullPointerException{
        if (!c.removePassenger(this)){
            throw new NullPointerException("Error: passenger not on board.");
        }
    }
    /**
     * getOffCar
     * @param Car c
     * @return none
     */
    public void getOffCar(Car c) {
        try {
            this.tryGetOff(c);
        } catch (NullPointerException e) {
            throw e;
        }
    }
}
