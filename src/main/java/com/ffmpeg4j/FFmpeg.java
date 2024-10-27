package com.ffmpeg4j;

public class FFmpeg {
    static {
        System.loadLibrary("ffmpeg");
    }

    public native int command(String[] args);
}
