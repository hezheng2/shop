package tw.edu.pu.s410819390.myapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn:Button = findViewById(R.id.btn)
        btn.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                if(txv.text contentEquals "123" && txv1.text contentEquals "123" ) {
                    intent = Intent(this@MainActivity, MainActivity2::class.java)
                    startActivity(intent)
                }
                else
                    txv2.text="登陆失败"
            }
            fun add(v:View){
                
            }
        })

    }
}