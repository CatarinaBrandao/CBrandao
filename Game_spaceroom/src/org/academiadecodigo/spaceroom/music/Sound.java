package Sound;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.net.URL;
    public class Sound{
        private Clip Intergalactic;
        private Clip Crash;
        public void setBackgroundSound() {
            try {
                URL IntergalacticURL = getClass().getResource("/Sound/Intergalactic.wav");
                AudioInputStream IntergalacticStream = AudioSystem.getAudioInputStream(IntergalacticURL);
                Intergalactic = AudioSystem.getClip();
                Intergalactic .open(IntergalacticStream);
            } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
                e.printStackTrace();
            }
        }
        public void setCrashSound(){
            try {
                URL  CrashURL = getClass().getResource("/Sound/Crash.wav");
                AudioInputStream CrashStream = AudioSystem.getAudioInputStream( CrashURL);
                Crash = AudioSystem.getClip();
                Crash.open(CrashStream);
            }catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
                e.printStackTrace();
            }

        }


      public void play(){
            if (Intergalactic != null) {
                Intergalactic.start();
            }

      }

        public void playBackgroundSound(){

            if (Intergalactic != null) {
                Intergalactic .loop(Clip.LOOP_CONTINUOUSLY);
            }
        }
        public void playCrashSound(){
            if(Crash != null) {
                Crash.setFramePosition(0);
                Crash.start();
            }
        }



        public void stopBackground(){
            if(Intergalactic != null && Intergalactic.isRunning()){
                Intergalactic .stop();
                Intergalactic .close();
            }
        }
        public void stopCrashSound(){
            if( Crash!= null && Crash.isRunning()){
                Crash.stop();
                Crash.close();
            }
        }
}
