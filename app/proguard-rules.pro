-keep class com.fashionai.** { *; }
-keep class androidx.** { *; }
-keep class com.google.dagger.** { *; }
-keep @interface com.google.dagger.* { *; }
-keep class org.tensorflow.** { *; }
-keep class * extends androidx.room.RoomDatabase { *; }
-keepclasseswithmembernames class * {
    native <methods>;
}
-keepclasseswithmembernames class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}
