package com.mababy.main.fragment;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import com.mababy.main.R;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mababy.main.fragment.Fragmentc;
import com.facebook.FacebookException;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.model.GraphUser;
import com.facebook.widget.LoginButton;
import com.facebook.widget.LoginButton.OnErrorListener;

public class GoogleFragment extends Fragment {

	private String value = "";
	private TextView facebook;
	public Fragmentc mainActivity;
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		Log.d("=====>", "GoogleFragment onAttach");

		mainActivity = new Fragmentc();
		value = mainActivity.getGoogleData();

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
		printHashKey();

		TextView txtResult = (TextView) this.getView().findViewById(
				R.id.textView1);
		txtResult.setText(value);
		facebook = (TextView) this.getView().findViewById(R.id.me_info);

		LoginButton authButton = (LoginButton) this.getView().findViewById(
				R.id.authButton);
		authButton.setOnErrorListener(new OnErrorListener() {

			@Override
			public void onError(FacebookException error) {
				Log.d("=====>", "LoginButton");

			}
		});
		 
		authButton.setReadPermissions(Arrays.asList("public_profile"));
		authButton.setSessionStatusCallback(new Session.StatusCallback() {

			@Override
			public void call(Session session, SessionState state,
					Exception exception) {	
				//session.getApplicationId();
				Log.d("=====>", "call + session.isOpened(): "+session.isOpened());
				if (session.isOpened()) {
					Log.d("=====>", "sessionn.isOpened()");
					Request.newMeRequest(session,
							new Request.GraphUserCallback() {

								@Override
								public void onCompleted(GraphUser user,
										Response response) {
									if (user != null) {
										facebook.setText("Hello"
												+ user.getName() + "!");
										Log.d("=====>", "user != null");
									}
									Log.d("=====>", "user == null");
								}

							}).executeAsync();
				}
			}
		});

	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		Log.d("=====>", "onActivityResult");
		Session.getActiveSession().onActivityResult(this.getActivity(),
				requestCode, resultCode, data);
	}

	public void printHashKey() {

		try {
			PackageInfo info = getActivity().getPackageManager()
					.getPackageInfo("com.mababy.main",
							PackageManager.GET_SIGNATURES);
			for (Signature signature : info.signatures) {
				MessageDigest md = MessageDigest.getInstance("SHA");
				md.update(signature.toByteArray());
				Log.d("TEMPTAGHASH KEY:",
						Base64.encodeToString(md.digest(), Base64.DEFAULT));
			}
		} catch (NameNotFoundException e) {

		} catch (NoSuchAlgorithmException e) {

		}

	}
}
