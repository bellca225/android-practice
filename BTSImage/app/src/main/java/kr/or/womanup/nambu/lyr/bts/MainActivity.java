package kr.or.womanup.nambu.lyr.bts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    String[] bts = {"RM", "진", "슈가", "제이홉", "지민", "뷰", "정국"};
    String[] names = {"김남준", "김석진", "민윤기", "정호석", "박지민", "김태형", "전정국"};
    int[] ids = {R.drawable.bts1, R.drawable.bts2, R.drawable.bts3, R.drawable.bts4, R.drawable.bts5, R.drawable.bts6, R.drawable.bts7};
    ListView listView;

    ArrayList<HashMap<String, Object>> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);

//        HashMap<String, Object>
//        ArrayList<HashMap<String, Object>>
         list = new ArrayList<>();

        for(int i=0;i<bts.length;i++){
            HashMap<String, Object> map = new HashMap<>(); // Obj -> 이미지도 들어가야 하기에 숫자와 문자가 들어가는 Obj로 설정
            map.put("nick", bts[i]); //HashMap의 특징 : 사전처럼 데이터를 관리, key(label),value => "nick",bts[i]
            // map.get("나이"); // 나이에 해당하는 숫자가 나온다.

            map.put("name", names[i]);
            map.put("image", ids[i]);

            list.add(map);
        }

        String[] from = {"nick", "name", "image"};
        int[] to = {R.id.txt_nick_item, R.id.txt_name_item, R.id.imageView_item};
        SimpleAdapter adapter =
                new SimpleAdapter(this, list, R.layout.layout_item, from, to);
        listView.setAdapter(adapter);

        ItemClickListener listener = new ItemClickListener();
        listView.setOnItemClickListener(listener);
    }

    class ItemClickListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            HashMap<String, Object> map = list.get(position);
            String nick = (String) map.get("nick"); // nick는 현재 Obj이기에 Str로 형변환을 해줘야 함!
            String name = (String)map.get("name");
            int image = (Integer) map.get("image"); // img가 obj 타입이기에 intger로 바꿔줘야 함
            // auto unboxing

            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            // MainActivity.this,는 현재 위치, DetailActivity.class 는 넘어갈 위치
            //들어가는 자리값의 타입이 class 라 .class 를 넣어주어야 한다.
            intent.putExtra("nick",nick); // 앞의 nick 은 매개변수 명칭, 오른쪽은 실제 값.
            intent.putExtra("rname",name);
            intent.putExtra("image",image);
            // 인텐트에 이런 3가지 정보를 넣어준다..

            startActivity(intent); //  새로 Activity를 만들라는 뜻..

        }
    }
}