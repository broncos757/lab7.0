@echo off
SETLOCAL EnableDelayedExpansion

:: saves current directory
cd > temp
set /p curLoc=<temp
del temp
:: switches current directory to the root directory
:: cd \

:: searches for the file
set break=0
for /f "skip=1" %%i in ('wmic logicaldisk get caption') do (
    for /f "delims=" %%k in ("%%i") do (
        if not !break!==1 (
            cd %%k\
            dir /b/s "Program Files\Java\jdk1.8*" > %curLoc%\temp
            powershell "(Get-ChildItem %curLoc%\temp).Length" > %curLoc%\lenTemp
            set /p len=<%curLoc%\lenTemp
            del %curLoc%\lenTemp
            if not !len!==0 set break=1
            )
        )
    )
:: back to original directory
cd %curLoc%

set /p var=<temp
del temp
:: sets the classpath
setx CLASSPATH "%CLASSPATH%;%cd%\CS15Support.jar" /M > nul
:: sets JAVA_HOME
setx JAVA_HOME "%var%" /M > nul
:: sets the system path to include JAVA_HOME\bin
powershell "[Environment]::SetEnvironmentVariable('Path','%%JAVA_HOME%%\bin;' + [Environment]::GetEnvironmentVariable('Path', [EnvironmentVariableTarget]::Machine),'Machine')"
:: if no error, deletes the settings and script files
if %errorlevel% neq 0 (
echo Something ain't right here. Better call a TA.
) else (
echo All set^^!
del settings.zip macSetup.sh 2>nul
)
