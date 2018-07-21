package dela.cemerlang.s1creative.alphabet;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Pilihan_Besar extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pilihan_besar);

        
        final MediaPlayer mp=MediaPlayer.create(this, R.raw.suara2);
        if(mp!= null) {
 	       if(mp.isPlaying()) mp.pause();
 	    }
		 mp.stop();
		 tombi();
        Button a = (Button)findViewById(R.id.keluar);
        
        a.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 mp.start();
				 
				 overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
				 Intent localIntent = new Intent(Pilihan_Besar.this, MainActivity.class);
				 localIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
				 startActivity(localIntent);
				  finish();
				 mp.stop();
			}
		});
        
        }
    public void tombi(){
      	 final MediaPlayer mp=MediaPlayer.create(this,R.raw.suara2);
    	 
 	    findViewById(R.id.a).setOnClickListener(new View.OnClickListener() {
 			
 				@Override
 				public void onClick(View arg0) {
 					mp.start();
 					   Intent a=new Intent(Pilihan_Besar.this, Canvas_Game_Besar.class);
 					   a.putExtra("nama", "A");
 					   a.putExtra("pilih", "huruf");
 					   startActivity(a);
 				   overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
 				  finish();
 					
 				}
 			});
 	  
 	        findViewById(R.id.b).setOnClickListener(new  View.OnClickListener() {
 				
 				@Override
 				public void onClick(View arg0) {
 					mp.start();
 					   Intent a=new Intent(Pilihan_Besar.this, Canvas_Game_Besar.class);
 					   a.putExtra("nama", "B");
 					   a.putExtra("pilih", "huruf");
 					   startActivity(a);
 				   overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);	
 				  finish(); 
 					
 				}
 			});
 	        
 	        findViewById(R.id.c).setOnClickListener(new  View.OnClickListener() {
 				
 				@Override
 				public void onClick(View arg0) {
 					mp.start();
 					   Intent a=new Intent(Pilihan_Besar.this, Canvas_Game_Besar.class);
 					   a.putExtra("nama", "C");
 					   a.putExtra("pilih", "huruf");
 					   startActivity(a);
 				   overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
 				  finish();	 
 					
 				}
 			});
 	        
 	        findViewById(R.id.d).setOnClickListener(new  View.OnClickListener() {
 				
 				@Override
 				public void onClick(View arg0) {
 					mp.start();
 					   Intent a=new Intent(Pilihan_Besar.this, Canvas_Game_Besar.class);
 					   a.putExtra("nama", "D");
 					   a.putExtra("pilih", "huruf");
 					   startActivity(a);
 				   overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
 				  finish();	
 					
 				}
 			});
 	 
 	        findViewById(R.id.e).setOnClickListener(new  View.OnClickListener() {
 				
 				@Override
 				public void onClick(View arg0) {
 					mp.start();
 					   Intent a=new Intent(Pilihan_Besar.this, Canvas_Game_Besar.class);
 					   a.putExtra("nama", "E");
 					   a.putExtra("pilih", "huruf");
 					   startActivity(a);
 				   overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
 				  finish();	
 					
 				}
 			});        
 	        

 	        findViewById(R.id.f).setOnClickListener(new  View.OnClickListener() {
 				
 				@Override
 				public void onClick(View arg0) {
 					mp.start();
 					   Intent a=new Intent(Pilihan_Besar.this, Canvas_Game_Besar.class);
 					   a.putExtra("nama", "F");
 					   a.putExtra("pilih", "huruf");
 					   startActivity(a);
 				   overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
 				  finish();	
 					
 				}
 			}); 
 	        
 	        findViewById(R.id.g).setOnClickListener(new  View.OnClickListener() {
 				
 				@Override
 				public void onClick(View arg0) {
 					mp.start();
 					   Intent a=new Intent(Pilihan_Besar.this, Canvas_Game_Besar.class);
 					   a.putExtra("nama", "G");
 					   a.putExtra("pilih", "huruf");
 					   startActivity(a);
 				   overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
 				  finish();	
 					
 				}
 			});         
 	        
 	        
 	        findViewById(R.id.h).setOnClickListener(new  View.OnClickListener() {
 				
 				@Override
 				public void onClick(View arg0) {
 					mp.start();
 					   Intent a=new Intent(Pilihan_Besar.this, Canvas_Game_Besar.class);
 					   a.putExtra("nama", "H");
 					   a.putExtra("pilih", "huruf");
 					   startActivity(a);
 				   overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
 				  finish();	
 					
 				}
 			});    
 	        
 	        findViewById(R.id.i).setOnClickListener(new  View.OnClickListener() {
 				
 				@Override
 				public void onClick(View arg0) {
 					mp.start();
 					   Intent a=new Intent(Pilihan_Besar.this, Canvas_Game_Besar.class);
 					   a.putExtra("nama", "I");
 					   a.putExtra("pilih", "huruf");
 					   startActivity(a);
 				   overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
 				  finish();	
 					
 				}
 			});  

 	        findViewById(R.id.j).setOnClickListener(new  View.OnClickListener() {
 				
 				@Override
 				public void onClick(View arg0) {
 					mp.start();
 					   Intent a=new Intent(Pilihan_Besar.this, Canvas_Game_Besar.class);
 					   a.putExtra("nama", "J");
 					   a.putExtra("pilih", "huruf");
 					   startActivity(a);
 				   overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
 				  finish();	
 					
 				}
 			});          
 	 
 	        findViewById(R.id.k).setOnClickListener(new  View.OnClickListener() {
 				
 				@Override
 				public void onClick(View arg0) {
 					mp.start();
 					   Intent a=new Intent(Pilihan_Besar.this, Canvas_Game_Besar.class);
 					   a.putExtra("nama", "K");
 					   a.putExtra("pilih", "huruf");
 					   startActivity(a);
 				   overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
 				  finish();	
 					
 				}
 			}); 
 	        
 	        findViewById(R.id.l).setOnClickListener(new  View.OnClickListener() {
 				
 				@Override
 				public void onClick(View arg0) {
 					mp.start();
 					   Intent a=new Intent(Pilihan_Besar.this, Canvas_Game_Besar.class);
 					   a.putExtra("nama", "L");
 					   a.putExtra("pilih", "huruf");
 					   startActivity(a);
 				   overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
 				  finish();	
 					
 				}
 			});           
 	  
 	        
 	        findViewById(R.id.m).setOnClickListener(new  View.OnClickListener() {
 				
 				@Override
 				public void onClick(View arg0) {
 					mp.start();
 					   Intent a=new Intent(Pilihan_Besar.this, Canvas_Game_Besar.class);
 					   a.putExtra("nama", "M");
 					   a.putExtra("pilih", "huruf");
 					   startActivity(a);
 				   overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
 				  finish();	
 					
 				}
 			});   
 	        
 	        
 	        findViewById(R.id.n).setOnClickListener(new  View.OnClickListener() {
 				
 				@Override
 				public void onClick(View arg0) {
 					mp.start();
 					   Intent a=new Intent(Pilihan_Besar.this, Canvas_Game_Besar.class);
 					   a.putExtra("nama", "N");
 					   a.putExtra("pilih", "huruf");
 					   startActivity(a);
 				   overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
 				  finish();	
 					
 				}
 			});           
 	        
 	        findViewById(R.id.o).setOnClickListener(new  View.OnClickListener() {
 				
 				@Override
 				public void onClick(View arg0) {
 					mp.start();
 					   Intent a=new Intent(Pilihan_Besar.this, Canvas_Game_Besar.class);
 					   a.putExtra("nama", "O");
 					   a.putExtra("pilih", "huruf");
 					   startActivity(a);
 				   overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
 				  finish();	
 					
 				}
 			});  
 	        
 	        
 	        findViewById(R.id.p).setOnClickListener(new  View.OnClickListener() {
 				
 				@Override
 				public void onClick(View arg0) {
 					mp.start();
 					   Intent a=new Intent(Pilihan_Besar.this, Canvas_Game_Besar.class);
 					   a.putExtra("nama", "P");
 					   a.putExtra("pilih", "huruf");
 					   startActivity(a);
 				   overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
 				  finish();	
 					
 				}
 			});       
 	        
 	        findViewById(R.id.q).setOnClickListener(new  View.OnClickListener() {
 				
 				@Override
 				public void onClick(View arg0) {
 					mp.start();
 					   Intent a=new Intent(Pilihan_Besar.this, Canvas_Game_Besar.class);
 					   a.putExtra("nama", "Q");
 					   a.putExtra("pilih", "huruf");
 					   startActivity(a);
 				   overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
 				  finish();	
 					
 				}
 			});     
 	        
 	        findViewById(R.id.r).setOnClickListener(new  View.OnClickListener() {
 				
 				@Override
 				public void onClick(View arg0) {
 					mp.start();
 					   Intent a=new Intent(Pilihan_Besar.this, Canvas_Game_Besar.class);
 					   a.putExtra("nama", "R");
 					   a.putExtra("pilih", "huruf");
 					   startActivity(a);
 				   overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
 				  finish();	
 					
 				}
 			});           
 	        
 	        findViewById(R.id.s).setOnClickListener(new  View.OnClickListener() {
 				
 				@Override
 				public void onClick(View arg0) {
 					mp.start();
 					   Intent a=new Intent(Pilihan_Besar.this, Canvas_Game_Besar.class);
 					   a.putExtra("nama", "S");
 					   a.putExtra("pilih", "huruf");
 					   startActivity(a);
 				   overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
 				  finish();	
 					
 				}
 			});  
 	        
 	        findViewById(R.id.t).setOnClickListener(new  View.OnClickListener() {
 				
 				@Override
 				public void onClick(View arg0) {
 					mp.start();
 					   Intent a=new Intent(Pilihan_Besar.this, Canvas_Game_Besar.class);
 					   a.putExtra("nama", "T");
 					   a.putExtra("pilih", "huruf");
 					   startActivity(a);
 				   overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
 				  finish();	
 					
 				}
 			});  
 	        
 	        findViewById(R.id.u).setOnClickListener(new  View.OnClickListener() {
 				
 				@Override
 				public void onClick(View arg0) {
 					mp.start();
 					   Intent a=new Intent(Pilihan_Besar.this, Canvas_Game_Besar.class);
 					   a.putExtra("nama", "U");
 					   a.putExtra("pilih", "huruf");
 					   startActivity(a);
 				   overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
 				  finish();	
 					
 				}
 			}); 
 	        
 	        findViewById(R.id.v).setOnClickListener(new  View.OnClickListener() {
 				
 				@Override
 				public void onClick(View arg0) {
 					mp.start();
 					   Intent a=new Intent(Pilihan_Besar.this, Canvas_Game_Besar.class);
 					   a.putExtra("nama", "V");
 					   a.putExtra("pilih", "huruf");
 					   startActivity(a);
 				   overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
 				  finish();	
 					
 				}
 			}); 
 	        
 	        findViewById(R.id.w).setOnClickListener(new  View.OnClickListener() {
 				
 				@Override
 				public void onClick(View arg0) {
 					mp.start();
 					   Intent a=new Intent(Pilihan_Besar.this, Canvas_Game_Besar.class);
 					   a.putExtra("nama", "W");
 					   a.putExtra("pilih", "huruf");
 					   startActivity(a);
 				   overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
 				  finish();	
 					
 				}
 			}); 
 	        
 	        findViewById(R.id.x).setOnClickListener(new  View.OnClickListener() {
 				
 				@Override
 				public void onClick(View arg0) {
 					mp.start();
 					   Intent a=new Intent(Pilihan_Besar.this, Canvas_Game_Besar.class);
 					   a.putExtra("nama", "X");
 					   a.putExtra("pilih", "huruf");
 					   startActivity(a);
 				   overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
 				  finish();	
 					
 				}
 			}); 
 	        
 	        findViewById(R.id.y).setOnClickListener(new  View.OnClickListener() {
 				
 				@Override
 				public void onClick(View arg0) {
 					mp.start();
 					   Intent a=new Intent(Pilihan_Besar.this, Canvas_Game_Besar.class);
 					   a.putExtra("nama", "Y");
 					   a.putExtra("pilih", "huruf");
 					   startActivity(a);
 				   overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
 				  finish();	
 					
 				}
 			}); 
 	        
 	        findViewById(R.id.z).setOnClickListener(new  View.OnClickListener() {
 				
 				@Override
 				public void onClick(View arg0) {
 					mp.start();
 					   Intent a=new Intent(Pilihan_Besar.this, Canvas_Game_Besar.class);
 					   a.putExtra("nama", "Z");
 					   a.putExtra("pilih", "huruf");
 					   startActivity(a);
 				   overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
 				  finish();	
 					
 				}
 			});
  }
  
        public void onBackPressed()
        {

        	overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
   		 Intent localIntent = new Intent(Pilihan_Besar.this, MainActivity.class);
   		 localIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
   		 startActivity(localIntent);
   		  finish();
        }
}
