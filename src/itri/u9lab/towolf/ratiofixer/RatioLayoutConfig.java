package itri.u9lab.towolf.ratiofixer;

public class RatioLayoutConfig {

	final int virtualWidth;
	final int virtualHeight;	
	
	//if true, turn on full screen mode if not turned on yet
	final boolean isFullScreenMode;
    
/*
 * constructor	
 */

    public RatioLayoutConfig(Builder pBuilder)
    {
        this.virtualHeight = pBuilder.virtualHeight;
        this.virtualWidth = pBuilder.virtualWidth;
        this.isFullScreenMode = pBuilder.isFullScreenMode;
    }
    
    
 /*
  * config builder
  */
 public  static class Builder
 {
	 private int virtualWidth = 768;
	 private int virtualHeight =1230;
	 boolean isFullScreenMode = false;
	 
	 public Builder()
	 {
		 
	 }
	 
	 /**
	  * Set device independent virtual size of RatioRelativeLayout, which will scale to maximum as it could on the physic screen with keeping aspect.  
	  * @param pWidth
	  * @param pHeight
	  * @return
	  */
	 public Builder setVirtualSize(int pWidth,int pHeight)
	 {
	   virtualWidth = pWidth;
	   virtualHeight = pHeight;
	   return this;
	 }
	 
	 
	 /**
	  * If set this value to true, full screen mode will be turned on. 
	  * @param mode
	  * @return
	  */
	 public Builder setFullScreen(boolean mode)
	 {
		 isFullScreenMode = mode;
		 return this;
	 }
	 
	 public RatioLayoutConfig build()
	 {
		 
		 return new RatioLayoutConfig(this);
	 }
 }//end of builder
    
    /**
     * Generate default RatioLayoutConfig with virtual width = 768 ,virtual height = 1230 and full screen mode off.
     * @return
     */
    public static RatioLayoutConfig getDefaultConfig()
    {
    	return new Builder().setFullScreen(false).setVirtualSize(768, 1230).build();
    }
	
}
