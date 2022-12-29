package com.munbonecci.myresume.domain

import android.content.Context
import com.munbonecci.myresume.R
import com.munbonecci.myresume.data.model.*

class DataGenerator(currentContext: Context) {

    val contactInfoDataList = listOf(
        ContactInfoData(
            label = currentContext.getString(R.string.contact_email_label),
            info = currentContext.getString(R.string.contact_email),
            icon = R.drawable.ic_baseline_email_24,
            iconContentDescription = currentContext.getString(R.string.email_icon_content_description),
            type = EMAIL_TYPE
        ),
        ContactInfoData(
            label = currentContext.getString(R.string.contact_phone_label),
            info = currentContext.getString(R.string.contact_phone),
            icon = R.drawable.ic_baseline_local_phone_24,
            iconContentDescription = currentContext.getString(R.string.phone_icon_content_description),
            type = PHONE_TYPE
        ),
        ContactInfoData(
            label = currentContext.getString(R.string.contact_linkedin_profile_label),
            info = currentContext.getString(R.string.contact_linked_in),
            icon = R.drawable.ic_baseline_link_24,
            iconContentDescription = currentContext.getString(R.string.link_icon_content_description),
            type = WEB_VIEW_TYPE
        ),
        ContactInfoData(
            label = currentContext.getString(R.string.contact_github_label),
            info = currentContext.getString(R.string.contact_github),
            icon = R.drawable.ic_baseline_link_24,
            iconContentDescription = currentContext.getString(R.string.link_icon_content_description),
            type = WEB_VIEW_TYPE
        ),
    )

    val categoryInfoDataList = listOf(
        CategoryData(
            label = currentContext.getString(R.string.category_contact_info_label),
            icon = R.drawable.ic_baseline_account_box_24,
            iconContentDescription = currentContext.getString(R.string.category_contact_info_content_description),
            type = CATEGORY_CONTACT_INFO
        ),
        CategoryData(
            label = currentContext.getString(R.string.category_experience_label),
            icon = R.drawable.ic_baseline_work_24,
            iconContentDescription = currentContext.getString(R.string.category_experience_content_description),
            type = CATEGORY_EXPERIENCE
        ),
        CategoryData(
            label = currentContext.getString(R.string.category_education_label),
            icon = R.drawable.ic_baseline_school_24,
            iconContentDescription = currentContext.getString(R.string.category_education_content_description),
            type = CATEGORY_EDUCATION
        ),
        CategoryData(
            label = currentContext.getString(R.string.category_skills_label),
            icon = R.drawable.ic_baseline_psychology_24,
            iconContentDescription = currentContext.getString(R.string.category_skills_content_description),
            type = CATEGORY_SKILLS
        ),
        CategoryData(
            label = currentContext.getString(R.string.category_technology_stack_label),
            icon = R.drawable.ic_baseline_memory_24,
            iconContentDescription = currentContext.getString(R.string.category_technology_stack_description),
            type = CATEGORY_TECH_STACK
        ),
        CategoryData(
            label = currentContext.getString(R.string.category_languages_label),
            icon = R.drawable.ic_baseline_language_24,
            iconContentDescription = currentContext.getString(R.string.category_languages_content_description),
            type = CATEGORY_LANGUAGES
        )
    )

    val experienceInfoDataList = listOf(
        ExperienceData(
            companyName = currentContext.getString(R.string.coppel_label),
            companyRole = currentContext.getString(R.string.company_role_sr_android),
            employmentType = currentContext.getString(R.string.employment_type_full),
            location = currentContext.getString(R.string.location_guadalajara),
            description = COPPEL_DESC,
            startDate = "Jun 2019",
            endDate = "Present",
            industry = INDUSTRY_RETAIL,
            companyURL = currentContext.getString(R.string.coppel_url),
            icon = R.drawable.coppel_icon,
            iconContentDescription = currentContext.getString(R.string.coppel_icon),
            type = 0
        ),
        ExperienceData(
            companyName = currentContext.getString(R.string.pegasus_label),
            companyRole = currentContext.getString(R.string.company_role_sr_android),
            employmentType = currentContext.getString(R.string.employment_type_full),
            location = currentContext.getString(R.string.location_zapopan),
            description = PEGASUS_DESC,
            startDate = "Feb 2018",
            endDate = "Jun 2019",
            industry = INDUSTRY_TECH,
            companyURL = currentContext.getString(R.string.pegasus_url),
            icon = R.drawable.pegasus_icon,
            iconContentDescription = currentContext.getString(R.string.pegasus_icon),
            type = 0
        ),
        ExperienceData(
            companyName = currentContext.getString(R.string.terra_mapping_label),
            companyRole = currentContext.getString(R.string.company_role_web),
            employmentType = currentContext.getString(R.string.employment_type_full),
            location = currentContext.getString(R.string.location_zapopan),
            description = "Maintenance and refactoring of the platform code using javascript and php.",
            startDate = "Nov 2017",
            endDate = "Feb 2018",
            industry = INDUSTRY_TECH,
            companyURL = currentContext.getString(R.string.terra_url),
            icon = R.drawable.terra_icon,
            iconContentDescription = currentContext.getString(R.string.terra_mapping_icon),
            type = 0
        ),
        ExperienceData(
            companyName = currentContext.getString(R.string.baricare_label),
            companyRole = currentContext.getString(R.string.company_role_android),
            employmentType = currentContext.getString(R.string.employment_type_full),
            location = currentContext.getString(R.string.location_zapopan),
            description = "UX/UI and Development of Android app coding in Java. Espresso and JUnit for test cases.",
            startDate = "Sep 2016",
            endDate = "Jul 2017",
            industry = INDUSTRY_TECH,
            companyURL = "",
            icon = R.drawable.baricare_icon,
            iconContentDescription = currentContext.getString(R.string.baricare_icon),
            type = 0
        )
    )

    val educationInfoDataList = listOf(
        EducationData(
            school = currentContext.getString(R.string.school_name),
            degree = currentContext.getString(R.string.school_degree),
            grade = currentContext.getString(R.string.school_grade),
            fieldOfStudy = currentContext.getString(R.string.school_field),
            location = currentContext.getString(R.string.location_zapopan),
            description = SCHOOL_DESC,
            startDate = currentContext.getString(R.string.school_start_date),
            endDate = currentContext.getString(R.string.school_end_date),
            schoolURL = currentContext.getString(R.string.school_url),
            icon = R.drawable.temmzapopan_icon,
            iconContentDescription = currentContext.getString(R.string.school_name_icon)
        )
    )

    val courseInfoDataList = listOf(
        EducationData(
            school = currentContext.getString(R.string.wizeline_academy_school),
            degree = currentContext.getString(R.string.animation_degree),
            grade = "",
            fieldOfStudy = currentContext.getString(R.string.android_course),
            location = currentContext.getString(R.string.location_zapopan),
            description = currentContext.getString(R.string.animation_course_description),
            startDate = currentContext.getString(R.string.may_2022),
            endDate = currentContext.getString(R.string.may_2022),
            schoolURL = currentContext.getString(R.string.wizeline_academy_url),
            icon = R.drawable.wizeline_academy_icon,
            iconContentDescription = currentContext.getString(R.string.wizeline_academy_icon)
        ),
        EducationData(
            school = currentContext.getString(R.string.wizeline_academy_school),
            degree = currentContext.getString(R.string.jetpack_degree),
            grade = "",
            fieldOfStudy = currentContext.getString(R.string.android_course),
            location = currentContext.getString(R.string.location_zapopan),
            description = currentContext.getString(R.string.jetpack_course_description),
            startDate = currentContext.getString(R.string.apr_2022),
            endDate = currentContext.getString(R.string.apr_2022),
            schoolURL = currentContext.getString(R.string.wizeline_academy_url),
            icon = R.drawable.wizeline_academy_icon,
            iconContentDescription = currentContext.getString(R.string.wizeline_academy_icon)
        )
    )

    val skillInfoDataList = listOf(
        SkillData(name = ANDROID_DEVELOPMENT_SKILL, percentage = 90),
        SkillData(name = KOTLIN_SKILL, percentage = 90),
        SkillData(name = JAVA_SKILL, percentage = 90),
        SkillData(name = ANDROID_COMPOSE_SKILL, percentage = 60),
        SkillData(name = MVVM_SKILL, percentage = 80),
        SkillData(name = CLEAN_ARCH_SKILL, percentage = 80),
        SkillData(name = JUNIT_SKILL, percentage = 70),
        SkillData(name = GIT_SKILL, percentage = 90),
        SkillData(name = SCRUM_SKILL, percentage = 80),
        SkillData(name = FIREBASE_TOOLS_SKILL, percentage = 90)
    )

    val languageInfoDataList = listOf(
        LanguageData(name = ENGLISH_LANGUAGE, percentage = 80),
        LanguageData(name = SPANISH_LANGUAGE, percentage = 100),
    )

    val projectStackDataList: List<TechStackData>
        get() = listOf(
            TechStackData(AZURE_DEV_OPS_TECH, category = PROJECT_MANAGEMENT_TECH_CATEGORY),
            TechStackData(TRELLO_TECH, category = PROJECT_MANAGEMENT_TECH_CATEGORY),
            TechStackData(JIRA_TECH, category = PROJECT_MANAGEMENT_TECH_CATEGORY),
        )

    val developmentStackDataList: List<TechStackData>
        get() = listOf(
            TechStackData(ANDROID_STUDIO_TECH, category = DEVELOPMENT_TOOLS_TECH_CATEGORY),
            TechStackData(VISUAL_STUDIO_CODE, category = DEVELOPMENT_TOOLS_TECH_CATEGORY),
            TechStackData(INTELLIJ_IDEA_TECH, category = DEVELOPMENT_TOOLS_TECH_CATEGORY),
        )

    val androidToolsStackDataList: List<TechStackData>
        get() = listOf(
            TechStackData(FIREBASE_TOOLS_TECH, category = ANDROID_TOOLS_TECH_CATEGORY),
            TechStackData(RETROFIT_TECH, category = ANDROID_TOOLS_TECH_CATEGORY),
            TechStackData(LOTTIE_TECH, category = ANDROID_TOOLS_TECH_CATEGORY),
            TechStackData(IMAGES_TECH, category = ANDROID_TOOLS_TECH_CATEGORY),
            TechStackData(DAGGER_HILT_TECH, category = ANDROID_TOOLS_TECH_CATEGORY),
            TechStackData(COROUTINES_TECH, category = ANDROID_TOOLS_TECH_CATEGORY),
            TechStackData(ONE_SIGNAL_TECH, category = ANALYTICS_TECH_CATEGORY),
            TechStackData(GOOGLE_MAPS_TECH, category = ANALYTICS_TECH_CATEGORY),
            TechStackData(BEACONS_TECH, category = ANALYTICS_TECH_CATEGORY)
        )

    val uiFrameworksStackDataList: List<TechStackData>
        get() = listOf(
            TechStackData(ANDROID_UI_TECH, category = UI_FRAMEWORKS_TECH_CATEGORY),
            TechStackData(JETPACK_COMPOSE_TECH, category = UI_FRAMEWORKS_TECH_CATEGORY),
        )

    val designToolsStackDataList: List<TechStackData>
        get() = listOf(
            TechStackData(FIGMA_TECH, category = DESIGN_TOOLS_TECH_CATEGORY),
            TechStackData(ZEPLIN_TECH, category = DESIGN_TOOLS_TECH_CATEGORY),
            TechStackData(GOOGLE_GALLERY_TECH, category = DESIGN_TOOLS_TECH_CATEGORY)
        )

    val databaseStackDataList: List<TechStackData>
        get() = listOf(
            TechStackData(DATABASE_TECH, category = DATABASE_TECH_CATEGORY),
            TechStackData(SQL_TECH, category = DESIGN_TOOLS_TECH_CATEGORY)
        )

    val versionControlStackDataList: List<TechStackData>
        get() = listOf(
            TechStackData(GITHUB_TECH, category = VERSION_CONTROL_SYSTEM_TECH_CATEGORY),
            TechStackData(GITLAB_TECH, category = VERSION_CONTROL_SYSTEM_TECH_CATEGORY),
            TechStackData(AZURE_REPO_TECH, category = VERSION_CONTROL_SYSTEM_TECH_CATEGORY)
        )

    val releaseStackDataList: List<TechStackData>
        get() = listOf(
            TechStackData(PLAY_STORE_TECH, category = RELEASE_MANAGEMENT_TECH_CATEGORY),
            TechStackData(HUAWEI_GALLERY_TECH, category = RELEASE_MANAGEMENT_TECH_CATEGORY)
        )

    val analyticsStackDataList: List<TechStackData>
        get() = listOf(
            TechStackData(FIREBASE_ANALYTICS_TECH, category = ANALYTICS_TECH_CATEGORY),
            TechStackData(SAS_TECH, category = ANALYTICS_TECH_CATEGORY),
            TechStackData(MEDAL_LIA_TECH, category = ANALYTICS_TECH_CATEGORY)
        )

    val othersStackDataList: List<TechStackData>
        get() = listOf(
            TechStackData(SLACK_TECH, category = OTHER_TOOLS_TECH_CATEGORY),
            TechStackData(PROXY_MAN_TECH, category = OTHER_TOOLS_TECH_CATEGORY)
        )

    companion object {
        const val EMAIL_TYPE = 1
        const val PHONE_TYPE = 2
        const val WEB_VIEW_TYPE = 3

        const val CATEGORY_CONTACT_INFO = 1
        const val CATEGORY_EXPERIENCE = 2
        const val CATEGORY_EDUCATION = 3
        const val CATEGORY_SKILLS = 4
        const val CATEGORY_TECH_STACK = 5
        const val CATEGORY_LANGUAGES = 6


        const val ABOUT_INFO =
            "Experienced Android Developer with a demonstrated history of working in e-commerce," +
                    "electrical and electronic manufacturing industry. Skilled in kotlin, Java, Firebase (Analytics, Realtime database, Crashlytics, Remote config)," +
                    "Retrofit, Coroutines, Git, MVVM, MVP, Clean Arch. and Software Development. Strong engineering professional with a Engineer's degree focused" +
                    "in Computer Systems Engineering from Instituto Tecnológico Superior de Zapopan."

        const val COPPEL_DESC =
            "Development of new features with the MVVM design pattern, Clean arch, " +
                    "coding in Kotlin and using Coroutines, Retrofit, Room database with cipher, firebase tools " +
                    "(Analytics, Crashlytics, Realtime DB, Remote config for A/B testing), and external libraries. " +
                    "Bug fixing and deployment of the application in Google Play store and Huawei gallery."

        const val PEGASUS_DESC =
            "Development of new features with MVP and MVC using Java and Kotlin, " +
                    "external libraries, connection of beacons and Bluetooth devices, use of google maps, " +
                    "bug fixes, and deployment in the Google Play Store."

        const val SCHOOL_DESC =
            "Ability to design, implement and manage computational infrastructure " +
                    "to provide innovative solutions for the benefit of society, in a global, " +
                    "multidisciplinary and sustainable context. Also focused on software development."
    }
}