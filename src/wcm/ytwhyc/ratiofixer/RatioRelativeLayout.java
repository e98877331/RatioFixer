package wcm.ytwhyc.ratiofixer;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;

public class RatioRelativeLayout extends RelativeLayout {

	private Context mContext;
	private RatioFixer mRatioFixer;
	
	public RatioRelativeLayout(Context context)
	{
		super(context);
		mContext = context;
		WindowManager wm = (WindowManager)
				context.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		//Point size = new Point();
		//display.getSize(size);
		int x =display.getWidth();
		int y = display.getHeight();
		mRatioFixer = new RatioFixer();
		mRatioFixer.initialize(x, y - getStatusBarHeight());
	}
	
	public RatioRelativeLayout(Context context,int width,int height) {
		super(context);
		// TODO Auto-generated constructor stub
		mContext = context;
		WindowManager wm = (WindowManager)
				context.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		//Point size = new Point();
		//display.getSize(size);
		int x =display.getWidth();
		int y = display.getHeight();
		mRatioFixer = new RatioFixer();
		mRatioFixer.setVirtualSize(width, height);
		
		mRatioFixer.initialize(x, y - getStatusBarHeight());

	}

	private int getStatusBarHeight() {
		int result = 0;
		int resourceId = getResources().getIdentifier("status_bar_height",
				"dimen", "android");
		if (resourceId > 0) {
			result = getResources().getDimensionPixelSize(resourceId);
		}
		return result;
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);

		View rootView = this.getRootView();
		rootView.setBackgroundColor(Color.BLACK);

//		 int widthSize = MeasureSpec.getSize(widthMeasureSpec);
//		 int heightSize = MeasureSpec.getSize(heightMeasureSpec);
//		 RatioFixer.initialize(widthSize, heightSize - getStatusBarHeight());

		// int x = RatioFixer.getRealWidth();
		// int y = RatioFixer.getRealHeight();

		setMeasuredDimension(mRatioFixer.getRealWidth(),
				mRatioFixer.getRealHeight());
	}

	
	public RatioFixer getRatioFixer()
	{
		return mRatioFixer;
	}
	// protected void onLayout (boolean changed, int left, int top, int right,
	// int bottom) {
	// // double factor = (right - left) / (double)_virtualWidth;
	//
	// int nchildren = getChildCount();
	//
	// for(int i = 0; i < nchildren; i++) {
	// View child = getChildAt(i);
	// LayoutParams lp = (LayoutParams) child.getLayoutParams();
	// // Scale child according to given space
	// float factor = RatioFixer.getRatio();
	// child.layout((int)(lp.leftMargin * factor),
	// (int)(lp.topMargin * factor),
	// (int)((lp.leftMargin + child.getMeasuredWidth()) * factor),
	// (int)((lp.topMargin + child.getMeasuredHeight()) * factor ));
	// }
	// }

	
	public void addView(View view,int width,int height,int x, int y)
	{
		this.addView(view , mRatioFixer.getLayoutParam(width, height, x, y));
	}
}
