@echo off
REM ---- Locate git.exe from the GIT installation directory. ----
set GIT_PATH="D:\Johan\Programs\Git\bin\git.exe"
%GIT_PATH% add -A
%GIT_PATH% commit -m "Auto-committed on %date%"
%GIT_PATH% push