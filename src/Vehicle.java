public interface Vehicle {
    public default void changeGear(boolean gearUp){
        if (gearUp){
            System.out.println("Gear is changed to next gear!");
        }
        else {
            System.out.println("Gear is changed to previous gear!");
        }

    }

    public default void speedUp(double increment){
        System.out.println("Speed increased by "+increment);
    }

    public default void applyBrakes(double intensity){
        System.out.println("Speed decresed by "+(intensity * 100)+" %");
    }

    public default int[] speedLimit(int gear){
        int[] speedLimits = {0,0};
        switch (gear){
            case -1:
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

    void controlUnit();
}
