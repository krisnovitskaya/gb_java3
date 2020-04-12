package less04;
//Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз (порядок – ABСABСABС). Используйте wait/notify/notifyAll.

public class ABCprint {

    private final Object mon = new Object();
    private  int number = 1;

    public static void main(String[] args) {
        ABCprint abc = new ABCprint();
        Thread t1 = new Thread(abc::printA);
        Thread t2 = new Thread(abc::printB);
        Thread t3 = new Thread(abc::printC);
        t1.start();
        t2.start();
        t3.start();
    }

    public void printA() {
        synchronized (mon) {
            int i = 0;
            while (i < 5) {
                while(number != 1){
                    try {
                        mon.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("A");
                i++;
                number = 2;
                mon.notifyAll();
            }
        }

    }

    public void printB() {
        synchronized (mon) {
            int i = 0;
            while (i < 5) {
                while(number != 2){
                    try {
                        mon.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("B");
                i++;
                number = 3;
                mon.notifyAll();
            }
        }
    }
    public void printC() {
        synchronized (mon) {
            int i = 0;
            while (i < 5) {
                while(number != 3){
                    try {
                        mon.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("C");
                i++;
                number = 1;
                mon.notifyAll();
            }
        }
    }

}