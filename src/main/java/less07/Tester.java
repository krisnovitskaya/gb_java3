package less07;
//Создать класс, который может выполнять «тесты», в качестве тестов выступают классы с наборами методов с аннотациями @Test.
// Для этого у него должен быть статический метод start(), которому в качестве параметра передается или объект типа Class, или имя класса.
// Из «класса-теста» вначале должен быть запущен метод с аннотацией @BeforeSuite, если такой имеется, далее запущены методы с аннотациями @Test,
// а по завершению всех тестов – метод с аннотацией @AfterSuite. К каждому тесту необходимо также добавить приоритеты (int числа от 1 до 10),
// в соответствии с которыми будет выбираться порядок их выполнения, если приоритет одинаковый, то порядок не имеет значения.
// Методы с аннотациями @BeforeSuite и @AfterSuite должны присутствовать в единственном экземпляре, иначе
// необходимо бросить RuntimeException при запуске «тестирования».

import less07.annotation.AfterSuite;
import less07.annotation.BeforeSuite;
import less07.annotation.Test;


import java.lang.reflect.Constructor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;


public class Tester {

    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        start(ClassForTest1.class);
    }


    public static void start(Class<?> clazz) throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        Constructor constructor = clazz.getConstructor();

        Object obj = constructor.newInstance();

        Method[] methods = clazz.getDeclaredMethods();

        checkBeforeAndAfterAnonMethods(methods);

        runBefore(methods, obj);

        List<Method> methodList = prepareAndSort(methods);

        //test methods
        for (Method method : methodList) {
            method.invoke(obj);
        }

        runAfter(methods, obj);

    }

    private static void checkBeforeAndAfterAnonMethods(Method[] methods) {
        int countBefore = 0;
        int countAfter = 0;
        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                countBefore++;
            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                countAfter++;
            }
        }
        if(countAfter != 1 || countBefore != 1){
            System.out.println("Методы с аннотациями @BeforeSuite и @AfterSuite должны присутствовать в единственном экземпляре: fail");
            throw new RuntimeException();
        }
    }

    private static List<Method> prepareAndSort(Method[] methods) {
        Comparator<Method> comparator = (o1, o2) -> {
            int x = o1.getAnnotation(Test.class).priority();
            int y = o2.getAnnotation(Test.class).priority();
            return Integer.compare(y, x);
        };

        List<Method> methodList = new ArrayList<>();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                methodList.add(method);
            }
        }

        Collections.sort(methodList,comparator);
        return methodList;
    }

    private static void runAfter(Method[] methods, Object obj) throws InvocationTargetException, IllegalAccessException {
        for (Method method : methods) {
            if (method.isAnnotationPresent(AfterSuite.class)) {
                method.invoke(obj);
                break;
            }
        }
    }

    private static void runBefore(Method[] methods, Object obj) throws InvocationTargetException, IllegalAccessException {
        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                method.invoke(obj);
                break;
            }
        }
    }
}
