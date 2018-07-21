package dela.cemerlang.s1creative.alphabet;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class Background_Sound extends Service{
	MediaPlayer mp;
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	public void onCreate(){
		mp = MediaPlayer.create(this, R.raw.k545_rondo);
		mp.setLooping(true);
		mp.setVolume(100, 100);
	}
	public int onStartCommand(Intent intent, int flags, int startid){
		//Log.d(tag, "On Start");
		mp.start();
		return 1;
	}
	public void onDestroy(){
		mp.stop();
		mp.release();
	}
	public void onStart(Intent intent, int startid){
		//Log.d(tag, "On Start");
		mp.start();
	}
}
