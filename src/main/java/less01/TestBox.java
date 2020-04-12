package less01;

public class TestBox {
    public static void main(String[] args) {
        Apple app1 = new Apple();
        Apple app2 = new Apple();
        Apple app3 = new Apple();
        Apple app4 = new Apple();
        Apple app5 = new Apple(1.5f);
        Orange or1 = new Orange();
        Orange or2 = new Orange();
        Orange or3 = new Orange();
        Orange or4 = new Orange();
        Orange or5 = new Orange();
        //Orange or6 = new Orange(1.5f);
        Orange or6 = new Orange(1.8f);


        BoxOfFruit<Orange> orangeBoxOfFruit = new BoxOfFruit<>();
        BoxOfFruit<Orange> orangeBoxOfFruit2 = new BoxOfFruit<>();
        BoxOfFruit<Apple> appleBoxOfFruit = new BoxOfFruit<>();

        orangeBoxOfFruit.addToBox(or3);
        orangeBoxOfFruit.addToBox(or2);
        orangeBoxOfFruit.addToBox(or4);
        orangeBoxOfFruit2.addToBox(or1);
        orangeBoxOfFruit2.addToBox(or5);
        orangeBoxOfFruit2.addToBox(or6);

        System.out.println("Вес коробки1 апельсинов");
        System.out.println(orangeBoxOfFruit.getWeight());
        System.out.println("Вес коробки2 апельсинов");
        System.out.println(orangeBoxOfFruit2.getWeight());

        appleBoxOfFruit.addToBox(app1);
        appleBoxOfFruit.addToBox(app3);
        appleBoxOfFruit.addToBox(app2);
        //appleBoxOfFruit.addToBox(app5);
        System.out.println("Вес коробки1 яблок");
        System.out.println(appleBoxOfFruit.getWeight());

        System.out.println("равны ли по весу коробка1 и коробка2 апельсинов");
        System.out.println(orangeBoxOfFruit.compare(orangeBoxOfFruit2));

        System.out.println("равны ли по весу коробка1 апельсинов и коробка1 яблок");
        System.out.println(orangeBoxOfFruit.compare(appleBoxOfFruit));


        System.out.println("пересыпаем фрукты");
        orangeBoxOfFruit.MoveTo(orangeBoxOfFruit2);
        System.out.println("Вес коробки1 апельсинов");
        System.out.println(orangeBoxOfFruit.getWeight());
        System.out.println("Вес коробки2 апельсинов");
        System.out.println(orangeBoxOfFruit2.getWeight());
    }
}
