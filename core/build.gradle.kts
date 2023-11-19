plugins {
    id(Plugins.library)
    id(Plugins.android)
}

android {
    namespace = "com.vsv.core"
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk
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

    implementation(Dependencies.Di.koinCore)
    implementation(Dependencies.Di.koinAndroid)

    implementation (Dependencies.Core.material)
    implementation (Dependencies.Core.constraintlayout)
    implementation (Dependencies.Core.lifecycle)
    implementation (Dependencies.Core.viewmodel)
}