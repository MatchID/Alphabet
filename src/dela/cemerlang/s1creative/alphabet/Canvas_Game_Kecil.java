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
import android.view.Window;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;

public class Canvas_Game_Kecil extends Activity implements OnTouchListener {ImageView imageView;
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

    mp=MediaPlayer.create(Canvas_Game_Kecil.this, R.raw.k545_rondo);
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
	  
	  	if (this.HurufKu.equals("a")){
		    xa1 = new Convert_Resolution(216, hg, wd);
		    xa2 = new Convert_Resolution(236, hg, wd);
		    ya1 = new Convert_Resolution(595, hg, wd);
		    ya2 = new Convert_Resolution(615, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    	{
		    		n1 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xb1 = new Convert_Resolution(446, hg, wd);
		    xb2 = new Convert_Resolution(466, hg, wd);
		    yb1 = new Convert_Resolution(585, hg, wd);
		    yb2 = new Convert_Resolution(605, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    	{
		    		n2 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xc1 = new Convert_Resolution(212, hg, wd);
		    xc2 = new Convert_Resolution(232, hg, wd);
		    yc1 = new Convert_Resolution(784, hg, wd);
		    yc2 = new Convert_Resolution(804, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    	{
		    		n3 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xd1 = new Convert_Resolution(479, hg, wd);
		    xd2 = new Convert_Resolution(499, hg, wd);
		    yd1 = new Convert_Resolution(850, hg, wd);
		    yd2 = new Convert_Resolution(870, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    	{
		    		n4 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xe1 = new Convert_Resolution(419, hg, wd);
		    xe2 = new Convert_Resolution(439, hg, wd);
		    ye1 = new Convert_Resolution(686, hg, wd);
		    ye2 = new Convert_Resolution(706, hg, wd);
		    if ((x >= xe1.getX()) && (x <= xe2.getX()) && (y >= ye1.getX()) && (y <= ye2.getX()))
		    	{
		    		n5 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		}
	  //batas A
	  
	  
	  	if (this.HurufKu.equals("b")){
		    xa1 = new Convert_Resolution(218, hg, wd);
		    xa2 = new Convert_Resolution(238, hg, wd);
		    ya1 = new Convert_Resolution(403, hg, wd);
		    ya2 = new Convert_Resolution(423, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    	{
		    		n1 = 1;
		  	      	this.has = (n1 + n2 + n3 + n4 + n5);
		  	      	tampil(5);
		    	}
		    xb1 = new Convert_Resolution(213, hg, wd);
		    xb2 = new Convert_Resolution(233, hg, wd);
		    yb1 = new Convert_Resolution(852, hg, wd);
		    yb2 = new Convert_Resolution(872, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    	{
		    		n2 = 1;
		  	      	this.has = (n1 + n2 + n3 + n4 + n5);
		  	      	tampil(5);
		    	}
		    xc1 = new Convert_Resolution(324, hg, wd);
		    xc2 = new Convert_Resolution(344, hg, wd);
		    yc1 = new Convert_Resolution(860, hg, wd);
		    yc2 = new Convert_Resolution(880, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    	{
		    		n3 = 1;
		  	      	this.has = (n1 + n2 + n3 + n4 + n5);
		  	      	tampil(5);
		    	}
		    xd1 = new Convert_Resolution(300, hg, wd);
		    xd2 = new Convert_Resolution(320, hg, wd);
		    yd1 = new Convert_Resolution(587, hg, wd);
		    yd2 = new Convert_Resolution(607, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    	{
		    		n4 = 1;
		  	      	this.has = (n1 + n2 + n3 + n4 + n5);
		  	      	tampil(5);
		    	}
		    xe1 = new Convert_Resolution(699, hg, wd);
		    xe2 = new Convert_Resolution(519, hg, wd);
		    ye1 = new Convert_Resolution(698, hg, wd);
		    ye2 = new Convert_Resolution(718, hg, wd);
		    if ((x >= xe1.getX()) && (x <= xe2.getX()) && (y >= ye1.getX()) && (y <= ye2.getX()))
		    	{
		    		n5 = 1;
		  	      	this.has = (n1 + n2 + n3 + n4 + n5);
		  	      	tampil(5);
		    	}
		}
	  //batas B
	  
	  
	  	if (this.HurufKu.equals("c")){
		    xa1 = new Convert_Resolution(468, hg, wd);
		    xa2 = new Convert_Resolution(488, hg, wd);
		    ya1 = new Convert_Resolution(603, hg, wd);
		    ya2 = new Convert_Resolution(623, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    {
		      n1 = 1;
		      this.has = (n1 + n2 + n3 + n4);
		      tampil(4);
		    }
		    xb1 = new Convert_Resolution(490, hg, wd);
		    xb2 = new Convert_Resolution(510, hg, wd);
		    yb1 = new Convert_Resolution(790, hg, wd);
		    yb2 = new Convert_Resolution(810, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    {
		      n2 = 1;
		      this.has = (n1 + n2 + n3 + n4);
		      tampil(4);
		    }
		    xc1 = new Convert_Resolution(228, hg, wd);
		    xc2 = new Convert_Resolution(248, hg, wd);
		    yc1 = new Convert_Resolution(619, hg, wd);
		    yc2 = new Convert_Resolution(639, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    {
		      n3 = 1;
		      this.has = (n1 + n2 + n3 + n4);
		      tampil(4);
		    }
		    xd1 = new Convert_Resolution(288, hg, wd);
		    xd2 = new Convert_Resolution(308, hg, wd);
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
	  
	  
	    if (this.HurufKu.equals("d")){
		    xa1 = new Convert_Resolution(480, hg, wd);
		    xa2 = new Convert_Resolution(500, hg, wd);
		    ya1 = new Convert_Resolution(414, hg, wd);
		    ya2 = new Convert_Resolution(434, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    	{
		    		n1 = 1;
		  	      	this.has = (n1 + n2 + n3 + n4 + n5);
		  	      	tampil(5);
		    	}
		    xb1 = new Convert_Resolution(484, hg, wd);
		    xb2 = new Convert_Resolution(504, hg, wd);
		    yb1 = new Convert_Resolution(843, hg, wd);
		    yb2 = new Convert_Resolution(863, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    	{
		    		n2 = 1;
		  	      	this.has = (n1 + n2 + n3 + n4 + n5);
		  	      	tampil(5);
		    	}
		    xc1 = new Convert_Resolution(379, hg, wd);
		    xc2 = new Convert_Resolution(399, hg, wd);
		    yc1 = new Convert_Resolution(568, hg, wd);
		    yc2 = new Convert_Resolution(588, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    	{
		    		n3 = 1;
		  	      	this.has = (n1 + n2 + n3 + n4 + n5);
		  	      	tampil(5);
		    	}
		    xd1 = new Convert_Resolution(210, hg, wd);
		    xd2 = new Convert_Resolution(230, hg, wd);
		    yd1 = new Convert_Resolution(742, hg, wd);
		    yd2 = new Convert_Resolution(762, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    	{
		    		n4 = 1;
		  	      	this.has = (n1 + n2 + n3 + n4 + n5);
		  	      	tampil(5);
		    	}
		    xe1 = new Convert_Resolution(394, hg, wd);
		    xe2 = new Convert_Resolution(414, hg, wd);
		    ye1 = new Convert_Resolution(847, hg, wd);
		    ye2 = new Convert_Resolution(867, hg, wd);
		    if ((x >= xe1.getX()) && (x <= xe2.getX()) && (y >= ye1.getX()) && (y <= ye2.getX()))
		    	{
		    		n5 = 1;
		  	      	this.has = (n1 + n2 + n3 + n4 + n5);
		  	      	tampil(5);
		    	}
		}
	  //batas D
	  
	  
	  
	    if (this.HurufKu.equals("e")){
		    xa1 = new Convert_Resolution(473, hg, wd);
		    xa2 = new Convert_Resolution(493, hg, wd);
		    ya1 = new Convert_Resolution(651, hg, wd);
		    ya2 = new Convert_Resolution(671, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    	{
		    		n1 = 1;
		  	      	this.has = (n1 + n2 + n3 + n4);
		  	      	tampil(4);
		    	}
		    xb1 = new Convert_Resolution(489, hg, wd);
		    xb2 = new Convert_Resolution(509, hg, wd);
		    yb1 = new Convert_Resolution(817, hg, wd);
		    yb2 = new Convert_Resolution(837, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    	{
		    		n2 = 1;
		  	      	this.has = (n1 + n2 + n3 + n4);
		  	      	tampil(4);
		    	}
		    xc1 = new Convert_Resolution(240, hg, wd);
		    xc2 = new Convert_Resolution(260, hg, wd);
		    yc1 = new Convert_Resolution(587, hg, wd);
		    yc2 = new Convert_Resolution(607, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    	{
		    		n3 = 1;
		  	      	this.has = (n1 + n2 + n3 + n4);
		  	      	tampil(4);
		    	}
		    xd1 = new Convert_Resolution(357, hg, wd);
		    xd2 = new Convert_Resolution(377, hg, wd);
		    yd1 = new Convert_Resolution(708, hg, wd);
		    yd2 = new Convert_Resolution(728, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    	{
		    		n4 = 1;
		  	      	this.has = (n1 + n2 + n3 + n4);
		  	      	tampil(4);
		    	}
		}
	  //batas E
	  
	
	    if (this.HurufKu.equals("f")){
		    xa1 = new Convert_Resolution(456, hg, wd);
		    xa2 = new Convert_Resolution(476, hg, wd);
		    ya1 = new Convert_Resolution(407, hg, wd);
		    ya2 = new Convert_Resolution(427, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    	{
		    		n1 = 1;
		  	      	this.has = (n1 + n2 + n3 + n4 + n5);
		  	      	tampil(5);
		    	}
		    xb1 = new Convert_Resolution(345, hg, wd);
		    xb2 = new Convert_Resolution(365, hg, wd);
		    yb1 = new Convert_Resolution(523, hg, wd);
		    yb2 = new Convert_Resolution(543, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    	{
		    		n2 = 1;
		  	      	this.has = (n1 + n2 + n3 + n4 + n5);
		  	      	tampil(5);
		    	}
		    xc1 = new Convert_Resolution(341, hg, wd);
		    xc2 = new Convert_Resolution(361, hg, wd);
		    yc1 = new Convert_Resolution(855, hg, wd);
		    yc2 = new Convert_Resolution(875, hg, wd);
		   if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    	{
		    		n3 = 1;
		  	      	this.has = (n1 + n2 + n3 + n4 + n5);
		  	      	tampil(5);
		    	}
		    xd1 = new Convert_Resolution(279, hg, wd);
		    xd2 = new Convert_Resolution(299, hg, wd);
		    yd1 = new Convert_Resolution(558, hg, wd);
		    yd2 = new Convert_Resolution(578, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    	{
		    		n4 = 1;
		  	      	this.has = (n1 + n2 + n3 + n4 + n5);
		  	      	tampil(5);
		    	}
		    xe1 = new Convert_Resolution(421, hg, wd);
		    xe2 = new Convert_Resolution(441, hg, wd);
		    ye1 = new Convert_Resolution(551, hg, wd);
		    ye2 = new Convert_Resolution(571, hg, wd);
		    if ((x >= xe1.getX()) && (x <= xe2.getX()) && (y >= ye1.getX()) && (y <= ye2.getX()))
		    	{
		    		n5 = 1;
		  	      	this.has = (n1 + n2 + n3 + n4 + n5);
		  	      	tampil(5);
		    	}	
	  	}
	  //batas F
	  


	    if (this.HurufKu.equals("g")){
		    xa1 = new Convert_Resolution(199, hg, wd);
		    xa2 = new Convert_Resolution(219, hg, wd);
		    ya1 = new Convert_Resolution(684, hg, wd);
		    ya2 = new Convert_Resolution(704, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    	{
		    		n1 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		    		tampil(6);
		    	}
		    xb1 = new Convert_Resolution(480, hg, wd);
		    xb2 = new Convert_Resolution(500, hg, wd);
		    yb1 = new Convert_Resolution(572, hg, wd);
		    yb2 = new Convert_Resolution(592, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    	{
		    		n2 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		    		tampil(6);
		    	}
		    xc1 = new Convert_Resolution(480, hg, wd);
		    xc2 = new Convert_Resolution(500, hg, wd);
		    yc1 = new Convert_Resolution(932, hg, wd);
		    yc2 = new Convert_Resolution(952, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    	{
		    		n3 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		    		tampil(6);
		    	}
		    xd1 = new Convert_Resolution(216, hg, wd);
		    xd2 = new Convert_Resolution(236, hg, wd);
		    yd1 = new Convert_Resolution(955, hg, wd);
		    yd2 = new Convert_Resolution(975, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    	{
		    		n4 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		    		tampil(6);
		    	}
		    xe1 = new Convert_Resolution(364, hg, wd);
		    xe2 = new Convert_Resolution(384, hg, wd);
		    ye1 = new Convert_Resolution(563, hg, wd);
		    ye2 = new Convert_Resolution(583, hg, wd);
		    if ((x >= xe1.getX()) && (x <= xe2.getX()) && (y >= ye1.getX()) && (y <= ye2.getX()))
		    	{
		    		n5 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		    		tampil(6);
		    	}
		    xf1 = new Convert_Resolution(369, hg, wd);
		    xf2 = new Convert_Resolution(389, hg, wd);
		    yf1 = new Convert_Resolution(845, hg, wd);
		    yf2 = new Convert_Resolution(865, hg, wd);
		    if ((x >= xf1.getX()) && (x <= xf2.getX()) && (y >= yf1.getX()) && (y <= yf2.getX()))
		    	{
		    		n6 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		    		tampil(6);
		    	}
		}
	  //batas G
	  
	  
	  
	    if (this.HurufKu.equals("h")){
		    xa1 = new Convert_Resolution(222, hg, wd);
		    xa2 = new Convert_Resolution(242, hg, wd);
		    ya1 = new Convert_Resolution(406, hg, wd);
		    ya2 = new Convert_Resolution(426, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    	{
		    		n1 = 1;
		    		this.has = (n1 + n2 + n3 + n4);
		    		tampil(4);
		    	}
		    xb1 = new Convert_Resolution(227, hg, wd);
		    xb2 = new Convert_Resolution(247, hg, wd);
		    yb1 = new Convert_Resolution(859, hg, wd);
		    yb2 = new Convert_Resolution(879, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    	{
		    		n2 = 1;
		    		this.has = (n1 + n2 + n3 + n4);
		    		tampil(4);
		    	}
		    xc1 = new Convert_Resolution(481, hg, wd);
		    xc2 = new Convert_Resolution(501, hg, wd);
		    yc1 = new Convert_Resolution(843, hg, wd);
		    yc2 = new Convert_Resolution(863, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    	{
		    		n3 = 1;
		    		this.has = (n1 + n2 + n3 + n4);
		    		tampil(4);
		    	}
		    xd1 = new Convert_Resolution(322, hg, wd);
		    xd2 = new Convert_Resolution(342, hg, wd);
		    yd1 = new Convert_Resolution(570, hg, wd);
		    yd2 = new Convert_Resolution(590, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    	{
		    		n4 = 1;
		    		this.has = (n1 + n2 + n3 + n4);
		    		tampil(4);
		    	}
	  	}  
	  //batas H
		  
		  
		  if (this.HurufKu.equals("i")){
			    xa1 = new Convert_Resolution(354, hg, wd);
			    xa2 = new Convert_Resolution(374, hg, wd);
			    ya1 = new Convert_Resolution(424, hg, wd);
			    ya2 = new Convert_Resolution(444, hg, wd);
			    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
			    	{
			    		n1 = 1;
			    		this.has = (n1 + n2 + n3);
			    		tampil(3);
			    	}
			    xb1 = new Convert_Resolution(354, hg, wd);
			    xb2 = new Convert_Resolution(374, hg, wd);
			    yb1 = new Convert_Resolution(563, hg, wd);
			    yb2 = new Convert_Resolution(583, hg, wd);
			    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
			    	{
			    		n2 = 1;
			    		this.has = (n1 + n2 + n3);
			    		tampil(3);
			    	}
			    xc1 = new Convert_Resolution(348, hg, wd);
			    xc2 = new Convert_Resolution(368, hg, wd);
			    yc1 = new Convert_Resolution(868, hg, wd);
			    yc2 = new Convert_Resolution(888, hg, wd);
			    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
			    	{
			    		n3 = 1;
			    		this.has = (n1 + n2 + n3);
			    		tampil(3);
			    	}	
		}
	//batas I
	  
	  
	  
	  if (this.HurufKu.equals("j")){
		    xa1 = new Convert_Resolution(352, hg, wd);
		    xa2 = new Convert_Resolution(372, hg, wd);
		    ya1 = new Convert_Resolution(411, hg, wd);
		    ya2 = new Convert_Resolution(431, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    	{
		    		n1 = 1;
		    		this.has = (n1 + n2 + n3 + n4);
		    		tampil(4);
		    	}
		    xb1 = new Convert_Resolution(345, hg, wd);
		    xb2 = new Convert_Resolution(365, hg, wd);
		    yb1 = new Convert_Resolution(573, hg, wd);
		    yb2 = new Convert_Resolution(593, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    	{
		    		n2 = 1;
		    		this.has = (n1 + n2 + n3 + n4);
		    		tampil(4);
		    	}
		    xc1 = new Convert_Resolution(345, hg, wd);
		    xc2 = new Convert_Resolution(365, hg, wd);
		    yc1 = new Convert_Resolution(960, hg, wd);
		    yc2 = new Convert_Resolution(980, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    	{
		    		n3 = 1;
		    		this.has = (n1 + n2 + n3 + n4);
		    		tampil(4);
		    	}
		    xd1 = new Convert_Resolution(242, hg, wd);
		    xd2 = new Convert_Resolution(262, hg, wd);
		    yd1 = new Convert_Resolution(1008, hg, wd);
		    yd2 = new Convert_Resolution(1028, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    	{
		    		n4 = 1;
		    		this.has = (n1 + n2 + n3 + n4);
		    		tampil(4);
		    	}	
	  	}  
	//batas J
	  
	  
	  
	  if (this.HurufKu.equals("k")){
		    xa1 = new Convert_Resolution(254, hg, wd);
		    xa2 = new Convert_Resolution(274, hg, wd);
		    ya1 = new Convert_Resolution(414, hg, wd);
		    ya2 = new Convert_Resolution(434, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    	{
		    		n1 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xb1 = new Convert_Resolution(254, hg, wd);
		    xb2 = new Convert_Resolution(274, hg, wd);
		    yb1 = new Convert_Resolution(850, hg, wd);
		    yb2 = new Convert_Resolution(870, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    	{
		    		n2 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xc1 = new Convert_Resolution(457, hg, wd);
		    xc2 = new Convert_Resolution(487, hg, wd);
		    yc1 = new Convert_Resolution(564, hg, wd);
		    yc2 = new Convert_Resolution(584, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    	{
		    		n3 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xd1 = new Convert_Resolution(483, hg, wd);
		    xd2 = new Convert_Resolution(503, hg, wd);
		    yd1 = new Convert_Resolution(850, hg, wd);
		    yd2 = new Convert_Resolution(870, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    	{
		    		n4 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		    xe1 = new Convert_Resolution(351, hg, wd);
		    xe2 = new Convert_Resolution(371, hg, wd);
		    ye1 = new Convert_Resolution(668, hg, wd);
		    ye2 = new Convert_Resolution(688, hg, wd);
		    if ((x >= xe1.getX()) && (x <= xe2.getX()) && (y >= ye1.getX()) && (y <= ye2.getX()))
		    	{
		    		n5 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5);
		    		tampil(5);
		    	}
		}	  
	//batas K
	  
	  
	  
	  if (this.HurufKu.equals("l")){
		    xa1 = new Convert_Resolution(352, hg, wd);
		    xa2 = new Convert_Resolution(372, hg, wd);
		    ya1 = new Convert_Resolution(407, hg, wd);
		    ya2 = new Convert_Resolution(427, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()) && (this.HurufKu.equals("I")))
		    {
		      n1 = 1;
		      this.has = (n1 + n2 + n3);
		      tampil(3);
		    }
		    xb1 = new Convert_Resolution(348, hg, wd);
		    xb2 = new Convert_Resolution(368, hg, wd);
		    yb1 = new Convert_Resolution(725, hg, wd);
		    yb2 = new Convert_Resolution(745, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()) && (this.HurufKu.equals("I")))
		    {
		      n2 = 1;
		      this.has = (n1 + n2 + n3);
		      tampil(3);
		    }
		    xc1 = new Convert_Resolution(348, hg, wd);
		    xc2 = new Convert_Resolution(368, hg, wd);
		    yc1 = new Convert_Resolution(865, hg, wd);
		    yc2 = new Convert_Resolution(885, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()) && (this.HurufKu.equals("I")))
		    {
		      n3 = 1;
		      this.has = (n1 + n2 + n3);
		      tampil(3);
		    }	
	  	}	  
	//batas L
	  
	  
	  
	  if (this.HurufKu.equals("m")){
		    xa1 = new Convert_Resolution(129, hg, wd);
		    xa2 = new Convert_Resolution(149, hg, wd);
		    ya1 = new Convert_Resolution(846, hg, wd);
		    ya2 = new Convert_Resolution(866, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    	{
		    		n1 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		    		tampil(6);
		    	}
		    xb1 = new Convert_Resolution(124, hg, wd);
		    xb2 = new Convert_Resolution(144, hg, wd);
		    yb1 = new Convert_Resolution(573, hg, wd);
		    yb2 = new Convert_Resolution(593, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    	{
		    		n2 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		    		tampil(6);
		    	}
		    xc1 = new Convert_Resolution(327, hg, wd);
		    xc2 = new Convert_Resolution(347, hg, wd);
		    yc1 = new Convert_Resolution(575, hg, wd);
		    yc2 = new Convert_Resolution(595, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    	{
		    		n3 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		    		tampil(6);
		    	}
		    xd1 = new Convert_Resolution(551, hg, wd);
		    xd2 = new Convert_Resolution(571, hg, wd);
		    yd1 = new Convert_Resolution(567, hg, wd);
		    yd2 = new Convert_Resolution(587, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    	{
		    		n4 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		    		tampil(6);
		    	}
		    xe1 = new Convert_Resolution(350, hg, wd);
		    xe2 = new Convert_Resolution(370, hg, wd);
		    ye1 = new Convert_Resolution(841, hg, wd);
		    ye2 = new Convert_Resolution(861, hg, wd);
		    if ((x >= xe1.getX()) && (x <= xe2.getX()) && (y >= ye1.getX()) && (y <= ye2.getX()))
		    	{
		    		n5 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		    		tampil(6);
		    	}
		    xf1 = new Convert_Resolution(583, hg, wd);
		    xf2 = new Convert_Resolution(603, hg, wd);
		    yf1 = new Convert_Resolution(849, hg, wd);
		    yf2 = new Convert_Resolution(869, hg, wd);
		    if ((x >= xf1.getX()) && (x <= xf2.getX()) && (y >= yf1.getX()) && (y <= yf2.getX()))
		    	{
		    		n6 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		    		tampil(6);
		    	}
		}
	//batas M
	  
	  
	  
	  if (this.HurufKu.equals("n")){
		    xa1 = new Convert_Resolution(223, hg, wd);
		    xa2 = new Convert_Resolution(243, hg, wd);
		    ya1 = new Convert_Resolution(558, hg, wd);
		    ya2 = new Convert_Resolution(578, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    	{
		    		n1 = 1;
		    		this.has = (n1 + n2 + n3 + n4);
		    		tampil(4);
		    	}
		    xb1 = new Convert_Resolution(222, hg, wd);
		    xb2 = new Convert_Resolution(242, hg, wd);
		    yb1 = new Convert_Resolution(839, hg, wd);
		    yb2 = new Convert_Resolution(859, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    	{
		    		n2 = 1;
		    		this.has = (n1 + n2 + n3 + n4);
		    		tampil(4);
		    	}
		    xc1 = new Convert_Resolution(438, hg, wd);
		    xc2 = new Convert_Resolution(358, hg, wd);
		    yc1 = new Convert_Resolution(569, hg, wd);
		    yc2 = new Convert_Resolution(589, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    	{
		    		n3 = 1;
		    		this.has = (n1 + n2 + n3 + n4);
		    		tampil(4);
		    	}
		    xd1 = new Convert_Resolution(478, hg, wd);
		    xd2 = new Convert_Resolution(498, hg, wd);
		    yd1 = new Convert_Resolution(850, hg, wd);
		    yd2 = new Convert_Resolution(870, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    	{
		    		n4 = 1;
		    		this.has = (n1 + n2 + n3 + n4);
		    		tampil(4);
		    	}	
		}	  
	//batas N
	  
	  
	  
	  if (this.HurufKu.equals("o")){
		    xa1 = new Convert_Resolution(215, hg, wd);
		    xa2 = new Convert_Resolution(235, hg, wd);
		    ya1 = new Convert_Resolution(643, hg, wd);
		    ya2 = new Convert_Resolution(663, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    {
		      n1 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5);
		      tampil(5);
		    }
		    xb1 = new Convert_Resolution(370, hg, wd);
		    xb2 = new Convert_Resolution(390, hg, wd);
		    yb1 = new Convert_Resolution(548, hg, wd);
		    yb2 = new Convert_Resolution(568, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    {
		      n2 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5);
		      tampil(5);
		    }
		    xc1 = new Convert_Resolution(464, hg, wd);
		    xc2 = new Convert_Resolution(484, hg, wd);
		    yc1 = new Convert_Resolution(800, hg, wd);
		    yc2 = new Convert_Resolution(820, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    {
		      n3 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5);
		      tampil(5);
		    }
		    xd1 = new Convert_Resolution(246, hg, wd);
		    xd2 = new Convert_Resolution(266, hg, wd);
		    yd1 = new Convert_Resolution(817, hg, wd);
		    yd2 = new Convert_Resolution(837, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    {
		      n4 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5);
		      tampil(5);
		    }
		    xe1 = new Convert_Resolution(473, hg, wd);
		    xe2 = new Convert_Resolution(493, hg, wd);
		    ye1 = new Convert_Resolution(610, hg, wd);
		    ye2 = new Convert_Resolution(630, hg, wd);
		    if ((x >= xe1.getX()) && (x <= xe2.getX()) && (y >= ye1.getX()) && (y <= ye2.getX()))
		    {
		      n5 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5);
		      tampil(5);
		    }	
		}	 	  
	//batas O
	  
	  
	  
	  if (this.HurufKu.equals("p")){
		    xa1 = new Convert_Resolution(215, hg, wd);
		    xa2 = new Convert_Resolution(235, hg, wd);
		    ya1 = new Convert_Resolution(553, hg, wd);
		    ya2 = new Convert_Resolution(573, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    {
		      n1 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5);
		      tampil(5);
		    }
		    xb1 = new Convert_Resolution(215, hg, wd);
		    xb2 = new Convert_Resolution(235, hg, wd);
		    yb1 = new Convert_Resolution(982, hg, wd);
		    yb2 = new Convert_Resolution(1002, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    {
		      n2 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5);
		      tampil(5);
		    }
		    xc1 = new Convert_Resolution(356, hg, wd);
		    xc2 = new Convert_Resolution(376, hg, wd);
		    yc1 = new Convert_Resolution(549, hg, wd);
		    yc2 = new Convert_Resolution(569, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    {
		      n3 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5);
		      tampil(5);
		    }
		    xd1 = new Convert_Resolution(490, hg, wd);
		    xd2 = new Convert_Resolution(510, hg, wd);
		    yd1 = new Convert_Resolution(703, hg, wd);
		    yd2 = new Convert_Resolution(723, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    {
		      n4 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5);
		      tampil(5);
		    }
		    xe1 = new Convert_Resolution(344, hg, wd);
		    xe2 = new Convert_Resolution(364, hg, wd);
		    ye1 = new Convert_Resolution(867, hg, wd);
		    ye2 = new Convert_Resolution(887, hg, wd);
		    if ((x >= xe1.getX()) && (x <= xe2.getX()) && (y >= ye1.getX()) && (y <= ye2.getX()))
		    {
		      n5 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5);
		      tampil(5);
		    }	
		}	  
	//batas P
	  
	  
	  
	  if (this.HurufKu.equals("q")){
		    xa1 = new Convert_Resolution(472, hg, wd);
		    xa2 = new Convert_Resolution(492, hg, wd);
		    ya1 = new Convert_Resolution(579, hg, wd);
		    ya2 = new Convert_Resolution(599, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    {
		      n1 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5);
		      tampil(5);
		    }
		    xb1 = new Convert_Resolution(482, hg, wd);
		    xb2 = new Convert_Resolution(502, hg, wd);
		    yb1 = new Convert_Resolution(993, hg, wd);
		    yb2 = new Convert_Resolution(1013, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    {
		      n2 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5);
		      tampil(5);
		    }
		    xc1 = new Convert_Resolution(320, hg, wd);
		    xc2 = new Convert_Resolution(340, hg, wd);
		    yc1 = new Convert_Resolution(557, hg, wd);
		    yc2 = new Convert_Resolution(577, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    {
		      n3 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5);
		      tampil(5);
		    }
		    xd1 = new Convert_Resolution(203, hg, wd);
		    xd2 = new Convert_Resolution(223, hg, wd);
		    yd1 = new Convert_Resolution(744, hg, wd);
		    yd2 = new Convert_Resolution(764, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    {
		      n4 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5);
		      tampil(5);
		    }
		    xe1 = new Convert_Resolution(356, hg, wd);
		    xe2 = new Convert_Resolution(376, hg, wd);
		    ye1 = new Convert_Resolution(860, hg, wd);
		    ye2 = new Convert_Resolution(880, hg, wd);
		    if ((x >= xe1.getX()) && (x <= xe2.getX()) && (y >= ye1.getX()) && (y <= ye2.getX()))
		    {
		      n5 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5);
		      tampil(5);
		    }	
		}		  
	//batas Q
	  
	  
	  
	  if (this.HurufKu.equals("r")){
		    xa1 = new Convert_Resolution(444, hg, wd);
		    xa2 = new Convert_Resolution(464, hg, wd);
		    ya1 = new Convert_Resolution(554, hg, wd);
		    ya2 = new Convert_Resolution(574, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    	{
		    		n1 = 1;
		    		this.has = (n1 + n2 + n3);
		    		tampil(3);
		    	}
		    xb1 = new Convert_Resolution(279, hg, wd);
		    xb2 = new Convert_Resolution(299, hg, wd);
		    yb1 = new Convert_Resolution(557, hg, wd);
		    yb2 = new Convert_Resolution(577, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    	{
		    		n2 = 1;
		    		this.has = (n1 + n2 + n3);
		    		tampil(3);
		    	}
		    xc1 = new Convert_Resolution(283, hg, wd);
		    xc2 = new Convert_Resolution(303, hg, wd);
		    yc1 = new Convert_Resolution(824, hg, wd);
		    yc2 = new Convert_Resolution(844, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    	{
		    		n3 = 1;
		    		this.has = (n1 + n2 + n3);
		    		tampil(3);
		    	}
		}		  
	//batas R
	  
	  
	  
	  if (this.HurufKu.equals("s")){
		    xa1 = new Convert_Resolution(453, hg, wd);
		    xa2 = new Convert_Resolution(473, hg, wd);
		    ya1 = new Convert_Resolution(585, hg, wd);
		    ya2 = new Convert_Resolution(605, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    {
		      n1 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5);
		      tampil(5);
		    }
		    xb1 = new Convert_Resolution(231, hg, wd);
		    xb2 = new Convert_Resolution(251, hg, wd);
		    yb1 = new Convert_Resolution(611, hg, wd);
		    yb2 = new Convert_Resolution(631, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    {
		      n2 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5);
		      tampil(5);
		    }
		    xc1 = new Convert_Resolution(356, hg, wd);
		    xc2 = new Convert_Resolution(376, hg, wd);
		    yc1 = new Convert_Resolution(701, hg, wd);
		    yc2 = new Convert_Resolution(721, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    {
		      n3 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5);
		      tampil(5);
		    }
		    xd1 = new Convert_Resolution(434, hg, wd);
		    xd2 = new Convert_Resolution(454, hg, wd);
		    yd1 = new Convert_Resolution(841, hg, wd);
		    yd2 = new Convert_Resolution(861, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    {
		      n4 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5);
		      tampil(5);
		    }
		    xe1 = new Convert_Resolution(226, hg, wd);
		    xe2 = new Convert_Resolution(246, hg, wd);
		    ye1 = new Convert_Resolution(810, hg, wd);
		    ye2 = new Convert_Resolution(830, hg, wd);
		    if ((x >= xe1.getX()) && (x <= xe2.getX()) && (y >= ye1.getX()) && (y <= ye2.getX()))
		    {
		      n5 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5);
		      tampil(5);
		    }	
		}		  
	//batas S
	  
	  
	  
	  if (this.HurufKu.equals("t")){
		    xa1 = new Convert_Resolution(342, hg, wd);
		    xa2 = new Convert_Resolution(362, hg, wd);
		    ya1 = new Convert_Resolution(429, hg, wd);
		    ya2 = new Convert_Resolution(449, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    {
		      n1 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5);
		      tampil(5);
		    }
		    xb1 = new Convert_Resolution(271, hg, wd);
		    xb2 = new Convert_Resolution(291, hg, wd);
		    yb1 = new Convert_Resolution(557, hg, wd);
		    yb2 = new Convert_Resolution(577, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    {
		      n2 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5);
		      tampil(5);
		    }
		    xc1 = new Convert_Resolution(409, hg, wd);
		    xc2 = new Convert_Resolution(429, hg, wd);
		    yc1 = new Convert_Resolution(551, hg, wd);
		    yc2 = new Convert_Resolution(571, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    {
		      n3 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5);
		      tampil(5);
		    }
		    xd1 = new Convert_Resolution(341, hg, wd);
		    xd2 = new Convert_Resolution(351, hg, wd);
		    yd1 = new Convert_Resolution(818, hg, wd);
		    yd2 = new Convert_Resolution(838, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    {
		      n4 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5);
		      tampil(5);
		    }
		    xe1 = new Convert_Resolution(440, hg, wd);
		    xe2 = new Convert_Resolution(460, hg, wd);
		    ye1 = new Convert_Resolution(866, hg, wd);
		    ye2 = new Convert_Resolution(886, hg, wd);
		    if ((x >= xe1.getX()) && (x <= xe2.getX()) && (y >= ye1.getX()) && (y <= ye2.getX()))
		    {
		      n5 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5);
		      tampil(5);
		    }	
		}  
	//batas T
	  
	  
	  
	  if (this.HurufKu.equals("u")){
		    xa1 = new Convert_Resolution(218, hg, wd);
		    xa2 = new Convert_Resolution(238, hg, wd);
		    ya1 = new Convert_Resolution(557, hg, wd);
		    ya2 = new Convert_Resolution(577, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    	{
		    		n1 = 1;
		    		this.has = (n1 + n2 + n3 + n4);
		    		tampil(4);
		    	}
		    xb1 = new Convert_Resolution(466, hg, wd);
		    xb2 = new Convert_Resolution(486, hg, wd);
		    yb1 = new Convert_Resolution(568, hg, wd);
		    yb2 = new Convert_Resolution(588, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    	{
		    		n2 = 1;
		    		this.has = (n1 + n2 + n3 + n4);
		    		tampil(4);
		    	}
		    xc1 = new Convert_Resolution(266, hg, wd);
		    xc2 = new Convert_Resolution(286, hg, wd);
		    yc1 = new Convert_Resolution(842, hg, wd);
		    yc2 = new Convert_Resolution(862, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    	{
		    		n3 = 1;
		    		this.has = (n1 + n2 + n3 + n4);
		    		tampil(4);
		    	}
		    xd1 = new Convert_Resolution(478, hg, wd);
		    xd2 = new Convert_Resolution(498, hg, wd);
		    yd1 = new Convert_Resolution(835, hg, wd);
		    yd2 = new Convert_Resolution(855, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    	{
		    		n4 = 1;
		    		this.has = (n1 + n2 + n3 + n4);
		    		tampil(4);
		    	}	
		}  
	//batas U
	  
	  
	  
	  if (this.HurufKu.equals("v")){
		    xa1 = new Convert_Resolution(217, hg, wd);
		    xa2 = new Convert_Resolution(237, hg, wd);
		    ya1 = new Convert_Resolution(551, hg, wd);
		    ya2 = new Convert_Resolution(571, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    {
		      n1 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5);
		      tampil(5);
		    }
		    xb1 = new Convert_Resolution(480, hg, wd);
		    xb2 = new Convert_Resolution(500, hg, wd);
		    yb1 = new Convert_Resolution(556, hg, wd);
		    yb2 = new Convert_Resolution(576, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    {
		      n2 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5);
		      tampil(5);
		    }
		    xc1 = new Convert_Resolution(400, hg, wd);
		    xc2 = new Convert_Resolution(420, hg, wd);
		    yc1 = new Convert_Resolution(791, hg, wd);
		    yc2 = new Convert_Resolution(811, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    {
		      n3 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5);
		      tampil(5);
		    }
		    xd1 = new Convert_Resolution(305, hg, wd);
		    xd2 = new Convert_Resolution(325, hg, wd);
		    yd1 = new Convert_Resolution(769, hg, wd);
		    yd2 = new Convert_Resolution(789, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    {
		      n4 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5);
		      tampil(5);
		    }
		    xe1 = new Convert_Resolution(349, hg, wd);
		    xe2 = new Convert_Resolution(369, hg, wd);
		    ye1 = new Convert_Resolution(871, hg, wd);
		    ye2 = new Convert_Resolution(891, hg, wd);
		    if ((x >= xe1.getX()) && (x <= xe2.getX()) && (y >= ye1.getX()) && (y <= ye2.getX()))
		    {
		      n5 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5);
		      tampil(5);
		    }	
		}	 
	//batas V
	  
	  
	  
	  if (this.HurufKu.equals("w")){
		    xa1 = new Convert_Resolution(115, hg, wd);
		    xa2 = new Convert_Resolution(135, hg, wd);
		    ya1 = new Convert_Resolution(558, hg, wd);
		    ya2 = new Convert_Resolution(578, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    	{
		    		n1 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		    		tampil(6);
		    	}
		    xb1 = new Convert_Resolution(213, hg, wd);
		    xb2 = new Convert_Resolution(233, hg, wd);
		    yb1 = new Convert_Resolution(840, hg, wd);
		    yb2 = new Convert_Resolution(860, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    	{
		    		n2 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		    		tampil(6);
		    	}
		    xc1 = new Convert_Resolution(348, hg, wd);
		    xc2 = new Convert_Resolution(368, hg, wd);
		    yc1 = new Convert_Resolution(582, hg, wd);
		    yc2 = new Convert_Resolution(602, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    	{
		    		n3 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		    		tampil(6);
		    	}
		    xd1 = new Convert_Resolution(455, hg, wd);
		    xd2 = new Convert_Resolution(475, hg, wd);
		    yd1 = new Convert_Resolution(848, hg, wd);
		    yd2 = new Convert_Resolution(868, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    	{
		    		n4 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		    		tampil(6);
		    	}
		    xe1 = new Convert_Resolution(575, hg, wd);
		    xe2 = new Convert_Resolution(595, hg, wd);
		    ye1 = new Convert_Resolution(566, hg, wd);
		    ye2 = new Convert_Resolution(588, hg, wd);
		    if ((x >= xe1.getX()) && (x <= xe2.getX()) && (y >= ye1.getX()) && (y <= ye2.getX()))
		    	{
		    		n5 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		    		tampil(6);
		    	}
		    xf1 = new Convert_Resolution(537, hg, wd);
		    xf2 = new Convert_Resolution(557, hg, wd);
		    yf1 = new Convert_Resolution(694, hg, wd);
		    yf2 = new Convert_Resolution(714, hg, wd);
		    if ((x >= xf1.getX()) && (x <= xf2.getX()) && (y >= yf1.getX()) && (y <= yf2.getX()))
		    	{
		    		n6 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		    		tampil(6);
		    	}
		}	 
	//batas W
	  
	  
	  
	  if (this.HurufKu.equals("x")){
		    xa1 = new Convert_Resolution(234, hg, wd);
		    xa2 = new Convert_Resolution(254, hg, wd);
		    ya1 = new Convert_Resolution(544, hg, wd);
		    ya2 = new Convert_Resolution(564, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    {
		      n1 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5);
		      tampil(5);
		    }
		    xb1 = new Convert_Resolution(220, hg, wd);
		    xb2 = new Convert_Resolution(240, hg, wd);
		    yb1 = new Convert_Resolution(872, hg, wd);
		    yb2 = new Convert_Resolution(892, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    {
		      n2 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5);
		      tampil(5);
		    }
		    xc1 = new Convert_Resolution(456, hg, wd);
		    xc2 = new Convert_Resolution(476, hg, wd);
		    yc1 = new Convert_Resolution(564, hg, wd);
		    yc2 = new Convert_Resolution(584, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    {
		      n3 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5);
		      tampil(5);
		    }
		    xd1 = new Convert_Resolution(447, hg, wd);
		    xd2 = new Convert_Resolution(467, hg, wd);
		    yd1 = new Convert_Resolution(852, hg, wd);
		    yd2 = new Convert_Resolution(872, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    {
		      n4 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5);
		      tampil(5);
		    }
		    xe1 = new Convert_Resolution(341, hg, wd);
		    xe2 = new Convert_Resolution(361, hg, wd);
		    ye1 = new Convert_Resolution(684, hg, wd);
		    ye2 = new Convert_Resolution(704, hg, wd);
		    if ((x >= xe1.getX()) && (x <= xe2.getX()) && (y >= ye1.getX()) && (y <= ye2.getX()))
		    {
		      n5 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5);
		      tampil(5);
		    }	
		}	  
	//batas X
	  
	  
	  
	  if (this.HurufKu.equals("y")){
		    xa1 = new Convert_Resolution(213, hg, wd);
		    xa2 = new Convert_Resolution(233, hg, wd);
		    ya1 = new Convert_Resolution(542, hg, wd);
		    ya2 = new Convert_Resolution(562, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    	{
		    		n1 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		    		tampil(6);
		    	}
		    xb1 = new Convert_Resolution(477, hg, wd);
		    xb2 = new Convert_Resolution(497, hg, wd);
		    yb1 = new Convert_Resolution(557, hg, wd);
		    yb2 = new Convert_Resolution(577, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    	{
		    		n2 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		    		tampil(6);
		    	}
		    xc1 = new Convert_Resolution(316, hg, wd);
		    xc2 = new Convert_Resolution(336, hg, wd);
		    yc1 = new Convert_Resolution(807, hg, wd);
		    yc2 = new Convert_Resolution(827, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    	{
		    		n3 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		    		tampil(6);
		    	}
		    xd1 = new Convert_Resolution(404, hg, wd);
		    xd2 = new Convert_Resolution(424, hg, wd);
		    yd1 = new Convert_Resolution(785, hg, wd);
		    yd2 = new Convert_Resolution(805, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    	{
		    		n4 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		    		tampil(6);
		    	}
		    xe1 = new Convert_Resolution(211, hg, wd);
		    xe2 = new Convert_Resolution(231, hg, wd);
		    ye1 = new Convert_Resolution(1016, hg, wd);
		    ye2 = new Convert_Resolution(1036, hg, wd);
		    if ((x >= xe1.getX()) && (x <= xe2.getX()) && (y >= ye1.getX()) && (y <= ye2.getX()))
		    	{
		    		n5 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		    		tampil(6);
		    	}
		    xd1 = new Convert_Resolution(335, hg, wd);
		    xd2 = new Convert_Resolution(355, hg, wd);
		    yd1 = new Convert_Resolution(945, hg, wd);
		    yd2 = new Convert_Resolution(965, hg, wd);
		    if ((x >= xf1.getX()) && (x <= xf2.getX()) && (y >= yf1.getX()) && (y <= yf2.getX()))
		    	{
		    		n6 = 1;
		    		this.has = (n1 + n2 + n3 + n4 + n5 + n6);
		    		tampil(6);
		    	}
		} 
	//batas Y
	  
	  
	  
	  if (this.HurufKu.equals("z")){
		    xa1 = new Convert_Resolution(218, hg, wd);
		    xa2 = new Convert_Resolution(239, hg, wd);
		    ya1 = new Convert_Resolution(561, hg, wd);
		    ya2 = new Convert_Resolution(581, hg, wd);
		    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
		    {
		      n1 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5);
		      tampil(5);
		    }
		    xb1 = new Convert_Resolution(427, hg, wd);
		    xb2 = new Convert_Resolution(447, hg, wd);
		    yb1 = new Convert_Resolution(605, hg, wd);
		    yb2 = new Convert_Resolution(625, hg, wd);
		    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
		    {
		      n2 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5);
		      tampil(5);
		    }
		    xc1 = new Convert_Resolution(260, hg, wd);
		    xc2 = new Convert_Resolution(280, hg, wd);
		    yc1 = new Convert_Resolution(791, hg, wd);
		    yc2 = new Convert_Resolution(811, hg, wd);
		    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
		    {
		      n3 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5);
		      tampil(5);
		    }
		    xd1 = new Convert_Resolution(267, hg, wd);
		    xd2 = new Convert_Resolution(287, hg, wd);
		    yd1 = new Convert_Resolution(867, hg, wd);
		    yd2 = new Convert_Resolution(888, hg, wd);
		    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
		    {
		      n4 = 1;
		      this.has = (n1 + n2 + n3 + n4 + n5);
		      tampil(5);
		    }
		    xe1 = new Convert_Resolution(473, hg, wd);
		    xe2 = new Convert_Resolution(493, hg, wd);
		    ye1 = new Convert_Resolution(872, hg, wd);
		    ye2 = new Convert_Resolution(892, hg, wd);
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
    if (HurufKu.equals("a")){
    	txtIsi.setText("a");
    }
    else if(HurufKu.equals("b")){
    	txtIsi.setText("b");
    }
    else if(HurufKu.equals("c")){
    	txtIsi.setText("c");
    }
    else if(HurufKu.equals("d")){
    	txtIsi.setText("d");
    }
    else if(HurufKu.equals("e")){
    	txtIsi.setText("e");
    }	    
    else if(HurufKu.equals("f")){
    	txtIsi.setText("f");
    }
    else if(HurufKu.equals("g")){
    	txtIsi.setText("g");
    }	
    else if(HurufKu.equals("h")){
    	txtIsi.setText("h");
    }	
    else if(HurufKu.equals("i")){
    	txtIsi.setText("i");
    }	 
    else if(HurufKu.equals("j")){
    	txtIsi.setText("j");
    }	
    else if(HurufKu.equals("k")){
    	txtIsi.setText("k");
    }
    else if(HurufKu.equals("l")){
    	txtIsi.setText("l");
    }
    else if(HurufKu.equals("m")){
    	txtIsi.setText("m");
    }	
    else if(HurufKu.equals("n")){
    	txtIsi.setText("n");
    }	
    else if(HurufKu.equals("o")){
    	txtIsi.setText("o");
    }	 
    else if(HurufKu.equals("p")){
    	txtIsi.setText("p");
    }	
    else if(HurufKu.equals("q")){
    	txtIsi.setText("q");
    }
    else if(HurufKu.equals("r")){
    	txtIsi.setText("r");
    }	 
    else if(HurufKu.equals("s")){
    	txtIsi.setText("s");
    }
    else if(HurufKu.equals("t")){
    	txtIsi.setText("t");
    }
    else if(HurufKu.equals("u")){
    	txtIsi.setText("u");
    }
    else if(HurufKu.equals("v")){
    	txtIsi.setText("v");
    }
    else if(HurufKu.equals("w")){
    	txtIsi.setText("w");
    }
    else if(HurufKu.equals("x")){
    	txtIsi.setText("x");
	}
    else if(HurufKu.equals("y")){
    	txtIsi.setText("y");
    }
    else if(HurufKu.equals("z")){
    	txtIsi.setText("z");
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
  hasil.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
  hasil.putExtra("pilih", "kecil");
  hasil.putExtra("isi", isi);
  startActivity(hasil);
  Canvas_Game_Kecil.this.finish();
}
}

public void waktu()
{
this.wkt = new CountDownTimer(31000L, 1000L)
{
  public void onFinish()
  {
	  Canvas_Game_Kecil.this.txtWaktu.setText("Maaf Waktu Habis");
    //Intent localIntent = new Intent(Canvas_Game_Angka.this, Pilihan_Angka.class);
    //Canvas_Game_Angka.this.startActivity(localIntent);
	  Canvas_Game_Kecil.this.cancelTimer();
	  Intent a=new Intent(Canvas_Game_Kecil.this,Pilihan_Kecil.class);
		 startActivity(a);
		 overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
	  Canvas_Game_Kecil.this.finish();
  }

  public void onTick(long paramAnonymousLong)
  {
       mp.start();
	  Canvas_Game_Kecil.this.txtWaktu.setText("Waktu Tersisa\n" + paramAnonymousLong / 1000L);
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
Intent a=new Intent(Canvas_Game_Kecil.this,Pilihan_Kecil.class);
	 startActivity(a);
	 overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
finish();
}


}