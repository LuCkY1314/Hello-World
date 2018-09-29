package chansiqing.myapplication;

import android.support.v4.util.ArrayMap;

/**
 * TODO:功能说明
 *
 * @author: chansiqing
 * @date: 2018-07-30 17:16
 */
public class MaidianData {
    public String id;
    public ArrayMap<String, Integer> map = new ArrayMap<>();

    public MaidianData(String id, ArrayMap<String, Integer> map) {
        this.id = id;
        this.map = map;
    }
}
