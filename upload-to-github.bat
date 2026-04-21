@echo off
echo 正在初始化Git仓库...
cd /d "c:\Users\tdp22\CodeBuddy\20260421222647"

git init
git add .
git commit -m "Initial commit: Round Clock App for circular display"
git branch -M main

echo.
echo 请输入你的GitHub用户名，然后按回车：
set /p username=

git remote add origin https://github.com/%username%/RoundClockApp.git
git push -u origin main

echo.
echo 上传完成！
echo 现在访问: https://github.com/%username%/RoundClockApp/actions
echo 等待3-5分钟后下载APK
pause
