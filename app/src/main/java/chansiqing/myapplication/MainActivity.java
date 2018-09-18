package chansiqing.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    private TextView text, left, right;
    private Button mButton, checkButton;
    private MyHandler myHandler;
    private MyAdapter myAdapter, myAdapter2;
    private RecyclerView mRecyclerView, mRecyclerView2;
    private boolean flag;
    private List<Entity> data1, data2;
    private SimpleDraweeView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.text);
        left = findViewById(R.id.left);
        right = findViewById(R.id.right);
        mButton = findViewById(R.id.button);
        test = findViewById(R.id.test_image);
        test.setImageURI("http://img.zcool.cn/community/0117e2571b8b246ac72538120dd8a4.jpg@1280w_1l_2o_100sh.jpg");
        checkButton = findViewById(R.id.check_button);
        mRecyclerView = findViewById(R.id.recycle_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView2 = findViewById(R.id.recycle_view2);
        mRecyclerView2.setLayoutManager(new LinearLayoutManager(this));
        MyThread myThread = new MyThread("myThread");
        myHandler = new MyHandler();
        myThread.start();
        mButton.setOnClickListener(v -> {
            MyThread thread = new MyThread("myThread");
            thread.start();
        });
        checkButton.setOnClickListener(v -> {
            int count = checkDiff();
            if (data1 != null & data2 != null) {
                left.setText("相同比例：" + (data1.size() == 0 ? 0 : count + "/" + data1.size()));
                right.setText("相同比例：" + (data2.size() == 0 ? 0 : count + "/" + data2.size()));
            }
            if (myAdapter2 != null && myAdapter != null) {
                myAdapter.notifyDataSetChanged();
                myAdapter2.notifyDataSetChanged();
            }
        });
    }

    private int checkDiff() {
        int count = 0;
        if (data1 != null && data2 != null) {
            for (Entity entity1 : data1) {
                for (Entity entity2 : data2) {
                    if (entity1.getSize().equals(entity2.getSize()) && entity1.getTitle().equals(entity2.getTitle())) {
                        entity1.setFlag(1);
                        entity2.setFlag(1);
                        count++;
                        break;
                    } else if (entity1.getTitle().equals(entity2.getTitle())) {
                        entity1.setFlag(2);
                        entity2.setFlag(2);
                        break;
                    }
                }
            }
        }
        return count;
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
            if (!flag) {
                data1 = data;
                if (myAdapter == null) {
                    myAdapter = new MyAdapter(MainActivity.this, data);
                    mRecyclerView.setAdapter(myAdapter);
                } else {
                    myAdapter.setData(data);
                    myAdapter.notifyDataSetChanged();
                }
            } else {
                data2 = data;
                if (myAdapter2 == null) {
                    myAdapter2 = new MyAdapter(MainActivity.this, data);
                    mRecyclerView2.setAdapter(myAdapter2);
                } else {
                    myAdapter2.setData(data);
                    myAdapter2.notifyDataSetChanged();
                }
            }
            flag = !flag;
        }
    }

    public class MyThread extends HandlerThread {
        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            List<Entity> result = FileUtils.getInfo();
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
            holder.size.setText("大小：" + entity.getSize() + "bytes");
            holder.image.setImageURI("file://" + entity.getPath());
            holder.image.setScaleType(ImageView.ScaleType.FIT_XY);
            if (entity.getFlag() == 1) {
                holder.title.setTextColor(Color.RED);
            } else if (entity.getFlag() == 2) {
                holder.title.setTextColor(Color.GREEN);
            } else {
                holder.title.setTextColor(Color.BLACK);
            }
        }

        @Override
        public int getItemCount() {
            return data == null ? 0 : data.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            private TextView title;
            private TextView size;
            private SimpleDraweeView image;

            public MyViewHolder(View itemView) {
                super(itemView);
                title = itemView.findViewById(R.id.title);
                size = itemView.findViewById(R.id.size);
                image = itemView.findViewById(R.id.image);
            }
        }
    }
}
