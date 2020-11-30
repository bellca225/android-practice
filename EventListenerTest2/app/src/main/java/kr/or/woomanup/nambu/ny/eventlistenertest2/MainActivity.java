package kr.or.woomanup.nambu.ny.eventlistenertest2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SearchView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    // 전역 변수 (멤버 변수)

    TextView  hello;

    Switch sw;
    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    ToggleButton toggleButton;
    SearchView searchBar;
    SeekBar seekBar;

    Button button1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /////////////////////////////////////////////////////////////////
        hello = findViewById(R.id.hello);

        sw = findViewById(R.id.switch1);
        sw.setText("스위치 입니다.");
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // CompoundButton buttonVie = switch
                if(isChecked){
                    hello.setText("켜짐");
                }else {
                    hello.setText("꺼짐");
                }
            }
        });

        checkBox1 = findViewById(R.id.checkBox1);
        checkBox1.setText("체크 박스 1입니다.");
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    hello.setText("체크 박스1을 체크하셨습니다");
                }else {
                    hello.setText("체크 박스1 체크를 해제하셨습니다");
                }
            }
        });

        checkBox2 = findViewById(R.id.checkBox2);
        checkBox2.setText("체크 박스 2입니다.");
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    hello.setText("체크 박스2을 체크하셨습니다");
                }else {
                    hello.setText("체크 박스2 체크를 해제하셨습니다");
                }
                
            }
        });

        checkBox3 = findViewById(R.id.checkBox3);
        checkBox3.setText("체크박스 3입니다.");

        toggleButton = findViewById(R.id.toggleButton);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    hello.setText("안녕!");

                }else{
                    hello.setText("잘가~");
                }
            }
        });

        searchBar = findViewById(R.id.searchBar);

        searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) { // 검색 버튼 누른 시점의 키워드가 나옴
                hello.setText(query+" 을/를 검색하셨습니다.");
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) { //바뀐 문자 열이 나옴
//                hello.setText(newText+" 입력 중입니다");
                return false;
            }
        });

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        BtnClickListener listener = new BtnClickListener(); //하나로 여러개 관리..

        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);



        seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // SeekBar seekBar = 이벤트 발생 시킨 것, int progress = 진행된 숫자, boolean fromUser = 내가 초기값 지정하기 +  alpha (ex. 중앙에 바를 두게 함)
//                hello.setText("현재 값은 "+progress+"입니다"); // progress 값 찍어주기
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
//                hello.setText("트래킹 시작");
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                hello.setText(seekBar.getProgress()+"트래킹 종료"); // 현재 seek_bar 의 progress 를 get 하는 함수.
            }
        });
        /////////////////////////////////////////////////////////////////



    }

    class BtnClickListener implements View.OnClickListener{ // inner class
        @Override
        public void onClick(View v) {
            int id = v.getId(); // 넘어온 변수값 => 여기서는 button1의 아이디를 가리킴
            if (id == R.id.button1){
                hello.setText("Hi! I'm Button1");
            }else if(id == R.id.button2){
                hello.setText("Hi! I'm Button2");
            }else{

            }
        }
    }


}

