plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.ktlint.android)
    id("kotlin-kapt")
}

android {
    namespace = "com.benidict.network"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        buildConfig = true
    }

    flavorDimensions += "env"
    productFlavors {
        create("dev") {
            dimension = "env"
            buildConfigField("String", "API_KEY", "\"UDou9LDrx3uBbl8AGhudVw==l9cw1WCv2G4K6ChN\"")
            buildConfigField("String", "BASE_URL", "\"https://api.api-ninjas.com/v1/\"")
        }
        create("prod") {
            dimension = "env"
            buildConfigField("String", "API_KEY", "\"UDou9LDrx3uBbl8AGhudVw==l9cw1WCv2G4K6ChN\"")
            buildConfigField("String", "BASE_URL", "\"https://api.api-ninjas.com/v1/\"")
        }
    }
}

dependencies {
    implementation(project(":domain"))

    kapt(libs.dagger.hilt.compiler)
    implementation(libs.okhttp)
    implementation(libs.interceptor)
    implementation(libs.gson)
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.dagger.hilt.android)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
