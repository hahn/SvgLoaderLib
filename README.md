# SvgLoaderLib

[![](https://jitpack.io/v/hahn/svgloaderlib.svg)](https://jitpack.io/#hahn/svgloaderlib)

Library for load SVG files in Android from internet using Glide v4. This library forked from  [AndroidSvgLoader](https://github.com/ar-android/AndroidSvgLoader). 
If you still use Glade v3, please use AndroidSvgLoader library instead. 

## Installation
**build.gradle**
```gradle
allprojects {
  repositories {
   maven { url 'https://jitpack.io' }
  }
 }
```
**app/build.grdle**
```gradle
implementation 'com.github.hahn:SvgLoaderLib:{VERSION}'
```

## Usage
```kotlin
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val url = "https://upload.wikimedia.org/wikipedia/commons/0/02/SVG_logo.svg"

        SvgLoader.pluck()
            .with(this)
            .setPlaceHolder(R.mipmap.ic_launcher, R.drawable.ic_launcher_background)
            .load(url, imageView)

    }

    override fun onDestroy() {
        super.onDestroy()
        SvgLoader.pluck().close()
    }
}
```

## License

```
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
