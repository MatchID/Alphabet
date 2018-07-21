package dela.cemerlang.s1creative.alphabet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


public class MainActivity extends Activity {
	BackgroundSound musik;

    @SuppressWarnings("null")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences xxx=getApplicationContext().getSharedPreferences("kirim",0);
        Editor ed=xxx.edit();
        ed.putString("total_nilai", "");
        ed.putInt("hasil",0);
        ed.commit();
        
        
	    musik = new BackgroundSound();
	    if(!(musik.equals(null))) {
 	    	musik.cancel(true);
	 	    }else{
	 		    musik.execute();
	 	    }

        
        final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.alpa);
        final Animation trans = AnimationUtils.loadAnimation(this, R.anim.trans);
        //final Animation besar = AnimationUtils.loadAnimation(this, R.anim.besar);
        
        final MediaPlayer mp=MediaPlayer.create(this,R.raw.suara2);
        

        findViewById(R.id.button1).setOnClickListener(new android.view.View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				arg0.startAnimation(trans);
				   mp.start();	
				   Intent a=new Intent(MainActivity.this, Pilihan_Besar.class);
				   a.putExtra("pilih", "huruf");
				   startActivity(a);
			   overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
			   //finish();
				
			}
		});
        
        findViewById(R.id.button2).setOnClickListener(new android.view.View.OnClickListener() {
	
        	@Override
        	public void onClick(View arg0) {
        		arg0.startAnimation(animAlpha);
        		mp.start();	
        		Intent a=new Intent(MainActivity.this, Pilihan_Angka.class);
        		a.putExtra("pilih", "angka");
        		startActivity(a);
        		overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
        		//finish();
        	}
        });  
 
        findViewById(R.id.button3).setOnClickListener(new android.view.View.OnClickListener() {
		
        	@Override
        	public void onClick(View arg0) {
        		arg0.startAnimation(animAlpha);
        		mp.start();	
        		Intent a=new Intent(MainActivity.this, About.class);
        		startActivity(a);
        		overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
        		//finish();
        	}
        });    
 
        findViewById(R.id.button4).setOnClickListener(new android.view.View.OnClickListener() {
	
        	@Override
        	public void onClick(View arg0) {
        		finish();
        		musik.cancel(true);
        		int pid = android.os.Process.myPid(); 
        		android.os.Process.killProcess(pid);
        		MainActivity.this.finish();
        	}
        });  
        
        findViewById(R.id.button5).setOnClickListener(new android.view.View.OnClickListener() {

        	@Override
        	public void onClick(View arg0) {
        		arg0.startAnimation(trans);
        		mp.start();	
        		Intent a=new Intent(MainActivity.this, Pilihan_Kecil.class);
        		startActivity(a);
        		overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
        		//finish();
        	}
        }); 
        
    }

public class BackgroundSound extends AsyncTask<Void, Void, Void>{

	@Override
	protected Void doInBackground(Void... params) {
		MediaPlayer player = MediaPlayer.create(MainActivity.this, R.raw.k545_rondo);
    	player.setLooping(true);
    	player.setVolume(1.0f, 1.0f);
    	player.start();
    	
    	return null;
	}
}

    public void onBackPressed()
    {
    }  

}
