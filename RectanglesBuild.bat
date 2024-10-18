@echo off

rem Directories
set SRC_DIR=src\main\java\com\joaolubaw\rectangles
set BIN_DIR=bin
set JAR_NAME=rectangles.jar
set MANIFEST_FILE=MANIFEST.MF

rem Create a directory, in case it doesn't exists
if not exist %BIN_DIR% (
    mkdir %BIN_DIR%
)

rem Compilee the Java
javac -d %BIN_DIR% %SRC_DIR%\*.java

rem Create que MANIFEST
echo Main-Class: com.joaolubaw.rectangles.Main > %MANIFEST_FILE%

rem Create the executable JAR
jar cfm %JAR_NAME% %MANIFEST_FILE% -C %BIN_DIR% .

rem Limpa o arquivo de manifesto
del %MANIFEST_FILE%

echo Build complete. You can run the JAR file using: java -jar %JAR_NAME%
