package wcm.ytwhyc.ratiofixer;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;

public class RatioActivity extends Activity {

	private RatioRelativeLayout mRatioLayout;
	
	private RatioFixer mRatioFixer;
	
	public int mVWidth = 0, mVHeight =0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.getActionBar().hide();
		onInitialize();
		
//		int x, y;
//		WindowManager wm = (WindowManager) this
//				.getSystemService(Context.WINDOW_SERVICE);
//		Display display = wm.getDefaultDisplay();

		// if(Build.VERSION.SDK_INT>Build.VERSION_CODES.HONEYCOMB){
		// Point size = new Point();
		// display.getSize(size);
		// x = size.x;
		// y = size.y;
		// }
		// else{
//		x = display.getWidth(); // deprecated
//		y = display.getHeight();
		// }
       if(mVWidth != 0&&mVHeight!= 0)
    	   mRatioLayout = new RatioRelativeLayout(this,mVWidth,mVHeight);
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
//		getWindow().getDecorView().findViewById(android.R.id.content)
//				.setBackgroundColor(Color.RED);
	}

/*
 * Initialize function, executes before RatioFixer initialize. Set virtual size or default virtual size here 
 */
	public void onInitialize()
	{
		
	}
	
	
	
	/*
	 * This function will invoke after the layout is drawn
	 */
	public void onLayoutCreated() {

	}
	

	public RatioRelativeLayout getMainLayout() {
		return mRatioLayout;
	}
	
	public void addView(View v,int width,int height,int x,int y)
	{
		mRatioLayout.addView(v,mRatioFixer.getLayoutParam(width, height, x, y));
	}

	public int getRealValue(int v)
	{
		return mRatioFixer.getRealValue(v);
	}
	
	public RatioFixer getRatioFixer()
	{
		return mRatioFixer;
	}
	
//	public void setVirtualSize(int width, int height)
//	{
//		mRatioFixer.setVirtualSize(width, height);
//	}
//	
//	public void setDefaultVirtualSize(int width,int height)
//	{
//		RatioFixer.setDefaultVirtualSize(width, height);
//	}
}
