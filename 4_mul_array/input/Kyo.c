#include <jni.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <Kyo.h>

JNIEXPORT void JNICALL Java_Kyo_init(JNIEnv *env, jclass obj) {
    system("stty -echo -icanon");
}

JNIEXPORT jint JNICALL Java_Kyo_key(JNIEnv *env, jclass obj) {
    char ch[8];
    int ret, key = -1;

    ret = read(0, ch, 8);
    if (ret == 1)
        key = ch[0];
    else if (ret == 3 && ch[0] == 27 && ch[1] == 91)
        key = ch[2] + 100;

    return key;
}

JNIEXPORT void JNICALL Java_Kyo_exit(JNIEnv *env, jclass obj) {
    system("stty echo icanon");
}
