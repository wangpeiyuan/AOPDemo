package com.wangpeiyuan.aopdemo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.wangpeiyuan.aspect_lib.annotation.DebugLog;

/**
 * Created by wangpeiyuan on 2020-01-09.
 */
public class MainActivity extends AppCompatActivity {

    @DebugLog
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
