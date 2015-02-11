package com.mababy.main.fragment;

import com.mababy.main.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mababy.main.fragment.Fragmentc;

public class GoogleFragment extends Fragment {

	private String value = "";

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		Log.d("=====>", "GoogleFragment onAttach");
		
		Fragmentc mainActivity = new  Fragmentc();
		value = mainActivity.getAppleData();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.d("=====>", "GoogleFragment onCreateView");
		return inflater.inflate(R.layout.frg_google, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.d("=====>", "GoogleFragment onActivityCreated");
		TextView txtResult = (TextView) this.getView().findViewById(R.id.textView1);
		txtResult.setText(value);
	}
	
}
