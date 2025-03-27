package com.javium.editor;

public record EditorConfig() {
    private static float[] backgroundColor = {0.0f, 0.0f, 0.0f, 1.0f};
    private static float[] textColor = {1.0f, 1.0f, 1.0f, 1.0f};

    public static float[] getBackgroundColor() {
        return backgroundColor;
    }

    public static float[] getTextColor() {
        return textColor;
    }
}
