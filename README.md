# Infinite Scroll View
Infinite Scroll Banner implementation with InfiniteScrollView.

 
## Tech Stack
* Jetpack Compose
* State
* Hilt
* Flow
* Coroutine
* Kotlin

# Sample
The sample application is implemented for the show how to use infinite scrool view framework. Please check app/com.github.mertkalecik.infinitescroolview.

# Sample App Design 
| Forward | Backward |
| ------ | ------ |
| ![isv_1](https://user-images.githubusercontent.com/38656031/183303623-a7e43a6d-9b6b-4588-9028-a948a247f2d5.gif)| ![isv3](https://user-images.githubusercontent.com/38656031/183303639-891a8bad-6687-45bc-8e64-4a7881225908.gif)|

### Dependencies
** Lifecycle\
    implementation "androidx.fragment:fragment-ktx"\
    implementation "androidx.lifecycle:lifecycle-runtime-ktx"\
    implementation "androidx.lifecycle:lifecycle-common-java8"\
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx"
    
** Coroutine\
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core"\
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android"
    
** Hilt\
    implementation "com.google.dagger:hilt-android" \
    implementation "androidx.hilt:hilt-lifecycle-viewmodel"\
    implementation "androidx.hilt:hilt-navigation-compose"\
    kapt "com.google.dagger:hilt-android-compiler"
    
 ** Coil\
    implementation "io.coil-kt:coil-compose"

## Contributors
Mert Kalecik
* contact: mert.kalecik@hotmail.com
[@Linkedin](https://www.linkedin.com/in/mert-kalecik-129202b5)
[@Twitter](https://twitter.com/mertkalecik)

## Version History

* v1.0.0
  * Initial Release

## Add it in your root build.gradle

```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

## Add the dependency for InfiniteScrollView

```
	dependencies {
	        implementation 'com.github.mertkalecik:InfiniteScrollView:1.0.0'
	}
```
