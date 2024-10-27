package com.ffmpeg4j;

public class Main {
    public static void main(String[] args) {
        FFmpeg ffmpeg = new FFmpeg();
//        String[] cmdStr = {"-version"};
        String[] cmdStr = {"-i", "/home/xiefeihong/视频/test.mp4", "/home/xiefeihong/视频/test.mov", "-y"};
        /*String[] cmdStr = new String[args.length-1];
        for (int i = 1; i < args.length; i++) {
            cmdStr[i - 1] = args[i];
        }*/
        ffmpeg.command(cmdStr);
    }
}
