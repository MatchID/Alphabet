package dela.cemerlang.s1creative.alphabet;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Hasil extends Activity  {
	String url, success, val, isi, minta, huruf, kondisi;
	TextView textView3, textView2;
	
 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hasil);
        
    	SharedPreferences xxx=getApplicationContext().getSharedPreferences("kirim",0);
    	Editor ed=xxx.edit();
        
        
        Bundle bd = getIntent().getExtras();
        val=bd.getString("pilih");
        
        Bundle bd2 = getIntent().getExtras();
        isi=bd2.getString("isi");
        
        if (val.equals("angka")){
        	Hasil_Kondisi hasilnya = new Hasil_Kondisi(isi,xxx.getInt("hasil", 0));
            textView2=(TextView)findViewById(R.id.textView2);
            textView2.setText(" Poin Kamu :");
            textView3=(TextView)findViewById(R.id.txtPoint);
            textView3.setText(""+hasilnya.getHasil());        	
        }else{
        	Hasil_Kondisi hasilnya = new Hasil_Kondisi(isi,xxx.getInt("hasil", 0));
        	
            textView2=(TextView)findViewById(R.id.textView2);
            textView2.setText(" Poin Kamu :");
            textView3=(TextView)findViewById(R.id.txtPoint);
            textView3.setText(""+hasilnya.getHasil());
        }
        sr();
        Button keluar = (Button)findViewById(R.id.button1);
        
        keluar.setOnClickListener(new View.OnClickListener() {
		
			@Override
			public void onClick(View arg0) {
				if(val.equals("angka")){
				 	finish();
					Intent a=new Intent(Hasil.this,Pilihan_Angka.class);
					startActivity(a);
					overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
					finish();
					
				}
			else if(val.equals("besar")){

				 	finish();
					Intent a=new Intent(Hasil.this,Pilihan_Besar.class);
					 startActivity(a);
					 overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
					 finish();
					
				}else{

				 	finish();
					Intent a=new Intent(Hasil.this,Pilihan_Kecil.class);
					a.putExtra("pilih", val);
					startActivity(a);
					overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
					finish();
				}
				
			}
		});
        
 }
 
 public void sr(){
	 final MediaPlayer mp= MediaPlayer.create(this,R.raw.tepuk);
	 if(mp!= null) {
	       if(mp.isPlaying()) mp.pause();
	    }	
	 mp.start();
 }

}
