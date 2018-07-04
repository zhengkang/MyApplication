package xiangqing.hulian.com.myapplication.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;

import java.util.List;

import xiangqing.hulian.com.myapplication.R;

/**
 * Created by Administrator on 2018/6/26.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements View.OnClickListener {

    private List<String> dataList;
    private Context context;

    public MyAdapter(List<String> dataList,Context context){
        this.dataList=dataList;
        this.context=context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(
                context).inflate(R.layout.item, parent,
                false);
        MyViewHolder holder = new MyViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.itemView.setTag(position);
        /*LayoutParams lp = holder.textView.getLayoutParams();
        lp.height = (int) (100 + Math.random() * 300);

        holder.textView.setLayoutParams(lp);*/
        holder.textView.setText(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public void onClick(View view) {
        onitemclick.onItemClick(view, (Integer) view.getTag());
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.text);
        }
    }


    public void refresh(List<String> dataList){
        this.dataList=dataList;
        notifyDataSetChanged();
    }
    private OnItemClickListener onitemclick;

    public void setItenClick(OnItemClickListener onitemclick){
        this.onitemclick=onitemclick;
    }

    public interface OnItemClickListener {
        void onItemClick(View view,int position);
    }
}
