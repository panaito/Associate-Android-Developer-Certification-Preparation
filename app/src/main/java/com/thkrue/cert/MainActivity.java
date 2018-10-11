package com.thkrue.cert;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.thkrue.cert.util.InputValidator;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";
    private EditText etEmail, etPwd;
    private TextView tvInfo;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        initInputFields();
        initLoginButton();
        initFab();
    }

    private void initInputFields() {
        etEmail = findViewById(R.id.et_email);
        etPwd = findViewById(R.id.et_password);
    }

    public void toasty(View v) {
        Toast.makeText(this, "X", Toast.LENGTH_SHORT).show();
    }

    private void initLoginButton() {
        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputValidator validator = new InputValidator();
                if (validator.isValidEmail(etEmail.getText().toString())) {
                    if (validator.isValidPassword(etPwd.getText().toString())) {
                        doLogin();
                    } else {
                        Log.i(TAG, "Wrong password");
                        //TODO highlight pwd
                    }
                } else {
                    Log.i(TAG, "Wrong email");
                    //TODO highlight email
                }
            }
        });
    }

    private void doLogin() {
        ((ImageView) findViewById(R.id.iv_header)).setImageResource(R.drawable.android);
        tvInfo = findViewById(R.id.tv_info);
        tvInfo.setText("Logged in!");
        tvInfo.setVisibility(View.VISIBLE);
    }

    private void initFab() {
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
