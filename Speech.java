import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class Speech {
    static Voice voice;

    static {
        System.setProperty("freetts.voices",
                "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        voice = VoiceManager.getInstance().getVoice("kevin16");
        if (voice != null) {
            voice.allocate();
        } else {
            throw new IllegalStateException("Cannot find voice: kevin16");
        }
    }

    public static void speak(String text) {
        if (voice != null) {
            voice.speak(text);
        }
    }
}
