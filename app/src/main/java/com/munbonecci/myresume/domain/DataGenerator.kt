package com.munbonecci.myresume.domain

import android.content.Context
import com.munbonecci.myresume.R
import com.munbonecci.myresume.data.model.CategoryData
import com.munbonecci.myresume.data.model.ContactInfoData

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
            label = currentContext.getString(R.string.category_languages_label),
            icon = R.drawable.ic_baseline_language_24,
            iconContentDescription = currentContext.getString(R.string.category_languages_content_description),
            type = CATEGORY_LANGUAGES
        )
    )

    companion object {
        const val EMAIL_TYPE = 1
        const val PHONE_TYPE = 2
        const val WEB_VIEW_TYPE = 3

        const val CATEGORY_CONTACT_INFO = 1
        const val CATEGORY_EXPERIENCE = 2
        const val CATEGORY_EDUCATION = 3
        const val CATEGORY_SKILLS = 4
        const val CATEGORY_LANGUAGES = 5

        const val ABOUT_INFO =
            "Experienced Android Developer with a demonstrated history of working in e-commerce," +
                    "electrical and electronic manufacturing industry. Skilled in kotlin, Java, Firebase (Analytics, Realtime database, Crashlytics, Remote config)," +
                    "Retrofit, Coroutines, Git, MVVM, MVP, Clean Arch. and Software Development. Strong engineering professional with a Engineer's degree focused" +
                    "in Computer Systems Engineering from Instituto Tecnológico Superior de Zapopan."
    }
}