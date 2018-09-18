package chansiqing.myapplication;


import android.support.v4.util.ArrayMap;

import org.junit.Test;

import java.security.KeyStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PrimitiveIterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private ConcurrentHashMap<String, MaidianData> map = new ConcurrentHashMap<>();
    boolean a = true;
    private int count=0;
    private Integer aa=1;
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test() {
        KotlinTest.StaticMethod.testReentrantReadWriteTryLock();
    }

    @Test
    public void trouble() {
        ArrayList<ArrayList> list = new ArrayList<ArrayList>();
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(2);
        list.add(list1);
        Iterator<ArrayList> iterator = list.iterator();
        while (iterator.hasNext()) {
            ArrayList integer = iterator.next();
            if ((Integer) integer.get(0) == 2)
                integer.remove(0);
        }
    }

    @Test
    public void test1() {
        for (int i = 0; i < 20; i++) {
            final int count = i;
            ArrayMap<String, Integer> arrayMap = new ArrayMap<>();
            arrayMap.put(count + "", count);
            MaidianData data = new MaidianData(count + "", arrayMap);
            map.put(count + "", data);
        }
        for (int i = 0; i < 100; i++) {
            final int count = i;
            new Thread(() -> {
                ArrayMap<String, Integer> arrayMap = new ArrayMap<>();
                arrayMap.put(count + "", count);
                MaidianData data = new MaidianData(count + "", arrayMap);
                map.put(count + "", data);
            }).start();
            new Thread(() -> {
                for (Iterator it = map.entrySet().iterator(); it.hasNext(); ) {
                    Map.Entry entry = (Map.Entry) it.next();
                    MaidianData data = (MaidianData) entry.getValue();
                    if (data != null && data.map != null) {
                        data.map.put(count + "", count);
                    }
                }
            }).start();
            new Thread(() -> {
                for (Iterator it = map.entrySet().iterator(); it.hasNext(); ) {
                    Map.Entry entry = (Map.Entry) it.next();
                    MaidianData data = (MaidianData) entry.getValue();
                    if (data != null && data.map.size() > 0) {
                        data.map.clear();
                    }
                }
            }).start();
            new Thread(() -> {
                for (Iterator it = map.entrySet().iterator(); it.hasNext(); ) {
                    Map.Entry entry = (Map.Entry) it.next();
                    MaidianData data = (MaidianData) entry.getValue();
                    if (data != null && data.map.size() > 0) {
                        for (Iterator iterator = data.map.entrySet().iterator(); iterator.hasNext(); ) {
                            Map.Entry<String, Integer> arrayEntry = (Map.Entry<String, Integer>) iterator.next();
                            Integer number = arrayEntry.getValue();
                            System.out.println(number + "");
                        }
                    }
                }
            }).start();
        }
    }

    @Test
    public void test2() throws InterruptedException {
        ArrayMap<String, String> map = new ArrayMap<>();
        map.put("11", "1");
        map.put("22", "2");
        map.put("33", "3");
        map.put("44", "4");
        map.put("55", "5");
        map.put("66", "6");
        map.put("77", "7");
        map.put("88", "8");
        for (int i = 0; i < 1000; i++) {
            int finalI1 = i;
            map.put(finalI1 + "", finalI1 + "");
        }
        for (int i = 0; i < 1000; i++) {
            int finalI1 = i;
            new Thread(() -> {
                map.remove(finalI1 + "", finalI1 + "");
            }).start();
        }
        Thread.sleep(50000);
    }

    @Test
    public void test3() throws InterruptedException {
        Ad ad = new Ad();
        ad.count = 0;
        int count = 0;
        for (int i = 0; i < 1000; i++) {
            count = count++;
            int finalCount = count;
            new Thread(() ->
            {
                ad.count = finalCount;
            }).start();
        }
        System.out.println(ad.count + " thread " + Thread.currentThread().getId());
        Thread.sleep(2000);
    }

    @Test
    public void test4() throws InterruptedException {
        Ad ad = new Ad();
        ad.count = 3;
        new MyThread(ad).start();
        Thread.sleep(600);
        new MyThread1(ad).start();
        Thread.sleep(6000);
    }

    @Test
    public void test5() throws InterruptedException {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                lock.writeLock().lock();
                if (a) {
                    System.out.println("线程 " + Thread.currentThread().getId() + "开始");
                    a = false;
                    System.out.println("线程 " + Thread.currentThread().getId() + "没问题");
                }
                lock.writeLock().unlock();
            }).start();
        }
        /*Thread.sleep(200);
        new Thread(() -> {
            System.out.println("线程 " + Thread.currentThread().getId() + "读取a之前");
            if (a) {
                System.out.println("线程 " + Thread.currentThread().getId() + "读取a之后");
                lock.writeLock().lock();
                System.out.println("线程 " + Thread.currentThread().getId() + "获取写锁");
                a = false;
                System.out.println("线程 " + Thread.currentThread().getId() + "写完");
                lock.writeLock().unlock();
                System.out.println("线程 " + Thread.currentThread().getId() + "没问题");
            }
        }).start();*/
        Thread.sleep(1200);
        System.out.println(count);
    }

    @Test
    public void test6() throws InterruptedException {

        new Thread(() -> {
            synchronized (aa){
                System.out.println("第一个线程");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Thread.sleep(300);
        new Thread(() -> {
            synchronized (aa){
                System.out.println("第二个线程");
            }
        }).start();
    }
}