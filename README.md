# 圆形屏安卓时钟应用

## 📱 项目简介

这是一个专为**圆形屏幕+安卓系统**设备设计的时钟表盘应用。采用自定义View实现，完美适配圆形显示屏。

## ✨ 特性

- ⭕ **圆形屏完美适配** - 专为圆形屏幕优化设计
- 🎨 **精美表盘** - 经典模拟时钟样式，带刻度和指针
- ⚡ **实时更新** - 秒针实时走动
- 🌙 **全屏显示** - 沉浸式体验，无状态栏和导航栏
- 💡 **常亮模式** - 屏幕保持常亮，适合作为桌面时钟
- 🎯 **轻量高效** - 纯原生实现，无第三方依赖

## 🛠️ 技术栈

- **语言**: Kotlin
- **最低SDK**: Android 8.0 (API 26)
- **目标SDK**: Android 14 (API 34)
- **架构**: 自定义View + Canvas绘制

## 📥 下载APK

### 方法1：GitHub Actions自动编译（推荐）

1. **Fork或上传本项目到GitHub**
2. **推送代码后自动编译**
   - 每次push代码，GitHub Actions会自动编译
   - 在仓库的 `Actions` 标签页查看编译进度
3. **下载APK**
   - 编译完成后，点击对应的workflow
   - 在 `Artifacts` 区域下载 `app-debug.apk` 或 `app-release.apk`

### 方法2：本地编译

需要安装Android Studio，然后：

```bash
./gradlew assembleDebug
# APK位置: app/build/outputs/apk/debug/app-debug.apk
```

### 方法3：使用Gitee在线编译（国内用户）

1. 将项目上传到Gitee
2. 设置项目语言为Android
3. 点击【生成APK】按钮
4. 等待编译完成后下载

## 📐 设计说明

### 时钟样式
- **表盘**: 白色外圈，黑色背景
- **时针**: 白色粗针，长度为半径的50%
- **分针**: 白色中针，长度为半径的70%
- **秒针**: 红色细针，长度为半径的85%
- **刻度**: 60个刻度，每5个一个粗刻度

### 圆形屏适配
- 自动计算屏幕中心点
- 根据屏幕尺寸动态调整表盘大小
- 所有元素相对于圆心定位

## 🚀 快速开始

### 环境要求
- Android Studio Hedgehog | 2023.1.1 或更高版本
- JDK 17
- Android SDK 34

### 构建步骤

1. 用Android Studio打开项目
2. 等待Gradle同步完成
3. 连接圆形屏安卓设备或使用模拟器
4. 点击运行按钮

### 安装到设备

```bash
./gradlew assembleRelease
adb install app/build/outputs/apk/release/app-release-unsigned.apk
```

## 📂 项目结构

```
RoundClockApp/
├── .github/workflows/
│   └── build-apk.yml              # GitHub Actions配置
├── app/
│   ├── src/main/
│   │   ├── java/com/roundclock/app/
│   │   │   ├── MainActivity.kt          # 主Activity
│   │   │   └── CustomClockView.kt       # 自定义时钟View
│   │   ├── res/
│   │   │   ├── layout/
│   │   │   │   └── activity_main.xml    # 主布局
│   │   │   ├── values/
│   │   │   │   ├── strings.xml
│   │   │   │   └── themes.xml
│   │   └── AndroidManifest.xml
│   └── build.gradle
├── gradle/wrapper/
│   └── gradle-wrapper.properties
├── gradlew                        # Gradle wrapper (Linux/Mac)
├── gradlew.bat                    # Gradle wrapper (Windows)
├── build.gradle
└── settings.gradle
```

## 🎨 自定义配置

在 `CustomClockView.kt` 中可以修改以下参数：

```kotlin
// 颜色配置
private var dialColor = Color.WHITE           // 表盘颜色
private var hourHandColor = Color.WHITE       // 时针颜色
private var minuteHandColor = Color.WHITE     // 分针颜色
private var secondHandColor = Color.parseColor("#FF5252")  // 秒针颜色
private var scaleColor = Color.parseColor("#CCCCCC")       // 刻度颜色
private var backgroundColor = Color.BLACK     // 背景颜色

// 尺寸配置
private var dialWidth = 4f          // 表盘线宽
private var hourHandWidth = 8f      // 时针宽度
private var minuteHandWidth = 6f    // 分针宽度
private var secondHandWidth = 2f    // 秒针宽度
```

## 🔧 功能说明

### MainActivity.kt
- 设置全屏模式和沉浸式体验
- 保持屏幕常亮
- 初始化时钟视图

### CustomClockView.kt
- 使用Canvas绘制时钟表盘
- 实时获取系统时间
- 每秒自动刷新显示
- 完美适配圆形屏幕

## 📱 适用设备

- 圆形智能手表
- 圆形屏幕安卓设备
- 智能家居显示屏
- 车载圆形仪表盘

## 🎯 后续优化方向

- [ ] 添加多种表盘主题
- [ ] 支持数字时钟模式
- [ ] 添加日期显示
- [ ] 支持12/24小时制切换
- [ ] 添加夜间模式
- [ ] 支持自定义颜色
- [ ] 添加天气信息显示

## 📄 开源协议

MIT License

## 👨‍💻 开发说明

本项目基于调研的开源方案，采用纯原生实现，无第三方库依赖，代码简洁高效。

---

**享受你的圆形时钟吧！** ⏰
