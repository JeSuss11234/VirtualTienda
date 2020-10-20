package com.example.tiendavirtual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AdminCategoriaActivity extends AppCompatActivity {
private ImageView tShirts,sportsTShirts,femaleDresses,sweathers;
private ImageView glasses,hatsCaps,walletsBagsPurses,shoes;
private ImageView headPhoneHandFree,Laptops,watches,mobilePhones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_categoria);

        tShirts=(ImageView)findViewById(R.id.t_shirts);
        sportsTShirts=(ImageView)findViewById(R.id.sports_t_shirts);
        femaleDresses=(ImageView)findViewById(R.id.femele_dresses);
        sweathers=(ImageView)findViewById(R.id.sweathers);

        glasses=(ImageView)findViewById(R.id.glasses);
        hatsCaps=(ImageView)findViewById(R.id.hats_caps);
        walletsBagsPurses=(ImageView)findViewById(R.id.purses_bags_wallets);
        shoes=(ImageView)findViewById(R.id.shoes);

        headPhoneHandFree=(ImageView)findViewById(R.id.headphones_handfree);
        Laptops=(ImageView)findViewById(R.id.laptops_pc);
        watches=(ImageView)findViewById(R.id.watches);
        mobilePhones=(ImageView)findViewById(R.id.mobilephones);



        tShirts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AdminCategoriaActivity.this,AdminAddNewProductActivity.class);
                i.putExtra("category","tShirts");
                startActivity(i);
            }
        });

        sportsTShirts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AdminCategoriaActivity.this,AdminAddNewProductActivity.class);
                i.putExtra("category","Sports tShirts");
                startActivity(i);
            }
        });

        femaleDresses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AdminCategoriaActivity.this,AdminAddNewProductActivity.class);
                i.putExtra("category","Female Dresses");
                startActivity(i);
            }
        });

        sweathers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AdminCategoriaActivity.this,AdminAddNewProductActivity.class);
                i.putExtra("category","Sweathers");
                startActivity(i);
            }
        });

        glasses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AdminCategoriaActivity.this,AdminAddNewProductActivity.class);
                i.putExtra("category","Glasses");
                startActivity(i);
            }
        });

        hatsCaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AdminCategoriaActivity.this,AdminAddNewProductActivity.class);
                i.putExtra("category","Hats Caps");
                startActivity(i);
            }
        });

        walletsBagsPurses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AdminCategoriaActivity.this,AdminAddNewProductActivity.class);
                i.putExtra("category","Wallets Bags Purses");
                startActivity(i);
            }
        });

        shoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AdminCategoriaActivity.this,AdminAddNewProductActivity.class);
                i.putExtra("category","Shoes");
                startActivity(i);
            }
        });

        headPhoneHandFree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AdminCategoriaActivity.this,AdminAddNewProductActivity.class);
                i.putExtra("category","HeadPhone HandFree");
                startActivity(i);
            }
        });

        Laptops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AdminCategoriaActivity.this,AdminAddNewProductActivity.class);
                i.putExtra("category","Laptops");
                startActivity(i);
            }
        });

        watches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AdminCategoriaActivity.this,AdminAddNewProductActivity.class);
                i.putExtra("category","Watches");
                startActivity(i);
            }
        });

        mobilePhones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AdminCategoriaActivity.this,AdminAddNewProductActivity.class);
                i.putExtra("category","Mobile Phones");
                startActivity(i);
            }
        });
    }
}