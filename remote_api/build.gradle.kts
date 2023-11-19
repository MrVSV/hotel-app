plugins {
    id(Plugins.library)
    id(Plugins.android)
    id(Plugins.ksp)
}

android {
    namespace = "com.vsv.remote_api"
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
}

dependencies {

    implementation(Dependencies.Di.koinCore)
    implementation(Dependencies.Di.koinAndroid)

    implementation(platform(Dependencies.Network.okHttpBom))
    implementation(Dependencies.Network.okHttp)
    implementation(Dependencies.Network.okHttpLogging)
    implementation(Dependencies.Network.retofit)
    implementation(Dependencies.Network.retofitConverter)

    implementation(Dependencies.Moshi.moshi)
    ksp(Dependencies.Moshi.ksp)
}