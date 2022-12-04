public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Car(180,6, "Maruti Suzuki", "S-Cross");
        vehicle.controlUnit();
        vehicle = new Bicycle(55,5,"Hero","Howler");
        vehicle.controlUnit();
        vehicle = new Bike(110,5,"Honda","SP125");
        vehicle.controlUnit();
    }
}