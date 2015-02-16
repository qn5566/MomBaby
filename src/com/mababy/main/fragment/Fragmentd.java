package com.mababy.main.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mababy.main.R;
import com.mababy.main.fragment.Fragmentb.TabDef;

public class Fragmentd extends Fragment {

	public Class Tab_class;

	// private ListView list;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return initView(inflater, container);
	}

	private View initView(LayoutInflater inflater, ViewGroup container) {
		View view = inflater.inflate(R.layout.fragment_d, container, false);

		FragmentTabHost tabHost = (FragmentTabHost) view
				.findViewById(android.R.id.tabhost);
		tabHost.setup(getActivity(), getChildFragmentManager(),
				R.id.realtabcontentt);

		for (TabDef ThisTab : new TabDef[] {
				new TabDef("精選", "Content 1", AppleFragment.class),
				new TabDef("推薦", "Content 2", GoogleFragment.class), }) {

			View indicatorview = android.view.LayoutInflater
					.from(getActivity()).inflate(R.layout.tabs_bg_styled, null);
			((TextView) indicatorview.findViewById(R.id.tabsText))
					.setText(ThisTab.Indicator);
			tabHost.addTab(
					tabHost.newTabSpec(ThisTab.Indicator).setIndicator(
							indicatorview), ThisTab.Tab_class, null);
		}
		return view;
	}

	public class TabDef {
		public final String Indicator, Content;
		public Class Tab_class;

		public TabDef(String Indicator, String Content, Class Tab_class) {
			this.Tab_class = Tab_class;
			this.Indicator = Indicator;
			this.Content = Content;
		}
	};

}
