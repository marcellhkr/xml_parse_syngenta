@ECHO OFF

IF NOT EXIST %~dp0logs mkdir %~dp0logs

set ROBO_HOME=%~dp0
set ROBO_LOG=%~dp0logs
set ROBO=parse_xml
set LIB_DIR=%ROBO_HOME%
set LOG_DIR=%ROBO_LOG%
set JAR_ROBO=%ROBO%.jar
set LOG_ROBO=%ROBO%_%date:~0,2%-%date:~3,2%-%date:~6,10%-%time:~0,2%-%time:~3,2%.log

cls
echo #------------------------------------------------------------------------------------------------------------------#
echo # ROBO PARSE SYNGENTA %ROBO% INICIADO EM %ROBO_HOME% , JAR EM %LIB_DIR% e LOG EM %LOG_DIR% #
echo #------------------------------------------------------------------------------------------------------------------#

TASKLIST /NH /FI "IMAGENAME eq %ROBO%" | FIND /I "%1" > NUL
IF %ERRORLEVEL%==0 java -jar %LIB_DIR%/%JAR_ROBO% > %LOG_DIR%/%LOG_ROBO%
