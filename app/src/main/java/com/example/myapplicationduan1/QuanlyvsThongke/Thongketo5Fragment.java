package com.example.myapplicationduan1.QuanlyvsThongke;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplicationduan1.LopAdapter.Top5_Adapter;
import com.example.myapplicationduan1.LopDao.Top5Dao;
import com.example.myapplicationduan1.LopModel.Top;
import com.example.myapplicationduan1.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Thongketo5Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Thongketo5Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Thongketo10Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Thongketo5Fragment newInstance(String param1, String param2) {
        Thongketo5Fragment fragment = new Thongketo5Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_thongketo5, container, false);
    }

    ListView lv_top;
    ArrayList<Top> list;
    Top5_Adapter top5_adapter;

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lv_top = view.findViewById(R.id._lvthongke);
        Top5Dao top10Dao =new Top5Dao(getActivity());
        list = (ArrayList<Top>) top10Dao.GetTop();
        top5_adapter = new Top5_Adapter(getActivity(),this,list);
        lv_top.setAdapter(top5_adapter);
    }
}
