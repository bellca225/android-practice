package kr.or.woomanup.nambu.ny.listviewtest2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[] bts = {"RM","진","슈가","제이홉","지민","뷔","정국"};
    String[] names = {"김남준","김석진","민윤기","정호석","박지민","김태형","전정국"};

    ArrayList<HashMap<String,String>> list;

    ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        HashMap<String, string>
//        ArrayList<HashMap><String, string>

        //List<>//리스트 상속받기, 리스트는 추상 클래스라 리스트 만으로 사용 불가함, 이를 구현 한 것이 Qeue, ArrayList...
        //HashMap<String -> 키의 자리,키는 스트링이어야 한다는 뜻, String -> 데이터의 자리, 데이터는 스트링이라느 뜻>

//        ArrayList<HashMap<String, String>> members = new ArrayList<>();
//
//        for(int i =0; i<bts.length; i++){
//            HashMap<String, String> map = new HashMap<>(); //데이터가 비어있는 해쉬맵이 하나 만들어짐
//            map.put("nick",bts[i]);
//            map.put("name",names[i]);
//            members.add(map);
////            해쉬 맵이 어레이 리스트에 딱딱 들어간다.
//        }

//        ArrayList<HashMap<String,String>> list = new ArrayList<>();
        //어레이 리스트 안에 맵을 상속 받는 해쉬맵이 들어감

        list = new ArrayList<>();

        for(int i=0; i<bts.length;i++){
            HashMap<String, String> map = new HashMap<>();
            map.put("nick",bts[i]);
            map.put("name",names[i]);
            list.add(map);
        }

//        규칙
        String[] keys = {"nick","name"}; // String[]이 들어가야 함
        int[] ids = { android.R.id.text1, android.R.id.text2 };

        listView = findViewById(R.id.listView);
        SimpleAdapter adapter = new SimpleAdapter(this , list , android.R.layout.simple_list_item_2,keys,ids);
        //생성자 한 개 있는 상태
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new ItemClickListener());
    }

    class ItemClickListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            HashMap<String,String> member = list.get(position);
            String nick = member.get("nick");
            String name = member.get("name");

            Toast.makeText(MainActivity.this, nick+":"+name,Toast.LENGTH_SHORT).show();
        }
    }
}