/* A basic C library program. */
#include "Hello.h"
#include <jni.h>
#include <stdio.h>

/*
 * Header:    Hello.h
 * Function:  print
 * Type:      void()
 */
JNIEXPORT void JNICALL Java_Hello_print (JNIEnv *env, jobject obj) {
	printf("Hello, World!");
	return;
} 
