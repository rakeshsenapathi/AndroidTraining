package com.senapathi.userform;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button toastButton;
    private EditText usernameEdt;
    private EditText passwordEdt;

    private String user;
    private String pwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Setting UI
        setContentView(R.layout.activity_user__form);
        //Find views
        toastButton = (Button) findViewById(R.id.btn_login);
        toastButton.setOnClickListener(this);
        //
        usernameEdt = (EditText) findViewById(R.id.et_user_name);
        passwordEdt = (EditText) findViewById(R.id.et_password);
        // Empty initialisation
        user = usernameEdt.getText().toString();
        pwd = passwordEdt.getText().toString();


    }

    @Override
    public void onClick(View v) {
        //Look for empty edit texts
        //if(user.isEmpty() && pwd.isEmpty()){
          //  Toast.makeText(this,"Empty Inputs",Toast.LENGTH_SHORT).show();}
        user = usernameEdt.getText().toString();
        pwd = passwordEdt.getText().toString();


        if (v.getId() == R.id.btn_login) {
            if (user.equals("admin") && pwd.equals("admin")) {

                Toast.makeText(this, "Logged In As " + usernameEdt.getText().toString(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, DashBoardActivity.class);
                intent.putExtra("user_name", usernameEdt.getText().toString());

                startActivity(intent);
            } else {
                Toast.makeText(this, "Validation Failed", Toast.LENGTH_LONG).show();
            }
        }

    }
}




