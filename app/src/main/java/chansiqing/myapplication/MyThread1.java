package chansiqing.myapplication;

/**
 * TODO:功能说明
 *
 * @author: chansiqing
 * @date: 2018-08-01 19:04
 */
public class MyThread1 extends Thread {
    private Ad ad;

    public MyThread1(Ad ad) {
        this.ad = ad;
    }

    @Override
    public void run() {
        ad.delete();
        System.out.println(ad.count + "Thread A " + currentThread().getId());
    }
}
