// Top-level build file where you can add configuration options common to all sub-projects/modules.
ext {
    set("kotlin_version", "1.9.23")
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.google.dagger.hilt.android) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.google.gms.google.services) apply false
    alias(libs.plugins.firebase.crashlytics) apply false
    alias(libs.plugins.serialization) apply false
}

task("clean", type = Delete::class) {
    delete(rootProject.buildDir)
}