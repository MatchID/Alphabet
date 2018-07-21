package dela.cemerlang.s1creative.alphabet;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class Canvas_Game_Besar extends Activity implements OnTouchListener {ImageView imageView;
Bitmap bitmap;
Canvas canvas;
Paint paint;

Convert_Resolution xa1,xa2, xb1,xb2, xc1,xc2, xd1,xd2, xe1,xe2, xf1,xf2, xg1,xg2;
Convert_Resolution ya1,ya2, yb1,yb2, yc1,yc2, yd1,yd2, ye1,ye2, yf1,yf2, yg1,yg2;

int n1=0;
int n2=0;
int n3=0;
int n4=0;
int n5=0;
int n6=0;

int has=0;
String HurufKu, jikaBenar;

private CountDownTimer wkt;

float downx = 0,downy = 0,upx = 0,upy = 0;

TextView txtIsi, txtWaktu,txPoint;
MediaPlayer mp;

@SuppressLint("NewApi") 
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.canvas);

    mp=MediaPlayer.create(Canvas_Game_Besar.this, R.raw.k545_rondo);
    mp.setLooping(true);
    mp.setVolume(1.0f, 1.0f);
    
    Bundle bundle=getIntent().getExtras();
    String value=bundle.getString("nama");
    
    waktu();
    try{
    	
    txtIsi=(TextView)findViewById(R.id.txtIsi);
	txtIsi.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    txtIsi.setTypeface(Typeface.createFromAsset(getAssets(), "ARLRDBD.TTF"));
    
    txtWaktu=(TextView)findViewById(R.id.txtWaktu);
    txPoint=(TextView)findViewById(R.id.txPoint);
    

	SharedPreferences xxx=getApplicationContext().getSharedPreferences("kirim",0);
	//txPoint.setText(""+xxx.getInt("hasil",0));
    HurufKu=value;
    
    	jikaHuruf();
    
    	imageView = (ImageView) this.findViewById(R.id.imageView1);
    	imageView.setDrawingCacheEnabled(false);
        
        Display currentDisplay = getWindowManager().getDefaultDisplay();
        float dw = currentDisplay.getWidth();
        float dh = currentDisplay.getHeight();
        float aa = imageView.getWidth();
        float ab = imageView.getWidth();

        bitmap = Bitmap.createBitmap((int) dw, (int) dh,
        Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.LINEAR_TEXT_FLAG);
        paint.setDither(true);
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(50);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeCap(Paint.Cap.ROUND);
        
        imageView.setImageBitmap(bitmap);
        //imageView.setBackgroundResource(R.drawable.a);
        imageView.setOnTouchListener(this);
        
        
    
    } catch(Exception e){
    	
    }
    
    
    findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			 
	        Display currentDisplay = getWindowManager().getDefaultDisplay();
	        float dw = currentDisplay.getWidth();
	        float dh = currentDisplay.getHeight();

	        bitmap = Bitmap.createBitmap((int) dw, (int) dh,
	        Bitmap.Config.ARGB_8888);
	        canvas = new Canvas(bitmap);
	        paint = new Paint();
	        paint.setDither(true);
	        paint.setColor(Color.GREEN);
	        paint.setStrokeWidth(50);
	        paint.setStyle(Paint.Style.STROKE);
	        paint.setStrokeJoin(Paint.Join.MITER);
	        paint.setStrokeCap(Paint.Cap.ROUND);
	        
	        imageView.setImageBitmap(bitmap);

	        //TextView textView1=(TextView)findViewById(R.id.txtHuruf);
	        //textView1.setText("Width : " + dw+ ", Height : " +dh);
		}
	});
    }

@Override
public boolean onTouch(View v, MotionEvent event) {
  
int action = event.getAction();
TextView textView1=(TextView)findViewById(R.id.txtHuruf);
switch (action) {
case MotionEvent.ACTION_DOWN:
  downx = event.getX();
  downy = event.getY();
  break;
case MotionEvent.ACTION_MOVE:
  upx = event.getX();
  upy = event.getY();
  canvas.drawLine(downx, downy, upx, upy, paint);
  imageView.invalidate();
  downx = upx;
  downy = upy;
  //textView1.setText("X = "+downx+" Y = "+downy);
  jika(downx,downy);
  break;
  
case MotionEvent.ACTION_UP:
  upx = event.getX();
  upy = event.getY();
  //textView1.setText("X = "+downx+" Y = "+downy);
  jika(downx,downy);
  
  canvas.drawLine(downx, downy, upx, upy, paint);
  imageView.invalidate();
  break;
case MotionEvent.ACTION_CANCEL:
  break;
default:
  break;
}

return true;
}

public void jika(float x,float y){
    Display currentDisplay = getWindowManager().getDefaultDisplay();
    float wd = currentDisplay.getWidth();
    float hg = currentDisplay.getHeight();
    
	  TextView textView1=(TextView)findViewById(R.id.txtHuruf);
	  
	  	if (this.HurufKu.equals("A")){
	  		/*
	  		 * 165 - 873
	  		 * 359 - 426
	  		 * 559 - 881
	  		 * 267 - 744
	  		 * 426 - 747
	  		 */
		    xa1 = new Convert_Resolution(155, hg, wd);
		    xa2 = new Convert_Resolution(175, hg, wd);
		    ya1 = new Convert_Resolution(863, hg, wd);
		    ya2 = new Convert_Resolution(883, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    	{
		    		n1 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xb1 = new Convert_Resolution(349, hg, wd);
		    xb2 = new Convert_Resolution(369, hg, wd);
		    yb1 = new Convert_Resolution(416, hg, wd);
		    yb2 = new Convert_Resolution(436, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    	{
		    		n2 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xc1 = new Convert_Resolution(549, hg, wd);
		    xc2 = new Convert_Resolution(569, hg, wd);
		    yc1 = new Convert_Resolution(871, hg, wd);
		    yc2 = new Convert_Resolution(891, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    	{
		    		n3 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xd1 = new Convert_Resolution(257, hg, wd);
		    xd2 = new Convert_Resolution(277, hg, wd);
		    yd1 = new Convert_Resolution(734, hg, wd);
		    yd2 = new Convert_Resolution(754, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    	{
		    		n4 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xe1 = new Convert_Resolution(416, hg, wd);
		    xe2 = new Convert_Resolution(436, hg, wd);
		    ye1 = new Convert_Resolution(737, hg, wd);
		    ye2 = new Convert_Resolution(757, hg, wd);
		    if ((x >= xe1.getX()) && (x <= xe2.getX()) && (y >= ye1.getX()) && (y <= ye2.getX()))
		    	{
		    		n5 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		}
	  //batas A
	  
	  
	  	if (this.HurufKu.equals("B")){
	  		/*
	  		 * 203 - 435
	  		 * 207 - 862
	  		 * 505 - 509
	  		 * 527 - 756
	  		 * 275 - 640
	  		 * 289 - 867
	  		 */
		    xa1 = new Convert_Resolution(193, hg, wd);
		    xa2 = new Convert_Resolution(213, hg, wd);
		    ya1 = new Convert_Resolution(425, hg, wd);
		    ya2 = new Convert_Resolution(445, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    	{
		    		n1 = 1;
		  	      	this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		  	      	tampil(6);
		    	}
		    xb1 = new Convert_Resolution(197, hg, wd);
		    xb2 = new Convert_Resolution(217, hg, wd);
		    yb1 = new Convert_Resolution(852, hg, wd);
		    yb2 = new Convert_Resolution(872, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    	{
		    		n2 = 1;
		  	      	this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		  	      	tampil(6);
		    	}
		    xc1 = new Convert_Resolution(495, hg, wd);
		    xc2 = new Convert_Resolution(515, hg, wd);
		    yc1 = new Convert_Resolution(499, hg, wd);
		    yc2 = new Convert_Resolution(519, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    	{
		    		n3 = 1;
		  	      	this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		  	      	tampil(6);
		    	}
		    xd1 = new Convert_Resolution(517, hg, wd);
		    xd2 = new Convert_Resolution(537, hg, wd);
		    yd1 = new Convert_Resolution(746, hg, wd);
		    yd2 = new Convert_Resolution(766, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    	{
		    		n4 = 1;
		  	      	this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		  	      	tampil(6);
		    	}
		    xe1 = new Convert_Resolution(265, hg, wd);
		    xe2 = new Convert_Resolution(285, hg, wd);
		    ye1 = new Convert_Resolution(630, hg, wd);
		    ye2 = new Convert_Resolution(650, hg, wd);
		    if ((x >= xe1.getX()) && (x <= xe2.getX()) && (y >= ye1.getX()) && (y <= ye2.getX()))
		    	{
		    		n5 = 1;
		  	      	this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		  	      	tampil(6);
		    	}
		    xf1 = new Convert_Resolution(279, hg, wd);
		    xf2 = new Convert_Resolution(299, hg, wd);
		    yf1 = new Convert_Resolution(425, hg, wd);
		    yf2 = new Convert_Resolution(445, hg, wd);
		    if ((x >= xf1.getX()) && (x <= xf2.getX()) && (y >= yf1.getX()) && (y <= yf2.getX()))
		    	{
		    		n6 = 1;
		  	      	this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		  	      	tampil(6);
		    	}
		}
	  //batas B
	  
	  
	  	if (this.HurufKu.equals("C")){
	  		/*
	  		 * 548 - 550
	  		 * 547 - 737
	  		 * 178 - 636
	  		 * 354 - 877
	  		 */
		    xa1 = new Convert_Resolution(538, hg, wd);
		    xa2 = new Convert_Resolution(558, hg, wd);
		    ya1 = new Convert_Resolution(540, hg, wd);
		    ya2 = new Convert_Resolution(560, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    {
		      n1 = 1;
		      this.has = (n1 + n2 + n3 + n4);
		      tampil(4);
		    }
		    xb1 = new Convert_Resolution(537, hg, wd);
		    xb2 = new Convert_Resolution(557, hg, wd);
		    yb1 = new Convert_Resolution(727, hg, wd);
		    yb2 = new Convert_Resolution(747, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    {
		      n2 = 1;
		      this.has = (n1 + n2 + n3 + n4);
		      tampil(4);
		    }
		    xc1 = new Convert_Resolution(168, hg, wd);
		    xc2 = new Convert_Resolution(188, hg, wd);
		    yc1 = new Convert_Resolution(626, hg, wd);
		    yc2 = new Convert_Resolution(646, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    {
		      n3 = 1;
		      this.has = (n1 + n2 + n3 + n4);
		      tampil(4);
		    }
		    xd1 = new Convert_Resolution(344, hg, wd);
		    xd2 = new Convert_Resolution(364, hg, wd);
		    yd1 = new Convert_Resolution(867, hg, wd);
		    yd2 = new Convert_Resolution(887, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    {
		      n4 = 1;
		      this.has = (n1 + n2 + n3 + n4);
		      tampil(4);
		    }	
	  	}
	  //batas C
	  
	  
	    if (this.HurufKu.equals("D")){
	    	/*
	    	 * 207 - 423
	    	 * 204 - 859
	    	 * 507 - 503
	    	 * 270 - 867
	    	 * 287 - 426
	    	 */
		    xa1 = new Convert_Resolution(197, hg, wd);
		    xa2 = new Convert_Resolution(217, hg, wd);
		    ya1 = new Convert_Resolution(413, hg, wd);
		    ya2 = new Convert_Resolution(433, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    	{
		    		n1 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xb1 = new Convert_Resolution(194, hg, wd);
		    xb2 = new Convert_Resolution(214, hg, wd);
		    yb1 = new Convert_Resolution(849, hg, wd);
		    yb2 = new Convert_Resolution(869, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    	{
		    		n2 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xc1 = new Convert_Resolution(497, hg, wd);
		    xc2 = new Convert_Resolution(517, hg, wd);
		    yc1 = new Convert_Resolution(493, hg, wd);
		    yc2 = new Convert_Resolution(513, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    	{
		    		n3 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xd1 = new Convert_Resolution(260, hg, wd);
		    xd2 = new Convert_Resolution(280, hg, wd);
		    yd1 = new Convert_Resolution(857, hg, wd);
		    yd2 = new Convert_Resolution(877, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    	{
		    		n4 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xe1 = new Convert_Resolution(277, hg, wd);
		    xe2 = new Convert_Resolution(297, hg, wd);
		    ye1 = new Convert_Resolution(416, hg, wd);
		    ye2 = new Convert_Resolution(436, hg, wd);
		    if ((x >= xe1.getX()) && (x <= xe2.getX()) && (y >= ye1.getX()) && (y <= ye2.getX()))
		    	{
		    		n5 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		}
	  //batas D
	  
	  
	  
	    if (this.HurufKu.equals("E")){
	    	/*
	    	 * 238 - 423
	    	 * 233 - 859
	    	 * 470 - 638
	    	 * 527 - 867
	    	 * 524 - 428
	    	 */
		    xa1 = new Convert_Resolution(218, hg, wd);
		    xa2 = new Convert_Resolution(248, hg, wd);
		    ya1 = new Convert_Resolution(413, hg, wd);
		    ya2 = new Convert_Resolution(433, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    	{
		    		n1 = 1;
		  	      	this.has = (n1 + n2 + n3 + n4 + n5);
		  	      	tampil(5);
		    	}
		    xb1 = new Convert_Resolution(213, hg, wd);
		    xb2 = new Convert_Resolution(243, hg, wd);
		    yb1 = new Convert_Resolution(849, hg, wd);
		    yb2 = new Convert_Resolution(869, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    	{
		    		n2 = 1;
		  	      	this.has = (n1 + n2 + n3 + n4 + n5);
		  	      	tampil(5);
		    	}
		    xc1 = new Convert_Resolution(460, hg, wd);
		    xc2 = new Convert_Resolution(480, hg, wd);
		    yc1 = new Convert_Resolution(628, hg, wd);
		    yc2 = new Convert_Resolution(648, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    	{
		    		n3 = 1;
		  	      	this.has = (n1 + n2 + n3 + n4 + n5);
		  	      	tampil(5);
		    	}
		    xd1 = new Convert_Resolution(517, hg, wd);
		    xd2 = new Convert_Resolution(537, hg, wd);
		    yd1 = new Convert_Resolution(857, hg, wd);
		    yd2 = new Convert_Resolution(877, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    	{
		    		n4 = 1;
		  	      	this.has = (n1 + n2 + n3 + n4 + n5);
		  	      	tampil(5);
		    	}
		    xe1 = new Convert_Resolution(514, hg, wd);
		    xe2 = new Convert_Resolution(534, hg, wd);
		    ye1 = new Convert_Resolution(418, hg, wd);
		    ye2 = new Convert_Resolution(438, hg, wd);
		    if ((x >= xe1.getX()) && (x <= xe2.getX()) && (y >= ye1.getX()) && (y <= ye2.getX()))
		    	{
		    		n5 = 1;
		  	      	this.has = (n1 + n2 + n3 + n4 + n5);
		  	      	tampil(5);
		    	}
		}
	  //batas E
	  
	
	    if (this.HurufKu.equals("F")){
	    	/*
	    	 * 253 - 883
	    	 * 253 - 435
	    	 * 521 - 430
	    	 * 471 - 640
	    	 */
		    xa1 = new Convert_Resolution(243, hg, wd);
		    xa2 = new Convert_Resolution(263, hg, wd);
		    ya1 = new Convert_Resolution(873, hg, wd);
		    ya2 = new Convert_Resolution(893, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    {
		      n1 = 1;
		      this.has = (n1 + n2 + n3 + n4);
		      tampil(4);
		    }
		    xb1 = new Convert_Resolution(243, hg, wd);
		    xb2 = new Convert_Resolution(263, hg, wd);
		    yb1 = new Convert_Resolution(425, hg, wd);
		    yb2 = new Convert_Resolution(445, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    {
		      n2 = 1;
		      this.has = (n1 + n2 + n3 + n4);
		      tampil(4);
		    }
		    xc1 = new Convert_Resolution(511, hg, wd);
		    xc2 = new Convert_Resolution(531, hg, wd);
		    yc1 = new Convert_Resolution(420, hg, wd);
		    yc2 = new Convert_Resolution(440, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    {
		      n3 = 1;
		      this.has = (n1 + n2 + n3 + n4);
		      tampil(4);
		    }	
		    xd1 = new Convert_Resolution(461, hg, wd);
		    xd2 = new Convert_Resolution(481, hg, wd);
		    yd1 = new Convert_Resolution(630, hg, wd);
		    yd2 = new Convert_Resolution(650, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    {
		      n4 = 1;
		      this.has = (n1 + n2 + n3 + n4);
		      tampil(4);
		    }	
	  	}
	  //batas F
	  


	    if (this.HurufKu.equals("G")){
	    	/*
	    	 * 541 - 523
	    	 * 410 - 670
	    	 * 376 - 882
	    	 * 159 - 663
	    	 * 554 - 761
	    	 */
		    xa1 = new Convert_Resolution(531, hg, wd);
		    xa2 = new Convert_Resolution(551, hg, wd);
		    ya1 = new Convert_Resolution(513, hg, wd);
		    ya2 = new Convert_Resolution(533, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    	{
		    		n1 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xb1 = new Convert_Resolution(400, hg, wd);
		    xb2 = new Convert_Resolution(420, hg, wd);
		    yb1 = new Convert_Resolution(660, hg, wd);
		    yb2 = new Convert_Resolution(680, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    	{
		    		n2 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xc1 = new Convert_Resolution(366, hg, wd);
		    xc2 = new Convert_Resolution(386, hg, wd);
		    yc1 = new Convert_Resolution(872, hg, wd);
		    yc2 = new Convert_Resolution(892, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    	{
		    		n3 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xd1 = new Convert_Resolution(149, hg, wd);
		    xd2 = new Convert_Resolution(169, hg, wd);
		    yd1 = new Convert_Resolution(653, hg, wd);
		    yd2 = new Convert_Resolution(673, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    	{
		    		n4 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xe1 = new Convert_Resolution(544, hg, wd);
		    xe2 = new Convert_Resolution(564, hg, wd);
		    ye1 = new Convert_Resolution(751, hg, wd);
		    ye2 = new Convert_Resolution(771, hg, wd);
		    if ((x >= xe1.getX()) && (x <= xe2.getX()) && (y >= ye1.getX()) && (y <= ye2.getX()))
		    	{
		    		n5 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		}
	  //batas G
	  
	  
	  
	    if (this.HurufKu.equals("H")){
	    	/*
	    	 * 200 - 409
	    	 * 200 - 866
	    	 * 524 - 409
	    	 * 524 - 874
	    	 * 288 - 631
	    	 * 447 - 630
	    	 */
		    xa1 = new Convert_Resolution(190, hg, wd);
		    xa2 = new Convert_Resolution(210, hg, wd);
		    ya1 = new Convert_Resolution(399, hg, wd);
		    ya2 = new Convert_Resolution(419, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    {
		      n1 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		      tampil(6);
		    }
		    xb1 = new Convert_Resolution(190, hg, wd);
		    xb2 = new Convert_Resolution(210, hg, wd);
		    yb1 = new Convert_Resolution(856, hg, wd);
		    yb2 = new Convert_Resolution(876, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    {
		      n2 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		      tampil(6);
		    }
		    xc1 = new Convert_Resolution(514, hg, wd);
		    xc2 = new Convert_Resolution(534, hg, wd);
		    yc1 = new Convert_Resolution(399, hg, wd);
		    yc2 = new Convert_Resolution(419, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    {
		      n3 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		      tampil(6);
		    }
		    xd1 = new Convert_Resolution(514, hg, wd);
		    xd2 = new Convert_Resolution(534, hg, wd);
		    yd1 = new Convert_Resolution(864, hg, wd);
		    yd2 = new Convert_Resolution(884, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    {
		      n4 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		      tampil(6);
		    }
		    xe1 = new Convert_Resolution(278, hg, wd);
		    xe2 = new Convert_Resolution(298, hg, wd);
		    ye1 = new Convert_Resolution(621, hg, wd);
		    ye2 = new Convert_Resolution(641, hg, wd);
		    if ((x >= xe1.getX()) && (x <= xe2.getX()) && (y >= ye1.getX()) && (y <= ye2.getX()))
		    {
		      n5 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		      tampil(6);
		    }
		    xf1 = new Convert_Resolution(437, hg, wd);
		    xf2 = new Convert_Resolution(457, hg, wd);
		    yf1 = new Convert_Resolution(620, hg, wd);
		    yf2 = new Convert_Resolution(640, hg, wd);
		    if ((x >= xf1.getX()) && (x <= xf2.getX()) && (y >= yf1.getX()) && (y <= yf2.getX()))
		    {
		      n6 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		      tampil(6);
		    }	
	  	}  
	  //batas H
		  
		  
		  if (this.HurufKu.equals("I")){
			  /*
			   * 358 - 415
			   * 352 - 683
			   * 363 - 870
			   */
		    xa1 = new Convert_Resolution(348, hg, wd);
		    xa2 = new Convert_Resolution(368, hg, wd);
		    ya1 = new Convert_Resolution(405, hg, wd);
		    ya2 = new Convert_Resolution(425, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    {
		      n1 = 1;
		      this.has = (n1 + n2 + n3);
		      tampil(3);
		    }
		    xb1 = new Convert_Resolution(342, hg, wd);
		    xb2 = new Convert_Resolution(362, hg, wd);
		    yb1 = new Convert_Resolution(673, hg, wd);
		    yb2 = new Convert_Resolution(693, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    {
		      n2 = 1;
		      this.has = (n1 + n2 + n3);
		      tampil(3);
		    }
		    xc1 = new Convert_Resolution(353, hg, wd);
		    xc2 = new Convert_Resolution(373, hg, wd);
		    yc1 = new Convert_Resolution(860, hg, wd);
		    yc2 = new Convert_Resolution(880, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    {
		      n3 = 1;
		      this.has = (n1 + n2 + n3);
		      tampil(3);
		    }	
		}
	//batas I
	  
	  
	  
	  if (this.HurufKu.equals("J")){
		  /*
		   * 459 - 421
		   * 452 - 829
		   * 209 - 734
		   * 335 - 869
		   */
		    xa1 = new Convert_Resolution(449, hg, wd);
		    xa2 = new Convert_Resolution(469, hg, wd);
		    ya1 = new Convert_Resolution(411, hg, wd);
		    ya2 = new Convert_Resolution(431, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    {
		      n1 = 1;
		      this.has = (n1 + n2 + n3 + n4);
		      tampil(4);
		    }
		    xb1 = new Convert_Resolution(442, hg, wd);
		    xb2 = new Convert_Resolution(462, hg, wd);
		    yb1 = new Convert_Resolution(819, hg, wd);
		    yb2 = new Convert_Resolution(839, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    {
		      n2 = 1;
		      this.has = (n1 + n2 + n3 + n4);
		      tampil(4);
		    }
		    xc1 = new Convert_Resolution(199, hg, wd);
		    xc2 = new Convert_Resolution(219, hg, wd);
		    yc1 = new Convert_Resolution(724, hg, wd);
		    yc2 = new Convert_Resolution(744, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    {
		      n3 = 1;
		      this.has = (n1 + n2 + n3 + n4);
		      tampil(4);
		    }	
		    xd1 = new Convert_Resolution(325, hg, wd);
		    xd2 = new Convert_Resolution(345, hg, wd);
		    yd1 = new Convert_Resolution(859, hg, wd);
		    yd2 = new Convert_Resolution(879, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    {
		      n4 = 1;
		      this.has = (n1 + n2 + n3 + n4);
		      tampil(4);
		    }	
	  	}  
	//batas J
	  
	  
	  
	  if (this.HurufKu.equals("K")){
		  /*
		   * 208 - 412
		   * 208 - 873
		   * 508 - 421
		   * 533 - 855
		   * 297 - 648
		   * 393 - 654
		   */
		    xa1 = new Convert_Resolution(198, hg, wd);
		    xa2 = new Convert_Resolution(218, hg, wd);
		    ya1 = new Convert_Resolution(402, hg, wd);
		    ya2 = new Convert_Resolution(322, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    {
		      n1 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		      tampil(6);
		    }
		    xb1 = new Convert_Resolution(198, hg, wd);
		    xb2 = new Convert_Resolution(218, hg, wd);
		    yb1 = new Convert_Resolution(863, hg, wd);
		    yb2 = new Convert_Resolution(883, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    {
		      n2 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		      tampil(6);
		    }
		    xc1 = new Convert_Resolution(498, hg, wd);
		    xc2 = new Convert_Resolution(518, hg, wd);
		    yc1 = new Convert_Resolution(411, hg, wd);
		    yc2 = new Convert_Resolution(431, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    {
		      n3 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		      tampil(6);
		    }
		    xd1 = new Convert_Resolution(523, hg, wd);
		    xd2 = new Convert_Resolution(543, hg, wd);
		    yd1 = new Convert_Resolution(845, hg, wd);
		    yd2 = new Convert_Resolution(865, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    {
		      n4 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		      tampil(6);
		    }
		    xe1 = new Convert_Resolution(287, hg, wd);
		    xe2 = new Convert_Resolution(307, hg, wd);
		    ye1 = new Convert_Resolution(638, hg, wd);
		    ye2 = new Convert_Resolution(658, hg, wd);
		    if ((x >= xe1.getX()) && (x <= xe2.getX()) && (y >= ye1.getX()) && (y <= ye2.getX()))
		    {
		      n5 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		      tampil(6);
		    }
		    xf1 = new Convert_Resolution(383, hg, wd);
		    xf2 = new Convert_Resolution(403, hg, wd);
		    yf1 = new Convert_Resolution(644, hg, wd);
		    yf2 = new Convert_Resolution(664, hg, wd);
		    if ((x >= xf1.getX()) && (x <= xf2.getX()) && (y >= yf1.getX()) && (y <= yf2.getX()))
		    {
		      n6 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		      tampil(6);
		    }
		}	  
	//batas K
	  
	  
	  
	  if (this.HurufKu.equals("L")){
		  /*
		   * 247 - 420
		   * 245 - 841
		   * 311 - 861
		   * 526 - 867
		   */
		    xa1 = new Convert_Resolution(237, hg, wd);
		    xa2 = new Convert_Resolution(257, hg, wd);
		    ya1 = new Convert_Resolution(410, hg, wd);
		    ya2 = new Convert_Resolution(430, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    {
		      n1 = 1;
		      this.has = (n1 + n2 + n3 + n4);
		      tampil(4);
		    }
		    xb1 = new Convert_Resolution(235, hg, wd);
		    xb2 = new Convert_Resolution(255, hg, wd);
		    yb1 = new Convert_Resolution(831, hg, wd);
		    yb2 = new Convert_Resolution(851, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    {
		      n2 = 1;
		      this.has = (n1 + n2 + n3 + n4);
		      tampil(4);
		    }
		    xc1 = new Convert_Resolution(301, hg, wd);
		    xc2 = new Convert_Resolution(321, hg, wd);
		    yc1 = new Convert_Resolution(851, hg, wd);
		    yc2 = new Convert_Resolution(871, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    {
		      n3 = 1;
		      this.has = (n1 + n2 + n3 + n4);
		      tampil(4);
		    }	
		    xd1 = new Convert_Resolution(516, hg, wd);
		    xd2 = new Convert_Resolution(536, hg, wd);
		    yd1 = new Convert_Resolution(857, hg, wd);
		    yd2 = new Convert_Resolution(887, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    {
		      n4 = 1;
		      this.has = (n1 + n2 + n3 + n4);
		      tampil(4);
		    }	
	  	}	  
	//batas L
	  
	  
	  
	  if (this.HurufKu.equals("M")){
		  /*
		   * 159 - 859
		   * 365 - 859
		   * 571 - 859
		   * 204 - 438
		   * 528 - 438
		   */
		    xa1 = new Convert_Resolution(149, hg, wd);
		    xa2 = new Convert_Resolution(169, hg, wd);
		    ya1 = new Convert_Resolution(849, hg, wd);
		    ya2 = new Convert_Resolution(869, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    	{
		    		n1 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xb1 = new Convert_Resolution(355, hg, wd);
		    xb2 = new Convert_Resolution(375, hg, wd);
		    yb1 = new Convert_Resolution(849, hg, wd);
		    yb2 = new Convert_Resolution(869, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    	{
		    		n2 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xc1 = new Convert_Resolution(561, hg, wd);
		    xc2 = new Convert_Resolution(581, hg, wd);
		    yc1 = new Convert_Resolution(849, hg, wd);
		    yc2 = new Convert_Resolution(869, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    	{
		    		n3 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xd1 = new Convert_Resolution(194, hg, wd);
		    xd2 = new Convert_Resolution(214, hg, wd);
		    yd1 = new Convert_Resolution(428, hg, wd);
		    yd2 = new Convert_Resolution(448, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    	{
		    		n4 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xe1 = new Convert_Resolution(518, hg, wd);
		    xe2 = new Convert_Resolution(538, hg, wd);
		    ye1 = new Convert_Resolution(328, hg, wd);
		    ye2 = new Convert_Resolution(448, hg, wd);
		    if ((x >= xe1.getX()) && (x <= xe2.getX()) && (y >= ye1.getX()) && (y <= ye2.getX()))
		    	{
		    		n5 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		}
	//batas M
	  
	  
	  
	  if (this.HurufKu.equals("N")){
		  /*
		   * 195 - 867
		   * 218 - 435
		   * 366 - 665
		   * 542 - 853
		   * 524 - 416
		   */
		    xa1 = new Convert_Resolution(185, hg, wd);
		    xa2 = new Convert_Resolution(205, hg, wd);
		    ya1 = new Convert_Resolution(857, hg, wd);
		    ya2 = new Convert_Resolution(877, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    	{
		    		n1 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xb1 = new Convert_Resolution(208, hg, wd);
		    xb2 = new Convert_Resolution(228, hg, wd);
		    yb1 = new Convert_Resolution(425, hg, wd);
		    yb2 = new Convert_Resolution(445, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    	{
		    		n2 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xc1 = new Convert_Resolution(356, hg, wd);
		    xc2 = new Convert_Resolution(376, hg, wd);
		    yc1 = new Convert_Resolution(655, hg, wd);
		    yc2 = new Convert_Resolution(675, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    	{
		    		n3 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xd1 = new Convert_Resolution(532, hg, wd);
		    xd2 = new Convert_Resolution(552, hg, wd);
		    yd1 = new Convert_Resolution(843, hg, wd);
		    yd2 = new Convert_Resolution(863, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    	{
		    		n4 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xe1 = new Convert_Resolution(532, hg, wd);
		    xe2 = new Convert_Resolution(552, hg, wd);
		    ye1 = new Convert_Resolution(406, hg, wd);
		    ye2 = new Convert_Resolution(426, hg, wd);
		    if ((x >= xe1.getX()) && (x <= xe2.getX()) && (y >= ye1.getX()) && (y <= ye2.getX()))
		    	{
		    		n5 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		}	  
	//batas N
	  
	  
	  
	  if (this.HurufKu.equals("O")){
		  /*
		   * 554 - 652
		   * 165 - 648
		   * 268 - 850
		   * 463 - 443
		   * 492 - 818
		   */
		    xa1 = new Convert_Resolution(544, hg, wd);
		    xa2 = new Convert_Resolution(564, hg, wd);
		    ya1 = new Convert_Resolution(642, hg, wd);
		    ya2 = new Convert_Resolution(662, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    	{
		    		n1 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xb1 = new Convert_Resolution(155, hg, wd);
		    xb2 = new Convert_Resolution(175, hg, wd);
		    yb1 = new Convert_Resolution(638, hg, wd);
		    yb2 = new Convert_Resolution(658, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    	{
		    		n2 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xc1 = new Convert_Resolution(258, hg, wd);
		    xc2 = new Convert_Resolution(278, hg, wd);
		    yc1 = new Convert_Resolution(840, hg, wd);
		    yc2 = new Convert_Resolution(860, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    	{
		    		n3 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xd1 = new Convert_Resolution(453, hg, wd);
		    xd2 = new Convert_Resolution(473, hg, wd);
		    yd1 = new Convert_Resolution(433, hg, wd);
		    yd2 = new Convert_Resolution(453, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    	{
		    		n4 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xe1 = new Convert_Resolution(483, hg, wd);
		    xe2 = new Convert_Resolution(502, hg, wd);
		    ye1 = new Convert_Resolution(808, hg, wd);
		    ye2 = new Convert_Resolution(828, hg, wd);
		    if ((x >= xe1.getX()) && (x <= xe2.getX()) && (y >= ye1.getX()) && (y <= ye2.getX()))
		    	{
		    		n5 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		}	 	  
	//batas O
	  
	  
	  
	  if (this.HurufKu.equals("P")){
		  /*
		   * 230 - 863
		   * 233 - 442
		   * 497 - 474
		   * 313 - 669
		   * 468 - 637
		   */
		    xa1 = new Convert_Resolution(220, hg, wd);
		    xa2 = new Convert_Resolution(240, hg, wd);
		    ya1 = new Convert_Resolution(853, hg, wd);
		    ya2 = new Convert_Resolution(873, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    	{
		    		n1 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xb1 = new Convert_Resolution(223, hg, wd);
		    xb2 = new Convert_Resolution(243, hg, wd);
		    yb1 = new Convert_Resolution(432, hg, wd);
		    yb2 = new Convert_Resolution(452, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    	{
		    		n2 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xc1 = new Convert_Resolution(487, hg, wd);
		    xc2 = new Convert_Resolution(507, hg, wd);
		    yc1 = new Convert_Resolution(464, hg, wd);
		    yc2 = new Convert_Resolution(484, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    	{
		    		n3 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xd1 = new Convert_Resolution(303, hg, wd);
		    xd2 = new Convert_Resolution(323, hg, wd);
		    yd1 = new Convert_Resolution(659, hg, wd);
		    yd2 = new Convert_Resolution(679, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    	{
		    		n4 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xe1 = new Convert_Resolution(458, hg, wd);
		    xe2 = new Convert_Resolution(478, hg, wd);
		    ye1 = new Convert_Resolution(627, hg, wd);
		    ye2 = new Convert_Resolution(647, hg, wd);
		    if ((x >= xe1.getX()) && (x <= xe2.getX()) && (y >= ye1.getX()) && (y <= ye2.getX()))
		    	{
		    		n5 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		}	  
	//batas P
	  
	  
	  
	  if (this.HurufKu.equals("Q")){
		  /*
		   * 545 - 544
		   * 191 - 780
		   * 256 - 443
		   * 366 - 795
		   * 595 - 910
		   * 458 - 841
		   */
		    xa1 = new Convert_Resolution(535, hg, wd);
		    xa2 = new Convert_Resolution(555, hg, wd);
		    ya1 = new Convert_Resolution(534, hg, wd);
		    ya2 = new Convert_Resolution(554, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    {
		      n1 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		      tampil(6);
		    }
		    xb1 = new Convert_Resolution(181, hg, wd);
		    xb2 = new Convert_Resolution(201, hg, wd);
		    yb1 = new Convert_Resolution(770, hg, wd);
		    yb2 = new Convert_Resolution(790, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    {
		      n2 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		      tampil(6);
		    }
		    xc1 = new Convert_Resolution(246, hg, wd);
		    xc2 = new Convert_Resolution(266, hg, wd);
		    yc1 = new Convert_Resolution(433, hg, wd);
		    yc2 = new Convert_Resolution(453, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    {
		      n3 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		      tampil(6);
		    }
		    xd1 = new Convert_Resolution(356, hg, wd);
		    xd2 = new Convert_Resolution(376, hg, wd);
		    yd1 = new Convert_Resolution(785, hg, wd);
		    yd2 = new Convert_Resolution(805, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    {
		      n4 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		      tampil(6);
		    }
		    xe1 = new Convert_Resolution(585, hg, wd);
		    xe2 = new Convert_Resolution(605, hg, wd);
		    ye1 = new Convert_Resolution(900, hg, wd);
		    ye2 = new Convert_Resolution(920, hg, wd);
		    if ((x >= xe1.getX()) && (x <= xe2.getX()) && (y >= ye1.getX()) && (y <= ye2.getX()))
		    {
		      n5 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		      tampil(6);
		    }
		    xf1 = new Convert_Resolution(448, hg, wd);
		    xf2 = new Convert_Resolution(468, hg, wd);
		    yf1 = new Convert_Resolution(831, hg, wd);
		    yf2 = new Convert_Resolution(851, hg, wd);
		    if ((x >= xf1.getX()) && (x <= xf2.getX()) && (y >= yf1.getX()) && (y <= yf2.getX()))
		    {
		      n6 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		      tampil(6);
		    }
		}		  
	//batas Q
	  
	  
	  
	  if (this.HurufKu.equals("R")){
		  /*
		   * 212 - 873
		   * 531 - 859
		   * 210 - 438
		   * 494 - 448
		   * 308 - 646
		   * 438 - 637
		   */
		    xa1 = new Convert_Resolution(202, hg, wd);
		    xa2 = new Convert_Resolution(222, hg, wd);
		    ya1 = new Convert_Resolution(863, hg, wd);
		    ya2 = new Convert_Resolution(883, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    {
		      n1 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		      tampil(6);
		    }
		    xb1 = new Convert_Resolution(521, hg, wd);
		    xb2 = new Convert_Resolution(541, hg, wd);
		    yb1 = new Convert_Resolution(849, hg, wd);
		    yb2 = new Convert_Resolution(869, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    {
		      n2 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		      tampil(6);
		    }
		    xc1 = new Convert_Resolution(200, hg, wd);
		    xc2 = new Convert_Resolution(220, hg, wd);
		    yc1 = new Convert_Resolution(428, hg, wd);
		    yc2 = new Convert_Resolution(448, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    {
		      n3 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		      tampil(6);
		    }
		    xd1 = new Convert_Resolution(484, hg, wd);
		    xd2 = new Convert_Resolution(504, hg, wd);
		    yd1 = new Convert_Resolution(438, hg, wd);
		    yd2 = new Convert_Resolution(458, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    {
		      n4 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		      tampil(6);
		    }
		    xe1 = new Convert_Resolution(298, hg, wd);
		    xe2 = new Convert_Resolution(318, hg, wd);
		    ye1 = new Convert_Resolution(636, hg, wd);
		    ye2 = new Convert_Resolution(656, hg, wd);
		    if ((x >= xe1.getX()) && (x <= xe2.getX()) && (y >= ye1.getX()) && (y <= ye2.getX()))
		    {
		      n5 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		      tampil(6);
		    }
		    xf1 = new Convert_Resolution(428, hg, wd);
		    xf2 = new Convert_Resolution(448, hg, wd);
		    yf1 = new Convert_Resolution(627, hg, wd);
		    yf2 = new Convert_Resolution(647, hg, wd);
		    if ((x >= xf1.getX()) && (x <= xf2.getX()) && (y >= yf1.getX()) && (y <= yf2.getX()))
		    {
		      n6 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		      tampil(6);
		    }
		}		  
	//batas R
	  
	  
	  
	  if (this.HurufKu.equals("S")){
		  /*
		   *193 - 758
		   *502 - 800
		   *500 - 489
		   *240 - 477
		   *359 - 628
		   *383 - 881 
		   */
		    xa1 = new Convert_Resolution(183, hg, wd);
		    xa2 = new Convert_Resolution(203, hg, wd);
		    ya1 = new Convert_Resolution(748, hg, wd);
		    ya2 = new Convert_Resolution(768, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    {
		      n1 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		      tampil(6);
		    }
		    xb1 = new Convert_Resolution(492, hg, wd);
		    xb2 = new Convert_Resolution(512, hg, wd);
		    yb1 = new Convert_Resolution(790, hg, wd);
		    yb2 = new Convert_Resolution(810, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    {
		      n2 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		      tampil(6);
		    }
		    xc1 = new Convert_Resolution(490, hg, wd);
		    xc2 = new Convert_Resolution(510, hg, wd);
		    yc1 = new Convert_Resolution(479, hg, wd);
		    yc2 = new Convert_Resolution(499, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    {
		      n3 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		      tampil(6);
		    }
		    xd1 = new Convert_Resolution(230, hg, wd);
		    xd2 = new Convert_Resolution(250, hg, wd);
		    yd1 = new Convert_Resolution(467, hg, wd);
		    yd2 = new Convert_Resolution(487, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    {
		      n4 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		      tampil(6);
		    }
		    xe1 = new Convert_Resolution(349, hg, wd);
		    xe2 = new Convert_Resolution(369, hg, wd);
		    ye1 = new Convert_Resolution(618, hg, wd);
		    ye2 = new Convert_Resolution(638, hg, wd);
		    if ((x >= xe1.getX()) && (x <= xe2.getX()) && (y >= ye1.getX()) && (y <= ye2.getX()))
		    {
		      n5 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		      tampil(6);
		    }
		    xf1 = new Convert_Resolution(373, hg, wd);
		    xf2 = new Convert_Resolution(393, hg, wd);
		    yf1 = new Convert_Resolution(871, hg, wd);
		    yf2 = new Convert_Resolution(891, hg, wd);
		    if ((x >= xf1.getX()) && (x <= xf2.getX()) && (y >= yf1.getX()) && (y <= yf2.getX()))
		    {
		      n6 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		      tampil(6);
		    }
		}		  
	//batas S
	  
	  
	  
	  if (this.HurufKu.equals("T")){
		  /*
		   * 185 - 420
		   * 533 - 427
		   * 359 - 486
		   * 363 - 852
		   */
		    xa1 = new Convert_Resolution(175, hg, wd);
		    xa2 = new Convert_Resolution(195, hg, wd);
		    ya1 = new Convert_Resolution(410, hg, wd);
		    ya2 = new Convert_Resolution(430, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    {
		      n1 = 1;
		      this.has = (n1 + n2 + n3 + n4);
		      tampil(4);
		    }
		    xb1 = new Convert_Resolution(523, hg, wd);
		    xb2 = new Convert_Resolution(543, hg, wd);
		    yb1 = new Convert_Resolution(417, hg, wd);
		    yb2 = new Convert_Resolution(437, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    {
		      n2 = 1;
		      this.has = (n1 + n2 + n3 + n4);
		      tampil(4);
		    }
		    xc1 = new Convert_Resolution(349, hg, wd);
		    xc2 = new Convert_Resolution(369, hg, wd);
		    yc1 = new Convert_Resolution(476, hg, wd);
		    yc2 = new Convert_Resolution(486, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    {
		      n3 = 1;
		      this.has = (n1 + n2 + n3 + n4);
		      tampil(4);
		    }
		    xd1 = new Convert_Resolution(353, hg, wd);
		    xd2 = new Convert_Resolution(373, hg, wd);
		    yd1 = new Convert_Resolution(842, hg, wd);
		    yd2 = new Convert_Resolution(862, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    {
		      n4 = 1;
		      this.has = (n1 + n2 + n3 + n4);
		      tampil(4);
		    }	
		}  
	//batas T
	  
	  
	  
	  if (this.HurufKu.equals("U")){
		  /*
		   * 188 - 419
		   * 527 - 418
		   * 474 - 834
		   * 251 - 833
		   */
		    xa1 = new Convert_Resolution(178, hg, wd);
		    xa2 = new Convert_Resolution(198, hg, wd);
		    ya1 = new Convert_Resolution(409, hg, wd);
		    ya2 = new Convert_Resolution(429, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    {
		      n1 = 1;
		      this.has = (n1 + n2 + n3 + n4);
		      tampil(4);
		    }
		    xb1 = new Convert_Resolution(517, hg, wd);
		    xb2 = new Convert_Resolution(537, hg, wd);
		    yb1 = new Convert_Resolution(408, hg, wd);
		    yb2 = new Convert_Resolution(428, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    {
		      n2 = 1;
		      this.has = (n1 + n2 + n3 + n4);
		      tampil(4);
		    }
		    xc1 = new Convert_Resolution(464, hg, wd);
		    xc2 = new Convert_Resolution(484, hg, wd);
		    yc1 = new Convert_Resolution(824, hg, wd);
		    yc2 = new Convert_Resolution(844, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    {
		      n3 = 1;
		      this.has = (n1 + n2 + n3 + n4);
		      tampil(4);
		    }
		    xd1 = new Convert_Resolution(241, hg, wd);
		    xd2 = new Convert_Resolution(261, hg, wd);
		    yd1 = new Convert_Resolution(823, hg, wd);
		    yd2 = new Convert_Resolution(843, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    {
		      n4 = 1;
		      this.has = (n1 + n2 + n3 + n4);
		      tampil(4);
		    }	
		}  
	//batas U
	  
	  
	  
	  if (this.HurufKu.equals("V")){
		  /*
		   * 183 - 441
		   * 537 - 426
		   * 333 - 854
		   * 398 - 827
		   */
		    xa1 = new Convert_Resolution(128, hg, wd);
		    xa2 = new Convert_Resolution(148, hg, wd);
		    ya1 = new Convert_Resolution(431, hg, wd);
		    ya2 = new Convert_Resolution(451, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    	{
		    		n1 = 1;
		  	      	this.has = (n1 + n2 + n3);
		  	      	tampil(3);
		    	}
		    xb1 = new Convert_Resolution(527, hg, wd);
		    xb2 = new Convert_Resolution(547, hg, wd);
		    yb1 = new Convert_Resolution(416, hg, wd);
		    yb2 = new Convert_Resolution(436, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    	{
		    		n2 = 1;
		  	      	this.has = (n1 + n2 + n3 + n4);
		  	      	tampil(4);
		    	}
		    xc1 = new Convert_Resolution(323, hg, wd);
		    xc2 = new Convert_Resolution(343, hg, wd);
		    yc1 = new Convert_Resolution(844, hg, wd);
		    yc2 = new Convert_Resolution(864, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    	{
		    		n3 = 1;
		  	      	this.has = (n1 + n2 + n3 + n4);
		  	      	tampil(4);
		    	}
		    xd1 = new Convert_Resolution(388, hg, wd);
		    xd2 = new Convert_Resolution(408, hg, wd);
		    yd1 = new Convert_Resolution(817, hg, wd);
		    yd2 = new Convert_Resolution(837, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    	{
		    		n4 = 1;
		  	      	this.has = (n1 + n2 + n3 + n4);
		  	      	tampil(4);
		    	}
		}	 
	//batas V
	  
	  
	  
	  if (this.HurufKu.equals("W")){
		  /*
		   * 88 - 420
		   * 190 - 831
		   * 354 - 438
		   * 506 - 826
		   * 645 - 414
		   * 277 - 664
		   */
		    xa1 = new Convert_Resolution(78, hg, wd);
		    xa2 = new Convert_Resolution(98, hg, wd);
		    ya1 = new Convert_Resolution(410, hg, wd);
		    ya2 = new Convert_Resolution(430, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    {
		      n1 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		      tampil(6);
		    }
		    xb1 = new Convert_Resolution(180, hg, wd);
		    xb2 = new Convert_Resolution(200, hg, wd);
		    yb1 = new Convert_Resolution(821, hg, wd);
		    yb2 = new Convert_Resolution(841, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    {
		      n2 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		      tampil(6);
		    }
		    xc1 = new Convert_Resolution(344, hg, wd);
		    xc2 = new Convert_Resolution(364, hg, wd);
		    yc1 = new Convert_Resolution(428, hg, wd);
		    yc2 = new Convert_Resolution(448, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    {
		      n3 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		      tampil(6);
		    }
		    xd1 = new Convert_Resolution(496, hg, wd);
		    xd2 = new Convert_Resolution(516, hg, wd);
		    yd1 = new Convert_Resolution(816, hg, wd);
		    yd2 = new Convert_Resolution(836, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    {
		      n4 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		      tampil(6);
		    }
		    xe1 = new Convert_Resolution(635, hg, wd);
		    xe2 = new Convert_Resolution(655, hg, wd);
		    ye1 = new Convert_Resolution(404, hg, wd);
		    ye2 = new Convert_Resolution(424, hg, wd);
		    if ((x >= xe1.getX()) && (x <= xe2.getX()) && (y >= ye1.getX()) && (y <= ye2.getX()))
		    {
		      n5 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		      tampil(6);
		    }
		    xf1 = new Convert_Resolution(267, hg, wd);
		    xf2 = new Convert_Resolution(287, hg, wd);
		    yf1 = new Convert_Resolution(654, hg, wd);
		    yf2 = new Convert_Resolution(674, hg, wd);
		    if ((x >= xf1.getX()) && (x <= xf2.getX()) && (y >= yf1.getX()) && (y <= yf2.getX()))
		    {
		      n6 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		      tampil(6);
		    }
		}	 
	//batas W
	  
	  
	  
	  if (this.HurufKu.equals("X")){
		  /*
		   * 217 - 411
		   * 509 - 846
		   * 208 - 859
		   * 495 - 438
		   * 366 - 635
		   */
		    xa1 = new Convert_Resolution(207, hg, wd);
		    xa2 = new Convert_Resolution(227, hg, wd);
		    ya1 = new Convert_Resolution(401, hg, wd);
		    ya2 = new Convert_Resolution(421, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    	{
		    		n1 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xb1 = new Convert_Resolution(499, hg, wd);
		    xb2 = new Convert_Resolution(519, hg, wd);
		    yb1 = new Convert_Resolution(836, hg, wd);
		    yb2 = new Convert_Resolution(856, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    	{
		    		n2 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xc1 = new Convert_Resolution(198, hg, wd);
		    xc2 = new Convert_Resolution(218, hg, wd);
		    yc1 = new Convert_Resolution(849, hg, wd);
		    yc2 = new Convert_Resolution(869, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    	{
		    		n3 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xd1 = new Convert_Resolution(485, hg, wd);
		    xd2 = new Convert_Resolution(505, hg, wd);
		    yd1 = new Convert_Resolution(428, hg, wd);
		    yd2 = new Convert_Resolution(448, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    	{
		    		n4 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xe1 = new Convert_Resolution(356, hg, wd);
		    xe2 = new Convert_Resolution(376, hg, wd);
		    ye1 = new Convert_Resolution(625, hg, wd);
		    ye2 = new Convert_Resolution(645, hg, wd);
		    if ((x >= xe1.getX()) && (x <= xe2.getX()) && (y >= ye1.getX()) && (y <= ye2.getX()))
		    	{
		    		n5 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		}	  
	//batas X
	  
	  
	  
	  if (this.HurufKu.equals("Y")){
		  /*
		   * 190 - 406
		   * 517 - 424
		   * 359 - 670
		   * 355 - 874
		   */
		    xa1 = new Convert_Resolution(180, hg, wd);
		    xa2 = new Convert_Resolution(200, hg, wd);
		    ya1 = new Convert_Resolution(396, hg, wd);
		    ya2 = new Convert_Resolution(416, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    {
		      n1 = 1;
		      this.has = (n1 + n2 + n3 + n4);
		      tampil(4);
		    }
		    xb1 = new Convert_Resolution(507, hg, wd);
		    xb2 = new Convert_Resolution(527, hg, wd);
		    yb1 = new Convert_Resolution(414, hg, wd);
		    yb2 = new Convert_Resolution(434, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    {
		      n2 = 1;
		      this.has = (n1 + n2 + n3 + n4);
		      tampil(4);
		    }
		    xc1 = new Convert_Resolution(349, hg, wd);
		    xc2 = new Convert_Resolution(369, hg, wd);
		    yc1 = new Convert_Resolution(660, hg, wd);
		    yc2 = new Convert_Resolution(680, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    {
		      n3 = 1;
		      this.has = (n1 + n2 + n3 + n4);
		      tampil(4);
		    }
		    xd1 = new Convert_Resolution(345, hg, wd);
		    xd2 = new Convert_Resolution(365, hg, wd);
		    yd1 = new Convert_Resolution(864, hg, wd);
		    yd2 = new Convert_Resolution(884, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    {
		      n4 = 1;
		      this.has = (n1 + n2 + n3 + n4);
		      tampil(4);
		    }	
		} 
	//batas Y
	  
	  
	  
	  if (this.HurufKu.equals("Z")){
		  /*
		   * 210 - 424
		   * 195 - 833
		   * 500 - 431
		   * 537 - 872
		   * 366 - 635
		   */
		    xa1 = new Convert_Resolution(200, hg, wd);
		    xa2 = new Convert_Resolution(220, hg, wd);
		    ya1 = new Convert_Resolution(414, hg, wd);
		    ya2 = new Convert_Resolution(434, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    	{
		    		n1 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xb1 = new Convert_Resolution(185, hg, wd);
		    xb2 = new Convert_Resolution(205, hg, wd);
		    yb1 = new Convert_Resolution(823, hg, wd);
		    yb2 = new Convert_Resolution(843, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    	{
		    		n2 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xc1 = new Convert_Resolution(490, hg, wd);
		    xc2 = new Convert_Resolution(510, hg, wd);
		    yc1 = new Convert_Resolution(421, hg, wd);
		    yc2 = new Convert_Resolution(441, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    	{
		    		n3 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xd1 = new Convert_Resolution(527, hg, wd);
		    xd2 = new Convert_Resolution(547, hg, wd);
		    yd1 = new Convert_Resolution(862, hg, wd);
		    yd2 = new Convert_Resolution(882, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    	{
		    		n4 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xe1 = new Convert_Resolution(356, hg, wd);
		    xe2 = new Convert_Resolution(376, hg, wd);
		    ye1 = new Convert_Resolution(625, hg, wd);
		    ye2 = new Convert_Resolution(645, hg, wd);
		    if ((x >= xe1.getX()) && (x <= xe2.getX()) && (y >= ye1.getX()) && (y <= ye2.getX()))
		    	{
		    		n5 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		}  
	//batas Z
}

public void jikaHuruf(){
    if (HurufKu.equals("A")){
    	txtIsi.setText("A");
    }
    else if(HurufKu.equals("B")){
    	txtIsi.setText("B");
    }
    else if(HurufKu.equals("C")){
    	txtIsi.setText("C");
    }
    else if(HurufKu.equals("D")){
    	txtIsi.setText("D");
    }
    else if(HurufKu.equals("E")){
    	txtIsi.setText("E");
    }	    
    else if(HurufKu.equals("F")){
    	txtIsi.setText("F");
    }
    else if(HurufKu.equals("G")){
    	txtIsi.setText("G");
    }	
    else if(HurufKu.equals("H")){
    	txtIsi.setText("H");
    }	
    else if(HurufKu.equals("I")){
    	txtIsi.setText("I");
    }	 
    else if(HurufKu.equals("J")){
    	txtIsi.setText("J");
    }	
    else if(HurufKu.equals("K")){
    	txtIsi.setText("K");
    }
    else if(HurufKu.equals("L")){
    	txtIsi.setText("L");
    }
    else if(HurufKu.equals("M")){
    	txtIsi.setText("M");
    }	
    else if(HurufKu.equals("N")){
    	txtIsi.setText("N");
    }	
    else if(HurufKu.equals("O")){
    	txtIsi.setText("O");
    }	 
    else if(HurufKu.equals("P")){
    	txtIsi.setText("P");
    }	
    else if(HurufKu.equals("Q")){
    	txtIsi.setText("Q");
    }
    else if(HurufKu.equals("R")){
    	txtIsi.setText("R");
    }	 
    else if(HurufKu.equals("S")){
    	txtIsi.setText("S");
    }
    else if(HurufKu.equals("T")){
    	txtIsi.setText("T");
    }
    else if(HurufKu.equals("U")){
    	txtIsi.setText("U");
    }
    else if(HurufKu.equals("V")){
    	txtIsi.setText("V");
    }
    else if(HurufKu.equals("W")){
    	txtIsi.setText("W");
    }
    else if(HurufKu.equals("X")){
    	txtIsi.setText("X");
	}
    else if(HurufKu.equals("Y")){
    	txtIsi.setText("Y");
    }
    else if(HurufKu.equals("Z")){
    	txtIsi.setText("Z");
    }	
}

public void tampil(int paramInt)
{
if (this.has >= paramInt)
{
	SharedPreferences xxx=getApplicationContext().getSharedPreferences("kirim",0);
	Editor ed=xxx.edit();
	ed.putInt("hasil", xxx.getInt("hasil", 0)+1);
	
	ed.commit();
	
      this.cancelTimer();
	    txtIsi = (TextView)findViewById(R.id.txtIsi);
	    String isi = txtIsi.getText().toString();
  Intent hasil = new Intent(this, Hasil.class);
  hasil.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
  hasil.putExtra("pilih", "besar");
  hasil.putExtra("isi", isi);
  startActivity(hasil);
  Canvas_Game_Besar.this.finish();
}
}

public void waktu()
{
this.wkt = new CountDownTimer(31000L, 1000L)
{
  public void onFinish()
  {
	  Canvas_Game_Besar.this.txtWaktu.setText("Maaf Waktu Habis");
    //Intent localIntent = new Intent(Canvas_Game_Angka.this, Pilihan_Angka.class);
    //Canvas_Game_Angka.this.startActivity(localIntent);
	  Canvas_Game_Besar.this.cancelTimer();
	  Intent a=new Intent(Canvas_Game_Besar.this,Pilihan_Besar.class);
		 startActivity(a);
		 overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
	  Canvas_Game_Besar.this.finish();
  }

  public void onTick(long paramAnonymousLong)
  {
       mp.start();
	  Canvas_Game_Besar.this.txtWaktu.setText("Waktu Tersisa\n" + paramAnonymousLong / 1000L);
  }
}
.start();
}

void cancelTimer()
{
mp.stop();
this.wkt.cancel();
}

public void onBackPressed()
{
//String str = getIntent().getExtras().getString("pilih");
//String huruf = txtIsi.getText().toString();
//Intent localIntent = new Intent(this, Pilihan_Angka.class);
//startActivity(localIntent);
cancelTimer();
Intent a=new Intent(Canvas_Game_Besar.this,Pilihan_Besar.class);
	 startActivity(a);
	 overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
finish();
}

}