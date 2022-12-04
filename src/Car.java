import java.util.Scanner;

public class Car implements Vehicle{
    private int maxSpeed;
    private int totalGears;
    private int currentSpeed;
    private int currentGear;
    private String manufacturer;
    private String model;

    public Car(int maxSpeed, int totalGears, String manufacturer, String model) {
        this.maxSpeed = maxSpeed;
        this.totalGears = totalGears;
        this.manufacturer = manufacturer;
        this.model = model;
        currentGear = 0;
        currentSpeed = 0;
    }

    @Override
    public void changeGear(boolean gearUp) {
        //excluding reverse gear
        int gears = totalGears-1;
        if (gearUp){
            if (currentGear+1 > gears){
                System.out.println("Car is on top gear!");
            }
            else {
                currentGear++;
                Vehicle.super.changeGear(gearUp);
            }
        }
        else {
            if (currentGear-1 < -1){
                System.out.println("Car is in reverse!");
            }
            else {
                currentGear--;
                Vehicle.super.changeGear(gearUp);
            }
        }

    }

    public int[] speedLimit(int gear){
        int[] speedLimits = {0,0};
        switch (gear){
            case 0:
                System.out.println("Current Speed Limit is : 0 <-> -10");
                speedLimits[0] = 0;
                speedLimits[1] = -10;
                break;
            case 1:
                System.out.println("Current Speed Limit is : 0 <-> 25");
                speedLimits[0] = 0;
                speedLimits[1] = 25;
                break;
            case 2:
                System.out.println("Current Speed Limit is : 25 <-> 55");
                speedLimits[0] = 25;
                speedLimits[1] = 55;
                break;
            case 3:
                System.out.println("Current Speed Limit is : 55 <-> 83");
                speedLimits[0] = 55;
                speedLimits[1] = 83;
                break;
            case 4:
                System.out.println("Current Speed Limit is : 83 <-> 95");
                speedLimits[0] = 83;
                speedLimits[1] = 95;
                break;
            case 5:
                System.out.println("Current Speed Limit is : 95 <-> 110");
                speedLimits[0] = 95;
                speedLimits[1] = 110;
                break;
        }
        return speedLimits;
    }

    public void speedUp(double increment){
        int[] speedLimits = speedLimit(currentGear);
        if (speedLimits[0] <= currentSpeed+increment){
            if (speedLimits[1] >= currentSpeed+increment){
                currentSpeed += increment;
            }
            else {
                changeGear(true);
                currentSpeed += increment;

            }
        }
        System.out.println("Current speed is : "+currentSpeed);
        System.out.println("Current Gear is : "+currentGear);
    }

    @Override
    public void applyBrakes(double intensity) {
        currentSpeed -= currentSpeed*intensity;
        int[] speedLimits = speedLimit(currentGear);
        if (!(speedLimits[0] <= currentSpeed)){
            changeGear(false);
        }
        System.out.println("Current speed is : "+currentSpeed);
        System.out.println("Current Gear is : "+currentGear);
    }

    public void controlUnit(){
        System.out.println("Welcome to "+manufacturer+" "+model);
        System.out.println("Total Gears : "+totalGears+" and Max speed : " + maxSpeed);
        int input = -1;
        double temp;
        Scanner sc = new Scanner(System.in);
        while (input != 0){
            System.out.println("1. Accelerate");
            System.out.println("2. Break");
            System.out.println("3. Change Gear");
            input = sc.nextInt();
            switch (input){
                case 1:
                    System.out.println("Enter the value by which speed should be increased : ");
                    temp = sc.nextDouble();
                    speedUp(temp);
                    break;
                case 2:
                    System.out.println("Enter the intensity (0.0 to 1.0) by which speed should be decreased : ");
                    temp = sc.nextDouble();
                    applyBrakes(temp);
                    break;
                case 3:
                    System.out.println("Enter the 1 to increment the gear, 0 to decrement : ");
                    temp = sc.nextDouble();
                    if (temp == 0){
                        changeGear(false);
                    }
                    else {
                        changeGear(true);
                    }
                    break;
            }
        }
    }
}
