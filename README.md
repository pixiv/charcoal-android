# charcoal-android  ― PIXIV Design System

## Usage
### Android View

```xml
<TextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Hello"
    android:textAppearance="@style/TextAppearance.Charcoal.Regular.20"
    android:textColor="?attr/colorCharcoalText1" />

<Button
    style="@style/Widget.Charcoal.Button.Default.M"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="OK" />
```

## Installation

```groovy
repositories {
    mavenCentral()
}
```

```groovy
ext {
    charcoal_version = "1.0.1"
}

dependencies {
    // Android View
    implementation "net.pixiv.charcoal:charcoal-android-view:$charcoal_version"
    // Compose(Experimental)
    implementation "net.pixiv.charcoal:charcoal-compose:$charcoal_version"
}
```

## Requirements

- minSdk 23+

## Documentation

- [Android View](https://pixiv.github.io/charcoal-android/android_view/)
- [Jetpack Compose](https://pixiv.github.io/charcoal-android/compose/)

