package com.mababy.main.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.mababy.main.R;

public class Fragmentb extends Fragment {

	private TabHost mTabHost;
	public TextView contentview;
	public LinearLayout Tab_layout, Tab_1, Tab_2;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return initView(inflater, container);
	}

	private View initView(LayoutInflater inflater, ViewGroup container) {
		View view = inflater.inflate(R.layout.fragment_b, container, false);
			mTabHost = (TabHost) view.findViewById(R.id.tabhost1);
			mTabHost.setup();
			mTabHost.getTabWidget().setDividerDrawable(
					R.drawable.tab_divider);
			for (TabDef ThisTab : new TabDef[] {
					new TabDef("精選", "Content 1"),
					new TabDef("推薦", "Content 2"),
					 }) {
				contentview = new TextView(getActivity());				
				contentview.setText(ThisTab.Content);
				Tab_layout = new LinearLayout(getActivity());
				
				
				View indicatorview = android.view.LayoutInflater.from(
						getActivity()).inflate(R.layout.tabs_bg_styled, null);
				((TextView) indicatorview.findViewById(R.id.tabsText))
						.setText(ThisTab.Indicator);
				mTabHost.addTab(mTabHost
						.newTabSpec(ThisTab.Indicator)
						.setIndicator(indicatorview)
						.setContent(
								new android.widget.TabHost.TabContentFactory() {									
									public View createTabContent(String tag) {											
										Tabswitch(tag);	
										
										return Tab_layout;
										//return contentview;
									} /* createTabContent */
								} /* TabContentFactory */
						));
			}
		
		return view;

	}

	
	public View Tabswitch(String tag){
		if(tag.equals("精選")){
//			Tab_layout = 
			//contentview.setText("你成功摟");
		}if(tag.equals("推薦")){
			
			//contentview.setText("你好嗎?");
		}
		return contentview;
	}
	
	public class TabDef {
		public final String Indicator, Content;

		public TabDef(String Indicator, String Content) {
			this.Indicator = Indicator;
			this.Content = Content;
		}
	};
}
