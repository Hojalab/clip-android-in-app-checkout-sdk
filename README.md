clip-android-in-app-checkout-sdk
================================

Clip's Android SDK Library to facilitate in-app checkout of good or services that will be used outside of your application. 

## Overview

* Import Libriaries
  * Android Studio
* Android Manifest Permissions
* Disable Screen Rotation
* Setup Widget

## Procedure

### Manual Instalation

Download `mpllibrary.aar`, `clipcorepayments-1.0.aar`, `clipoba-1.0.aar`, `clipposlibrary-1.0.aar`, `clipwalletlibrary-1.0.aar`, and `PayclipCommonLibrary-1.0.aar` into a local directory.

#### Android Studio

Create a new module for each .aar with File -> New Module -> Import .JAR or .AAR Package.

Add the following dependencies into your app's build.gradle (they should match the generated library modules just created):

```
dependencies {
    compile project(':clipcorepayments-1.0')
    compile project(':clipoba-1.0')
    compile project(':clipposlibrary-1.0')
    compile project(':clipwalletlibrary-1.0')
    compile project(':PayclipCommonLibrary-1.0')
    compile project(':mpllibrary')
}
```
### Android Manifest Permissions

Add the following permissions to your app's AndroidManifest.xml:

```xml
    <uses-permission android:name="android.permission.VIBRATE" />
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
    <uses-permission android:name="android.permission.BLUETOOTH" />
```

### Disable Screen Rotation

Because the Clip widget only works in portrait mode, add set the screen orientation to portrait for any activities in which you want to use a Clip widget. Add this to each activity in which you want to have a Clip widget in you app's AndroidManifest.xml:

```xml
<activity
    ...
    ...
    android:screenOrientation="portrait">
```

### Setup Widget

To create a Clip widget implement an instance of it in your activity as follows:  

```java
    ClipWidget _widget = new ClipWidget(this, 
                                        "your access token",
                                        "your users id",
                                        "user token",
                                        "charge amount", // (eg. "5.99")
                                        _myDrawable,
                                        "Foo app")
```
The appIcon and appName parameters can be set to null, but if provided will be displayed during a keyed entered flow. 

You then need to set the color scheme (either dark or light), and add the widget to the view as a fragment. Possibly in your activity's onCreate():
```java
    _widget.setColorScheme(ClipWidget.ClipWidgetColorScheme.CLIP_WIDGET_COLOR_SCHEME_DARK);

    FragmentManager fragmentManager = getFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    fragmentTransaction.add(R.id.widget_container, _widget.fragment);
    fragmentTransaction.commit();
```
The widget_container just needs to be a FrameLayout positioned where you want it

## Example

See the folder clip-in-app-checkout-example for an example project that was setup up using the manual installation instructions.  
