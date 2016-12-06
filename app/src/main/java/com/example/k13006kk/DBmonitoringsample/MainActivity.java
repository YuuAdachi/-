package com.example.k13006kk.DBmonitoringsample;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.example.k13006kk.mylibrary.DBaccess;
import com.example.k13006kk.mylibrary.UserColumns;

public class MainActivity extends Activity {

    DBaccess dBaccess = new DBaccess();
    public String[] enterroom = new String[6];
    public String[] exitroom = new String[6];

    TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView) findViewById(R.id.toumei);
        tv1.setText("null");

        tv2 = (TextView) findViewById(R.id.heyamei);
        tv2.setText("null");

        tv3 = (TextView) findViewById(R.id.heyaban);
        tv3.setText("null");

        tv4 = (TextView) findViewById(R.id.nichiji);
        tv4.setText("null");

        tv5 = (TextView) findViewById(R.id.toumei2);
        tv5.setText("null");

        tv6 = (TextView) findViewById(R.id.heyamei2);
        tv6.setText("null");

        tv7 = (TextView) findViewById(R.id.heyaban2);
        tv7.setText("null");

        tv8 = (TextView) findViewById(R.id.nichiji2);
        tv8.setText("null");
    }

    ContentObserver mContentObserver = new ContentObserver(new Handler()) {
        @Override
        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            // 変更された時の処理を書く
            final ContentResolver resolver = getContentResolver();
            for (int i = 0; i < dBaccess.getenterroom(resolver).length; i++) {
                enterroom[i] = dBaccess.getenterroom(resolver)[i];
            }
            for (int i = 0; i < dBaccess.getexitroom(resolver).length; i++) {
                exitroom[i] = dBaccess.getexitroom(resolver)[i];
            }

            tv1 = (TextView) findViewById(R.id.toumei);
            tv1.setText(enterroom[1]);

            tv2 = (TextView) findViewById(R.id.heyamei);
            tv2.setText(enterroom[2]);

            tv3 = (TextView) findViewById(R.id.heyaban);
            tv3.setText(enterroom[3]);

            tv4 = (TextView) findViewById(R.id.nichiji);
            tv4.setText(enterroom[4]);

            tv5 = (TextView) findViewById(R.id.toumei2);
            tv5.setText(exitroom[1]);

            tv6 = (TextView) findViewById(R.id.heyamei2);
            tv6.setText(exitroom[2]);

            tv7 = (TextView) findViewById(R.id.heyaban2);
            tv7.setText(exitroom[3]);

            tv8 = (TextView) findViewById(R.id.nichiji2);
            tv8.setText(exitroom[4]);
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        getContentResolver().registerContentObserver(UserColumns.CONTENT_URI,true,mContentObserver);
    }

    @Override
    protected void onPause() {
        super.onPause();
        getContentResolver().unregisterContentObserver(mContentObserver);
    }

    public void onClick(View view){

        tv1 = (TextView) findViewById(R.id.toumei);
        tv1.setText("null");

        tv2 = (TextView) findViewById(R.id.heyamei);
        tv2.setText("null");

        tv3 = (TextView) findViewById(R.id.heyaban);
        tv3.setText("null");

        tv4 = (TextView) findViewById(R.id.nichiji);
        tv4.setText("null");

        tv5 = (TextView) findViewById(R.id.toumei2);
        tv5.setText("null");

        tv6 = (TextView) findViewById(R.id.heyamei2);
        tv6.setText("null");

        tv7 = (TextView) findViewById(R.id.heyaban2);
        tv7.setText("null");

        tv8 = (TextView) findViewById(R.id.nichiji2);
        tv8.setText("null");
    }
}
