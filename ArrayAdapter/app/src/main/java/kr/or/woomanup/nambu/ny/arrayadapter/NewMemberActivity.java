package kr.or.woomanup.nambu.ny.arrayadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewMemberActivity extends AppCompatActivity {

    EditText editTxt;
    Button btnAdd__new;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_member);

        editTxt = findViewById(R.id.editTxt);
        btnAdd__new = findViewById(R.id.btn__add__new);

        Intent intent = getIntent();

        btnAdd__new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newMember= editTxt.getText().toString(); // editText 형식을 String 으로 바꿔주는 것 -> toString

                try {
                    Intent intent = new Intent(); // 이 페이지는 다음으로 넘어지 않기 때문에 매개변수가 필요 없다.
                    intent.putExtra("new_member", newMember);
                    setResult(Activity.RESULT_OK, intent); //
                } catch (Exception e){
                    setResult(Activity.RESULT_CANCELED);
                }

                finish();
            }
        });



    }
}