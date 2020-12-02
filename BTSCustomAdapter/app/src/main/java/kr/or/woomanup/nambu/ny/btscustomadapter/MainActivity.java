package kr.or.woomanup.nambu.ny.btscustomadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    String[] bts = {"RM", "진", "슈가", "제이홉", "지민", "뷰", "정국"};
    String[] names = {"김남준", "김석진", "민윤기", "정호석", "박지민", "김태형", "전정국"};
    int[] ids = {R.drawable.bts1, R.drawable.bts2, R.drawable.bts3, R.drawable.bts4, R.drawable.bts5, R.drawable.bts6, R.drawable.bts7};
    ListView listView;

    // BTSjava 를 만들면 해쉬맵을 안써도 된다.
//    ArrayList<HashMap<String,Object>> list;
    ArrayList<BTSJava> list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();


        for(int i=0;i<bts.length;i++){
//            HashMap<String,Object> map = new HashMap<>();
//            map.put("nick",bts[i]);
//            map.put("name",names[i]);
//            map.put("image",ids[i]);
//            list.add(map);
            BTSJava member = new BTSJava(bts[i],names[i],ids[i]);
            list.add(member);
        }

        listView = findViewById(R.id.listView);
        BTSAdapter adapter = new BTSAdapter(this,list,R.layout.layout_first);

        listView.setAdapter(adapter); // 실행만 해준 단계.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 익명함수로 작동하는 곳, 페이지를 이동시킴
                Intent intent = new Intent(getApplicationContext(), ActivityDetail.class);

                // 데이터 보내기
                BTSJava member = list.get(position);
                intent.putExtra("member",member);


                startActivity(intent);

            }
        });

    }

}


