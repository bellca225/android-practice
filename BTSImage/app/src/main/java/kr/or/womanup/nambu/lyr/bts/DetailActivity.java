package kr.or.womanup.nambu.lyr.bts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    ImageView imageView;
    TextView txtNick;
    TextView txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageView = findViewById(R.id.imageView_detail);
        txtNick = findViewById(R.id.txt_nick_detail);
        txtName = findViewById(R.id.txt_name_detail);

        Intent intent = getIntent(); //넘어오는 intent 를 받아오는 것이라 new 가 아닌 getIntent() 를 써야 함!

        String nick = intent.getStringExtra("nick");
        String name = intent.getStringExtra("rname");
        int image = intent.getIntExtra("image",0); //실패 했을 때 가져오는 값을 따로 가져옴

        txtNick.setText(nick);
        txtName.setText(name);
        imageView.setImageResource(image);


    }
}