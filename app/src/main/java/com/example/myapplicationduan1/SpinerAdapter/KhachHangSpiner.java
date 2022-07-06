package com.example.myapplicationduan1.SpinerAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplicationduan1.LopModel.KhachHang;
import com.example.myapplicationduan1.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class KhachHangSpiner extends ArrayAdapter<KhachHang> {
    Context context;
    ArrayList<KhachHang> list;
    TextView tv_spinertv;

    public KhachHangSpiner(Context context, ArrayList<KhachHang> list){
        super(context, 0, list);
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.custom_spiner_khachhang, null);
        }
        KhachHang khachHang = list.get(position);
        if (khachHang != null) {
            tv_spinertv = view.findViewById(R.id.tv_spiner_thanhvien);
            tv_spinertv.setText(khachHang.getHoTenTV());
        }
        return view;
    }

    @Override
    public View getDropDownView(int position, @Nullable @org.jetbrains.annotations.Nullable View convertView, @NonNull @NotNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.custom_spiner_khachhang, null);
        }
        KhachHang khachHang = list.get(position);
        if (khachHang != null) {
            tv_spinertv = view.findViewById(R.id.tv_spiner_thanhvien);
            tv_spinertv.setText(khachHang.getHoTenTV());
        }
        return view;
    }
}
