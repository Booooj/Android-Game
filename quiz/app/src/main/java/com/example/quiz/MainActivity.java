package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int i = 0;
    private Button select1;
    private Button select2;
    private Button select3;
    private Button select4;
    private Button buttonnext;
    String question[][] = {
            // {"動物名", "正解", "選択1", "選択2", "選択３"}
            {"日本語訳はどれ？「raccoon」", "アライグマ", "リス", "イタチ", "アオダイショウ"},
            {"hedgehog", "ハリネズミ", "モグラ", "キツツキ", "カラス"},
            {"camel", "ラクダ", "アマガエル", "アリ", "シマウマ"},
            {"donkey", "ロバ", "シカ", "キツネ", "ライオン"},
            {"mole", "モグラ", "キリン", "カバ", "ラクダ"},
            {"hippopotamus", "カバ", "キツネ", "タヌキ", "ウシ"},
            {"raccoon dog", "タヌキ", "メダカ", "アリ", "ハマグリ"},
            {"baboon", "ヒヒ", "ヘビ", "ヤモリ", "サバ"},
            {"sea otter", "ラッコ", "ヒト", "ナマズ", "ウマ"},
            {"guinea pig", "モルモット", "コブタ", "カブトムシ", "ムササビ"},
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show();
        Button buttonnext = findViewById(R.id.buttonnext);
        buttonnext.setEnabled(false);
    }
 @Override
    public void onBackPressed(){
                    finish();
    }
    public void show() {
        List<Integer> q = Arrays.asList(1, 2, 3, 4);
        Collections.shuffle(q);
        ((TextView) findViewById(R.id.question)).setText(question[i][0]);
        ((Button) findViewById(R.id.Q)).setText(question[i][q.get(0)]);
        ((Button) findViewById(R.id.select1)).setText(question[i][q.get(1)]);
        ((Button) findViewById(R.id.select2)).setText(question[i][q.get(2)]);
        ((Button) findViewById(R.id.select3)).setText(question[i][q.get(3)]);
    }

    public void onButton(View view) {
        Button selectBtn = (Button) view;
        String correctanswer = selectBtn.getText().toString();

        if (correctanswer.equals(question[i][1])) {
            ((TextView) findViewById(R.id.textview)).setText("正解！！〇");
            Button buttonnext = findViewById(R.id.buttonnext);
            buttonnext.setEnabled(true);
        } else {
            ((TextView) findViewById(R.id.textview)).setText("不正解！！×");
        }
    }
    public void onNext(View view) {
        if (i == 5) {
            Intent intent = new Intent(this, MainActivity2.class);
            startActivity(intent);
              finish();
        }
        i++;
        show();
        ((TextView) findViewById(R.id.textview)).setText("結果...");
        Button buttonnext = findViewById(R.id.buttonnext);
        buttonnext.setEnabled(false);
    }
}
