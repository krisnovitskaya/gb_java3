package less05;

import java.util.concurrent.locks.ReentrantLock;

import static less05.MainClass.cdlFinish;
import static less05.MainClass.cdlStart;

public class Car implements Runnable {

    private static int CARS_COUNT;


    static {
        CARS_COUNT = 0;
    }
    private static ReentrantLock lock = new ReentrantLock();
    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cdlStart.countDown();
            cdlStart.await();
            Thread.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);

            if(i == race.getStages().size() - 1){
                if(lock.tryLock()){
                    lock.lock();
                    System.out.println(this.name + " WIN");
                    cdlFinish.countDown();
                } else {
                    cdlFinish.countDown();
                    System.out.println(this.name + " закончил гонку.");
                }


            }
        }
    }
}