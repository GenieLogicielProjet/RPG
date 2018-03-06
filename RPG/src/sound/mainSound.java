package sound;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class mainSound {
	
public static void main(String[] args) {
	Sound player = new Sound("blackpanther.wav");
	InputStream stream = new ByteArrayInputStream(player.getSamples()); 
	player.play(stream);
}

}