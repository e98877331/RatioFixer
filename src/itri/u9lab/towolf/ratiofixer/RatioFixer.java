package itri.u9lab.towolf.ratiofixer;

import android.widget.RelativeLayout.LayoutParams;

public class RatioFixer {

	static int defaultVirtualWidth =768;
	static int defaultVirtualHeight = 1230;
	
	 int virtualWidth =0;
	 int virtualHeight =0;
	// final static int VIRTUALWIDTH =1230;
	// final static int VIRTUALHEIGHT = 768;
	

	float ratio;

	int realWidth;
	int realHeight;

	public RatioFixer() {

	}

	public  LayoutParams getLayoutParam(int width, int height, int x,
			int y) {
		LayoutParams rp = new LayoutParams(getRealValue(width), getRealValue(height));
		rp.leftMargin = getRealValue(x);
		rp.topMargin = getRealValue(y);
		return rp;
	}

	public  void initialize(int pw, int ph) {
		if(virtualWidth == 0 && virtualHeight == 0)
		{
			virtualWidth = defaultVirtualWidth;
			virtualHeight = defaultVirtualHeight;
		}
		
		
		float aspect = (float) virtualHeight / virtualWidth;
		float realRatio = (float) ph / pw;
		// mInstance.ratio = VIRTUALHEIGHT/ VIRTUALWIDTH;
		// mInstance.realWidth = pw;
		// mInstance.realHeight = (int)(VIRTUALHEIGHT *mInstance.ratio);
		// mInstance.realHeight = (int)(VIRTUALHEIGHT *mInstance.ratio);

		if (realRatio < aspect) {
			realHeight = ph;
			realWidth = (int) (realHeight / aspect);

		} else {
			realWidth = pw;
			realHeight = (int) (realWidth * aspect);
		}

		ratio = (float)realWidth / virtualWidth;
	}

	public  float getRatio() {
		return ratio;
	}

	public  int getRealValue(int p) {
		return (int) (p * ratio);
	}

	public  void setVirtualSize(int vWidth, int vHeight) {
		virtualWidth = vWidth;
		virtualHeight = vHeight;
	}
	

	public  int getRealWidth() {
		return realWidth;

	}

	public  int getRealHeight() {
		return realHeight;
	}


	public static void setDefaultVirtualSize(int vWidth,int vHeigth)
	{
		defaultVirtualWidth = vWidth;
		defaultVirtualHeight = vHeigth;
	}
	
}
