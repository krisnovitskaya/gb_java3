package less01;

//3. Интересная задача:
//        a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
//        b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
//        c. Для хранения фруктов внутри коробки можете использовать ArrayList;
//        d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
//        e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут в compare в качестве параметра, true - если их веса равны, false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
//        f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
//        g. Не забываем про метод добавления фрукта в коробку.

import java.util.ArrayList;

// b.
public class BoxOfFruit<T extends Fruit> {

    //c.
    private ArrayList<T> box;
    public BoxOfFruit() {
        this.box = new ArrayList<>();
    }
    //g.
    public void addToBox(T fruit){
        box.add(fruit);
    }

    //d.
    public float getWeight(){
        float weightOfBox = 0;
        for (T t : this.box) {
            weightOfBox += t.getWeightOneFruit();
        }
        return weightOfBox;
    }

    //e.
    public boolean compare(BoxOfFruit<?> box2){
        if(this.getWeight() == box2.getWeight()){
            return true;
        }
        return false;
    }

    //f.
    public void MoveTo(BoxOfFruit<T> box2){
        for (T t : this.box) {
            box2.addToBox(t);
        }
        this.box.clear();
    }
}
