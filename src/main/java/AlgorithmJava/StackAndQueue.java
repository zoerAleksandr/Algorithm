package AlgorithmJava;

import java.util.*;

/**
 * Project Algorithm
 *
 * @Author Zoer Aleksandr
 * Created 08.05.2021 14:30
 */

/*Задание 4.1
На основе данных объектного списка из задания 3.4 реализуйте простой стек и его базовые методы.
Оцените время выполнения операций с помощью базового метода System.nanoTime().
Задание 4.2
На основе данных объектного списка из задания 3.4 реализуйте простую очередь и его базовые методы.
Реализуйте вспомогательные методы.
Оцените время выполнения операций с помощью базового метода System.nanoTime().
Задание 4.3
На основе данных объектного списка из задания 3.4 реализуйте простой дек и его базовые методы.
Оцените время выполнения операций с помощью базового метода System.nanoTime().
Задание 4.4
Реализуйте приоритетную очередь на основе ссылочных типов данных, например, integer.
Оцените время выполнения операций с помощью базового метода System.nanoTime().
Задание 4.5
На основе данных из задания 4.1 и 4.2, реализуйте стек и очередь на базе связанного списка.
Оцените время выполнения операций с помощью базового метода System.nanoTime().
*/
public class StackAndQueue {
    static long start;

    public static void main(String[] args) {
// задание 4.1
        stackTest();
// задание 4.2
        queueTest();
// задание 4.3
        dequeTest();
// задание 4.4
        priorityTest();
// задание 4.5
        stackAndQueueTest();


    }

    private static void stackAndQueueTest() {
        Stack<String> stack = new Stack<>();
        start = System.nanoTime();
        stack.addAll(createList(100_000));
        System.out.println("Время добавления коллекции в Stack - " + (System.nanoTime() - start));

        start = System.nanoTime();
        stack.push("Push");
        System.out.println("Время добавления элемента в Stack - " + (System.nanoTime() - start));

        start = System.nanoTime();
        stack.peek();
        System.out.println("Время получения элемента в Stack - " + (System.nanoTime() - start));

        start = System.nanoTime();
        stack.pop();
        System.out.println("Время удаления элемента в Stack - " + (System.nanoTime() - start));
        System.out.println("<<<<<<-------------->>>>>>>>");


        start = System.nanoTime();
        Queue<String> queue = new LinkedList<>(createList(100_000));
        System.out.println("Время добавления коллекции в Queue - " + (System.nanoTime() - start));

        start = System.nanoTime();
        queue.add("Add");
        System.out.println("Время добавления элемента в Queue - " + (System.nanoTime() - start));

        start = System.nanoTime();
        queue.poll();
        System.out.println("Время удаления элемента в Queue - " + (System.nanoTime() - start));

        start = System.nanoTime();
        String s = queue.peek();
        System.out.println("Время получения элемента в Queue - " + (System.nanoTime() - start));
        System.out.println("<<<<<<-------------->>>>>>>>");
    }

    private static void priorityTest() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(1);
        priorityQueue.add(5);
        priorityQueue.add(2);
        priorityQueue.add(9);

        start = System.nanoTime();
        priorityQueue.offer(0);
        System.out.println("Время добавления элемента в PriorityQueue - " + (System.nanoTime() - start));

        start = System.nanoTime();
        priorityQueue.poll();
        System.out.println("Время удаления элемента в PriorityQueue - " + (System.nanoTime() - start));

        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
        System.out.println("<<<<<<-------------->>>>>>>>");

    }

    private static void dequeTest() {
        start = System.nanoTime();
        Deque<String> deque = new LinkedList<>(createList(100_000));
        System.out.println("Время добавления коллекции в Deque - " + (System.nanoTime() - start));

        start = System.nanoTime();
        deque.addFirst("first");
        System.out.println("Время добавления в начало Deque - " + (System.nanoTime() - start));

        start = System.nanoTime();
        deque.addLast("last");
        System.out.println("Время добавления в конец Deque - " + (System.nanoTime() - start));

        start = System.nanoTime();
        deque.getFirst();
        System.out.println("Время получения первого элемента Deque - " + (System.nanoTime() - start));

        start = System.nanoTime();
        deque.getLast();
        System.out.println("Время получения последнего элемента Deque - " + (System.nanoTime() - start));
        System.out.println("<<<<<<-------------->>>>>>>>");

    }

    private static void queueTest() {
        ArrayList<String> arrayList = createList(100_000);
        start = System.nanoTime();
        MQueue mQueue = new MQueue(arrayList);
        System.out.println("Время добавления коллекции в МQueue - " + (System.nanoTime() - start));

        start = System.nanoTime();
        System.out.println("Время добавления элемента в МQueue - " + (System.nanoTime() - start));

        start = System.nanoTime();
        System.out.println("Время чтения элемента в МQueue - " + (System.nanoTime() - start));

        start = System.nanoTime();
        System.out.println("Время удаления элемента в МQueue - " + (System.nanoTime() - start));
        System.out.println("<<<<<<-------------->>>>>>>>");

    }

    private static void stackTest() {
        ArrayList<String> arrayList = createList(100_000);
        start = System.nanoTime();
        MStack<String> stack = new MStack<>(arrayList);
        System.out.println("Время добавления коллекции в MStack - " + (System.nanoTime() - start));

        start = System.nanoTime();
        System.out.println("Время добавления элемента в MStack - " + (System.nanoTime() - start));

        start = System.nanoTime();
        System.out.println("Время чтения элемента в MStack - " + (System.nanoTime() - start));

        start = System.nanoTime();
        System.out.println("Время удаления элемента в MStack - " + (System.nanoTime() - start));
        System.out.println("<<<<<<-------------->>>>>>>>");

    }

    private static ArrayList<String> createList(int count) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            arrayList.add(String.valueOf(i));
        }
        return arrayList;
    }
}

class MQueue<T> {
    private ArrayList<T> list;

    public MQueue(ArrayList<T> list) {
        this.list = list;
    }

    public void insert(T t) {
        list.add(t);
    }

    public T remove() {
        T t = list.get(0);
        list.remove(0);
        return t;
    }

    public T peek() {
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}

class MStack<T> {
    ArrayList<T> list;

    public MStack(ArrayList<T> list) {
        this.list = list;
    }

    public void insert(T t) {
        list.add(t);
    }

    public T remove() {
        T t = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return t;
    }

    public T peek() {
        return list.get(list.size() - 1);
    }
}
