# SVGPNGContainer
SVGの中にパス指定のimageタグがある場合、その内容をbase64にしてSVGの中に埋め込みます。対応画像フォーマットはPNGです。

# How to Use
Read [this test](https://github.com/ukiuni/SVGPNGContainer/blob/master/src/test/java/SVGPng64ContainerTest.java) 

# リポジトリ
gradle
```
repositories {
    maven { url 'https://raw.githubusercontent.com/ukiuni/SVGPNGContainer/master/repository' }
}

dependencies {
    compile 'org.ukiuni:svgpngcontainer:1.0.0' 
}
```
