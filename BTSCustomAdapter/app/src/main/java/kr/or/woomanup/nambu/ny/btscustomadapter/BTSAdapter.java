package kr.or.woomanup.nambu.ny.btscustomadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

// 템플릿 코드를 따로 빼 줌


public class BTSAdapter extends BaseAdapter { //상속 받아서 써야 함.

    View itemView;
    // 4개 다 구현
//     adapter 만들려면 리스트뷰, 레이아웃, 데이터가 필요!
    Context context;
    ArrayList<HashMap<String,Object>> members; //data
    int layout;
    // 3가지를 선언 후 Generate -> constructor

    public BTSAdapter(Context context, ArrayList<HashMap<String, Object>> members, int layout) {
        this.context = context;
        this.members = members;
        this.layout = layout;
    }
    // 3가지를 토대로 생성자 완료

    @Override
    public int getCount() {
        return members.size(); //getCount()를 호출해서 members.size()만큼 진행. 1) getCount()로 물어봄
    }

    @Override
    public Object getItem(int position) { //
        return members.get(position);
    }

    @Override
    public long getItemId(int position) { // id 가져와라
        return position;
    }

    // ********
    @Override
    public View getView(int position, View convertView, ViewGroup parent) { // view 를 반환함 , 여기서 parents 는 리스트뷰..?

        //        getView 는 재활용하는 장소, 이 때 아무것도 로딩되지 않았다면(null) 구현( implement )한다
        if(convertView == null){
//            재활용할 게 없는 상태에서는 아래처럼 구현해준다. 이 코드를 쓰면 더 효율적으로 진행
            LayoutInflater inflater = LayoutInflater.from(context); // LayoutInflater 가 실실적으로 xml을 구현해 줌
            convertView = inflater.inflate(layout,parent,false); // 만든 UI 상태를 구현만
        }

        HashMap<String, Object> member = members.get(position); // 꺼내면 해쉬맵
        String nick = (String)member.get("nick");
        String name = (String)member.get("name");
        int image = (Integer)member.get("image");

        ImageView imageView = convertView.findViewById(R.id.imageView); // BTSAdapter에서 찾는 것이기 때문에 앞에 itemView에서 참고해야함
        TextView txtNick = convertView.findViewById(R.id.txt_nick_item);
        TextView txtName = convertView.findViewById(R.id.txt_name_item);

        // 각각의 아이템마다 값을 넣어주는 코드
        txtNick.setText(nick);
        txtName.setText(name);
        imageView.setImageResource(image);

        return convertView;
    }
}
