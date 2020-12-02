package kr.or.woomanup.nambu.ny.btscustomadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityDetail extends AppCompatActivity {

    TextView txtDel_main, txtDel_sub;
    ImageView imageView_Del;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtDel_main = findViewById(R.id.textView_detail_main);
        txtDel_sub = findViewById(R.id.textView_detail_sub);
        imageView_Del = findViewById(R.id.imageView_Detail);

        Intent intent = getIntent();
        BTSJava member = (BTSJava) intent.getSerializableExtra("member"); // 실제로 BTS 타입임.
        txtDel_main.setText(member.nick);
        txtDel_sub.setText(member.name);
        imageView_Del.setImageResource(member.image);

        finish();




    }
}