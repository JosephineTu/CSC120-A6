public class Engine{
    /**
     * Attributes
     */
    private FuelType f;
    private double currentFuelLevel;
    private double maxFuelLevel;
    /**
     * Constructor
     * @param f,currentFuelLevel,maxFuelLevel
     */
    Engine(FuelType f, double currentFuelLevel, double maxFuelLevel){
        this.f=f;
        this.currentFuelLevel=currentFuelLevel;
        this.maxFuelLevel=maxFuelLevel;
    }
    /**
     * Getter method getFuelType()
     * @return FuelType FuelType
     */
    public FuelType getFuelType(){
        return this.f;
    }
    /**
     * Getter method getMaxFuel()
     * @return double maxFuelLevel
     */
    public double getMaxFuel(){
        return this.maxFuelLevel;
    }
    /**
     * Getter getCurrentFuel()
     * @return double currentFuelLevel
     */
    public double getCurrentFuel(){
        return this.currentFuelLevel;
    }
    /**
     * refuel()
     * rewrite currentFuelLevel with the value of maxFuelLevel
     */
    public void refuel(){
        this.currentFuelLevel=this.maxFuelLevel;
    }
    /**
     * go()
     * subtract 10.0 from currentFuelLevel
     * @return Boolean whether need to refuel(false) or not(true)
     */
    public Boolean go(){  
        this.currentFuelLevel-=10.0;
        if(this.currentFuelLevel>0.0){
            System.out.println("Fuel remaining:"+this.currentFuelLevel);
            return true;
        }
        else{
            System.out.println("Not enough fuel. Please refuel.");
            return false;
        }
        
    
    }
    /**
     * toString() test method converting object attributes into println string
     */
    public String toString(){
        return ("Engine has fuel type"+this.f+"Max fuel level"+this.maxFuelLevel+"Current fuel level"+this.currentFuelLevel);
    }
    /**
     * main method
     * @param args
     */
    public static void main(String[] args){
        //create an Engine object
        Engine myEngine=new Engine(FuelType.ELECTRIC,0.0,1.0);
        String out=myEngine.toString();
        System.out.println(out);
    }
}