package AlgorithmJava;

import java.util.Arrays;
import java.util.Random;

/**
 * Project Algorithm
 *
 * @Author Zoer Aleksandr
 * Created 26.04.2021 16:53
 */
/*Задание 2.1
На основе программного кода из домашнего задания №1 реализуйте массив на основе существующих примитивных или ссылочных типов данных.
Выполните обращение к массиву и базовые операции класса Arrays.
Оценить выполненные методы с помощью базового класса System.nanoTime().
Задание 2.2
На основе написанного кода в задании 2.1 реализуйте линейный и двоичный поиск.
Оценить алгоритмы линейного и двоичного поиска с помощью базового класса System.nanoTime(), при необходимости расширьте уже существующий массив данных.
Задание 2.3

Создайте массив размером 400 элементов.
Выполните сортировку с помощью метода sort().
Оцените сортировку с помощью базового класса System.nanoTime().
Задание 2.4
На основе существующего массива данных из задания 2.3 реализуйте алгоритм сортировки пузырьком.
Оцените сортировку с помощью базового класса System.nanoTime().
Сравните время выполнения алгоритмы сортировки методом sort() из задания 2.1 и сортировку пузырьком.
Задание 2.5
На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом выбора.
Оцените сортировку с помощью базового класса System.nanoTime().
Сравните с временем выполнения алгоритмов сортировки из прошлых заданий 2.3 и 2.4.
Задание 2.6
На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом вставки.
Оцените сортировку с помощью базового класса System.nanoTime().
Сравните с временем выполнения алгоритмов сортировки из прошлых заданий 2.3, 2.4 и 2.5.*/

public class ArraysAndSorting {

    public static void main(String[] args) {
// задание 2.1
        int[] integers1 = createArrInt(100_000_000);
        int[] integers2 = createArrInt(100_000);
        Algorithm[] algorithms1 = createArrAlg(100_000);
        Algorithm[] algorithms2 = createArrAlg(100_000);
        String[] strings1 = createArrStr(100_000);
        String[] strings2 = createArrStr(100_000);
        
        long start1 = System.nanoTime();
        System.out.println(Arrays.equals(integers1, integers2));
        System.out.println("Время выполнения сравнения int- " + (System.nanoTime() - start1));

        long start2 = System.nanoTime();
        System.out.println(Arrays.equals(algorithms1, algorithms2));
        System.out.println("Время выполнения сравнения Algorithm- " + (System.nanoTime() - start2));

        long start3 = System.nanoTime();
        System.out.println(Arrays.equals(strings1, strings2));
        System.out.println("Время выполнения сравнения String- " + (System.nanoTime() - start3));

// задание 2.2
        // линейный поиск
        System.out.println(linearSearch(900_000, integers1));
        // двоичний поиск
        System.out.println(binarySearch(900_000, integers1));

// задание 2.3
        Random random = new Random();
        int[] integers3 = new int[400];
        for (int i = 0; i < integers3.length; i++) {
            integers3[i] = random.nextInt(400);
        }
        methodSort(integers3);

// задание 2.4
        // пузырек v.1
//        bubbleSort1(integers3);

        // пузырек v.2
//        bobbleSort2(integers3);

// задание 2.5
        // выбор
//        selectionSort(integers3);

// задание 2.6
        // вставка
//        insertionSort(integers3);

    }

    private static void insertionSort(int[] arr) {
        long start = System.nanoTime();
        for (int left = 0; left < arr.length; left++) {
            int value = arr[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < arr[i]) {
                    arr[i + 1] = arr[i];
                } else break;
            }
            arr[i + 1] = value;
        }
        System.out.println("Время выполнения сортировки вставкой - " + (System.nanoTime() - start));
    }

    private static void selectionSort(int[] integers3) {
        long start = System.nanoTime();
        for (int i = 0; i < integers3.length; i++) {
            int min = i;
            for (int j = i; j < integers3.length; j++) {
                if (integers3[j] < integers3[min]) {
                    min = j;
                }
            }
            swap(integers3, i, min);
        }
        System.out.println("Время выполнения сортировки выбором - " + (System.nanoTime() - start));
    }

    private static void swap(int[] arr, int a, int b) {
        int buff = arr[a];
        arr[a] = arr[b];
        arr[b] = buff;
    }


    private static void methodSort(int[] arr) {
        long start = System.nanoTime();
        Arrays.sort(arr);
        System.out.println("Время выполнения метода sort - " + (System.nanoTime() - start));
    }

    private static void bubbleSort1(int[] arr) {
        boolean sorted = false;
        long start = System.nanoTime();
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    sorted = false;
                    swap(arr, i, i + 1);
                }
            }
        }
        System.out.println("Время выполнения сортировки пузырьком первый способ - " + (System.nanoTime() - start));
    }

    private static void bobbleSort2(int[] arr) {
        long start = System.nanoTime();
        for (int i = arr.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        System.out.println("Время выполнения сортировки пузырьком второй способ - " + (System.nanoTime() - start));
    }

    private static String binarySearch(int i, int[] ints) {
        int first = 0;
        int last = ints.length - 1;

        long start = System.nanoTime();
        while (first <= last) {
            int middle = (first + last) / 2;

            if (ints[middle] == i) {
                System.out.println("Время выполнения двоичного поиска " + (System.nanoTime() - start));
                return String.valueOf(ints[middle]);
            } else if (ints[middle] > i) {
                last = middle - 1;
            } else if (ints[middle] < i) {
                first = middle + 1;
            }
        }
        return "Значение не найдено";
    }

    private static String linearSearch(int i, int[] ints) {
        long start = System.nanoTime();
        for (int j = 0; j < ints.length; j++) {
            if (ints[j] == i) {
                System.out.println("Время выполнения линейного поиска " + (System.nanoTime() - start));
                return String.valueOf(j);
            }
        }
        return "Значение не найдено";
    }

    private static int[] createArrInt(int count) {
        int[] arr = new int[count];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        return arr;
    }

    private static String[] createArrStr(int count) {
        String[] arr = new String[count];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = "Number" + i;
        }
        return arr;
    }

    private static Algorithm[] createArrAlg(int count) {
        Algorithm[] arr = new Algorithm[count];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Algorithm("Number - " + i, i + 15);
        }
        return arr;
    }
}
