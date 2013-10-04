package itri.u9lab.towolf.ratiofixer;

public class RatioLayoutConfig {

	final int virtualWidth;
	final int virtualHeight;	
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
    
    
    
 public  static class Builder
 {
	 private int virtualWidth = 768;
	 private int virtualHeight =1230;
	 boolean isFullScreenMode = false;
	 
	 public Builder()
	 {
		 
	 }
	 
	 public Builder setVirtualSize(int pWidth,int pHeight)
	 {
	   virtualWidth = pWidth;
	   virtualHeight = pHeight;
	   return this;
	 }
	 
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
    
 
 /*
  * generate default RatioLayoutConfig
  */
    public static RatioLayoutConfig getDefaultConfig()
    {
    	return new Builder().setFullScreen(false).setVirtualSize(768, 1230).build();
    }
	
}
