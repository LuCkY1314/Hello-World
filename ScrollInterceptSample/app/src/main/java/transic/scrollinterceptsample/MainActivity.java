package transic.scrollinterceptsample;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private BaseFragment fragment1, fragment2, fragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewpager);
        fragment1 = new BaseFragment();
        fragment2 = new BaseFragment();
        fragment3 = new BaseFragment();
        fragment3.setTag(R.color.color3);
        fragment2.setTag(R.color.color2);
        fragment1.setTag(R.color.color1);
        List<Fragment> list = new ArrayList<>();
        list.add(fragment1);
        list.add(fragment2);
        list.add(fragment3);
        MyAdapter adapter = new MyAdapter(getSupportFragmentManager(), list);
        viewPager.setAdapter(adapter);
        viewPager.setRotation(90);
        viewPager.setCurrentItem(0);
    }
}
