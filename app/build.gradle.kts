plugins {
    id(Plugins.application)
    id(Plugins.android)
    id(Plugins.saveArgs)
}

android {
    namespace = "com.vsv.hoteltestapp"
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = "com.vsv.hoteltestapp"
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

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
        targetCompatibility = Config.javaVersion
        sourceCompatibility = Config.javaVersion
    }
    kotlinOptions {
        jvmTarget = Config.jmvTarget
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(project(":feature_hotel"))
    implementation(project(":feature_rooms"))
    implementation(project(":feature_booking"))
    implementation(project(":remote_api"))
    implementation(project(":core"))

    implementation(Dependencies.Navigation.fragment)
    implementation(Dependencies.Navigation.ui)

    implementation(Dependencies.Di.koinCore)
    implementation(Dependencies.Di.koinAndroid)

    implementation(Dependencies.Core.coreKtx)
    implementation(Dependencies.Core.appcompat)
    implementation(Dependencies.Core.material)
    implementation(Dependencies.Core.constraintlayout)
    implementation(Dependencies.Core.lifecycle)
    implementation(Dependencies.Core.viewmodel)


//    implementation(platform(Dependencies.Network.okHttpBom))
//    implementation(Dependencies.Network.okHttp)
//    implementation(Dependencies.Network.okHttpLogging)
//    implementation(Dependencies.Network.retofit)
//    implementation(Dependencies.Network.retofitConverter)
//
//    implementation(Dependencies.Moshi.moshi)
//    ksp(Dependencies.Moshi.ksp)

}