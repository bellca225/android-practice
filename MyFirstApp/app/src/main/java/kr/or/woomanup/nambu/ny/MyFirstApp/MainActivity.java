package kr.or.woomanup.nambu.ny.MyFirstApp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int l;
    TextView textView; // 전역 변수로 빼주기

    /* getter , setter
    private int age; // 외부에서 접근 못하게 함. 나이는 함부로 수정할 수 없게 설정

    public void setAge(int age) { // age를 초기에 설정해줌
        // Setter
        if(age<=0) {return;}
        this.age = age;
    }

    public int getAge() {
        // Getter
        return age;
    }
    */


    @Override
    protected void onCreate(Bundle savedInstanceState) { //psvm 대신 onCreate 사용
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // res\layout\activity_main.xml 을 열어서 화면 구성해라 , 참조변수가 필요

        textView = findViewById(R.id.textView); // 예전에는 형변환을 해줬어야 하나,(textView) 지금은 필요 없음.
        textView.setText("안녕, 난 내가 추가한 내용이야!");
        textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER); // 우축정렬

        String text = textView.getText().toString(); // toString() 까지 해주어야 함

        Button button = findViewById(R.id.button12);
        button.setText("내가 지정한 버튼");

        Button button2 = findViewById(R.id.button13);
        button2.setText("두번째로 지정한 버튼");

//        button.setTextAlignment(View.TEXT_ALIGNMENT_CENTER); // 사실 버튼 같은 것은 내용이 잘 바뀌지 않으니 그냥 layout 서 처리해도 됨

        BtnOnClickListener listener = new BtnOnClickListener();
        button.setOnClickListener(listener); // 너의 listener 는 누구다(() 안의 listener ) 라고 알려줌

        BtnOnClickListner2 listner2 = new BtnOnClickListner2();
        button2.setOnClickListener(listner2);


        Button btnthird = findViewById(R.id.btn_third);
        btnthird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("버튼3이 눌려졌습니다");
            }
        }); // 좀 더 간결한 방식.
        
    }

    // 가장 간단한 방식
    public void onClick (View view){ // layout\activity_main.xml의 Attributes의 Commom Atribute의 onClick 방식을 넣어줍니다,
        textView.setText("가장 간단한 버튼 누루기 방식입니다.");
    }
    // 중요한 것은 View 형이 view 형이여야 합니다. ex. int 안 됨

    class BtnOnClickListener implements View.OnClickListener {
        //Generate > Implements ..
        @Override
        public void onClick(View v) {
            l = 10; // inner class 로 l에 접근 가능.
            textView.setText("첫번째 버튼이 눌려졌습니다.");

        }
}

    class BtnOnClickListner2 implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            textView.setText("두번째 버튼이 눌려졌습니다.");
        }
    }


}