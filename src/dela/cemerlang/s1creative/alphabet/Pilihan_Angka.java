package dela.cemerlang.s1creative.alphabet;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Pilihan_Angka extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pilihan_angka);

        final MediaPlayer mp=MediaPlayer.create(this, R.raw.suara2);
        if(mp!= null) {
 	       if(mp.isPlaying()){
 	    	   mp.pause();}
 	    }
        tombi();
		 mp.stop();
		 
        Button a = (Button)findViewById(R.id.keluar);
        
        a.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 mp.start();
				 
				 overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
				 Intent localIntent = new Intent(Pilihan_Angka.this, MainActivity.class);
				 localIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
				 startActivity(localIntent);
				  finish();
				 mp.stop();
			}
		});
        }
    
    public void tombi(){
   	 final MediaPlayer mp=MediaPlayer.create(this, R.raw.suara2);
   	 
   	 findViewById(R.id.a).setOnClickListener(new  View.OnClickListener() {
   		
   		@Override
   		public void onClick(View arg0) {
   			
   			mp.start();
   			Intent a=new Intent(Pilihan_Angka.this, Canvas_Game_Angka.class);
   			a.putExtra("nama","1");
   			a.putExtra("pilih", "angka");
   			startActivity(a);
   			 overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);	
   			//finish();
   		}
   	});
   	 
   	 findViewById(R.id.b).setOnClickListener(new  View.OnClickListener() {
   		
   		@Override
   		public void onClick(View arg0) {
   			
   			mp.start();
   			Intent a=new Intent(Pilihan_Angka.this, Canvas_Game_Angka.class);
   			a.putExtra("nama","2");
   			a.putExtra("pilih", "angka");
   			startActivity(a);
   			 overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);	
   			finish();
   		}
   	});
   	 
   	 findViewById(R.id.c).setOnClickListener(new  View.OnClickListener() {
   		
   		@Override
   		public void onClick(View arg0) {
   			
   			mp.start();
   			Intent a=new Intent(Pilihan_Angka.this, Canvas_Game_Angka.class);
   			a.putExtra("nama","3");
   			a.putExtra("pilih", "angka");
   			startActivity(a);
   			 overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);	
   			finish();
   		}
   	});
   	 
   	 findViewById(R.id.d).setOnClickListener(new  View.OnClickListener() {
   		
   		@Override
   		public void onClick(View arg0) {
   			
   			mp.start();
   			Intent a=new Intent(Pilihan_Angka.this, Canvas_Game_Angka.class);
   			a.putExtra("nama","4");
   			a.putExtra("pilih", "angka");
   			startActivity(a);
   			 overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);	
   			finish();
   		}
   	});
   	 
   	 findViewById(R.id.e).setOnClickListener(new  View.OnClickListener() {
   		
   		@Override
   		public void onClick(View arg0) {
   			
   			mp.start();
   			Intent a=new Intent(Pilihan_Angka.this, Canvas_Game_Angka.class);
   			a.putExtra("nama","5");
   			a.putExtra("pilih", "angka");
   			startActivity(a);
   			 overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
   			finish();	
   		}
   	});
   	 
   	 findViewById(R.id.f).setOnClickListener(new  View.OnClickListener() {
   		
   		@Override
   		public void onClick(View arg0) {
   			
   			mp.start();
   			Intent a=new Intent(Pilihan_Angka.this, Canvas_Game_Angka.class);
   			a.putExtra("nama","6");
   			a.putExtra("pilih", "angka");
   			startActivity(a);
   			 overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
   			finish();	
   		}
   	});
   	 
   	 findViewById(R.id.g).setOnClickListener(new  View.OnClickListener() {
   		
   		@Override
   		public void onClick(View arg0) {
   			
   			mp.start();
   			Intent a=new Intent(Pilihan_Angka.this, Canvas_Game_Angka.class);
   			a.putExtra("nama","7");
   			a.putExtra("pilih", "angka");
   			startActivity(a);
   			 overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
   			finish();	
   		}
   	});
   	 
   	 findViewById(R.id.h).setOnClickListener(new  View.OnClickListener() {
   		
   		@Override
   		public void onClick(View arg0) {
   			
   			mp.start();
   			Intent a=new Intent(Pilihan_Angka.this, Canvas_Game_Angka.class);
   			a.putExtra("nama","8");
   			a.putExtra("pilih", "angka");
   			startActivity(a);
   			 overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
   			finish();	
   		}
   	});
   	 
   	 findViewById(R.id.i).setOnClickListener(new  View.OnClickListener() {
   		
   		@Override
   		public void onClick(View arg0) {
   			
   			mp.start();
   			Intent a=new Intent(Pilihan_Angka.this, Canvas_Game_Angka.class);
   			a.putExtra("nama","9");
   			a.putExtra("pilih", "angka");
   			startActivity(a);
   			 overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
   			finish();	
   		}
   	});
   	 
   	 findViewById(R.id.j).setOnClickListener(new  View.OnClickListener() {
   		
   		@Override
   		public void onClick(View arg0) {
   			
   			mp.start();
   			Intent a=new Intent(Pilihan_Angka.this, Canvas_Game_Angka.class);
   			a.putExtra("nama","0");
   			a.putExtra("pilih", "angka");
   			startActivity(a);
   			 overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
   			finish();	
   		}
   	});
   	 
    }
    
    public void onBackPressed()
    {
		 overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
		 Intent localIntent = new Intent(Pilihan_Angka.this, MainActivity.class);
		 localIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
		 startActivity(localIntent);
		  finish();
    }
    
}
