RatioFixer
==========

An extended Activity class for Android which we can specify exact locations (x/y coordinates) according to our own defined virtual size, then scale to any screen size by ratio automatically.


Welcome to the RatioFixer wiki!

This project is supported by Industrial Technology Research Institute A100 Team of Taiwan.


RatioFixer works as below:

    public class TestActivity extends RatioActivity {
    //two button for demo
    Button btn1;
    Button btn2;
        /*optional function, you can set virtual size here. default size:   
         int VIRTUALWIDTH = 768;
	 int VIRTUALHEIGHT = 1230;
        */
	@Override
	public void onInitialize() {
		// TODO Auto-generated method stub
		super.onInitialize();
                  
                /* This line will set default virtual size for all ratio activity.
                 * make sure always invoke this function in onInitialize()
                 */
		setDefaultVirtualSize(1280,718);
                /* This line will set individual virtual size for this ratio activity.
                 * Ignore default virtual size if set;
                 * make sure always invoke this function in onInitialize()
                 */
                setVirtualSize(1280,718);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	   btn1 = new Button(this);
	   btn2 = new Button(this);
	   addView(btn1, 1280, 200, 0, 0);
	   addView(btn2, 640, 100, 615, 200);
	}
    }

Note:

0. Always remember that everything add to screen by using RatioActivity.addView() method have been calculated to real dimension for each device before showing. 
1. this.getActionBar().hide() will default called in RationAcitity. 
2. Every RatioActivity holds their own RatioFixer to maintain virtual size and ratio.
   So if you have two Activity for both portrait and landscape, remember to set different Virtual size in "OnInitialize()";

3.Use Acticity.this.getRealValue() to translate virtual values to real size. This may be useful when doing something like add padding or set text size. for example
    
    btn1.setPadding(getRealValue(5), getRealValue(5), 0, 0);

4. Default virtual size is 

    int VIRTUALWIDTH = 768;
    int VIRTUALHEIGHT = 1230;

which in my opinion is the best value for nowaday devices in portrait mode with status bar.And

    int VIRTUALHEIGHT = 1280;

without status bar;
