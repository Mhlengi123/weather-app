🌤️ Weather Buddy - Android Weather Application
A modern Android weather app built with Kotlin featuring secure authentication, real-time weather data, and modern Android architecture patterns.

🚀 Features
🔐 Secure User Authentication - Registration and login with encrypted password storage

🌤️ Real-time Weather Data - Fetch current weather from OpenWeatherMap API

📱 Modern Architecture - MVVM pattern with Repository pattern

🗄️ Local Data Storage - Room database for user data persistence

🔒 Security - EncryptedSharedPreferences for sensitive data

🧪 Unit Testing - Comprehensive testing for critical components

🎨 User-friendly UI - Clean, intuitive interface with proper error handling

🔄 Auto-refresh - Regular weather updates

📍 Location Services - Get weather for current location (optional)

🛠️ Built With
Kotlin - Primary programming language

Android Jetpack Components:

ViewModel & LiveData

Room Database

Navigation Component

DataBinding

Retrofit2 - REST API communication

Material Design - Modern UI components

EncryptedSharedPreferences - Secure data storage

Google Play Services - Location services

📁 Project Structure
text
app/src/main/java/com/yourname/weatherbuddy/
├── data/
│   ├── model/           # Data classes (User, WeatherData, UserSettings)
│   ├── remote/          # API services (Retrofit, ApiService)
│   ├── repository/      # Data repositories (WeatherRepository, AuthRepository)
│   └── local/           # Database (Room, DAOs)
├── ui/
│   ├── viewmodel/       # ViewModels (AuthViewModel, WeatherViewModel)
│   ├── fragments/       # UI fragments (RegisterFragment, WeatherFragment)
│   └── MainActivity.kt  # Main activity
├── utils/               # Utility classes (EncryptionHelper)
└── WeatherApplication.kt # Application class
🔧 Installation & Setup
Prerequisites
Android Studio Arctic Fox or later

Android SDK API 21+

Kotlin 1.9.10+

Steps to Run
Clone the repository

bash
git clone https://github.com/yourusername/weather-buddy.git
cd weather-buddy
Open in Android Studio

Open Android Studio

Select "Open an existing project"

Navigate to the cloned directory

Get API Key

Sign up at OpenWeatherMap

Get your free API key

Replace YOUR_API_KEY in ApiService.kt

Build and Run

Connect an Android device or start an emulator

Click "Run" in Android Studio (▶️ button)

🎯 Usage
User Registration & Login
Launch the Weather Buddy app

Navigate to the Register screen

Create an account with username, email, and password

Passwords are securely encrypted using SHA-256 hashing

Weather Features
Enter a city name in the search field

View current weather information including:

🌡️ Temperature in Celsius

☁️ Weather description

💧 Humidity percentage

💨 Wind speed

Use the refresh button to update weather data

Switch between different cities

🧪 Testing
The project includes comprehensive unit tests:

bash
# Run all tests
./gradlew test

# Run specific test class
./gradlew test --tests "*.WeatherRepositoryTest"

# Run instrumented tests
./gradlew connectedAndroidTest
📸 Screenshots
(Add screenshots of your app here)

Login/Registration screen

Weather display screen

Settings screen

🎥 Demo Video
https://img.youtube.com/vi/VIDEO_ID/0.jpg

Click the image above to watch the demo video showing all features

🔐 Security Features
🔒 Password encryption using SHA-256 hashing

🗄️ EncryptedSharedPreferences for local data storage

✅ Input validation and error handling

🌐 Secure API communication with HTTPS

🛡️ Safe credential storage

🌐 API Integration
OpenWeatherMap API - Current weather data

RESTful architecture with Retrofit2

Error handling for network failures

JSON parsing with Gson

Logging interceptor for debugging

📊 Architecture
Weather Buddy follows the MVVM (Model-View-ViewModel) architecture:

Model: Data layer (Room, Retrofit, Repositories)

View: UI layer (Fragments, Activities, XML layouts)

ViewModel: Business logic and data presentation

🚀 Future Enhancements
5-day weather forecast

Location-based weather using GPS

Push notifications for weather alerts

Multiple city favorites

Weather maps integration

Social sharing features

Dark mode theme

Weather widgets for home screen

🤝 Contributing
We welcome contributions to make Weather Buddy even better!

Fork the project

Create your feature branch (git checkout -b feature/AmazingFeature)

Commit your changes (git commit -m 'Add some AmazingFeature')

Push to the branch (git push origin feature/AmazingFeature)

Open a Pull Request

📝 License
This project is licensed under the MIT License - see the LICENSE.md file for details.

👨‍💻 Developer
Your Name

GitHub: @yourusername

Email: your.email@example.com

Portfolio: yourportfolio.com

🙏 Acknowledgments
OpenWeatherMap for providing reliable weather data API

Android Jetpack team for excellent architecture components

Google Material Design for beautiful UI components

Kotlin team for the amazing programming language

📞 Support
If you have any questions or issues, please:

Check the Issues page

Create a new issue if your problem isn't already reported

Contact the developer via email
