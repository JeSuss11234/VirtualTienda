package com.example.tiendavirtual;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tiendavirtual.Model.Users;
import com.example.tiendavirtual.Prevalent.Prevalent;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rey.material.widget.CheckBox;

import java.security.AllPermission;

import io.paperdb.Paper;

public class loginActivity extends AppCompatActivity {

    private EditText InputPhoneNumber, InputPassword;
    private Button LoginButton;
    private ProgressDialog loadingBar;

    private TextView AdminLink,NotAdminLink;

    private String parentDbName="Users";
    private CheckBox chkBoxRememberMe;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginButton = (Button) findViewById(R.id.login_btn);
        InputPassword = (EditText) findViewById(R.id.login_password_input);
        InputPhoneNumber = (EditText) findViewById(R.id.login_phone_number_input);
        AdminLink= (TextView) findViewById(R.id.admin_panel_link);
        NotAdminLink= (TextView) findViewById(R.id.not_admin_panel_link);
        loadingBar = new ProgressDialog(this);

        chkBoxRememberMe=(CheckBox)findViewById(R.id.remember_me_chkb);
        Paper.init(this);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginUser();
            }
        });

        AdminLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginButton.setText("Login Admin");
                AdminLink.setVisibility(View.INVISIBLE);
                NotAdminLink.setVisibility(View.VISIBLE);
                parentDbName="Admins";
            }
        });
        NotAdminLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginButton.setText("Login");
                AdminLink.setVisibility(View.VISIBLE);
                NotAdminLink.setVisibility(View.INVISIBLE);
                parentDbName="Users";
            }
        });
    }

    private void LoginUser() {
        String phone=InputPhoneNumber.getText().toString();
        String password=InputPassword.getText().toString();

        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "please write your phone number.....", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "please write your password.....", Toast.LENGTH_SHORT).show();
        } else {
            loadingBar.setTitle("Login Account");
            loadingBar.setMessage("Please wait, while we are checking the credentials.");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();

            AllowAccessToAccount(phone,password);
        }

    }

    private void AllowAccessToAccount(final String phone, final String password) {

        if(chkBoxRememberMe.isChecked()){
            Paper.book().write(Prevalent.UserPhoneKey, phone);
            Paper.book().write(Prevalent.UserPasswordKey, password);
        }


        final DatabaseReference RootRef;
        RootRef= FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               if(snapshot.child(parentDbName).child(phone).exists()){
                Users usersData=snapshot.child(parentDbName).child(phone).getValue(Users.class);
                if(usersData.getPhone().equals(phone)){
                    if(usersData.getPassword().equals(password)){

                        if(parentDbName.equals("Admins")){
                            Toast.makeText(loginActivity.this, "Welcome Admin, you are logged in Successfully..", Toast.LENGTH_SHORT).show();
                            loadingBar.dismiss();

                            Intent i =new Intent(loginActivity.this, AdminCategoriaActivity.class);
                            startActivity(i);
                        }else if(parentDbName.equals("Users")){
                            Toast.makeText(loginActivity.this, "logged in Successfully..", Toast.LENGTH_SHORT).show();
                            loadingBar.dismiss();

                            Intent i =new Intent(loginActivity.this, NavigationActivity.class);
                            Prevalent.currentOnlineUser = usersData;
                            startActivity(i);
                        }

                        /*Toast.makeText(loginActivity.this, "logged in Successfully..", Toast.LENGTH_SHORT).show();
                        loadingBar.dismiss();

                        Intent i =new Intent(loginActivity.this, HomeActivity.class);
                        startActivity(i);*/
                    }
                    else
                    {
                        loadingBar.dismiss();
                        Toast.makeText(loginActivity.this, "Password is incorrect.", Toast.LENGTH_SHORT).show();
                    }
                }
               }else{
                   Toast.makeText(loginActivity.this, "Account with this " + phone + "number do not exists.", Toast.LENGTH_SHORT).show();
                   loadingBar.dismiss();
               }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}