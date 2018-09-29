package chansiqing.myapplication;


import android.support.v4.util.ArrayMap;


/**
 * TODO:功能说明
 *
 * @author: chansiqing
 * @date: 2018-07-30 19:15
 */
public class Ad {
    public int count;

    public boolean isEqual(int time) throws InterruptedException {
        int c = count;
        Thread.sleep(time);
        if (c == count) {
            return true;
        } else {
            return false;
        }
    }

    public synchronized void plus() throws InterruptedException {
        count = count + 1;
        Thread.sleep(5000);
        System.out.println("plus" + this.count );
    }

    public synchronized void delete() {
        count = count - 1;
        System.out.println("delete" + this.count);
    }

    public static ArrayMap<String, Integer> arrayMapTest() {
        ArrayMap<String, Integer> map = new ArrayMap<>();
        map.put("1", 1);
        map.put("2", 2);
        return map;
    }


    public static void main(String[] arg) {
    }
}
