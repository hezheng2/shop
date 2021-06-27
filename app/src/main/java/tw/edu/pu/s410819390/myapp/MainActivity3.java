package tw.edu.pu.s410819390.myapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Instant;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {


    TextView tv1;
    TextView tv2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        tv1 = findViewById(R.id.tv_1);
        tv2 = findViewById(R.id.tv_2);
        Button bt1 = findViewById(R.id.bt_1);
        bt1.setOnClickListener(this);



    }

    public String getString(){
        return "s";
    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_1:
                System.out.println("aaaaaaaaaaaaaaaaa11111111");
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("提示");
                builder.setMessage("是否登录");
                builder.setPositiveButton("确定",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //...To-do
                                if ("123".equals(tv1.getText().toString().trim()) ) {
                                    if(tv2.getText().toString().trim().equals("123")) {
                                        MainActivity4.launch(MainActivity3.this, "1234");
                                    }
                                    else{
                                        Toast.makeText(MainActivity3.this, "\"账号/密码错误", Toast.LENGTH_SHORT).show();
                                        System.out.println(tv1.getText());
                                        System.out.println(tv2.getText());
                                    }
                                }
                                else{
                                    Toast.makeText(MainActivity3.this, "\"账号/密码错误", Toast.LENGTH_SHORT).show();
                                    System.out.println(tv1.getText());
                                    System.out.println(tv2.getText());
                                }


                            }
                        });

                builder.setNegativeButton("关闭",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //...To-do
                                dialog.dismiss();
                            }
                        });
                // 显示
                builder.show();
//                Intent instant = new Intent(this, MainActivity4.class);
//                instant.putExtra("id","1234");
//                startActivity(instant);
//                MainActivity4.launch(this,"1234");
                break;
        }
    }
}