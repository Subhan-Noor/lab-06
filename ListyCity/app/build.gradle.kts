plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "ca.ualberta.snoor1.listycity"
    compileSdk = 36

    defaultConfig {
        applicationId = "ca.ualberta.snoor1.listycity"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

// Add Javadoc task for Android project
tasks.register<Javadoc>("javadoc") {
    source = android.sourceSets["main"].java.getSourceFiles()
    classpath = configurations["debugCompileClasspath"]
    destinationDir = file("$buildDir/docs/javadoc")
    options {
        this as StandardJavadocDocletOptions
        addBooleanOption("html5", true)
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}