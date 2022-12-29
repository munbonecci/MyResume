package com.munbonecci.myresume.data.model

data class TechStackData(
    val name: String = "",
    val description: String = "",
    val category: Int = 0
) {
    override fun toString(): String = name
}

const val PROJECT_MANAGEMENT_TECH_CATEGORY = 1
const val DEVELOPMENT_TOOLS_TECH_CATEGORY = 2
const val ANDROID_TOOLS_TECH_CATEGORY = 3
const val UI_FRAMEWORKS_TECH_CATEGORY = 4
const val DESIGN_TOOLS_TECH_CATEGORY = 5
const val DATABASE_TECH_CATEGORY = 6
const val VERSION_CONTROL_SYSTEM_TECH_CATEGORY = 7
const val RELEASE_MANAGEMENT_TECH_CATEGORY = 8
const val ANALYTICS_TECH_CATEGORY = 9
const val OTHER_TOOLS_TECH_CATEGORY = 10

const val ANDROID_STUDIO_TECH = "Android Studio"
const val AZURE_DEV_OPS_TECH = "Azure DevOps"
const val JIRA_TECH = "Jira"
const val TRELLO_TECH = "Trello"
const val RETROFIT_TECH = "Retrofit2, OkHttp3, GSON"
const val FIREBASE_TOOLS_TECH =
    "Firebase Tools (Crashlytics, Realtime database, Remote Config, A/B Testing)"
const val LOTTIE_TECH = "Lottie"
const val IMAGES_TECH = "Coil, Glide, Picasso"
const val DAGGER_HILT_TECH = "Dagger Hilt"
const val COROUTINES_TECH = "Android Coroutines"
const val ANDROID_UI_TECH = "Android UI"
const val JETPACK_COMPOSE_TECH = "Jetpack Compose"
const val DATABASE_TECH = "Room and Cypher from DB encryption"
const val SQL_TECH = "SQLLite"
const val SLACK_TECH = "Slack"
const val PROXY_MAN_TECH = "Proxyman"
const val GITLAB_TECH = "GitLab"
const val GITHUB_TECH = "Github"
const val AZURE_REPO_TECH = "Azure repo"
const val PLAY_STORE_TECH = "Play Store"
const val HUAWEI_GALLERY_TECH = "Huawei Gallery"
const val FIREBASE_ANALYTICS_TECH = "Firebase Analytics"
const val ONE_SIGNAL_TECH = "One signal push notifications"
const val SAS_TECH = "SAS analytics, intelligent banners and carousels"
const val MEDAL_LIA_TECH = "Medallia"
const val FIGMA_TECH = "FIGMA"
const val ZEPLIN_TECH = "Zeplin"
const val GOOGLE_GALLERY_TECH = "Google Gallery"
const val VISUAL_STUDIO_CODE = "Visual studio code"
const val INTELLIJ_IDEA_TECH = "Intellij Idea CE"
const val GOOGLE_MAPS_TECH = "Google maps, Geofencing"
const val BEACONS_TECH = "Beacons"