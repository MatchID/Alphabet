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

public class Canvas_Game_Angka extends Activity implements OnTouchListener {ImageView imageView;
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

	        mp=MediaPlayer.create(Canvas_Game_Angka.this, R.raw.k545_rondo);
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
		  

		  if (this.HurufKu.equals("1")){
			  /*
			   * 233 - 569
			   * 391 - 466
			   * 391 - 856
			   */
			    xa1 = new Convert_Resolution(223, hg, wd);
			    xa2 = new Convert_Resolution(243, hg, wd);
			    ya1 = new Convert_Resolution(559, hg, wd);
			    ya2 = new Convert_Resolution(579, hg, wd);
			    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
			    {
			      n1 = 1;
			      this.has = (n1 + n2 + n3);
			      tampil(3);
			    }
			    xb1 = new Convert_Resolution(381, hg, wd);
			    xb2 = new Convert_Resolution(401, hg, wd);
			    yb1 = new Convert_Resolution(456, hg, wd);
			    yb2 = new Convert_Resolution(476, hg, wd);
			    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
			    {
			      n2 = 1;
			      this.has = (n1 + n2 + n3);
			      tampil(3);
			    }
			    xc1 = new Convert_Resolution(381, hg, wd);
			    xc2 = new Convert_Resolution(401, hg, wd);
			    yc1 = new Convert_Resolution(846, hg, wd);
			    yc2 = new Convert_Resolution(866, hg, wd);
			    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
			    {
			      n3 = 1;
			      this.has = (n1 + n2 + n3);
			      tampil(3);
			    }	
		  	}
		  //batas 1
		  

		  
		  if (this.HurufKu.equals("2")){
			  /*
			   * 234 - 530
			   * 489 - 548
			   * 238 - 836
			   * 489 - 865
			   */
			    xa1 = new Convert_Resolution(224, hg, wd);
			    xa2 = new Convert_Resolution(244, hg, wd);
			    ya1 = new Convert_Resolution(520, hg, wd);
			    ya2 = new Convert_Resolution(540, hg, wd);
			    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
			    	{
			    		n1 = 1;
			    		this.has = (n1 + n2 + n3 + n4);
			    		tampil(4);
			    	}
			    xb1 = new Convert_Resolution(479, hg, wd);
			    xb2 = new Convert_Resolution(499, hg, wd);
			    yb1 = new Convert_Resolution(538, hg, wd);
			    yb2 = new Convert_Resolution(558, hg, wd);
			    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
			    	{
			    		n2 = 1;
			    		this.has = (n1 + n2 + n3 + n4);
			    		tampil(4);
			    	}
			    xc1 = new Convert_Resolution(228, hg, wd);
			    xc2 = new Convert_Resolution(248, hg, wd);
			    yc1 = new Convert_Resolution(826, hg, wd);
			    yc2 = new Convert_Resolution(846, hg, wd);
			    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
			    	{
			    		n3 = 1;
			    		this.has = (n1 + n2 + n3 + n4);
			    		tampil(4);
			    	}
			    xd1 = new Convert_Resolution(479, hg, wd);
			    xd2 = new Convert_Resolution(499, hg, wd);
			    yd1 = new Convert_Resolution(855, hg, wd);
			    yd2 = new Convert_Resolution(875, hg, wd);
			    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
			    	{
			    		n4 = 1;
			    		this.has = (n1 + n2 + n3 + n4);
			    		tampil(4);
			    	}
			}
		  //batas 2

		  
		  
		  if (this.HurufKu.equals("3")){
			  /*
			   * 
			   * 238 - 501
			   * 452 - 561
			   * 340 - 621
			   * 488 - 744
			   * 227 - 772
			   */
			    xa1 = new Convert_Resolution(228, hg, wd);
			    xa2 = new Convert_Resolution(248, hg, wd);
			    ya1 = new Convert_Resolution(491, hg, wd);
			    ya2 = new Convert_Resolution(511, hg, wd);
			    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
			    	{
			    		n1 = 1;
			    		this.has = (n1 + n2 + n3 + n4 + n5);
			    		tampil(5);
			    	}
			    xb1 = new Convert_Resolution(442, hg, wd);
			    xb2 = new Convert_Resolution(462, hg, wd);
			    yb1 = new Convert_Resolution(551, hg, wd);
			    yb2 = new Convert_Resolution(571, hg, wd);
			    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
			    	{
			    		n2 = 1;
			    		this.has = (n1 + n2 + n3 + n4 + n5);
			    		tampil(5);
			    	}
			    xc1 = new Convert_Resolution(330, hg, wd);
			    xc2 = new Convert_Resolution(350, hg, wd);
			    yc1 = new Convert_Resolution(611, hg, wd);
			    yc2 = new Convert_Resolution(631, hg, wd);
			    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
			    	{
			    		n3 = 1;
			    		this.has = (n1 + n2 + n3 + n4 + n5);
			    		tampil(5);
			    	}
			    xd1 = new Convert_Resolution(478, hg, wd);
			    xd2 = new Convert_Resolution(498, hg, wd);
			    yd1 = new Convert_Resolution(734, hg, wd);
			    yd2 = new Convert_Resolution(754, hg, wd);
			    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
			    	{
			    		n4 = 1;
			    		this.has = (n1 + n2 + n3 + n4 + n5);
			    		tampil(5);
			    	}
			    xe1 = new Convert_Resolution(217, hg, wd);
			    xe2 = new Convert_Resolution(237, hg, wd);
			    ye1 = new Convert_Resolution(762, hg, wd);
			    ye2 = new Convert_Resolution(782, hg, wd);
			    if ((x >= xe1.getX()) && (x <= xe2.getX()) && (y >= ye1.getX()) && (y <= ye2.getX()))
			    	{
			    		n5 = 1;
			    		this.has = (n1 + n2 + n3 + n4 + n5);
			    		tampil(5);
			    	}
			}
		  //batas 3

		  
		  
		  if (this.HurufKu.equals("4")){
			  /*
			   * 
			   * 428 - 447
			   * 444 - 874
			   * 208 - 727
			   * 501 - 752
			   */
			    xa1 = new Convert_Resolution(418, hg, wd);
			    xa2 = new Convert_Resolution(438, hg, wd);
			    ya1 = new Convert_Resolution(437, hg, wd);
			    ya2 = new Convert_Resolution(457, hg, wd);
			    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
			    	{
			    		n1 = 1;
			    		this.has = (n1 + n2 + n3 + n4);
			    		tampil(4);
			    	}
			    xb1 = new Convert_Resolution(434, hg, wd);
			    xb2 = new Convert_Resolution(454, hg, wd);
			    yb1 = new Convert_Resolution(864, hg, wd);
			    yb2 = new Convert_Resolution(884, hg, wd);
			    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
			    	{
			    		n2 = 1;
			    		this.has = (n1 + n2 + n3 + n4);
			    		tampil(4);
			    	}
			    xc1 = new Convert_Resolution(198, hg, wd);
			    xc2 = new Convert_Resolution(218, hg, wd);
			    yc1 = new Convert_Resolution(717, hg, wd);
			    yc2 = new Convert_Resolution(737, hg, wd);
			    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
			    	{
			    		n3 = 1;
			    		this.has = (n1 + n2 + n3 + n4);
			    		tampil(4);
			    	}
			    xd1 = new Convert_Resolution(491, hg, wd);
			    xd2 = new Convert_Resolution(511, hg, wd);
			    yd1 = new Convert_Resolution(742, hg, wd);
			    yd2 = new Convert_Resolution(762, hg, wd);
			    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
			    	{
			    		n4 = 1;
			    		this.has = (n1 + n2 + n3 + n4);
			    		tampil(4);
			    	}
			}
		  //batas 4

		  
		  
		  if (this.HurufKu.equals("5")){
			  /*
			   * 227 - 782
			   * 461 - 839
			   * 249 - 607
			   * 446 - 433
			   * 469 - 650
			   */
			    xa1 = new Convert_Resolution(217, hg, wd);
			    xa2 = new Convert_Resolution(237, hg, wd);
			    ya1 = new Convert_Resolution(772, hg, wd);
			    ya2 = new Convert_Resolution(792, hg, wd);
			    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
			    	{
			    		n1 = 1;
			    		this.has = (n1 + n2 + n3 + n4 + n5);
			    		tampil(5);
			    	}
			    xb1 = new Convert_Resolution(451, hg, wd);
			    xb2 = new Convert_Resolution(471, hg, wd);
			    yb1 = new Convert_Resolution(829, hg, wd);
			    yb2 = new Convert_Resolution(849, hg, wd);
			    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
			    	{
			    		n2 = 1;
			    		this.has = (n1 + n2 + n3 + n4 + n5);
			    		tampil(5);
			    	}
			    xc1 = new Convert_Resolution(239, hg, wd);
			    xc2 = new Convert_Resolution(259, hg, wd);
			    yc1 = new Convert_Resolution(597, hg, wd);
			    yc2 = new Convert_Resolution(617, hg, wd);
			    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
			    	{
			    		n3 = 1;
			    		this.has = (n1 + n2 + n3 + n4 + n5);
			    		tampil(5);
			    	}
			    xd1 = new Convert_Resolution(456, hg, wd);
			    xd2 = new Convert_Resolution(476, hg, wd);
			    yd1 = new Convert_Resolution(423, hg, wd);
			    yd2 = new Convert_Resolution(443, hg, wd);
			    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
			    	{
			    		n4 = 1;
			    		this.has = (n1 + n2 + n3 + n4 + n5);
			    		tampil(5);
			    	}
			    xe1 = new Convert_Resolution(459, hg, wd);
			    xe2 = new Convert_Resolution(479, hg, wd);
			    ye1 = new Convert_Resolution(640, hg, wd);
			    ye2 = new Convert_Resolution(660, hg, wd);
			    if ((x >= xe1.getX()) && (x <= xe2.getX()) && (y >= ye1.getX()) && (y <= ye2.getX()))
			    	{
			    		n5 = 1;
			    		this.has = (n1 + n2 + n3 + n4 + n5);
			    		tampil(5);
			    	}
			}
		  //batas 5

		  
		  
		  if (this.HurufKu.equals("6")){
			  /*
			   * 487 - 483
			   * 223 - 673
			   * 435 - 866
			   * 343 - 608
			   */
			    xa1 = new Convert_Resolution(477, hg, wd);
			    xa2 = new Convert_Resolution(497, hg, wd);
			    ya1 = new Convert_Resolution(473, hg, wd);
			    ya2 = new Convert_Resolution(493, hg, wd);
			    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
			    	{
			    		n1 = 1;
			    		this.has = (n1 + n2 + n3 + n4);
			    		tampil(4);
			    	}
			    xb1 = new Convert_Resolution(213, hg, wd);
			    xb2 = new Convert_Resolution(233, hg, wd);
			    yb1 = new Convert_Resolution(663, hg, wd);
			    yb2 = new Convert_Resolution(683, hg, wd);
			    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
			    	{
			    		n2 = 1;
			    		this.has = (n1 + n2 + n3 + n4);
			    		tampil(4);
			    	}
			    xc1 = new Convert_Resolution(425, hg, wd);
			    xc2 = new Convert_Resolution(445, hg, wd);
			    yc1 = new Convert_Resolution(856, hg, wd);
			    yc2 = new Convert_Resolution(876, hg, wd);
			    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
			    	{
			    		n3 = 1;
			    		this.has = (n1 + n2 + n3 + n4);
			    		tampil(4);
			    	}
			    xd1 = new Convert_Resolution(333, hg, wd);
			    xd2 = new Convert_Resolution(353, hg, wd);
			    yd1 = new Convert_Resolution(598, hg, wd);
			    yd2 = new Convert_Resolution(618, hg, wd);
			    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
			    	{
			    		n4 = 1;
			    		this.has = (n1 + n2 + n3 + n4);
			    		tampil(4);
			    	}
			}
		  //batas 6

		  
		  
		  if (this.HurufKu.equals("7")){
			  /*
			   * 242 - 436
			   * 504 - 459
			   * 329 - 844
			   */
			    xa1 = new Convert_Resolution(232, hg, wd);
			    xa2 = new Convert_Resolution(252, hg, wd);
			    ya1 = new Convert_Resolution(426, hg, wd);
			    ya2 = new Convert_Resolution(446, hg, wd);
			    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
			    	{
			    		n1 = 1;
			    		this.has = (n1 + n2 + n3);
			    		tampil(3);
			    	}
			    xb1 = new Convert_Resolution(494, hg, wd);
			    xb2 = new Convert_Resolution(514, hg, wd);
			    yb1 = new Convert_Resolution(449, hg, wd);
			    yb2 = new Convert_Resolution(469, hg, wd);
			    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
			    	{
			    		n2 = 1;
			    		this.has = (n1 + n2 + n3);
			    		tampil(3);
			    	}
			    xc1 = new Convert_Resolution(319, hg, wd);
			    xc2 = new Convert_Resolution(339, hg, wd);
			    yc1 = new Convert_Resolution(834, hg, wd);
			    yc2 = new Convert_Resolution(854, hg, wd);
			    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
			    	{
			    		n3 = 1;
			    		this.has = (n1 + n2 + n3);
			    		tampil(3);
			    	}
			}
		  //batas 7

		  
		  
		  if (this.HurufKu.equals("8")){
			  /*
			   * 356 - 416
			   * 307 - 634
			   * 477 - 830
			   * 251 - 843
			   * 474 - 502
			   */
			    xa1 = new Convert_Resolution(346, hg, wd);
			    xa2 = new Convert_Resolution(366, hg, wd);
			    ya1 = new Convert_Resolution(406, hg, wd);
			    ya2 = new Convert_Resolution(426, hg, wd);
			    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
			    	{
			    		n1 = 1;
			    		this.has = (n1 + n2 + n3 + n4 + n5);
			    		tampil(5);
			    	}
			    xb1 = new Convert_Resolution(297, hg, wd);
			    xb2 = new Convert_Resolution(317, hg, wd);
			    yb1 = new Convert_Resolution(624, hg, wd);
			    yb2 = new Convert_Resolution(644, hg, wd);
			    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
			    	{
			    		n2 = 1;
			    		this.has = (n1 + n2 + n3 + n4 + n5);
			    		tampil(5);
			    	}
			    xc1 = new Convert_Resolution(467, hg, wd);
			    xc2 = new Convert_Resolution(487, hg, wd);
			    yc1 = new Convert_Resolution(820, hg, wd);
			    yc2 = new Convert_Resolution(840, hg, wd);
			    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
			    	{
			    		n3 = 1;
			    		this.has = (n1 + n2 + n3 + n4 + n5);
			    		tampil(5);
			    	}
			    xd1 = new Convert_Resolution(241, hg, wd);
			    xd2 = new Convert_Resolution(261, hg, wd);
			    yd1 = new Convert_Resolution(833, hg, wd);
			    yd2 = new Convert_Resolution(853, hg, wd);
			    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
			    	{
			    		n4 = 1;
			    		this.has = (n1 + n2 + n3 + n4 + n5);
			    		tampil(5);
			    	}
			    xe1 = new Convert_Resolution(464, hg, wd);
			    xe2 = new Convert_Resolution(484, hg, wd);
			    ye1 = new Convert_Resolution(492, hg, wd);
			    ye2 = new Convert_Resolution(512, hg, wd);
			    if ((x >= xe1.getX()) && (x <= xe2.getX()) && (y >= ye1.getX()) && (y <= ye2.getX()))
			    	{
			    		n5 = 1;
			    		this.has = (n1 + n2 + n3 + n4 + n5);
			    		tampil(5);
			    	}
			}
		  //batas 8

		  
		  
		  if (this.HurufKu.equals("9")){
			  /*
			   * 219 - 796
			   * 481 - 731
			   * 320 - 423
			   * 375 - 688
			   */
			    xa1 = new Convert_Resolution(209, hg, wd);
			    xa2 = new Convert_Resolution(229, hg, wd);
			    ya1 = new Convert_Resolution(786, hg, wd);
			    ya2 = new Convert_Resolution(806, hg, wd);
			    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
			    	{
			    		n1 = 1;
			    		this.has = (n1 + n2 + n3);
			    		tampil(4);
			    	}
			    xb1 = new Convert_Resolution(471, hg, wd);
			    xb2 = new Convert_Resolution(491, hg, wd);
			    yb1 = new Convert_Resolution(721, hg, wd);
			    yb2 = new Convert_Resolution(741, hg, wd);
			    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
			    	{
			    		n2 = 1;
			    		this.has = (n1 + n2 + n3 + n4);
			    		tampil(4);
			    	}
			    xc1 = new Convert_Resolution(310, hg, wd);
			    xc2 = new Convert_Resolution(330, hg, wd);
			    yc1 = new Convert_Resolution(413, hg, wd);
			    yc2 = new Convert_Resolution(433, hg, wd);
			    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
			    	{
			    		n3 = 1;
			    		this.has = (n1 + n2 + n3 + n4);
			    		tampil(4);
			    	}
			    xd1 = new Convert_Resolution(365, hg, wd);
			    xd2 = new Convert_Resolution(385, hg, wd);
			    yd1 = new Convert_Resolution(678, hg, wd);
			    yd2 = new Convert_Resolution(698, hg, wd);
			    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
			    	{
			    		n4 = 1;
			    		this.has = (n1 + n2 + n3 + n4);
			    		tampil(4);
			    	}
			}
		  //batas 9
		  
		  
		  
		  if (this.HurufKu.equals("0")){
			  /*
			   * 245 - 495
			   * 475 - 794
			   * 389 - 426
			   * 303 - 866
			   * 482 - 509
			   */
			    xa1 = new Convert_Resolution(235, hg, wd);
			    xa2 = new Convert_Resolution(255, hg, wd);
			    ya1 = new Convert_Resolution(485, hg, wd);
			    ya2 = new Convert_Resolution(505, hg, wd);
			    if ((x >= xa1.getX()) && (x <= xa2.getX()) && (y >= ya1.getX()) && (y <= ya2.getX()))
			    	{
			    		n1 = 1;
			  	      	this.has = (n1 + n2 + n3 + n4);
			  	      	tampil(4);
			    	}
			    xb1 = new Convert_Resolution(465, hg, wd);
			    xb2 = new Convert_Resolution(485, hg, wd);
			    yb1 = new Convert_Resolution(784, hg, wd);
			    yb2 = new Convert_Resolution(804, hg, wd);
			    if ((x >= xb1.getX()) && (x <= xb2.getX()) && (y >= yb1.getX()) && (y <= yb2.getX()))
			    	{
			    		n2 = 1;
			  	      	this.has = (n1 + n2 + n3 + n4);
			  	      	tampil(4);
			    	}
			    xc1 = new Convert_Resolution(379, hg, wd);
			    xc2 = new Convert_Resolution(399, hg, wd);
			    yc1 = new Convert_Resolution(416, hg, wd);
			    yc2 = new Convert_Resolution(436, hg, wd);
			    if ((x >= xc1.getX()) && (x <= xc2.getX()) && (y >= yc1.getX()) && (y <= yc2.getX()))
			    	{
			    		n3 = 1;
			  	      	this.has = (n1 + n2 + n3 + n4);
			  	      	tampil(4);
			    	}
			    xd1 = new Convert_Resolution(293, hg, wd);
			    xd2 = new Convert_Resolution(313, hg, wd);
			    yd1 = new Convert_Resolution(856, hg, wd);
			    yd2 = new Convert_Resolution(876, hg, wd);
			    if ((x >= xd1.getX()) && (x <= xd2.getX()) && (y >= yd1.getX()) && (y <= yd2.getX()))
			    	{
			    		n4 = 1;
			  	      	this.has = (n1 + n2 + n3 + n4);
			  	      	tampil(4);
			    	}
			}	  
		//batas 0
	  }
	  
	  public void jikaHuruf(){
		  if(HurufKu.equals("1")){
		    	txtIsi.setText("1");
		    }
		    else if(HurufKu.equals("2")){
		    	txtIsi.setText("2");
		    }	 
		    else if(HurufKu.equals("3")){
		    	txtIsi.setText("3");
		    }
		    else if(HurufKu.equals("4")){
		    	txtIsi.setText("4");
		    }
		    else if(HurufKu.equals("5")){
		    	txtIsi.setText("5");
		    }
		    else if(HurufKu.equals("6")){
		    	txtIsi.setText("6");
		    }
		    else if(HurufKu.equals("7")){
		    	txtIsi.setText("7");
		    }
		    else if(HurufKu.equals("8")){
		    	txtIsi.setText("8");
			}
		    else if(HurufKu.equals("9")){
		    	txtIsi.setText("9");
		    }
		    else if(HurufKu.equals("0")){
		    	txtIsi.setText("0");
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
	      hasil.putExtra("pilih", "angka");
	      hasil.putExtra("isi", isi);
	      startActivity(hasil);
	      Canvas_Game_Angka.this.finish();
	    }
	  }

	  public void waktu()
	  {
	    this.wkt = new CountDownTimer(31000L, 1000L)
	    {
	      public void onFinish()
	      {
	        Canvas_Game_Angka.this.txtWaktu.setText("Maaf Waktu Habis");
	        //Intent localIntent = new Intent(Canvas_Game_Angka.this, Pilihan_Angka.class);
	        //Canvas_Game_Angka.this.startActivity(localIntent);
	        Canvas_Game_Angka.this.cancelTimer();
	  	  Intent a=new Intent(Canvas_Game_Angka.this,Pilihan_Angka.class);
			 startActivity(a);
			 overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
	        Canvas_Game_Angka.this.finish();
	      }

	      public void onTick(long paramAnonymousLong)
	      {
		 	       mp.start();
		 	       
	    	  Canvas_Game_Angka.this.txtWaktu.setText("Waktu Tersisa\n" + paramAnonymousLong / 1000L);
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
	  Intent a=new Intent(Canvas_Game_Angka.this,Pilihan_Angka.class);
		 startActivity(a);
		 overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
	  finish();
	}


}
