package telran.model;

import java.util.Random;

public class Tarakan  implements Runnable{
    private final String name;
    private int distance;
    private static final int MAX = 5;
    private static final int MIN = 2;
    private static Random random = new Random();

    public Tarakan(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        System.out.println("Tarakan" + name +" has stared");
        for (int i = 0; i < distance + 1; i++) {
            System.out.println("Tarakan " + name);
            try {
                Thread.sleep(random.nextInt(MIN, MAX + 1));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Tarakan" + name + " has finished");
    }
}
