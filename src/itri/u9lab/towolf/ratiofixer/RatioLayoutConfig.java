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

public class RatioLayoutConfig {

	final int virtualWidth;
	final int virtualHeight;

	// if true, turn on full screen mode if not turned on yet
	final boolean isFullScreenMode;

	/*
	 * constructor
	 */

	public RatioLayoutConfig(Builder pBuilder) {
		this.virtualHeight = pBuilder.virtualHeight;
		this.virtualWidth = pBuilder.virtualWidth;
		this.isFullScreenMode = pBuilder.isFullScreenMode;
	}

	/*
	 * config builder
	 */
	public static class Builder {
		private int virtualWidth = 768;
		private int virtualHeight = 1230;
		boolean isFullScreenMode = false;

		public Builder() {

		}

		/**
		 * Set device independent virtual size of RatioRelativeLayout, which
		 * will scale to maximum as it could on the physic screen with keeping
		 * aspect.
		 * 
		 * @param pWidth
		 * @param pHeight
		 * @return
		 */
		public Builder setVirtualSize(int pWidth, int pHeight) {
			virtualWidth = pWidth;
			virtualHeight = pHeight;
			return this;
		}

		/**
		 * If set this value to true, full screen mode will be turned on.
		 * 
		 * @param mode
		 * @return
		 */
		public Builder setFullScreen(boolean mode) {
			isFullScreenMode = mode;
			return this;
		}

		public RatioLayoutConfig build() {

			return new RatioLayoutConfig(this);
		}
	}// end of builder

	/**
	 * Generate default RatioLayoutConfig with virtual width = 768 ,virtual
	 * height = 1230 and full screen mode off.
	 * 
	 * @return
	 */
	public static RatioLayoutConfig getDefaultConfig() {
		return new Builder().setFullScreen(false).setVirtualSize(768, 1230)
				.build();
	}

}
