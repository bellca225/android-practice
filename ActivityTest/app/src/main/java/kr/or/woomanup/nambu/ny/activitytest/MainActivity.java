package kr.or.woomanup.nambu.ny.activitytest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Activity 가 왔다 갔다하는 프로그램 만들 예정.
    // 서로 값을 전달하는 형식

    Button btn_main;
    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_main= findViewById(R.id.button_main);
        textView = findViewById(R.id.textView_main);
        editText = findViewById(R.id.edit_main);

        btn_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                // 앞으로 Intent 만들 때에는 getApplicationContext()를 기본으로 사용
//                intent.putExtra("num1",123);
//                intent.putExtra("num2",456);

                // 나중에 텍스트를 지워줌

                String inputText = editText.getText().toString(); // 형변환
                intent.putExtra("text",inputText);
                //결과값을 받고 싶으면 아래 함수를 사용
                startActivityForResult(intent,101); //requsetCode ..

                editText.setText("");
            }
        });
    }

    // 위치가 중요! 오버라이드에서 불러옴
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==101){
            if(resultCode== Activity.RESULT_OK){ // 정상적으로 답을 받아온 것인지 확인

                String result = data.getStringExtra("text");
                textView.setText(result);

//                int sum = data.getIntExtra("sum",0);
//                textView.setText("result:" + sum);
            }
        }
    }
}