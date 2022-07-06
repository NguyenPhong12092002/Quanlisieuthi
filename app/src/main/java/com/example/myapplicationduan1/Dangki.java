package com.example.myapplicationduan1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplicationduan1.LopDao.DangkiDao;
import com.example.myapplicationduan1.LopDao.NVDao;
import com.example.myapplicationduan1.LopModel.NhanVien;
import com.google.android.material.textfield.TextInputLayout;

public class Dangki extends AppCompatActivity {

    private EditText edtaikhoan;

    private EditText edPassnew;

    private EditText edEnterpass;
    private AppCompatButton btnSave;
    private AppCompatButton btnClear;
    DangkiDao dangkiDao;
    com.example.myapplicationduan1.LopModel.Dangki dangki;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangki);
        edtaikhoan = findViewById(R.id.edttaikhoan);

        edPassnew = findViewById(R.id.edPassnew);
        dangkiDao = new DangkiDao(Dangki.this);
        edEnterpass = findViewById(R.id.edEnterpass);
        btnSave = findViewById(R.id.btn_save);
        btnClear = findViewById(R.id.btn_clear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtaikhoan.setText("");
                edPassnew.setText("");
                edEnterpass.setText("");
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.example.myapplicationduan1.LopModel.Dangki dangki = new com.example.myapplicationduan1.LopModel.Dangki();
                    dangki.setUsername(edtaikhoan.getText().toString());
                    dangki.setPass(edPassnew.getText().toString());
                   if (edPassnew.equals(edEnterpass) || edtaikhoan.getText().length()>0){
                       dangkiDao.ADDTV(dangki);
                       Toast.makeText(Dangki.this,"thêm thành công",Toast.LENGTH_SHORT).show();
                       startActivity(new Intent(Dangki.this,ManhinhHome.class));
                   }
                   else {
                       Toast.makeText(Dangki.this,"đăng kí thất bại",Toast.LENGTH_SHORT).show();
                   }

//                    if (kq > 0 || edPassnew.equals(edEnterpass)) {
//                        edtaikhoan.setText("");
//                        edPassnew.setText("");
//                        edEnterpass.setText("");
//                        Toast.makeText(Dangki.this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();
//                    } else {
//                        Toast.makeText(Dangki.this, "Sai thông tin đăng kí ==> thất bại", Toast.LENGTH_SHORT).show();
//                    }
               }

        });
    }

    }


