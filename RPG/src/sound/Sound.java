rapackage sound;

import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;


// To play sound using Clip, the process need to be alive.
// Hence, we use a Swing application.
//In InterfaceTest add "new Sound();"
public class Sound {
   
   // Constructor
   public Sound() {
   
      try {
         // Open an audio input stream.
    	  File soundFile = new File("esperance.wav");
    	  AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
         // Get a sound clip resource.
         Clip clip = AudioSystem.getClip();
         // Open audio clip and load samples from the audio input stream.
         clip.open(audioIn);
         clip.start();
         clip.loop(Clip.LOOP_CONTINUOUSLY);
      } catch (UnsupportedAudioFileException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (LineUnavailableException e) {
         e.printStackTrace();
      }
   }
   
}
