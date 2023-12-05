package PirateModel.Accessibility;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import javax.sound.sampled.AudioInputStream;

public class TextToSpeech {
    /*
    class ScreenReader
    Reads a string out loud for accessibility purposes
     */

    public void speak(String s) {
        /*
        Reads the input string out loud
         */
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");

        VoiceManager vm = VoiceManager.getInstance();

        Voice voice = vm.getVoice("kevin16");
        voice.allocate();
        voice.speak(s);
    }

}
