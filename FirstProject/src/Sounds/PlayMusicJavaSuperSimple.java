package Sounds;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class PlayMusicJavaSuperSimple {
	public static void main(String[] agrs) {

		String filepath = "C:\\Voice\\kimvoice2.wav";
		PlayMusic(filepath);
		JOptionPane.showMess	ageDialog(null, "Press Ok to stop Playing");
	}

	public static void PlayMusic(String location) {
		try {

			File musicPath = new File(location);
			if (musicPath.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
			} else {
				System.out.println("can't find Files");
			}
		} catch (

		Exception e) {
			System.out.println(e);
		}
	}
}
