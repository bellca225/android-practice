package kr.or.woomanup.nambu.ny.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    Button btn;
    int sum;
    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        Intent intent = getIntent();
//        int num1 = intent.getIntExtra("num1",0); // 디폴트는 0 -> 만약 num1이 없을 경우 0..
//        int num2 = intent.getIntExtra("num2",0);
//        sum = num1 + num2; //sum 값을 mainActivity 로 보내야 함. 그래서 Intent 필요

        String text = intent.getStringExtra("text");
        textView = findViewById(R.id.textView_sub);
        textView.setText(text);
        editText =findViewById(R.id.edit_sub);

        btn = findViewById(R.id.button_sub);
        btn.setOnClickListener(new View.OnClickListener() { // 익명 함수
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent();
//                intent1.putExtra("sum",sum); // "변수명", 키
                String resultText = editText.getText().toString();
                intent1.putExtra("text",resultText);
                setResult(Activity.RESULT_OK,intent1); // 정상적으로 들어갔다는 뜻
                finish();// 본인 Activity가 닫힘
            }
        });
    }
}