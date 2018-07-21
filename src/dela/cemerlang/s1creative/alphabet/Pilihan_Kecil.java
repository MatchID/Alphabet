package dela.cemerlang.s1creative.alphabet;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Pilihan_Kecil extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pilihan_kecil);

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
				 Intent localIntent = new Intent(Pilihan_Kecil.this, MainActivity.class);
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
 					   Intent a=new Intent(Pilihan_Kecil.this, Canvas_Game_Kecil.class);
 					   a.putExtra("nama", "a");
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
 					   Intent a=new Intent(Pilihan_Kecil.this, Canvas_Game_Kecil.class);
 					   a.putExtra("nama", "b");
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
 					   Intent a=new Intent(Pilihan_Kecil.this, Canvas_Game_Kecil.class);
 					   a.putExtra("nama", "c");
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
 					   Intent a=new Intent(Pilihan_Kecil.this, Canvas_Game_Kecil.class);
 					   a.putExtra("nama", "d");
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
 					   Intent a=new Intent(Pilihan_Kecil.this, Canvas_Game_Kecil.class);
 					   a.putExtra("nama", "e");
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
 					   Intent a=new Intent(Pilihan_Kecil.this, Canvas_Game_Kecil.class);
 					   a.putExtra("nama", "f");
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
 					   Intent a=new Intent(Pilihan_Kecil.this, Canvas_Game_Kecil.class);
 					   a.putExtra("nama", "g");
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
 					   Intent a=new Intent(Pilihan_Kecil.this, Canvas_Game_Kecil.class);
 					   a.putExtra("nama", "h");
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
 					   Intent a=new Intent(Pilihan_Kecil.this, Canvas_Game_Kecil.class);
 					   a.putExtra("nama", "i");
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
 					   Intent a=new Intent(Pilihan_Kecil.this, Canvas_Game_Kecil.class);
 					   a.putExtra("nama", "j");
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
 					   Intent a=new Intent(Pilihan_Kecil.this, Canvas_Game_Kecil.class);
 					   a.putExtra("nama", "k");
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
 					   Intent a=new Intent(Pilihan_Kecil.this, Canvas_Game_Kecil.class);
 					   a.putExtra("nama", "l");
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
 					   Intent a=new Intent(Pilihan_Kecil.this, Canvas_Game_Kecil.class);
 					   a.putExtra("nama", "m");
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
 					   Intent a=new Intent(Pilihan_Kecil.this, Canvas_Game_Kecil.class);
 					   a.putExtra("nama", "n");
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
 					   Intent a=new Intent(Pilihan_Kecil.this, Canvas_Game_Kecil.class);
 					   a.putExtra("nama", "o");
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
 					   Intent a=new Intent(Pilihan_Kecil.this, Canvas_Game_Kecil.class);
 					   a.putExtra("nama", "p");
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
 					   Intent a=new Intent(Pilihan_Kecil.this, Canvas_Game_Kecil.class);
 					   a.putExtra("nama", "q");
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
 					   Intent a=new Intent(Pilihan_Kecil.this, Canvas_Game_Kecil.class);
 					   a.putExtra("nama", "r");
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
 					   Intent a=new Intent(Pilihan_Kecil.this, Canvas_Game_Kecil.class);
 					   a.putExtra("nama", "s");
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
 					   Intent a=new Intent(Pilihan_Kecil.this, Canvas_Game_Kecil.class);
 					   a.putExtra("nama", "t");
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
 					   Intent a=new Intent(Pilihan_Kecil.this, Canvas_Game_Kecil.class);
 					   a.putExtra("nama", "u");
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
 					   Intent a=new Intent(Pilihan_Kecil.this, Canvas_Game_Kecil.class);
 					   a.putExtra("nama", "v");
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
 					   Intent a=new Intent(Pilihan_Kecil.this, Canvas_Game_Kecil.class);
 					   a.putExtra("nama", "w");
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
 					   Intent a=new Intent(Pilihan_Kecil.this, Canvas_Game_Kecil.class);
 					   a.putExtra("nama", "x");
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
 					   Intent a=new Intent(Pilihan_Kecil.this, Canvas_Game_Kecil.class);
 					   a.putExtra("nama", "y");
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
 					   Intent a=new Intent(Pilihan_Kecil.this, Canvas_Game_Kecil.class);
 					   a.putExtra("nama", "z");
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
   		 Intent localIntent = new Intent(Pilihan_Kecil.this, MainActivity.class);
   		 localIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
   		 startActivity(localIntent);
   		  finish();
        }
}
