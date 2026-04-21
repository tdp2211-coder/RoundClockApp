@echo off
echo ========================================
echo   Gitee 一键上传脚本
echo ========================================
echo.

cd /d "c:\Users\tdp22\CodeBuddy\20260421222647"

echo [1/4] 初始化Git仓库...
git init
git add .
git commit -m "Initial commit: Round Clock App for circular display"
git branch -M master

echo.
echo [2/4] 请输入你的Gitee用户名：
set /p username=

echo.
echo [3/4] 正在连接Gitee...
git remote add origin https://gitee.com/%username%/RoundClockApp.git

echo.
echo [4/4] 正在上传代码...
git push -u origin master

echo.
echo ========================================
echo   上传完成！
echo ========================================
echo.
echo 接下来的步骤：
echo 1. 访问: https://gitee.com/%username%/RoundClockApp
echo 2. 点击【管理】-【仓库设置】
echo 3. 将项目语言设置为【Android】
echo 4. 返回首页，点击【生成APK】按钮
echo 5. 等待编译完成后下载APK
echo.
pause
