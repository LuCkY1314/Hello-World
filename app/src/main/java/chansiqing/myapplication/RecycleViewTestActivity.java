package chansiqing.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO:功能说明
 *
 * @author: jd
 * @date: 2018-09-19 14:34
 */
public class RecycleViewTestActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<Entity> mEntities = new ArrayList<>();
    private Button testBtn;
    private EditText mEditText;
    private MyAdapter mAdapter;
    private Handler mHandler = new Handler();
    private int times;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mRecyclerView = findViewById(R.id.recycle_view);
        testBtn = findViewById(R.id.test_btn);
        mEditText = findViewById(R.id.edit);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        testBtn.setOnClickListener(view -> testStart());
        initData();
    }

    private void testStart() {
        Log.d("testActivity", "开始实验");
        try {
            times = Integer.valueOf(mEditText.getText().toString());
        } catch (Exception e) {
        }
        for (int i = 0; i < (times != 0 ? times : 1000); i++) {
            int finalI = i;
            new Thread(() -> changeData(finalI)).start();
        }
    }

    private void initData() {
        for (int i = 0; i < 22; i++) {
            Entity entity = new Entity("title" + i, "size" + i, "path" + i);
            mEntities.add(entity);
        }
        mAdapter = new MyAdapter(this);
        mAdapter.setData(mEntities);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void changeData(int i) {
        mHandler.post(() -> {
            mAdapter.clear();
            mAdapter.setData(mEntities);
            Log.d("testActivity", i + 1 + "");
            if (i == times) {
                Log.d("testActivity", "实验结束");
            }
        });
    }
}
