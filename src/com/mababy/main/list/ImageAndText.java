package com.mababy.main.list;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.mababy.main.R;

public class ImageAndText extends ArrayAdapter<String>{
	private LayoutInflater mInflater;
	private String[] mString;
	private TypedArray mIcon;
	private int mViewResource;
	

	public ImageAndText(Context context, int Viewresource, String[] strings,
			TypedArray icons) {
		super(context,Viewresource, strings);
		mInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		mViewResource=Viewresource;
		mString=strings;
		mIcon=icons;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mString.length;
	}

	@Override
	public String getItem(int position) {
		// TODO Auto-generated method stub
		return mString[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView=mInflater.inflate(mViewResource, null);
		ImageView iv=(ImageView) convertView.findViewById(R.id.menu1);
		iv.setImageDrawable(mIcon.getDrawable(position));
		TextView tv=(TextView) convertView.findViewById(R.id.menutext1);
		tv.setText(mString[position]);
		return convertView;
	}
	
}