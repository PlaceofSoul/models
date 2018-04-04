package model;
/**
 * 
 * @author robson
 *
 */
public class Models {

	private String firstName;
	private String lastName;
	private int height;
	private double weight;
	private boolean canTravel;
	private boolean smoke;
	private static String occuapation = "modeling";
	public static final int INCHES_PER_FOOT = 12;
	public static final int BASE_RATE_DOLLARS_PER_HOUR = 60;
	public static final int TALL_INCHES = 67;
	public static final double THIN_POUNDS = 140.0;
	public static final int TALL_THIN_BONUS_DOLLARS_PER_HOUR = 5;
	public static final int TRAVEL_BONUS_DOLLARS_PER_HOUR = 4;
	public static final int SMOKER_DEDUCTION_DOLLARS_PER_HOUR = 10;
	
	public Models(){
		
	}
	
	/**
	 * Parameters used to make a profile of models
	 * @param firstName used as a rule to store the first name
	 * @param lastName used as a rule to store the last name	
	 * @param height used as a rule to verify if the model has a specific height
	 * @param weight used as a rule to verify if the model has a specific weight
	 * @param canTravel to determinate if the model is able to travel
	 * @param smoke to determinate if the model is a smoker
	 */
	public Models(String firstName, String lastName, int height, double weight, 
			boolean canTravel, boolean smoke){
		if (isValideName(firstName)){
			this.firstName = firstName;
		}
		if (isValideName(lastName)){
			this.lastName = lastName;
		}
		if (height>= 24 && height<= 84){
			this.height = height;
		}
		if(weight>= 80 && weight<= 280){
			this.weight = weight;
		}
		
		this.canTravel = canTravel;
		this.smoke = smoke;
		
	}
	public Models(String firstName, String lastName, int height, double weight){
		if (isValideName(firstName)){
			this.firstName = firstName;
		}
		if (isValideName(lastName)){
			this.lastName = lastName;
		}
		if (height>= 24 && height<= 84){
			this.height = height;
		}
		if(weight>= 80 && weight<= 280){
			this.weight = weight;
		}

		this.canTravel = true;
		this.smoke = false;
	}
	
	/**
	 * 
	 * @param name
	 * @return true valid false not
	 */
	private boolean isValideName(String name){
		if( name.length()>=3 && name.length()<=20){
			return true;
		}
		return false;
	}
	public final void setFirstName(String firstName){
		this.firstName = firstName;
	}
	public String getFirstName(){
		return firstName;
	}
	public final void setLastName(String lastName){
		this.lastName = lastName;
	}
	public String getLastName(){
		return lastName;
	}
	public final void setHeight(int height){
		this.height = height;
	}
	public int getHeight(){
		return height;
	}
	/**
	 * 
	 * @param weight
	 */
	public final void setWeight(double weight){
		this.weight = weight;
	}
	public double getWeight(){
		return weight;
	}
	/**
	 * 
	 * @param canTravel
	 */
	public final void setCanTravel(boolean canTravel){
		this.canTravel = canTravel;
	}
	public boolean getCanTravel(){
		return canTravel;
	}
	/**
	 * 
	 * @param smoke
	 */
	public final void setSmoke(boolean smoke){
		this.smoke = smoke;
	}
	public boolean getSmoke(){
		return smoke;
	}
	
	public void printDetails(){
		System.out.println("Name:" + getFirstName() + " "+ getLastName());
		System.out.println("Height:" + getHeight() + "Inches");
		System.out.println("Weight:" + Math.round(getWeight()) + "Pounds");
		
		if(canTravel){
			System.out.println("Does Travel");
		}else {
			System.out.println("Does not Travel");
		}
		if(smoke){
			System.out.println("Does smoke");
		}else{
			System.out.println("Does not smoke");
		}
		
	}
	public String getHeightInFeetAndInches(){
		int feet = height/INCHES_PER_FOOT;
		int inches = height%INCHES_PER_FOOT;
		String heightAndFeetAndInches = feet + "feet";
		if (inches != 0){
			if( inches == 1){
				heightAndFeetAndInches += inches + "inch";
			}else {
				heightAndFeetAndInches += inches + "inches";
			}
			
		}
		
		return heightAndFeetAndInches; 
	}
	public long getWeightKg(){
		long kg = (long) (weight/2.20);
		return kg;
	}
	public final void setWeight(long kilograms){
		double pounds = (weight*2.20);
		setWeight(pounds);
	}
	public final void setHeight(int feet, int inches){
		int heightInInches = ((feet*12) + inches);
		setHeight(heightInInches);
	}
	public int getHeightCm(){
		int heightInInches = Math.round(height*2.54f);
		return heightInInches;
	}
	public int calculatePayDollarsPerHours(){
		int payDay = BASE_RATE_DOLLARS_PER_HOUR;
		if(TALL_INCHES <= height && THIN_POUNDS >= weight){
			payDay += TALL_THIN_BONUS_DOLLARS_PER_HOUR;
		}
		if(canTravel){
			payDay += TRAVEL_BONUS_DOLLARS_PER_HOUR; 
		}
		if(smoke){
			payDay -= SMOKER_DEDUCTION_DOLLARS_PER_HOUR;
		}
		return payDay;
	}
	public void displayModelDetails(){
		System.out.println("Name:" + getFirstName() + " "+ getLastName());
		System.out.println("Height:" + getHeight() + "Inches");
		System.out.println("Weight:" + Math.round(getWeight()) + "Pounds");
		
		if(canTravel){
			System.out.println("Does Travel");
		}else {
			System.out.println("Does not Travel");
		}
		if(smoke){
			System.out.println("Does smoke");
		}else{
			System.out.println("Does not smoke");
		}
		
		System.out.println("$" + calculatePayDollarsPerHours());
		
	}
	public void	displayModelDetails(boolean metricUnits){
		if(!metricUnits){
			displayModelDetails();
		}
		System.out.println("Name:" + getFirstName() + " "+ getLastName());
		System.out.println("Height:" + getHeightCm() + "cm");
		System.out.println("Weight" + getWeightKg() + "Kg");
		
		if(canTravel){
			System.out.println("Does Travel");
		}else {
			System.out.println("Does not Travel");
		}
		if(smoke){
			System.out.println("Does smoke");
		}else{
			System.out.println("Does not smoke");
		}
		
		System.out.println("$" + calculatePayDollarsPerHours());
	}
	
}
