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
    charcoal_version = "1.0.4"
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
- compileSdk
    - `charcoal-android-view`: 35+
    - `charcoal-compose`: 37+

## Screenshot test

`charcoal-compose` は [Roborazzi](https://github.com/takahirom/roborazzi) で Composable Preview の
スクリーンショットを生成・比較できます。対象はモジュール内のすべての `@Preview`（private を含む）で、
テストコードは自動生成されます。

```sh
# スクリーンショットを生成する（charcoal-android-compose/build/outputs/roborazzi/ に出力）
./gradlew :charcoal-android-compose:recordRoborazziDebug

# 前回の生成結果と比較する（差分画像は *_compare.png として出力）
./gradlew :charcoal-android-compose:compareRoborazziDebug

# 差分があればテストを失敗させる
./gradlew :charcoal-android-compose:verifyRoborazziDebug
```

基準画像はリポジトリにコミットしていません。変更前後を比較するときは、変更前のコミットで `record` してから
変更後のコミットに切り替えて `compare` を実行してください（出力先は `build/` 配下なので切り替えても残ります）。

通常の `testDebugUnitTest` ではスクリーンショットテストは実行されません。

## Documentation

- [Android View](https://pixiv.github.io/charcoal-android/android_view/)
- [Jetpack Compose](https://pixiv.github.io/charcoal-android/compose/)

