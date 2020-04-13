package less06;

//2. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
// Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов, идущих после последней четверки.
// Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо выбросить RuntimeException.
// Написать набор тестов для этого метода (по 3-4 варианта входных данных). Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].

// 3. Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или единицы, то метод вернет false;
// Написать набор тестов для этого метода (по 3-4 варианта входных данных).

import java.util.Arrays;

public class ArrayMethods {


    public int[] arrayAfter4 (int[] arr) throws RuntimeException{
        int index4 = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] == 4) {
                index4 = i;
                break;
            }
        }
        if(index4 < 0){
            throw new RuntimeException();
        }
        if(index4 == arr.length - 1){
            return new int[0];
        }
        int[] newArr = Arrays.copyOfRange(arr, index4 + 1, arr.length);
        return newArr;
    }




    public boolean arrayOf4and1 (int[] arr){
        boolean is1 = false;
        boolean is4 = false;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 1){
                is1 = true;
            }else if(arr[i] == 4){
                is4 = true;
            } else {
                return false;
            }
        }

        if(is1 && is4) {
            return true;
        } else {
            return false;
        }
    }
}
