package com.antiy.demo.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

/**
 * @Author ygh
 * @Description
 * @Date 2019/11/26
 */
public class RunnableT1 {
    public static void main(String[] args) {
        f1();
        f2();
        f3();
    }

    private static void f1() {
        Runnable r = () -> System.out.println("hell0");
        Thread thread = new Thread(r);
        thread.start();
    }

    private static void f2() {
        final List<Book> list = Arrays.asList(new Book(1, "Ramayan"), new Book(2, "Mahabharat"));
        Runnable r = () -> {
            Consumer<Book> style = (Book b) -> System.out.println("Book Id:" + b.getId() + ", Book Name:" + b.getName());
            list.forEach(style);
        };
        Thread thread = new Thread(r);
        thread.start();
    }

    private static void f3() {
        final List<Book> list = Arrays.asList(new Book(1, "Ramayan"), new Book(2, "Mahabharat"));
        ExecutorService service = Executors.newFixedThreadPool(2);
        Runnable r1 = () -> list.forEach(Book::print);
        service.execute(r1);
        Runnable r2 = () -> {
            Consumer<Book> style = (Book b) -> System.out.println("Book Id:" + b.getId() + ", Book Name:" + b.getName());
            list.forEach(style);
        };
        service.execute(r2);
    }


    public static class Book {
        public int id;
        public String name;

        public Book(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void print() {
            System.out.println("id:" + id + ", Name:" + name);
        }
    }
}
