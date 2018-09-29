package chansiqing.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private LayoutInflater mInflater;
    private List<Entity> data=new ArrayList<>();

    public List<Entity> getData() {
        return data;
    }

    public void setData(List<Entity> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public void clear() {
        data.clear();
    }

    public MyAdapter(Context context, List<Entity> data) {
        this.context = context;
        this.data = data;
        mInflater = LayoutInflater.from(context);
    }

    public MyAdapter(Context context) {
        this.context = context;
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