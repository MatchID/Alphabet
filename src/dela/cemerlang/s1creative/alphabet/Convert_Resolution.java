package dela.cemerlang.s1creative.alphabet;

public class Convert_Resolution {

	float x, y;

	public Convert_Resolution(float xy, float height, float width){  
		//width > 720
		//height > 1280
		  float xxa = (xy * 100)/ 720; //untuk x
		  float yya = (xy * 100)/ 1280; //untuk y
		  
		  float aas = (xxa * width) / 100;
		  float aab = (yya * height) / 100;
		  
		  this.x = aas;
		  this.y = aab;
	}

    public Float getX () {
        return this.x;
    }
    public Float getY () {
        return this.y;
    }
	   
}
