package com.example.therobins.beacongame;

/**
 * Created by rishabh on 12/29/16.
 */

public class Hint {

    private String text_hint;
    private String audio_hint;

    Hint(){
        text_hint = "";
        audio_hint = "";
    }

    public String getAudio_hint() {
        return audio_hint;
    }

    public void setAudio_hint(String audio_hint) {
        this.audio_hint = audio_hint;
    }

    public String getText_hint() {
        return text_hint;
    }

    public void setText_hint(String text_hint) {
        this.text_hint = text_hint;
    }
}
