package com.example.administrator.dialog_builder;

import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button cole_button;
    private Button Login_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
    }
    void findView(){
        cole_button = (Button)findViewById(R.id.cole_button);
        Login_button=(Button)findViewById(R.id.Login_button);
        cole_button.setOnClickListener(this);
        Login_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cole_button:{
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("没有错与对");
                builder.setTitle("你的名字");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"等一个人咖啡",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"重返20岁",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }break;
            case R.id.Login_button: {
                LayoutInflater layoutInflater = LayoutInflater.from(this);
                final View textEntryView = layoutInflater.inflate(R.layout.alertdialog_login_layout,null);

                final AlertDialog.Builder  builder = new AlertDialog.Builder(this);
                builder.setTitle("登陆");
                builder.setView(textEntryView);
                builder.setPositiveButton("登陆", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                         EditText Mes = (EditText)textEntryView.findViewById(R.id.account_Text);
                         EditText pass=(EditText)textEntryView.findViewById(R.id.password_Text);
                        String useName = Mes.getText().toString().trim();
                        String password = pass.getText().toString().trim();

                        if(useName.equals("abc")&&password.equals("123")){
                            Toast.makeText(MainActivity.this,"登陆成功",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(MainActivity.this,"登陆失败",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton("退出", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        builder.setCancelable(false);
                    }
                });
                builder.show();
            }break;
            default:break;
        }
    }
}
