package com.munbonecci.myresume.domain.model

import com.munbonecci.myresume.data.model.*

data class CategoryDetailData(
    val contacts: List<ContactInfoData> = listOf(),
    val experiences: List<ExperienceData> = listOf(),
    val educationData: CategoryEducationData = CategoryEducationData(),
    val skills: List<SkillData> = listOf(),
    val techData: CategoryTechData = CategoryTechData(),
    val languages: List<LanguageData> = listOf()
)

data class CategoryEducationData(
    val educationList: List<EducationData> = listOf(),
    val courseList: List<EducationData> = listOf()
)

data class CategoryTechData(
    val projects: List<TechStackData> = listOf(),
    val developmentStacks: List<TechStackData> = listOf(),
    val androidTools: List<TechStackData> = listOf(),
    val uiFrameworks: List<TechStackData> = listOf(),
    val designTools: List<TechStackData> = listOf(),
    val databases: List<TechStackData> = listOf(),
    val versionControlStacks: List<TechStackData> = listOf(),
    val releases: List<TechStackData> = listOf(),
    val analytics: List<TechStackData> = listOf(),
    val others: List<TechStackData> = listOf(),
)