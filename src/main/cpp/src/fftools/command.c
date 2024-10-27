#include <jni.h>
#include "fftools/ffmpeg.h"

JNIEXPORT jint JNICALL Java_com_ffmpeg4j_FFmpeg_command(JNIEnv *env, jobject obj, jobjectArray array) {
    jsize length = (*env)->GetArrayLength(env, array);
    int argc = (int)length;
    char** argv = (char**)malloc((argc + 1) * sizeof(char*));
//    argv[0] = "";
    for (int i = 0; i < argc; i++) {
        jstring str = (jstring)(*env)->GetObjectArrayElement(env, array, i);
        const char *cstr = (*env)->GetStringUTFChars(env, str, NULL);
        argv[i + 1] = (char*)malloc((strlen(cstr) + 1) * sizeof(char));
        strcpy(argv[i + 1], cstr);
        (*env)->ReleaseStringUTFChars(env, str, cstr);
    }

    int result = command(argc + 1, argv);

    // 释放内存
    for (int i = 1; i <= argc; i++) {
//        printf("Arg %d: %s\n", i, argv[i]);
        free(argv[i]);
    }
    free(argv);

    return result;
}