package kr.or.woomanup.nambu.ny.listviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] bts = {"RM","진","슈가","제이홉","지민","뷔","정국"};
//    String[] idle = {"소연","미연","슈화","수진","민니","우기"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView); // 실제 처리는 어뎁터가 처리

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, bts);
        // adapter 에는 데이터와 레이아웃이 필요, contenxt 에서는 내가 누구인지 알려줌 this ->는 main activity class를 가리킴
        // android.R.layout 는 기본적으로 안드로이드가 가지고 있는 레이아웃, 여러가지 옵션이 있음
        // 마지막으로 데이터 -> 배열인 bts 를 가져 옴
        listView.setAdapter(adapter); // listView 의 Adapter 는 방금 만든 adapter 라고 알려줌.
        Toast.makeText(this,"테스트",Toast.LENGTH_SHORT).show();
//        item을 클릭할 때


//        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//        };
//        listView.setOnItemClickListener(listener);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//        });
//위의 코드와 동일


//        listView = findViewById(R.id.listView);
//        ArrayAdapter adapter_idle = new ArrayAdapter(this, android.R.layout.simple_list_item_1,idle);
//        listView.setAdapter(adapter_idle);
        ItemClickListener listener = new ItemClickListener();
        listView.setOnItemClickListener(listener);

    }

    class ItemClickListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // parent -> listView 가 넘어옴, view-> itemView 가 넘어옴, position ->몇번째 아이템이 선택되었는지 알려줌
            System.out.println(bts[position]);
//            Toast toast = Toast.makeText(MainActivity.this,bts[position],Toast.LENGTH_SHORT);
            // context-> 안드로이드 운영 체제에게 내가 누구다. 라고 알려줌,  나올 내용 , 보여주는 시간
//            toast.show();
            Toast.makeText(MainActivity.this,bts[position],Toast.LENGTH_LONG).show();





        }
    } // 익명 클래스 사용 시
}