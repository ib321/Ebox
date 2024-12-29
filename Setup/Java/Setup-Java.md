# How to setup Java: Download & Install JDK | Set Path and JAVA_HOME

This guide demonstrates how to download and install the Java Development Kit (JDK) on Windows, and how to set the necessary environment variables (PATH and JAVA_HOME).

## Steps:

### 1. Download the JDK 8:
- For Windows(x64):
    - Click on this link and download JDK 1.8 - [Java-1.8 Download Link](https://drive.google.com/file/d/1s3v2EEYO8ICMntTzFiFaTwfV1ATEfx22/view?usp=sharing)
    - [Java 1.8 8u381 Direct Download Link](https://javadl.oracle.com/webapps/download/AutoDL?BundleId=248737_8c876547113c4e4aab3c868e9e0ec572)

- For Other Operating System:
    - Open a web browser and search for "JDK" on Google.
    - Click on the first result from Oracle.com.
    - Select the installer for Windows and download it.
- JDK 1.8 archive oracle URL
    - [oracle.com/javase8u211-later](https://www.oracle.com/in/java/technologies/javase/javase8u211-later-archive-downloads.html)

### 2. Install the JDK:
1. Double-click on the installer file.
2. Accept the default installation path or change it if needed.
3. Click "Next" to start the installation.
4. Once the installation is complete, you can optionally view the API documentation or tutorials.

### 3. Set the JAVA_HOME environment variable:
1. Open Enviroment Varibale Panel:
    - Open the Control Panel and go to **System > Advanced System Settings > Environment Variables**.
    - Or if not above try **Right click on This PC -> Properties ->Advanced System Settings > Environment Variables**
    - OR if above not work: search **system env** in search box then click on **Edit the system environment variable** then click **Environment Variables**
2. Then You will get popup like this: 
    - ![Enviroment varibale PopUp](https://github.com/ib321/Ebox/blob/main/Setup/Java/images/1EnvVar.png?raw=true)
3. Create a new **system variable** by clicking New below.
4. Enter variable name: `JAVA_HOME` 
5. Enter variable Value: `JAVA_HOME` to the path of the JDK installation directory.
    - Example: `C:\Program Files\Java\jdk1.8.0_311`
    - ![Set Value](https://github.com/ib321/Ebox/blob/main/Setup/Java/images/2EnvVar.png?raw=true)

### 4. Set the PATH environment variable:
1. Click on the "Path" variable and add the path to the JDK's `bin` folder.
    - Example1: `C:\Program Files\Java\jdk1.8.0_311\bin`
    - Example2: `%JAVA_HOME%\bin`

### 5. Test the installation:
1. Open a command prompt and type `java -version`
2. If the installation was successful, the command will display the version of the JDK that is installed.

**Note:** The specific paths and version numbers may vary depending on your installation.
