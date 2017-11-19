package com.site.siteproject.mathura.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.site.siteproject.R;
import com.site.siteproject.mathura.adapter.SpecificationAdapter;


/**
 * Created by Creative IT Works on 14-Nov-17.
 */

public class Specification extends Fragment{
    RecyclerView specification_list;
    SpecificationAdapter adapter;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.mathura_specification, container, false);
        specification_list=(RecyclerView)view.findViewById(R.id.specification_list);

        adapter = new SpecificationAdapter(getActivity());
        GridLayoutManager ll = new GridLayoutManager(getActivity(),2);
        ll.setOrientation(LinearLayoutManager.VERTICAL);
        specification_list.setLayoutManager(ll);

        specification_list.setAdapter(adapter);

        return view;

    }
}
