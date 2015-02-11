package com.mababy.main.fragment;

import android.app.Fragment;
import android.os.Bundle;

import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mababy.main.R;

public class Fragmentc extends Fragment {

	//private ListView list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_c, container, false);
    }   

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		FragmentTabHost tabHost = (FragmentTabHost)getView().findViewById(android.R.id.tabhost);

	    tabHost.setup();

	    //1
	    tabHost.addTab(tabHost.newTabSpec("Apple")
	                          .setIndicator("Apple"), 
	                   AppleFragment.class, 
	                   null);
	    //2
	    tabHost.addTab(tabHost.newTabSpec("Google")
	                          .setIndicator("Google"), 
	                   GoogleFragment.class, 
	                   null);
	    //3
	    tabHost.addTab(tabHost.newTabSpec("Facebook")
	                          .setIndicator("Facebook"), 
	                   FacebookFragment.class, 
	                   null);
	    //4
	    tabHost.addTab(tabHost.newTabSpec("Twitter")
	                          .setIndicator("Twitter"), 
	                   TwitterFragment.class, 
	                   null);
	  }

	  /**************************
	  * 
	  * 給子頁籤呼叫用
	  * 
	  **************************/
	  public String getAppleData(){
	    return "Apple 123";
	  }
	  public String getGoogleData(){
	    return "Google 456";
	  }
	  public String getFacebookData(){
	    return "Facebook 789";
	  }
	  public String getTwitterData(){
	    return "Twitter abc";
	  }
		
		
		
	}
    
    
    


