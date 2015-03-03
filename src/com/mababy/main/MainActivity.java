package com.mababy.main;

import android.app.Activity;

import android.app.ActionBar;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.widget.ShareActionProvider;
import android.widget.ShareActionProvider.OnShareTargetSelectedListener;
import android.widget.Toast;

import com.facebook.Session;
import com.mababy.main.actionprovider.DynamicShareActionProvider;
import com.mababy.main.fragment.Fragmenta;
import com.mababy.main.fragment.Fragmentb;
import com.mababy.main.fragment.Fragmentc;
import com.mababy.main.fragment.Fragmentd;
import com.mababy.main.fragment.Fragmente;
import com.mababy.main.fragment.Fragmentf;

public class MainActivity extends FragmentActivity implements
		NavigationDrawerFragment.NavigationDrawerCallbacks {

	/**
	 * Fragment managing the behaviors, interactions and presentation of the
	 * navigation drawer.
	 */
	private NavigationDrawerFragment mNavigationDrawerFragment;

	/**
	 * Used to store the last screen title. For use in
	 * {@link #restoreActionBar()}.
	 */
	private CharSequence mTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager()
				.findFragmentById(R.id.navigation_drawer);
		mTitle = getTitle();

		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));

	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {
		selectItem(position);
		// FragmentManager fragmentManager = getFragmentManager();
		// fragmentManager
		// .beginTransaction()
		// .replace(R.id.container,
		// PlaceholderFragment.newInstance(position + 1)).commit();
	}

	private void selectItem(int position) {
		Fragment fragment;

		switch (position) {
		case 0:
			fragment = new Fragmenta();
			break;

		case 1:
			fragment = new Fragmentb();
			break;

		case 2:
			fragment = new Fragmentc();

			break;

		case 3:
			fragment = new Fragmentd();
			break;

		case 4:
			fragment = new Fragmente();
			break;

		case 5:
			fragment = new Fragmentf();
			break;

		default:

			return;
		}

		FragmentTransaction tran = getSupportFragmentManager()
				.beginTransaction();
		tran.replace(R.id.container, fragment).commit();
	}

	public void onSectionAttached(int number) {
		switch (number) {
		case 1:
			mTitle = getString(R.string.title_section1);
			break;
		case 2:
			mTitle = getString(R.string.title_section2);
			break;
		case 3:
			mTitle = getString(R.string.title_section3);
			break;
		}
	}

	public void restoreActionBar() {
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(mTitle);
	}

	private ShareActionProvider mShareActionProvider;

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// 加载菜单资源文件
		getMenuInflater().inflate(R.menu.test, menu);
		// 用ShareActionProvider定位MenuItem
		MenuItem item = menu.findItem(R.id.menu_item_share);
		// 获取并存储ShareActionProvider
		mShareActionProvider = (ShareActionProvider) item.getActionProvider();
		// 然后true来显示菜单
		mShareActionProvider.setShareIntent(getIntent());

		return super.onCreateOptionsMenu(menu);
	}

	// 调用来更新share intent
	private void setShareIntent(Intent shareIntent) {
		if (mShareActionProvider != null) {
			mShareActionProvider.setShareIntent(shareIntent);
		}
	}

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// if (!mNavigationDrawerFragment.isDrawerOpen()) {
	// getMenuInflater().inflate(R.menu.joey, menu);
	//
	// DynamicShareActionProvider provider = (DynamicShareActionProvider)
	// MenuItemCompat
	// .getActionProvider(menu.findItem(R.id.menu_item_share));
	// provider.setShareDataType("text/plain");
	// provider.setOnShareIntentUpdateListener(new
	// DynamicShareActionProvider.OnShareIntentUpdateListener() {
	//
	// @Override
	// public Bundle onShareIntentExtrasUpdate() {
	// Bundle extras = new Bundle();
	// // EditText shareEdit = (EditText)
	// // findViewById(R.id.share_edit);
	// // extras.putString(android.content.Intent.EXTRA_TEXT,
	// // shareEdit.getText().toString());
	// return extras;
	// }
	//
	// });

	// DynamicShareActionProvider shareLaterProvider =
	// (DynamicShareActionProvider) MenuItemCompat
	// .getActionProvider(menu
	// .findItem(R.id.menu_item_share_later));
	// shareLaterProvider.setShareDataType("text/plain");
	// shareLaterProvider
	// .setOnShareLaterListener(new
	// DynamicShareActionProvider.OnShareLaterListener() {
	//
	// @Override
	// public void onShareClick(Intent shareIntent) {
	// MyShareAsyncTask task = new MyShareAsyncTask();
	// task.execute(shareIntent);
	// }
	//
	// });
	//
	// return true;
	// }
	// return super.onCreateOptionsMenu(menu);
	// }
	//
	// private class MyShareAsyncTask extends AsyncTask<Intent, Void, Intent> {
	//
	// @Override
	// protected void onPreExecute() {
	// Toast.makeText(MainActivity.this, R.string.asynctask,
	// Toast.LENGTH_LONG).show();
	// }
	//
	// @Override
	// protected Intent doInBackground(Intent... intents) {
	// try {
	// Thread.sleep(2000);
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// }
	//
	// // EditText shareEdit = (EditText) findViewById(R.id.share_edit);
	// // intents[0].putExtra(android.content.Intent.EXTRA_TEXT,
	// // "Shared from an AsyncTask: " + shareEdit.getText().toString());
	//
	// return intents[0];
	// }
	//
	// @Override
	// protected void onPostExecute(Intent intent) {
	// startActivity(intent);
	// }
	//
	// }

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// if (!mNavigationDrawerFragment.isDrawerOpen()) {
	// // Only show items in the action bar relevant to this screen
	// // if the drawer is not showing. Otherwise, let the drawer
	// // decide what to show in the action bar.
	// getMenuInflater().inflate(R.menu.main, menu);
	// restoreActionBar();
	// return true;
	// }
	// return super.onCreateOptionsMenu(menu);
	// }

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {

			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		private static final String ARG_SECTION_NUMBER = "section_number";

		/**
		 * Returns a new instance of this fragment for the given section number.
		 */
		public static PlaceholderFragment newInstance(int sectionNumber) {
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}

		@Override
		public void onAttach(Activity activity) {
			super.onAttach(activity);
			((MainActivity) activity).onSectionAttached(getArguments().getInt(
					ARG_SECTION_NUMBER));
		}

	}

	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// This gets called
		super.onActivityResult(requestCode, resultCode, data);
		Session.getActiveSession().onActivityResult(this,
				requestCode, resultCode, data);
		Toast.makeText(getApplication(), "Consumed by activity",
				Toast.LENGTH_SHORT).show();
	}

}
