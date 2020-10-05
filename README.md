## Summary

This project is to demonstrate Android app validation in server side when an API call is made from the app.

Main objective is to determine if our API is getting called from the right APK file that was signed by the release certificate or keystore file.


## How it is done?

To obtain this behavior, the app is generating the SHA1 fingerprint string in runtime and sending it as a header when the API endpoint is called.

In server side, this string is already saved somewhere. When API is called, we can verify the request is coming from the original release App 

by matching these strings.

## Important!!

- In the Android project, you can see I have included two keystore files. This is simply for demonstration purpose. In real project, you should not put your keystore file in the source.

- This projects do not follow any best practices. Main focus is to demonstrate how we can pass some pointer to server from client. 

## Test

In current setup, if you run the server project and run the App in an emulator, the app will get valid response from the server.

Check Android studio Logcat to see the response. 

It is because, now the android project is using valid.keystore file and in server side the SHA1 fingerprint string is set for this keystore.



To test how server blocks unauthorized app getting valid response, you can change the Android project to use invalid.keystore.

To do that go to app/build.gradle file and comment out existing debug signingConfig and uncomment the other debug signingConfig that uses invalid.keystore.

Now if you run the app and click on the button, app will get an emptry array.

## Is it enough?

It should give you some level of security for your system. Now no one can request to your endpoint except from the original App.

If anyone gets the source code of the Android app by reverse engineering, he still will not be able to get response from the API endpoint because he does not have your signing certificate.

This project is based on this [blog](https://www.airpair.com/android/posts/adding-tampering-detection-to-your-android-app). Here you can see some other ways to secure Android app.


## Note
- If you want to use an actual android device instead of emulator, you may need to change the BASE_URL in MainActivity.java

- API must be served with HTTPS protocol. Otherwise, anyone can see SHA1 fingerprint string that is sent to server while app is calling the API endpoint.



