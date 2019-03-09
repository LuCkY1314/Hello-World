package com.example.chansiqing.databindingstudy.activity;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.chansiqing.databindingstudy.R;
import com.example.chansiqing.databindingstudy.data.Entity;
import com.example.chansiqing.databindingstudy.utils.FileUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO:功能说明
 *
 * @author: chansiqing
 * @date: 2019-02-21 14:17
 */

public class PictureCatchActivity extends AppCompatActivity {
    private TextView first, second, result, sameRate, banner, sku;
    private Button collectButton, checkButton, deleteButton;
    private MyHandler myHandler;
    private MyAdapter myAdapter;
    private RecyclerView mRecyclerView;
    private List<Entity> data1, data2, data3;
    private SimpleDraweeView test;
    private int count = 0, count_banner = 0, count_sku = 0;
    private LinearLayout l_rate, l_statistics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_catch);

        first = findViewById(R.id.txv_check_first);
        second = findViewById(R.id.txv_check_second);
        result = findViewById(R.id.txv_check_result);
        sameRate = findViewById(R.id.txv_samerate);
        banner = findViewById(R.id.txv_banner);
        sku = findViewById(R.id.txv_sku);

        l_rate = findViewById(R.id.ll_rate);
        l_statistics = findViewById(R.id.ll_statistics);
        collectButton = findViewById(R.id.btn_search);
        deleteButton = findViewById(R.id.btn_delete);
        test = findViewById(R.id.test_image);
        test.setImageURI("http://img.zcool.cn/community/0117e2571b8b246ac72538120dd8a4.jpg@1280w_1l_2o_100sh.jpg");
        checkButton = findViewById(R.id.check_button);
        mRecyclerView = findViewById(R.id.recycle_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myHandler = new MyHandler();
        collectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyThread thread = new MyThread("myThread");
                thread.start();
            }
        });
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkDiff();
                if (data1 != null && data2 != null) {
                    showStatices();
                }
                if (myAdapter != null && data3 != null) {
                    myAdapter.setData(data3);
                    myAdapter.notifyDataSetChanged();
                }
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileUtils.clear(FileUtils.urlTaobao);
                if (myAdapter != null) {
                    myAdapter.setData(null);
                    myAdapter.notifyDataSetChanged();
                }
                l_rate.setVisibility(View.GONE);
                l_statistics.setVisibility(View.GONE);
                test.setVisibility(View.VISIBLE);
            }
        });
    }

    private void showStatices() {
        first.setText("first：" + (data1.size() == 0 ? 0 : count + "/" + data1.size()));
        second.setText("second：" + (data1.size() == 0 ? 0 : count + "/" + data2.size()));
        result.setText("total：" + (data1.size() == 0 ? 0 : count + "/" + data3.size()));
        sku.setText("2000~20000b：" + count_sku);
        banner.setText("20000~50000b：" + count_banner);
        l_rate.setVisibility(View.VISIBLE);
        l_statistics.setVisibility(View.VISIBLE);
        sameRate.setVisibility(View.GONE);
    }

    private void checkDiff() {
        data3 = new ArrayList<>();
        int size = 0;
        if (data1 != null && data2 != null) {
            for (Entity entity1 : data1) {
                for (Entity entity2 : data2) {
                    if (entity1.getSizeOne().equals(entity2.getSizeOne()) && entity1.getTitle().equals(entity2.getTitle())) {
                        entity1.setFlag(1);
                        entity2.setFlag(1);
                        count++;
                        size = Integer.parseInt(entity1.getSizeOne());
                        if (size > 20000 && size <= 50000)
                            count_banner++;
                        else if (size >= 2000 && size <= 20000)
                            count_sku++;
                        if (!data3.contains(entity2))
                            data3.add(entity2);
                    } else {
                        if (entity1.getTitle().equals(entity2.getTitle())) {
                            entity1.setFlag(2);
                            entity1.setSizeTwo(entity2.getSizeOne());
                            entity2.setFlag(2);
                            entity2.setSizeTwo(entity1.getSizeOne());
                            if (!data3.contains(entity2))
                                data3.add(entity2);
                        } else if (!data3.contains(entity2)) {
                            data3.add(entity2);
                        }
                    }
                }
                if (entity1.getFlag() != 1 && entity1.getFlag() != 2 && !data3.contains(entity1)) {
                    data3.add(entity1);
                }
            }
        }
    }

    public class MyHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.arg1 == 1) {
                if (msg.obj != null && msg.obj instanceof List) {
                    List<Entity> data = (List<Entity>) msg.obj;
                    collectData(data);
                }
            }
        }

        private synchronized void collectData(List<Entity> data) {
            if (data.isEmpty())
                return;
            if (data1 == null) {
                data1 = data;
            } else {
                if (data2 == null)
                    data2 = data;
                else {
                    data1 = data2;
                    data2 = data;
                }
            }
            if (myAdapter == null) {
                myAdapter = new MyAdapter(PictureCatchActivity.this, data);
                mRecyclerView.setAdapter(myAdapter);
            } else {
                myAdapter.setData(data);
                myAdapter.notifyDataSetChanged();
            }
            if (test.getVisibility() == View.VISIBLE)
                test.setVisibility(View.GONE);
        }
    }

    public class MyThread extends HandlerThread {
        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            List<Entity> result = FileUtils.getInfo(false);
            Message msg = new Message();
            msg.obj = result;
            msg.arg1 = 1;
            myHandler.sendMessage(msg);
        }
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
        private Context context;
        private LayoutInflater mInflater;
        private List<Entity> data;

        public List<Entity> getData() {
            return data;
        }

        public void setData(List<Entity> data) {
            this.data = data;
        }

        public MyAdapter(Context context, List<Entity> data) {
            this.context = context;
            this.data = data;
            mInflater = LayoutInflater.from(context);
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyViewHolder(mInflater.inflate(R.layout.item_photo, parent, false));
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            if (data == null)
                return;
            Entity entity = data.get(position);
            holder.title.setText("图片：" + entity.getPath());
            holder.image.setImageURI("file://" + entity.getPath());
            holder.sizeTv.setText("长宽为：" + entity.getWidth() + "x" + entity.getHeight());
            if (entity.getFlag() == 1) {
                holder.sizeOne.setText("大小：" + entity.getSizeOne() + "kb");
                holder.title.setTextColor(Color.RED);
            } else if (entity.getFlag() == 2) {
                holder.sizeOne.setText("first大小：" + entity.getSizeOne() + "kb");
                holder.sizeTwo.setText("second大小：" + entity.getSizeTwo() + "kb");
                holder.title.setTextColor(Color.GREEN);
            } else {
                holder.sizeOne.setText("大小：" + entity.getSizeOne() + "kb");
                holder.title.setTextColor(Color.BLACK);
            }
        }

        @Override
        public int getItemCount() {
            return data == null ? 0 : data.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            private TextView title;
            private TextView sizeOne;
            private TextView sizeTwo;
            private TextView sizeTv;
            private SimpleDraweeView image;

            public MyViewHolder(View itemView) {
                super(itemView);
                title = itemView.findViewById(R.id.title);
                sizeOne = itemView.findViewById(R.id.sizeone);
                sizeTwo = itemView.findViewById(R.id.sizetwo);
                image = itemView.findViewById(R.id.image);
                sizeTv = itemView.findViewById(R.id.size);
            }
        }
    }
}
