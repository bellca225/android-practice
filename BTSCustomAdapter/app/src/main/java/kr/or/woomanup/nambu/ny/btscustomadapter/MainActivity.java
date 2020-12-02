package kr.or.woomanup.nambu.ny.btscustomadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    String[] bts = {"RM", "진", "슈가", "제이홉", "지민", "뷰", "정국"};
    String[] names = {"김남준", "김석진", "민윤기", "정호석", "박지민", "김태형", "전정국"};
    int[] ids = {R.drawable.bts1, R.drawable.bts2, R.drawable.bts3, R.drawable.bts4, R.drawable.bts5, R.drawable.bts6, R.drawable.bts7};
    ListView listView;

    ArrayList<HashMap<String,Object>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        for(int i=0;i<bts.length;i++){
            HashMap<String,Object> map = new HashMap<>();
            map.put("nick",bts[i]);
            map.put("name",names[i]);
            map.put("image",ids[i]);
            list.add(map);
        }

        listView = findViewById(R.id.listView);
        BTSAdapter adapter = new BTSAdapter(this,list,R.layout.layout_first);
        listView.setAdapter(adapter); // 실행만 해준 단계.


    }
}


