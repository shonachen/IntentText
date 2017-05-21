package com.example.administrator.intenttext;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Administrator on 2017/5/21.
 */

public class SecondActivity extends Activity {
    EditText etSearch,etTellPhone;
    Button btnSearch,btnTellPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        etSearch = (EditText)findViewById(R.id.et_search);
        etTellPhone = (EditText)findViewById(R.id.et_tellphone);
        btnSearch = (Button)findViewById(R.id.btn_search);
        btnTellPhone = (Button)findViewById(R.id.btn_tellphone);

        //搜索监听事件
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String search = etSearch.getText().toString();
                //intent.action_view，设置动作，Uri.parse设置要访问的数据
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + search));
                startActivity(intent);
            }
        });

        //拨打电话监听事件
        btnTellPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tellPhone = etTellPhone.getText().toString();
                //此处也可使用action.call，实现的是直接拨打电话，使用action.dial实现的是先进入电话号码输入页面，再点击拨打按钮拨打电话
                Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:" + tellPhone));
                startActivity(intent);
            }
        });

    }
}

