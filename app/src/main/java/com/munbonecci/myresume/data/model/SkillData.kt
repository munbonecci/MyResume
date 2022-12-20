package com.munbonecci.myresume.data.model

data class SkillData(
    val name: String,
    val percentage: Int
) {
    override fun toString(): String = name
}

const val KOTLIN_SKILL = "Kotlin"
const val JAVA_SKILL = "Java"
const val JUNIT_SKILL = "Junit"
const val ANDROID_COMPOSE_SKILL = "Jetpack Compose"
const val GIT_SKILL = "Git"
const val SCRUM_SKILL = "SCRUM"
const val FIREBASE_TOOLS_SKILL = "Firebase tools"
const val ANDROID_DEVELOPMENT_SKILL = "Android Development"
const val MVVM_SKILL = "MVVM"
const val CLEAN_ARCH_SKILL = "Clean arch"