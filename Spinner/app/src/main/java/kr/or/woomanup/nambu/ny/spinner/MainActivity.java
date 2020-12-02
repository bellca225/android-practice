package kr.or.woomanup.nambu.ny.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    String[] bts = {"RM", "진", "슈가", "제이홉", "지민", "뷰", "정국"};
    TextView textView;
    Spinner spinner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = findViewById(R.id.textView);
        spinner = findViewById(R.id.spinner);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,bts);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textView.setText(bts[position]+"이/가 선택되었습니다");
                // 아이템이 선택 됐을 때
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // 아무것도 선택 안 헸을 때
                textView.setText(" ");
            }
        });
    }
}