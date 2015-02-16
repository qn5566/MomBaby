package com.mababy.main.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

import com.mababy.main.R;

public class Fragmentc extends Fragment {

	// private ListView list;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return initView(inflater, container);
	}

	private View initView(LayoutInflater inflater, ViewGroup container) {
		View view = inflater.inflate(R.layout.fragment_c, container, false);
		FragmentTabHost tabHost = (FragmentTabHost)view.findViewById(android.R.id.tabhost);
		tabHost.setup(getActivity(), getChildFragmentManager(), R.id.realtabcontent);
			
//		tabHost.addTab(setIndicator(tabHost.newTabSpec("Tab1"),
//                R.drawable.image1),
		//1
		tabHost.addTab(tabHost.newTabSpec("首頁")
			   				  .setIndicator("首頁"), 
   					  AppleFragment.class, 
   					  null);
	    //2
		tabHost.addTab(tabHost.newTabSpec("熱門")
				   			  .setIndicator("熱門"),
					  GoogleFragment.class, 
					  null);
		return view;
	}

	
	public TabSpec setIndicator(Context ctx,TabSpec spec, int resid) {
        // TODO Auto-generated method stub
        View v = LayoutInflater.from(ctx).inflate(R.layout.tabs_bg_styled, null);
        v.setBackgroundResource(resid);
        TextView text = (TextView) v.findViewById(R.id.tabsText);
        text.setText(spec.getTag());
        return spec.setIndicator(v);
    }
	
	/**************************
	 * 
	 * 給子頁籤呼叫用
	 * 
	 **************************/
	public String getAppleData() {
		return "Apple 123";
	}

	public String getGoogleData() {
		return "Google 456";
	}

	public String getFacebookData() {
		return "Facebook 789";
	}

	public String getTwitterData() {
		return "Twitter abc";
	}

}
