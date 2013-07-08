RatioFixer
==========

An extended Activity class for Android which we can specify exact locations (x/y coordinates) according to our own defined virtual size, then scale to any screen size by ratio automatically.


This project is supported by Industrial Technology Research Institute Big Data Center A100 Team of Taiwan.

You have two ways to use RatioRelativeLayout,

Firstly, use RatioAcitivty:

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


Or secondary, use RatioRelativeLayout directly:

    public class RatioRelativeLayoutTest extends Activity{
	Button btn1,btn2;
	RatioRelativeLayout mainLayout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//setting total units of width and height you want
		mainLayout = new RatioRelativeLayout(this,500,500);
		
		//or use default size which is defined as width * height = 768 *1230
		//mainLayout = new RatioRelativeLayout(this);
		
		mainLayout.setBackgroundColor(Color.WHITE);
	
		LayoutParams layoutParams = new LayoutParams(
				android.view.ViewGroup.LayoutParams.MATCH_PARENT,
				android.view.ViewGroup.LayoutParams.MATCH_PARENT);
		layoutParams.gravity = Gravity.CENTER;
		setContentView(mainLayout,layoutParams);
		
		btn1 = new Button(this);
		mainLayout.addView(btn1,500,250,0,0);
		
		btn2 = new Button(this);
	        mainLayout.addView(btn2,250,100,0,250);
		
	}

    }





Note:

0. Always remember that everything add to screen by using addView(View view,int width,int height,int x, int y) method have been calculated to real dimension for each device before drawing. 
1. this.getActionBar().hide() will called in RationAcitity in default setting. 
2. If you have two Activity for both portrait and landscape, remember to set different Virtual size;

3. Use Acticity.this.getRealValue() to translate virtual values to real size. This may be useful when doing something like add padding or set text size. for example
    
    btn1.setPadding(getRealValue(5), getRealValue(5), 0, 0);

4. Default virtual size is 

    int VIRTUALWIDTH = 768;
    int VIRTUALHEIGHT = 1230;

which in my opinion is the best value for nowaday devices in portrait mode with status bar. And

    int VIRTUALHEIGHT = 1280;

without status bar;
