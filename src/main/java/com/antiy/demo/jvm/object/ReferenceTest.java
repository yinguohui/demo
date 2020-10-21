package com.antiy.demo.jvm.object;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @Author ygh
 * @Description 对象引用 --------未完
 * <p>
 * 强引用
 * Object obj = new Object()这类的引用，只要强引用还存在，垃圾收集器就永远不会回收被引用的对象。
 * 如果想中断强引用和某个对象之间的关联，可以显示的将引用赋值为null，这样jvm在合适的时间就会回收该对象
 * <p>
 * 软引用
 * 软引用是用来描述一些还有用但并非必需的对象。对于软引用关联着的对象，在系统将会发生内存溢出异常之前，
 * 将会把这些对象列进回收范围之中进行第二次回收。SoftReference的特点是它的一个实例保存对一个Java对象的软引用，
 * 该软引用的存在不妨碍垃圾收集器线程对该Java对象的回收
 * <p>
 * 弱引用
 * 弱引用也是用来描述非必需对象的。当JVM进行垃圾回收时，无论内存是否充足，都会回收被弱引用关联的对象。
 * 在java中，用java.lang.ref.WeakReference类来表示
 * <p>
 * 虚引用
 * 虚引用和前面的软引用和弱引用不同，它并不影响对象的生命周期。在java中使用PhantomReference类来表示。
 * 如果一个对象与虚引用关联，跟没有引用与之关联一样，任何时候都可能被回收。要注意的是，虚引用必须和引用队列关联使用。
 * 当垃圾收集器准备回收一个对象时，如果发现它还有虚引用，就会把这个虚引用加入到与之关联的引用队列中。
 * 为对象设置虚引用的唯一目的就是能在这个对象被垃圾收集器回收时收到一个系统通知
 * @Date 2020/9/11
 */
public class ReferenceTest {


    public static void main(String[] args) {
        Object t = 1;
        WeakReference reference = new WeakReference<>(t);
        ReferenceQueue q = null;
        PhantomReference reference1 = new PhantomReference(t, q);
        System.out.println(reference);
        System.out.println(t);
        t = null;
        System.gc();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.gc();
        System.out.println(t);
        System.out.println(reference.get());
    }
}
