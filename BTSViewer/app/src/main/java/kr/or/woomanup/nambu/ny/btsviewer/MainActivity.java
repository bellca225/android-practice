package kr.or.woomanup.nambu.ny.btsviewer;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button btnNext, btnPrev;
    TextView txtName, txtNum;
    SeekBar seekBar;

    int index = 0;
    int[] images = {R.drawable.bts1, R.drawable.bts2,R.drawable.bts3, R.drawable.bts4,R.drawable.bts5, R.drawable.bts6,R.drawable.bts7};
    String[] names ={"RM","진","슈가","제이홉","지민","뷔","정국"};

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//    참조 전역 변수값들 모음
        initUI();
//        초기값 설정
        initBtnListener();

        display();

        int max = names.length-1;
//        seekBar.setMin(0); 필요없음
        seekBar.setMax(max);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                index = progress;
                btnPrev.setEnabled(true);
                btnNext.setEnabled(true);

                if(index<=0){
                    btnPrev.setEnabled(false)
                ;}
                if(index>=images.length-1){
                    btnNext.setEnabled(false);
                }
                display();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {


            }
        });

        // image 가져오기
        display(); //Refactor -> Extract Method


    }

    private void initBtnListener() {
        BtnOnClickListener listener = new BtnOnClickListener();
        btnNext.setOnClickListener(listener);
        btnPrev.setOnClickListener(listener);
        btnPrev.setEnabled(false);
    }

    private void initUI() {
        imageView = findViewById(R.id.imageView);
        btnNext = findViewById(R.id.btn_Next);
        btnPrev = findViewById(R.id.btn_Prev);
        txtName =findViewById(R.id.txtName);
        txtNum=findViewById(R.id.txtNum);
        seekBar = findViewById(R.id.seekBar);
    }

    private void display() {

        imageView.setImageResource(images[index]);
        txtName.setText(names[index]);
        txtNum.setText((index+1) +"/"+ names.length);
    }

    class BtnOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            int id = v.getId();
            if (id == R.id.btn_Prev) {
                index--;
            }else if(id == R.id.btn_Next) {
                    index++;
                }// if end
            setIndex(index);
        } //onClick
    } // BtnOnClickListener


    void setIndex(int i){

        btnPrev.setEnabled(true);
        btnNext.setEnabled(true);

        if (i <= 0) {
            btnPrev.setEnabled(false);
        }
        if (i >= images.length - 1) {
            btnNext.setEnabled(false);
        }
        seekBar.setProgress(i);
        display();
    }

} // all end