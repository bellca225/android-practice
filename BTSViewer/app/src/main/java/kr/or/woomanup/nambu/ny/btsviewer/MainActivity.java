package kr.or.woomanup.nambu.ny.btsviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    Button btnNext;
    Button btnPrev;
    TextView txtName, txtNum;


    int[] images = {R.drawable.bts1, R.drawable.bts2,R.drawable.bts3, R.drawable.bts4,R.drawable.bts5, R.drawable.bts6,R.drawable.bts7};
    String[] names ={"RM","진","슈가","제이홉","지민","뷔","정국"};

    int index = 0;

    SeekBar seekBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

        btnNext = findViewById(R.id.btn_Next);
        btnPrev = findViewById(R.id.btn_Prev);

        BtnOnClickListener listener = new BtnOnClickListener();

        btnNext.setOnClickListener(listener);
        btnPrev.setOnClickListener(listener);
        btnPrev.setEnabled(false);

        txtName =findViewById(R.id.txtName);
        txtNum=findViewById(R.id.txtNum);

        seekBar = findViewById(R.id.seekBar);



        int max = names.length;
        seekBar.setMin(0);
        seekBar.setMax(max);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                index++;
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

    private void display() {

        imageView.setImageResource(images[index]);
        txtName.setText(names[index]);
        txtNum.setText((index+1) +"/"+ names.length);
    }


    class BtnOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            btnPrev.setEnabled(true);
            btnNext.setEnabled(true);

            int id = v.getId();
            if (id == R.id.btn_Prev) {
                index--;
                if (index <= 0) {
                    btnPrev.setEnabled(false);
                }
            }else if(id == R.id.btn_Next) {
                    index++;
                    if (index >= images.length - 1) {
                        btnNext.setEnabled(false);
                    }
                }// if end

            display();

        } //onClick
    } // BtnOnClickListener



} // all end