package kr.or.woomanup.nambu.ny.eventlistenertest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView text1; // 전역 변수로 만들기, 전역변수로 만들면 아래에서 (textView) 이런 식으로 형변환 하지 않아도 됨.
    // 이건 화면을 가리킴

    Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        객체가 만들어진 주소 값이 필요함. 참조 변수 TextView 만들어서 가져와야 함

//        TextView text1 = findViewById(R.id.textView1); 여기서 Text를 전역 변수로 바꿨기 때문에 형 변환을 하지 않아야 한다
        text1 = findViewById(R.id.textView1);
        //id로 View를 찾아줌. R이라는 클래스와 id 라는 클래스를 내부적으로 생성, 이 안에는 모든 정보가 있음. 그중  id textView01을 골라라
        text1.setText("첫번째 TextView");
        Button button1 = findViewById(R.id.button1);
        button1.setText("첫번째 버튼을 눌러보세요");

        BtnOnClickListener listener = new BtnOnClickListener(); // 아래 있던  BtnOnClickListener 사용. 두번째
        button1.setOnClickListener(listener); //listener // 너의 listener 는 누구다(() 안의 listener ) 라고 알려줌 3번째
        
        Button button2 = findViewById(R.id.button2);
        button2.setText("두번째 버튼입니다.");

        // 익명 클래스 사용2===================================================================
        View.OnClickListener listener2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText("버튼 2가 눌렸습니다.");
            }
        };
        button2.setOnClickListener(listener2);
        // 익명 클래스 사용2===================================================================


        Button button3 = findViewById(R.id.button3);
        button3.setText("마지막 버튼");

        // 익명 클래스 사용3===================================================================
        View.OnClickListener listener3 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText("버튼 3가 눌렸습니다.");
            }
        };
        button3.setOnClickListener(listener3);
        // 익명 클래스 사용3===================================================================

        button4 = findViewById(R.id.button4);


    }


    public void onClcik(View v){
        // View 형의 타입이 하나 만들어져야 함. v는 그냥 변수
        text1.setText("버튼 4가 눌려졌습니다."); // 이후 layout에 가서 onClcik의 onClcik 설정
        button4.setText("버튼4가 눌렸습니다."); //button4도 맴버변수(전역 변수)로 변화해봄

    }

    // button1 방식으로 만들 때 이걸 만들어줘야 함.  //onClickLestner를 구현해야 함 이게 첫번째!
    class BtnOnClickListener implements View.OnClickListener{
        // 양이 많으면 class를 MainActivity 파일 밖으로 뺄 수도 있음, 잘 그러진 않음.
        // 이걸 MainActivity 안에서 정의 할 수도 있음. 그럼 맴버 변수를 같이 쓸 수도 있음.(inner, 중첩 클래스) 상황에 따라 진행
        // 추상 메소드 -> 메소드의 형만 있는 경우, 구현 없이 선언만 있는 것! 이게 하나 이상 있으면 추상 클래스,

        // = 추상 메소드가 하나 이상 포함되면 반드시 추상 클래스로 선언되어야 한다.
        // 추상 클래스의 특징은 그대로 사용할 수 없고 꼭 상속을 받아야 한다.
        // 반드시 추상 클래스를 *상속하는 자식 클래스에서 부모가 가진 추상 메소드를 모두 오버라이딩* 해야 한다.
        // 추상 클래스에서 추상 메소드가 아닌 일반 메소드를 포함시킬 수 있다.

    /*추가로 추상 클래스는, 상속 관계에서 어느 메소드를 오버라이딩 할 때 사용.
     다음은 추상 클래스를 선언하는 방법입니다. (abstract)

    abstract 클래스명 {
        ...
        abstract void 메소드명();
    }
     자식 클래스들의 특징이 서로 다를때 메소드를 미완성 메소드로 남겨두어 부모 클래스를 상속한 자식 클래스에서 각각의 기능을 구현할수 있도록 함/
     */

        // interface -> 추상 메소드랑 비슷하지만 클래스가 아님, 둘을 구분함. interface 도 구현 없이 선언만 있음
        // implements -> 구현 한다는 뜻.

        public void onClick(View v) { // 구현하기 시작
            text1.setText("버튼 1이 눌러졌어요");
        }
    };


//    class Btn2OnClickListener implements View.OnClickListener{
//
//        public void onClick(View v) { // 구현하기 시작
//            text1.setText("버튼 2가 눌러졌어요");
//        }
//    };

}

