package itri.u9lab.towolf.ratiofixer;

import android.widget.RelativeLayout.LayoutParams;

public class RatioFixer {

	
	int virtualWidth;
	int virtualHeight;

	RatioLayoutConfig mConfig;

	float ratio;
	int realWidth;
	int realHeight;

	public RatioFixer(RatioLayoutConfig pConfig) {
		mConfig = pConfig;
		virtualWidth = mConfig.virtualWidth;
		virtualHeight = mConfig.virtualHeight;
	}

	public LayoutParams getLayoutParam(int width, int height, int x, int y) {
		LayoutParams rp = new LayoutParams(getRealValue(width),
				getRealValue(height));
		rp.leftMargin = getRealValue(x);
		rp.topMargin = getRealValue(y);
		return rp;
	}

	public void initialize(int pw, int ph) {

		float aspect = (float) virtualHeight / virtualWidth;
		float realRatio = (float) ph / pw;


		if (realRatio < aspect) {
			realHeight = ph;
			realWidth = (int) (realHeight / aspect);

		} else {
			realWidth = pw;
			realHeight = (int) (realWidth * aspect);
		}

		ratio = (float) realWidth / virtualWidth;
	}

	public float getRatio() {
		return ratio;
	}

	public int getRealValue(int p) {
		return (int) (p * ratio);
	}


	public int getRealWidth() {
		return realWidth;

	}

	public int getRealHeight() {
		return realHeight;
	}


}
