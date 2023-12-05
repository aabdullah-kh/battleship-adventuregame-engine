package PirateModel.Accessibility;

import org.junit.jupiter.api.Test;

public class TextToSpeechTest {
    /*
    Testing for Accessibility feature
     */

    @Test
    public void TextToSpeechTestVoice() {
        TextToSpeech tts = new TextToSpeech();

        tts.Speak("I love C S C 2 3 6 hahahahaha yeah");

    }


}
