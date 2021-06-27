package tw.edu.pu.s410819390.myapp;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Click click;
    private Context mContext;
    private ArrayList<FoodBean> mDatas;

    public FoodAdapter(Context context, ArrayList<FoodBean> datas) {
        mContext = context;
        mDatas = datas;
    }

    public ArrayList<FoodBean> getData(){
        return mDatas;
    }

    @NonNull
    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_food, parent, false);
        return new NormalHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {
        NormalHolder normalHolder = (NormalHolder) holder;
        normalHolder.tv_title.setText(mDatas.get(position).getTitle());
        normalHolder.tv_money.setText(mDatas.get(position).getMoney()+"");
        normalHolder.tv_num.setText(mDatas.get(position).getNum()+"");

        normalHolder.cl_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = mDatas.get(position).getNum();
                mDatas.get(position).setNum(num+1);
                notifyDataSetChanged();
                click.click();
            }
        });

        normalHolder.tv_deal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = mDatas.get(position).getNum();
                System.out.println("ddddddddddddddd num = "+num);
                if(num == 0){
                    Toast.makeText(mContext,"请选择产品",Toast.LENGTH_SHORT).show();
                }else {
                    mDatas.get(position).setNum(num-1);
                    notifyDataSetChanged();
                    click.click();
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class NormalHolder extends RecyclerView.ViewHolder{
        public ConstraintLayout cl_home;
        public TextView tv_title;
        public TextView tv_money;
        public TextView tv_num;
        public TextView tv_deal;

        public NormalHolder(View itemView) {
            super(itemView);
            cl_home = (ConstraintLayout) itemView.findViewById(R.id.cl_home);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_money = (TextView) itemView.findViewById(R.id.tv_money);
            tv_num = (TextView) itemView.findViewById(R.id.tv_num);
            tv_deal = (TextView) itemView.findViewById(R.id.tv_deal);


        }
    }
    public void setOnClick(Click click){
        this.click = click;
    }

    public interface Click{
        void click();
    }

}
