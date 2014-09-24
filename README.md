clip-android-in-app-checkout-sdk
================================

Clip's Android SDK Library to facilitate in-app checkout of good or services that will be used outside of your application. 

### Widget setup

To create a Clip widget implement an instance of it in your activity as follows:  

```java
    ClipWidget _widget = new ClipWidget(this, 
                                        "your access token",
                                        "your users id",
                                        "user token",
                                        "charge amount", (eg. "5.99")
                                        _myDrawable,
                                        "Foo app")
```
The appIcon and appName parameters can be set to null, but if provided wil be displayed during a keyed entered flow. 

### Example

See the folder clip-in-app-checkout-example for an example project that was setup up using the manual installation instructions.  
