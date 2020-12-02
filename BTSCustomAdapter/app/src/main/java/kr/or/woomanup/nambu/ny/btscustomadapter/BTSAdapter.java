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

//    View itemView;
    // 4개 다 구현
//     adapter 만들려면 리스트뷰, 레이아웃, 데이터가 필요!

    Context context;
    ArrayList<BTSJava> members; //data HashMap<String,Object> -> BTSjava
    int layout;
    // 3가지를 선언 후 Generate -> constructor

    public BTSAdapter(Context context, ArrayList<BTSJava> members, int layout) { //HashMap<String, Object> -> BTSjava
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
    } // 우리가 많이 씀

    @Override
    public long getItemId(int position) { // id 가져와라
        return position;
    }

    // ********
    @Override
    public View getView(int position, View convertView, ViewGroup parent) { // view 를 반환함
        // 리스트뷰가 겟 뷰를 담음 -> convertView 는 재활용할 것이 있으면 담아 줌,
        // 화면 상에 안보이는 부분을 재활용 통에 담아두고 이걸 필요할 때마다 사용함

        ViewHolder holder;

        BTSJava member = members.get(position); // 꺼내면 해쉬맵 HashMap<String, Object> -> BTSjava
        String nick =member.nick;
        String name =member.name;
        int image = member.image;

//        String nick = (String)member.get("nick");
//        String name = (String)member.get("name");
//        int image = (Integer)member.get("image");

        //        getView 는 재활용하는 장소, 이 때 아무것도 로딩되지 않았다면(null) 구현(implement)한다

        if(convertView == null){
//            재활용할 게 없는 상태에서는 아래처럼 구현해준다. 이 코드를 쓰면 더 효율적으로 진행
            LayoutInflater inflater = LayoutInflater.from(context); // LayoutInflater 가 실실적으로 xml 을 구현해 줌
            convertView = inflater.inflate(layout,parent,false); // 만든 UI 상태를 구현만 함
            // holder에 저장 되어 있음
            holder = new ViewHolder();
            holder.txtNick=convertView.findViewById(R.id.txt_nick_item);
            holder.txtName=convertView.findViewById(R.id.txt_name_item);
            holder.imageView=convertView.findViewById(R.id.imageView_item);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();

        }

        // 3개의 참조값, 이 부분 많이 가져오면 부하가 많이 걸림b -> 그래서 holder
//        ImageView imageView = convertView.findViewById(R.id.imageView_item); // BTSAdapter에서 찾는 것이기 때문에 앞에 itemView에서 참고해야함
//        TextView txtNick = convertView.findViewById(R.id.txt_nick_item);
//        TextView txtName = convertView.findViewById(R.id.txt_name_item);

        // 각각의 아이템마다 값을 넣어주는 코드
        holder.txtNick.setText(nick);
        holder.txtName.setText(name);
        holder.imageView.setImageResource(image);

        return convertView;
    }

    class ViewHolder{
        ImageView imageView;
        TextView txtNick;
        TextView txtName;
    }
}
