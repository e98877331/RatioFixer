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
		LayoutParams rp = new LayoutParams(width<0?width:getRealValue(width),
				height<0?height:getRealValue(height));
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

	/**
	 * Convert virtual size to read pixel size
	 * 
	 * @param v
	 * @return
	 */

	public int getRealValue(int p) {
		return (int) (p * ratio);
	}

	/**
	 * Get max width in pixel
	 * 
	 * @return
	 */

	public int getRealWidth() {
		return realWidth;

	}

	/**
	 * Get max height in pixel
	 * 
	 * @return
	 */
	public int getRealHeight() {
		return realHeight;
	}

}
