package com.letscombine.jsonparsing.jsonparsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private Button btnSumit;
    private TextView text;
    private String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSumit = (Button)findViewById(R.id.btnSumit);
        text = (TextView)findViewById(R.id.text);
        btnSumit.setOnClickListener(mOnClickListner);


         str =
                "[{'name':'배트맨','age':43,'address':'고담'},"+
                        "{'name':'슈퍼맨','age':36,'address':'뉴욕'},"+
                        "{'name':'앤트맨','age':25,'address':'LA'}]";


    }

    Button.OnClickListener mOnClickListner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                JSONArray jarray = new JSONArray(str);
                StringBuffer sb = new StringBuffer();

                for(int i=0; i < jarray.length(); i++){
                    JSONObject jObject = jarray.getJSONObject(i);  // JSONObject 추출
                    String address = jObject.getString("address");
                    String name = jObject.getString("name");
                    int age = jObject.getInt("age");

                    sb.append(
                            "주소:" + address + ", " +
                            "이름:" + name + ", " +
                            "나이:" + age + "\n"
                    );
                }
                    text.setText(sb.toString());

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    };
}
