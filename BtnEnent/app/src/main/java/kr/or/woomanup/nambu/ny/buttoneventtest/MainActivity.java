package kr.or.woomanup.nambu.ny.buttoneventtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView; // 전역 변수로 빼주어야 전역으로 사용 가능


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//////////////////////////////////////////////////////////////////////////
        textView = findViewById(R.id.textView001); // view ID 설정

        Button btnFirst = findViewById(R.id.btn_first); // btn ID 설정
        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("첫번째 버튼이 눌려졌습니다.");};
        });

        Button btnSecond = findViewById(R.id.btn_second);
        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("두번째 버튼이 눌렸습니다.");
            }
        });

        Button btnThird = findViewById(R.id.btn_third);
        btnThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("세번째 버튼이 눌렸습니다.");
            }
        });

        Switch sw = findViewById(R.id.switch_first);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    textView.setText("스위치가 켜졌습니다.");
            }else {
                textView.setText("스위치가 꺼졌습니다.");
                }
            }
        });

        SeekBar seekBar = findViewById(R.id.seekBar01);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView.setText(""+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                textView.setText("트래킹 시작");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textView.setText("트래킹 종료");
            }
        });


//////////////////////////////////////////////////////////////////////////
    }


}