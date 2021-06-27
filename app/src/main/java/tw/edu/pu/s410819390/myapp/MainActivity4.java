package tw.edu.pu.s410819390.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {
    RecyclerView lv_list;
    TextView tv_sum;
    FoodAdapter adapter;
    ArrayList<FoodBean> foodBeanList = new ArrayList<FoodBean>() {};

    public static final void launch(Context context,String id){
        Intent intent = new Intent(context, MainActivity4.class);
        intent.putExtra("id",id);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        String id = getIntent().getStringExtra("id");
        System.out.println("id = "+id);
        lv_list = (RecyclerView)findViewById(R.id.lv_list);
        tv_sum = (TextView)findViewById(R.id.tv_sum);
        //线性布局
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        lv_list.setLayoutManager(linearLayoutManager);
        addData();
        adapter = new FoodAdapter(this,foodBeanList);
        lv_list.setAdapter(adapter);
        adapter.setOnClick(new FoodAdapter.Click() {
            @Override
            public void click() {
                ArrayList<FoodBean> data = adapter.getData();
                int sum = 0;
                for (FoodBean foodBean :data){
                    int i = foodBean.getNum()*foodBean.getMoney();
                    sum = sum+i;
                }
                tv_sum.setText("合计："+sum);
            }
        });



    }

    public void addData(){
        FoodBean foodBean1 = new FoodBean("香肠", 0, 2);
        FoodBean foodBean2 = new FoodBean("鸡翅", 0, 5);
        FoodBean foodBean3 = new FoodBean("可乐", 0, 3);
        foodBeanList.add(foodBean1);
        foodBeanList.add(foodBean2);
        foodBeanList.add(foodBean3);

    }
}