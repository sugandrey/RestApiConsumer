package org.example;

public class Translation {

    private String text;
    private String detectedLanguageCode;

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public String getDetectedLanguageCode() {
        return detectedLanguageCode;
    }

    public void setDetectedLanguageCode(final String detectedLanguageCode) {
        this.detectedLanguageCode = detectedLanguageCode;
    }
}
