package chansiqing.myapplication;

/**
 * TODO:功能说明
 *
 * @author: chansiqing
 * @date: 2018-08-01 19:01
 */
public class MyThread extends Thread {
    private Ad mAd;

    public MyThread(Ad ad) {
        mAd = ad;
    }

    @Override
    public void run() {
        try {
            mAd.plus();
            System.out.println(mAd.count + "Thread B " + currentThread().getId());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
