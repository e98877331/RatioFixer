package itri.u9lab.towolf.ratiofixer;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

public class RatioRelativeLayout extends RelativeLayout {

	/*
	 * Fields
	 */
	
	private Context mContext;
	private RatioFixer mRatioFixer;
	private RatioLayoutConfig mConfig;
	
	/*
	 * Constructors
	 */
	
	public RatioRelativeLayout(Context context)
	{
		this(context, RatioLayoutConfig.getDefaultConfig());
	}
	
	public RatioRelativeLayout(Context context,int pWidth,int pHeight) {
		this(context, new RatioLayoutConfig.Builder().setVirtualSize(pWidth, pHeight).build());
	}

	public RatioRelativeLayout(Context context,int pWidth,int pHeight,boolean pIsFullScreen) {
		this(context, new RatioLayoutConfig.Builder().setVirtualSize(pWidth, pHeight).setFullScreen(pIsFullScreen).build());
	}
	public RatioRelativeLayout(Context context,RatioLayoutConfig config)
	{
		super(context);
		mContext = context;
		mConfig = config;
		 
		 
		if(mConfig.isFullScreenMode)
		fullScreen();
		
		//hide actionBar in all situation when using ratio layout
        hideActionBar();

       
		//get physic screen size and use it to initialize ratiofixer
		int x =mContext.getResources().getDisplayMetrics().widthPixels;
		int y = mContext.getResources().getDisplayMetrics().heightPixels;
		mRatioFixer = new RatioFixer(mConfig);
		mRatioFixer.initialize(x, y - getStatusBarHeight());
		
		
	}
	
	/*
	 * Override methods
	 */
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);

		View rootView = this.getRootView();
		rootView.setBackgroundColor(Color.BLACK);

		setMeasuredDimension(mRatioFixer.getRealWidth(),
				mRatioFixer.getRealHeight());
	}

	/*
	 * private methods
	 */
	
	private void fullScreen()
	{
		Activity activity = (Activity)mContext;
        WindowManager.LayoutParams attrs = activity.getWindow().getAttributes();
        attrs.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        activity.getWindow().setAttributes(attrs);
	}
	
	
	private void hideActionBar()
	{
		Activity context = (Activity)mContext;
		if(context.getActionBar()!= null)
			context.getActionBar().hide();
	}
	
	
	private boolean isFullScreen()
	{
		return (((Activity)mContext).getWindow().getAttributes().flags & WindowManager.LayoutParams.FLAG_FULLSCREEN) != 0;
	}
	
	private int getStatusBarHeight() {
		
		//int flags = ((Activity)mContext).getWindow().getAttributes().flags;
		
		//case of full screen mode
		if(isFullScreen() == true)
		return 0;
		
		int result = 0;
		int resourceId = getResources().getIdentifier("status_bar_height",
				"dimen", "android");
		if (resourceId > 0) {
			result = getResources().getDimensionPixelSize(resourceId);
		}
		return result;
	}

	
	/*
	 * public methods
	 */
	
	
	public RatioFixer getRatioFixer()
	{
		return mRatioFixer;
	}

	/*
	 * add subview with width, height, and x,y position 
	 */
	public void addView(View view,int width,int height,int x, int y)
	{
		this.addView(view , mRatioFixer.getLayoutParam(width, height, x, y));
	}
	
	
	/*
	 * set this RatioRelativeLayout as target activity's content view
	 */
	public void setToContentView(Activity pActivity)
	{
		FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
				android.view.ViewGroup.LayoutParams.MATCH_PARENT,
				android.view.ViewGroup.LayoutParams.MATCH_PARENT);
		layoutParams.gravity = Gravity.CENTER;
		pActivity.setContentView(this,layoutParams);
		
	}
}
