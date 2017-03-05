/* A basic C++ library program. */
#include "Hello.h"
#include <jni.h>
#include <iostream>

/*
 * Header:    Hello.h
 * Function:  print
 * Type:      void()
 */
JNIEXPORT void JNICALL Java_Hello_print (JNIEnv *env, jobject obj) {
	std::cout << "Hello, World!";
	return;
} 
