plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.google.gms.google.services) // Apply the Google Services Gradle plugin
}

android {
    namespace = "com.example.quizflicknew"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.quizflicknew"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures{
        viewBinding = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }



    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.firebase.firestore)
    implementation(libs.firebase.auth) // Firebase Auth library
    implementation("com.google.firebase:firebase-auth:23.0.0")
    implementation(libs.firebase.database) // Add Firebase Auth dependency (this line is optional since it's already included above)

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation("com.airbnb.android:lottie:6.1.0")
    // Navigation Component
    implementation("androidx.navigation:navigation-fragment-ktx:2.8.3")
    implementation("androidx.navigation:navigation-ui-ktx:2.8.3")
    implementation("com.airbnb.android:lottie:6.1.0")
    annotationProcessor("androidx.room:room-compiler:2.5.0")
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("com.mikhaellopez:circularprogressbar:3.1.0")
}
