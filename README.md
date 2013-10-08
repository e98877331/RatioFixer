RatioFixer
==========

This project aims to provide a absolute layout like compolent but user can specify max virtual width and height,

than it will automatically scaling to fit physical screen size with same aspect ratio once being set as content view.

Basic Usage:

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		RatioRelativeLayout mView = new RatioRelativeLayout(this);
		mView.setBackgroundColor(Color.WHITE);
		
		Button bt1 = new Button(this);
		
		//add bt1 to mView at (0,0) with width = 200 and height = 300
		mView.addView(bt1, 200, 300, 0, 0);
		
		TextView tv1 = new TextView(this);
		tv1.setText("Hello World");
		tv1.setBackgroundColor(Color.CYAN);
		
		//add tv1 to mView at (300,400) with wrap_content width and height
		mView.addView(tv1, RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT, 300, 400);
		
		mView.setToContentView(this);

 	}

this will make the follow layout on all devices:


You can also use the following RatioRelativeLayout contructor to specify virtual size:

	RatioRelativeLayout(context,width,heigth);

or configure the activity it attaches to use full screen mode or not in boolean:

	RatioRelativeLayout(context,width,heigth,useFullScreen);


RatioFixer:

RatioFixer is a class that maintains relationship between virtual size and physical size for each RatioRelativeLayout.

You can obtain RatioFixer by using getRatioFixer() method of RatioRelativeLayout, then use getRatio() method to get value of (physical size)/(virtual size)

Alternatively, you can directly use getRealValue(virtual width/height) to get real pixel length on screen by given virtual width/heigth. 

RatioFixer operations may be useful in some circumstances such like add padding or set text size,

because these methods in Android sdk are not under control of RatioRelativeLayout and use pixel as parameter unit instead of our own defined virtual size.

As the consquence, we have to translate virtual size which we'd like to use to real pixel length manually.

for example:

	RatioRelativeLayout mainLayout = new RatioRelativeLayout(this);
	RatioFixer rf = mainLayout.getRatioFixer(); 
	
	btn1.setPadding(rf.getRealValue(5), rf.getRealValue(5), 0, 0);



Note:

0. Everything add to layout by using addView(View view,int width,int height,int x, int y) method will be calculated to real pixel size according to different devices. 

1. Action bar always be hidden by RatioRelativeLayout. 

2. Default virtual size for acitivitys with status bar is 

    int VIRTUALWIDTH = 768;
    int VIRTUALHEIGHT = 1230;

    without status bar is 
   
    int VIRTUALWIDTH = 768;
    int VIRTUALHEIGHT = 1280;


