package com.ffmpeg4j;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FFmpegTest {

    private FFmpeg ffmpeg;

    @Test
    void command() {
//        String[] cmdStr = {"-version"};
        String[] cmdStr = {"-i", "/home/xiefeihong/视频/test.mp4", "/home/xiefeihong/视频/test.mov", "-y"};
        ffmpeg.command(cmdStr);
    }

    @BeforeEach
    void setUp() {
        ffmpeg = new FFmpeg();
    }

}