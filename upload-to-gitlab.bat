@echo off
echo ========================================
echo   GitLab 一键上传脚本
echo ========================================
echo.

cd /d "c:\Users\tdp22\CodeBuddy\20260421222647"

echo [1/4] 初始化Git仓库...
git init
git add .
git commit -m "Initial commit: Round Clock App for circular display"
git branch -M main

echo.
echo [2/4] 请输入你的GitLab用户名：
set /p username=

echo.
echo [3/4] 正在连接GitLab...
git remote add origin https://gitlab.com/%username%/RoundClockApp.git

echo.
echo [4/4] 正在上传代码...
git push -u origin main

echo.
echo ========================================
echo   上传完成！
echo ========================================
echo.
echo 接下来的步骤：
echo 1. 访问: https://gitlab.com/%username%/RoundClockApp
echo 2. 进入 CI/CD -^> Pipelines
echo 3. 等待编译完成
echo 4. 下载生成的APK
echo.
echo 注意：GitLab需要配置.gitlab-ci.yml文件才能自动编译
echo.
pause
