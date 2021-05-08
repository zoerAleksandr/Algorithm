package AlgorithmJava;

import java.awt.font.TextHitInfo;
import java.util.*;

/**
 * Project Algorithm
 *
 * @Author Zoer Aleksandr
 * Created 06.05.2021 11:34
 */
public class Collections {
    /*Задание 3.1
На основе массива из домашнего задания 2.1 реализуйте простой список и коллекцию.
Оцените время выполнения преобразования.
Задание 3.2
На основе списка из задания 3.1 реализуйте основные методы добавления, удаления и получения объекта или элемента из списка.
Оценить выполненные методы с помощью базового класса System.nanoTime().
Задание 3.3
Реализуйте простой односвязный список и его базовые методы.
Задание 3.4
На основе списка из задания 3.1 реализуйте простой двусторонний список и его базовые методы.
Реализуйте список заполненный объектами из вашего класса из задания 1.3
Задание 3.5
Реализуйте итератор на основе связанных списков из задания 3.4 и выполните базовые операции итератора.
Оцените время выполнения операций с помощью базового метода System.nanoTime()
*/

    public static void main(String[] args) {
// задание 3.1
        long start = System.nanoTime();
        String[] strings = ArraysAndSorting.createArrStr(100_000);
        List<String> list = Arrays.asList(strings);
        System.out.println("Время преобразования из массива в List- " + (System.nanoTime() - start));

        long start2 = System.nanoTime();
        ArrayList<String> arrayList = new ArrayList<>(list);
        System.out.println("Время преодразования List в ArrayList - " + (System.nanoTime() - start2));
// задание 3.2
        long start3 = System.nanoTime();
        arrayList.add("first");
        System.out.println("ArrayList");
        System.out.println("Время добавления в начало - " + (System.nanoTime() - start3));

        long start4 = System.nanoTime();
        arrayList.set(arrayList.size() - 1, "last");
        System.out.println("ArrayList");
        System.out.println("Время переопределения значения в конце - " + (System.nanoTime() - start4));

        long start6 = System.nanoTime();
        arrayList.set(1, "1");
        System.out.println("ArrayList");
        System.out.println("Время переопределения значения в начале - " + (System.nanoTime() - start6));

        long start5 = System.nanoTime();
        arrayList.remove(arrayList.size() - 1);
        System.out.println("ArrayList");
        System.out.println("Время удаления значения в конце - " + (System.nanoTime() - start5));

        long start11 = System.nanoTime();
        arrayList.remove(0);
        System.out.println("ArrayList");
        System.out.println("Время удаления значения в начале - " + (System.nanoTime() - start11));

// задание 3.3
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.insert("1");
        myLinkedList.insert("2");
        myLinkedList.insert("3");
        myLinkedList.insert("4");
        System.out.println(myLinkedList.search("3"));
        myLinkedList.deleteFirst();
        myLinkedList.print();

// задание 3.4
        LinkedList<String> linkedList = new LinkedList<>(arrayList);
        long start7 = System.nanoTime();
        arrayList.add("first");
        System.out.println("LinkedList");
        System.out.println("Время добавления в начало - " + (System.nanoTime() - start7));

        long start8 = System.nanoTime();
        arrayList.set(arrayList.size() - 1, "last");
        System.out.println("LinkedList");
        System.out.println("Время переопределения значения в конце - " + (System.nanoTime() - start8));

        long start9 = System.nanoTime();
        arrayList.set(1, "1");
        System.out.println("LinkedList");
        System.out.println("Время переопределения значения в начале - " + (System.nanoTime() - start9));

        long start10 = System.nanoTime();
        arrayList.remove(arrayList.size() - 1);
        System.out.println("LinkedList");
        System.out.println("Время удаления значения в конце - " + (System.nanoTime() - start10));

        long start12 = System.nanoTime();
        arrayList.remove(0);
        System.out.println("LinkedList");
        System.out.println("Время удаления значения в начале - " + (System.nanoTime() - start12));

// задание 3.5
        ListIterator<String> iterator = linkedList.listIterator();
        int s = linkedList.size();
        long start13 = System.nanoTime();
        while (iterator.hasNext()){
            iterator.next();
            iterator.remove();
        }
        System.out.println("Время элементов коллекции из " + s + " значений составило - " + (System.nanoTime() - start13));
    }
}

// задание 3.3
class MyLink<T> {
    private T link;
    private MyLink next;

    public MyLink(T link) {
        this.link = link;
    }

    public T get() {
        return link;
    }

    public MyLink getNext() {
        return next;
    }

    @Override
    public String toString() {
        return link.toString();
    }

    public void set(T newLink) {
        this.link = newLink;
    }

    public void setNext(MyLink newNext) {
        this.next = newNext;
    }
}

class MyLinkedList<T> {
    private MyLink first;

    public MyLinkedList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insert(T link) {
        MyLink<T> myLink = new MyLink<>(link);
        myLink.setNext(first);
        this.first = myLink;
    }

    public void deleteFirst() {
        if (!isEmpty()) {
            first = first.getNext();
        }
    }

    public void print() {
        MyLink current = first;
        while (current != null) {
            System.out.println(current.toString());
            current = current.getNext();
        }
    }

    public T search(T s) {
        MyLink<T> myLink = new MyLink<>(s);
        MyLink current = first;
        while (current != null) {
            if (current.get().equals(myLink.get())) {
                return myLink.get();
            }
            current = current.getNext();
        }
        return null;
    }
}
