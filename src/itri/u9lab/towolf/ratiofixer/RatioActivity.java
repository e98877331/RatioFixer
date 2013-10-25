/*******************************************************************************
 * Copyright 2013 U9Lab,Industrial Technology Research Institute
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

/*
 * This class is deprecated. not sure if it functions well.
 * */

package itri.u9lab.towolf.ratiofixer;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;

public class RatioActivity extends Activity {

	private RatioRelativeLayout mRatioLayout;

	private RatioFixer mRatioFixer;

	public int mVWidth = 0, mVHeight = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.getActionBar().hide();
		onInitialize();

		if (mVWidth != 0 && mVHeight != 0)
			mRatioLayout = new RatioRelativeLayout(this, mVWidth, mVHeight);
		else
			mRatioLayout = new RatioRelativeLayout(this);
		mRatioFixer = mRatioLayout.getRatioFixer();
		mRatioLayout.post(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				onLayoutCreated();
			}
		});
		mRatioLayout.setBackgroundColor(Color.WHITE);

		LayoutParams layoutParams = new LayoutParams(
				android.view.ViewGroup.LayoutParams.MATCH_PARENT,
				android.view.ViewGroup.LayoutParams.MATCH_PARENT);
		layoutParams.gravity = Gravity.CENTER;
		setContentView(mRatioLayout, layoutParams);
		// getWindow().getDecorView().findViewById(android.R.id.content)
		// .setBackgroundColor(Color.RED);
	}

	/*
	 * Initialize function, executes before RatioFixer initialize. Set virtual
	 * size or default virtual size here
	 */
	public void onInitialize() {

	}

	/*
	 * This function will invoke after the layout is drawn
	 */
	public void onLayoutCreated() {

	}

	public RatioRelativeLayout getMainLayout() {
		return mRatioLayout;
	}

	/**
	 * Add view with width, height and (x,y) position
	 * 
	 * @param v
	 * @param width
	 * @param height
	 * @param x
	 * @param y
	 */
	public void addView(View v, int width, int height, int x, int y) {
		mRatioLayout
				.addView(v, mRatioFixer.getLayoutParam(width, height, x, y));
	}

	/**
	 * Get real pixel size by passing in virtual size
	 * 
	 * @param v
	 * @return
	 */

	public int getRealValue(int v) {
		return mRatioFixer.getRealValue(v);
	}

	public RatioFixer getRatioFixer() {
		return mRatioFixer;
	}

	public void setVirtualSize(int width, int height) {
		// mRatioFixer.setVirtualSize(width, height);
		mVWidth = width;
		mVHeight = height;
	}

}
