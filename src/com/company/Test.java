package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author - ED
 * @version - 1.0
 */
public class Test {
    /**
     * Поле объекта ArrayList
     */
    private ArrayList<Double> arrayList = new ArrayList<>();
    /**
     * Поле объекта LinkedList
     */
    private LinkedList<Double> linkedList = new LinkedList<>();
    /**
     * Поле для фиксации времени начала выполнения метода
     */
    private long startTime;
    /**
     * Поле для фиксации времени окончания выполнения метода
     */
    private long endTime;
    /**
     * Поле для фиксации результата
     */
    private final String result;
    /**
     * Поле для хранениния количества повторений метода
     */
    private final int count;

    /**
     * @param count - Количество повторений методов
     */

    public Test(int count) {
        String result1;
        this.count = count;
        double a, b, c, d, e, f;
        a = testAddArray();
        b = testAddLinked();
        result1 = "Время выполнения методов ArrayList в нс" + '\t' + "|" + '\t' + "Время выполнения методов LinkedList в нс"
                + '\n' + "Метод add - " + a + '\t' + "|" + '\t' + b + '\n';
        startTime = 0;
        endTime = 0;
        c = testGetArray();
        d = testGetLinked();
        result1 += "Метод get - " + c + '\t' + "|" + '\t' + d + '\n';
        startTime = 0;
        endTime = 0;
        e = testDeleteArray();
        f = testDeleteLinked();
        result1 += "Метод remove - " + e + '\t' + "|" + '\t' + f + '\n'
                + "Итоги сравнения (быстрее) : " + '\n' + "Метод add - " + comparison(a, b) + '\n' + "Метод get - " + comparison(c, d)
                + '\n' + "Метод remove - " + comparison(e, f);
        result = result1;
    }

    /**
     * Метод для просмотра поля result
     *
     * @return - result
     */
    public String getResult() {
        return result;
    }

    /**
     * Метод для вычесления времени работы метода LinkedList - add
     *
     * @return - Время работы метода (разница между оконочанием и началом работы метода)
     */
    private long testAddLinked() {
        startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            linkedList.add(0.0);
        }
        endTime = System.nanoTime();
        return (endTime - startTime);
    }

    /**
     * Метод для вычесления времени работы метода ArrayList - add
     *
     * @return - Время работы метода (разница между оконочанием и началом работы метода)
     */
    private long testAddArray() {
        startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            arrayList.add(0.0);
        }
        endTime = System.nanoTime();
        return (endTime - startTime);
    }

    /**
     * Метод для вычесления времени работы метода ArrayList - get
     *
     * @return - Время работы метода (разница между оконочанием и началом работы метода)
     */
    private long testGetArray() {
        startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            arrayList.get(i);
        }
        endTime = System.nanoTime();
        return (endTime - startTime);
    }

    /**
     * Метод для вычесления времени работы метода LinkedList - get
     *
     * @return - Время работы метода (разница между оконочанием и началом работы метода)
     */
    private long testGetLinked() {
        startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            linkedList.get(i);
        }
        endTime = System.nanoTime();
        return (endTime - startTime);
    }

    /**
     * Метод для вычесления времени работы метода ArrayList - delete
     *
     * @return - Время работы метода (разница между оконочанием и началом работы метода)
     */
    private long testDeleteArray() {
        startTime = System.nanoTime();
        for (int i = count - 1; i >= 0; i--) {
            arrayList.remove(i);
        }
        endTime = System.nanoTime();
        return (endTime - startTime);
    }

    /**
     * Метод для вычесления времени работы метода LinkedList - delete
     *
     * @return - Время работы метода (разница между оконочанием и началом работы метода)
     */
    private long testDeleteLinked() {
        startTime = System.nanoTime();
        for (int i = count - 1; i >= 0; i--) {
            linkedList.remove(i);
        }
        endTime = System.nanoTime();
        return (endTime - startTime);
    }

    /**
     * Метод для сравнения времени работы методов
     *
     * @return - Результат сравнения
     */
    private String comparison(double a, double b) {
        if (a < b) {
            return "ArrayList";
        } else {
            return "LinkedList";
        }
    }
}

