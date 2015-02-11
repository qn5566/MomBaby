package com.mababy.main.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TextView;

import com.mababy.main.R;

public class Fragmentb extends Fragment {

	private TabHost mTabHost;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return initView(inflater, container);
	}

	private View initView(LayoutInflater inflater, ViewGroup container) {
		View view = inflater.inflate(R.layout.fragment_b, container, false);
			final TabHost ThisTabHost = (TabHost) view.findViewById(R.id.tabhost1);
			ThisTabHost.setup();
			ThisTabHost.getTabWidget().setDividerDrawable(
					R.drawable.tab_divider);
			for (TabDef ThisTab : new TabDef[] {
					new TabDef("精選", "Content 1"),
					new TabDef("推薦", "Content 2"),
					 }) {
				final TextView contentview = new TextView(getActivity());
				
				contentview.setText(ThisTab.Content);
				
				
				
				
				View indicatorview = android.view.LayoutInflater.from(
						getActivity()).inflate(R.layout.tabs_bg_styled, null);
				((TextView) indicatorview.findViewById(R.id.tabsText))
						.setText(ThisTab.Indicator);
				ThisTabHost.addTab(ThisTabHost
						.newTabSpec(ThisTab.Indicator)
						.setIndicator(indicatorview)
						.setContent(
								new android.widget.TabHost.TabContentFactory() {
									
									public View createTabContent(String tag) {
										
										
										
										
										return contentview;
									} /* createTabContent */
								} /* TabContentFactory */
						));
			}
		
		return view;

	}

	public class TabDef {
		public final String Indicator, Content;

		public TabDef(String Indicator, String Content) {
			this.Indicator = Indicator;
			this.Content = Content;
		}
	};
}
