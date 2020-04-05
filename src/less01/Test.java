package less01;

//1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
//2. Написать метод, который преобразует массив в ArrayList

import java.util.ArrayList;

public class Test {

    //1
    public static <T> void replaceByIndex(T[] array, int index1, int index2){
        if((index1 >= 0 && index1 < array.length) && (index2 >= 0 && index2 < array.length)){
            T buffer = array[index1];
            array[index1] = array[index2];
            array[index2] = buffer;
        }
    }

    //2
    public static <T> ArrayList<T> arrayToArrayList(T[] array){
        ArrayList<T> list = new ArrayList<>();
        for (T t : array) {
            list.add(t);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println("Тест 1");
        Integer[] arr = {2, 6 , 8, 9 , 4, 7};
        printArray(arr);
        replaceByIndex(arr, 2, 5);
        printArray(arr);

        System.out.println("Тест 2");
        String[] arr2 = {"1", "2","3","four","five"};
        ArrayList<String> listS = arrayToArrayList(arr2);
        printList(listS);

        System.out.println("Тест 3");
        replaceByIndex(arr2, 1, 2);
        printArray(arr2);

    }

    public static <T> void printArray(T[] array){
        for (T t : array) System.out.print(t + " ");
        System.out.println();
    }

    public static <T> void printList(ArrayList<T> array){
        for (T t : array) System.out.print(t + " ");
        System.out.println();
    }

}
