# Ejada Mobile Appium

## Overview

The **Ejada_Mobile_Appium** project is a mobile test automation framework built using Appium, designed to automate testing for Android and iOS applications. This repository contains scripts and configurations to perform automated UI testing on mobile applications, ensuring robust and reliable testing across multiple platforms. The framework leverages Appium's capabilities to interact with native, hybrid, and mobile web applications.

## Features

- **Cross-Platform Testing**: Supports automation for both Android and iOS applications.
- **Appium Integration**: Built on top of the Appium framework, utilizing the W3C WebDriver protocol for seamless mobile automation.
- **TestNG Framework**: Uses TestNG for test execution and reporting.
- **Maven Build**: Structured as a Maven project for dependency management and build automation.
- **Scalable Architecture**: Modular design to easily extend test cases and add new functionalities.

## Prerequisites

To run the tests in this repository, ensure you have the following installed:

- **Java Development Kit (JDK)**: Version 11 or higher.
- **Node.js**: Required for installing Appium.
- **Appium**: Install via npm with `npm install -g appium`.
- **Android SDK**: For Android testing, set up `ANDROID_HOME` and add platform-tools to your PATH.
- **Xcode**: For iOS testing, required on macOS with a valid developer account.
- **Maven**: For building and managing dependencies.
- **Appium Inspector**: For inspecting app elements and building locators.
- **Emulators/Simulators or Real Devices**: Configured Android emulators or iOS simulators, or physical devices connected via USB.

## Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/Abdullahmostafah/Ejada_Mobile_Appium.git
   cd Ejada_Mobile_Appium
   ```

2. **Install Dependencies**:
   Run the following command to install project dependencies using Maven:
   ```bash
   mvn install
   ```

3. **Install Appium**:
   Ensure Appium is installed globally:
   ```bash
   npm install -g appium
   ```

4. **Install Appium Drivers**:
   Install the necessary drivers for your target platform:
   ```bash
   appium driver install uiautomator2  # For Android
   appium driver install xcuitest      # For iOS
   ```

5. **Set Up Environment Variables**:
   - For Android:
     ```bash
     export ANDROID_HOME=<path-to-android-sdk>
     export PATH=$PATH:$ANDROID_HOME/platform-tools:$ANDROID_HOME/tools
     ```
   - For iOS, ensure Xcode is configured with a valid provisioning profile.

## Usage

1. **Configure Desired Capabilities**:
   Update the desired capabilities in the configuration file (e.g., `src/test/resources/config.properties` or a dedicated capabilities file) to specify the app, device, and platform details. Example:
   ```json
   {
     "platformName": "Android",
     "appium:automationName": "UiAutomator2",
     "appium:deviceName": "Pixel_3a",
     "appium:udid": "<device-udid>",
     "appium:app": "<path-to-apk>"
   }
   ```

2. **Start Appium Server**:
   Launch the Appium server in a terminal:
   ```bash
   appium
   ```

3. **Run Tests**:
   Execute the test suite using Maven:
   ```bash
   mvn test
   ```

4. **Inspect Elements**:
   Use Appium Inspector to identify elements in the app under test. Connect to the Appium server (default: `http://127.0.0.1:4723`) and provide the same desired capabilities.

## Project Structure

```
Ejada_Mobile_Appium/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/example/ # Utility classes and page objects
│   └── test/
│       └── java/
│           └── com/example/tests/ # Test cases
├── pom.xml                 # Maven configuration
├── config.properties       # Test configuration
└── README.md               # Project documentation
```



## Contributing

Contributions are welcome! To contribute:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -m 'Add your feature'`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Open a pull request.

Please ensure your code follows the project's coding standards and includes relevant tests.


## Author
Abdullah Mostafa

GitHub: Abdullahmostafah
