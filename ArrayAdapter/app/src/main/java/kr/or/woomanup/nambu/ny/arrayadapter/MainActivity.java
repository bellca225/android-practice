package kr.or.woomanup.nambu.ny.arrayadapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    String[] bts = {"RM", "진", "슈가", "제이홉", "지민", "뷔", "정국"};
    ArrayList<String> list;
    ListView listView;
//    ListView listView;

    Button btnDel , btnAdd , btndelMul;
    public static final int REQ_NEWMEMBER = 101;
    ArrayAdapter adapter;


//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ArrayList
        list = new ArrayList<>();
        for (String name : bts) {
            list.add(name);
        }

        // ListView
        listView = findViewById(R.id.listView);


        // ArrayAdapter
        adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_checked, list);
        listView.setAdapter(adapter);
//        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE); // 체크 하나만 할 수 있게 함
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE); // 체크 여러 개 할 수 있게 함

        btnDel = findViewById(R.id.btn__del);
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 삭제 버튼을 클릭했을 때 벌어지는 일
                int pos = listView.getCheckedItemPosition();
                if (pos != ListView.INVALID_POSITION) { // 유효하지 않은 포지션 -> 이걸 해야 그냥 삭제 버튼을 눌렀을 때 삭제 되지 않음
                    list.remove(pos);

                    adapter.notifyDataSetChanged(); // 데이터가 바뀌었다고 소개
//                    listView.clearChoices(); // 체크를 해지하는 코드
                }
            }
        });


        btnAdd =findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 추가 버튼을 클릭했을 때 벌어지는 일
                Intent intent = new Intent(getApplicationContext(),NewMemberActivity.class); //나는 누구인지, 어디로 갈 것인지 -> 이건 이동할 때만 필요
                startActivityForResult(intent,REQ_NEWMEMBER); // 결과 값을 받아올 경우
            }
        });

        btndelMul = findViewById(R.id.btn__del__mul);
        btndelMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 모두 삭제 버튼을 눌렀을 때 나타나는 일
                SparseBooleanArray checkedItems = listView.getCheckedItemPositions();

                // 여기서 for 문은 앞에서 부터 삭제하면 아이템의 인덱스가 변화해 정삭작동이 안 됨.
                for(int i = list.size()-1; i>-1;i--){
                    if(checkedItems.get(i)){
                        list.remove(i);
                        adapter.notifyDataSetChanged(); // 어뎁터에게 변경 사항을 전달함 늘 마지막에 꼭 넣어주기
                    }
                }
                listView.clearChoices(); // 여러개 있을 때 삭제된 아이템의 해당 인덱스들 그대로 남은 아이템에 체크가 되기에 꼭 삭제 해주어야 한다
            }
        });

    }

    // 결과 값을 받아온 후의 코드 처리 Callback Method, **Generate 할 위치는 onCreate()와 동일한 위치에서**
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) { // Intent data는 NewMember의 intent 정보에서 오는 것
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQ_NEWMEMBER){
            if(resultCode == Activity.RESULT_OK){
                String newMember = data.getStringExtra("new_member"); // NewActivity 키 값을 확인 후 널어주어라

                // 리스트 뷰에 받아온 데이터 넣어주기
                list.add(newMember);
                adapter.notifyDataSetChanged(); // 어뎁터에게 변경 사항을 전달함



                
            }

        }
    }
}


