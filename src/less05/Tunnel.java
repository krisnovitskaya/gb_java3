package less05;

import java.util.concurrent.*;
public class Tunnel extends Stage {
    Semaphore semaphore;

    public Tunnel(int carCount) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        this.semaphore = new Semaphore(carCount/2);
    }
    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                semaphore.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                //с err лучше видно
                //System.err.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                //System.err.println(c.getName() + " закончил этап: " + description);
                semaphore.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
