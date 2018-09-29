package transic.scrollinterceptsample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by siqingchan on 2018/4/11.
 * mail:gonejobfindme@163.com
 */

public class BaseFragment extends Fragment {
    private TextView textView1, textView2;
    private int tag;

    public void setTag(int tag) {
        this.tag = tag;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container,false);
        textView1 = view.findViewById(R.id.text1);
        textView2 = view.findViewById(R.id.text2);
        textView1.setText("fragment" + tag);
        textView2.setText("fragment" + tag);
        view.setBackgroundColor(tag);
        view.setRotation(-90);
        return view;
    }

}
