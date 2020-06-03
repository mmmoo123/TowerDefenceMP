package sounds;

import java.io.File;

import jaco.mp3.player.MP3Player;

public class PlayMusic {

	public static final String SONG = "C:\\eclipse-workspace\\TDPro\\sounds\\soundtrack.mp3";
	static MP3Player mp3player = new MP3Player(new File(SONG));
	public static void main(String[] args) {
		

	}
	
	public static void playMusic() {
		mp3player.play();
	}
	
	public static boolean musicIsStopped() {
		return mp3player.isStopped();
				
			
	}

}
