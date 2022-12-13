package com.munbonecci.myresume.domain

import android.content.Context
import com.munbonecci.myresume.R
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

    companion object {
        const val EMAIL_TYPE = 1
        const val PHONE_TYPE = 2
        const val WEB_VIEW_TYPE = 3
    }
}