package dela.cemerlang.s1creative.alphabet;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.webkit.WebView;

public class About extends Activity  {
	
 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        
        String dat="<html>"+
    			"<table>"+
    			"<tr><td>Nama </td><td>: </td><td>Rini Lovia Dela</td></tr>"+
    			"<tr><td></td><td></td><td></td></tr>"+
    			"<tr><td>Jurusan </td><td>: </td><td>Informatika</td></tr>"+
    			"<tr><td></td><td></td><td></td></tr>"+
    			"<tr><td>Judul Skripsi </td><td>: </td><td>Media Edukasi Berbasis Android Untuk Pembelajaran Menulis Alfabet dan Angka Pada PAUD</td></tr>"+
    			"<tr><td></td><td></td><td></td></tr>"+
    			"<tr><td>Universitas </td><td>: </td><td>UIGM Palembang</td></tr>"+
    			"<tr><td></td><td></td><td> <img src=''> </td></tr>"+			
    			"</table>"+
    			"</html>";


    WebView wb=(WebView)findViewById(R.id.webView1);
    wb.setBackgroundColor(Color.TRANSPARENT);
    wb.loadData(dat,"text/html","utf-8");
 }

}