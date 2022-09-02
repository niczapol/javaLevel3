package lesson7;

import lesson7.annotations.AfterSuite;
import lesson7.annotations.BeforeSuite;
import lesson7.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        TestClass testObj = new TestClass();

        try {
            start(TestClass.class, testObj);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    private static void start(Class<?> c, TestClass testObj) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = c.getDeclaredMethods();

        if (Arrays.stream(methods).filter(method -> method.isAnnotationPresent(BeforeSuite.class)).count() > 1 ||
                Arrays.stream(methods).filter(method -> method.isAnnotationPresent(AfterSuite.class)).count() > 1) {
            throw new RuntimeException();
        }

        HashMap<Integer, ArrayList<Method>> testingMethods = new HashMap<>();
        Method beforeSuite = null;
        Method afterSuite = null;

        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                int annotationPriority = method.getDeclaredAnnotation(Test.class).priority();
                if (!testingMethods.containsKey(annotationPriority)) {
                    testingMethods.put(annotationPriority, new ArrayList<>());
                }
                testingMethods.get(annotationPriority).add(method);
            }
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                beforeSuite = method;
            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                afterSuite = method;
            }
        }

        if (beforeSuite != null) {
            beforeSuite.setAccessible(true);
            beforeSuite.invoke(testObj);
        }

        testingMethods.forEach((k, v) -> v.forEach(T -> {
            System.out.print(T.getName() + "(priority " + T.getAnnotation(Test.class).priority() + ") :");
            T.setAccessible(true);
            try {
                T.invoke(testObj);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }));

        if (afterSuite != null) {
            afterSuite.setAccessible(true);
            afterSuite.invoke(testObj);
        }
    }


    //Ещё один вариант проверки колличества экземпляров аннотаций, возможно, он будет эффективней

    /*private static void BeforeAndAfterSuiteCountCheck(Method[] methods) {
        int BeforeSuiteAnnotationCount = 0;
        int AfterSuiteAnnotationCount = 0;

        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                BeforeSuiteAnnotationCount++;
            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                AfterSuiteAnnotationCount++;
            }

            if (BeforeSuiteAnnotationCount > 1 || AfterSuiteAnnotationCount > 1) {
                throw new RuntimeException();
            }
        }
    }*/
}

