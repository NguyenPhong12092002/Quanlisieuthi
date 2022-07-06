package com.example.myapplicationduan1.LopDao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplicationduan1.LopModel.Dangki;
import com.example.myapplicationduan1.LopModel.KhachHang;
import com.example.myapplicationduan1.LopModel.NhanVien;
import com.example.myapplicationduan1.SQLopenhelper.CreateData;

import java.util.ArrayList;
import java.util.List;

public class DangkiDao {
    SQLiteDatabase sqLitetv;
    CreateData createData;
    Context mcontext;
    public DangkiDao(Context context) {
        createData = new CreateData(context);
        sqLitetv = createData.getWritableDatabase();
    }
    public void OPEN() {
        sqLitetv = createData.getWritableDatabase();
    }

    public void Close() {
        createData.close();
    }

    public long ADDTV(Dangki dangki) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(dangki.COL_NAME_TK, dangki.getUsername());
        contentValues.put(dangki.COL_NAME_MK, dangki.getPass());
        return sqLitetv.insert(dangki.TB_NAME_DK, null, contentValues);
    }


    // get tất cả dữ liệu

    public List<Dangki> GETNV() {
        String select = "SELECT* FROM Dangki";
        return getdata(select);
    }
    public Dangki getUser(String user) {
        String getuser = "SELECT * FROM Dangki WHERE taikhoan=?";
        List<Dangki> list = getdata(getuser, user);
        return list.get(0);
    }
    public int getUserName(String user) {
        String dl = "SELECT * FROM Dangki WHERE taikhoan=? ";
        List<Dangki> list = getdata(dl, user);
        if (list.size() == 0) {
            return -1;
        } else {
            return 1;
        }
    }
    public int getlogin(String user, String pass) {
        String dl = "SELECT * FROM Dangki WHERE taikhoan=? AND matKhau=?";
        List<Dangki> list = getdata(dl, user, pass);
        if (list.size() == 0) {
            return -1;
        } else {
            return 1;
        }
    }

    // get dữ liệu theo id
    public Dangki getId(String id) {
        String dl = "SELECT * FROM Dangki WHERE madangki==? ";
        List<Dangki> list = getdata(dl, id);
        return list.get(0);
    }
    // get dữ liệu nhiều tham số
    @SuppressLint("Range")
    private List<Dangki> getdata(String dl, String... Arays) {
        List<Dangki> list = new ArrayList<>();
        Cursor cursor = sqLitetv.rawQuery(dl, Arays);
        while (cursor.moveToNext()) {
            Dangki dangki = new Dangki();
            dangki.setUsername(cursor.getString(cursor.getColumnIndex(Dangki.COL_NAME_TK)));
            dangki.setPass(cursor.getString(cursor.getColumnIndex(Dangki.COL_NAME_MK)));
            list.add(dangki);
        }
        return list;
    }
}
