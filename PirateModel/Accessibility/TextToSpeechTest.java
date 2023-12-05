package PirateModel.Accessibility;

import org.junit.jupiter.api.Test;

public class TextToSpeechTest {
    /*
    Testing for Accessibility feature
     */

    @Test
    public void textToSpeechTestVoice() {
        TextToSpeech tts = new TextToSpeech();

        tts.speak("I love C S C 2 3 6 hahahahaha yeah");

    }


}
