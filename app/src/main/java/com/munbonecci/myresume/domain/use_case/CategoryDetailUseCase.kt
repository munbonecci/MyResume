package com.munbonecci.myresume.domain.use_case

import android.content.Context
import com.munbonecci.myresume.commons.Resource
import com.munbonecci.myresume.domain.DataGenerator
import com.munbonecci.myresume.domain.model.CategoryDetailData
import com.munbonecci.myresume.domain.model.CategoryEducationData
import com.munbonecci.myresume.domain.model.CategoryTechData
import com.munbonecci.myresume.domain.use_case.CategoryDetailConstants.ERROR_CODE_SERVICE
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CategoryDetailUseCase @Inject constructor(private val context: Context) {
    operator fun invoke(categoryId: Int): Flow<Resource<CategoryDetailData>> = flow {
        emit(Resource.Loading())

        when (categoryId) {
            DataGenerator.CATEGORY_CONTACT_INFO -> {
                emit(Resource.Success(CategoryDetailData(contacts = DataGenerator(context).contactInfoDataList)))
            }
            DataGenerator.CATEGORY_EXPERIENCE -> {
                emit(
                    Resource.Success(
                        CategoryDetailData(
                            experiences = DataGenerator(context).experienceInfoDataList
                        )
                    )
                )
            }
            DataGenerator.CATEGORY_EDUCATION -> {
                emit(
                    Resource.Success(
                        CategoryDetailData(
                            educationData = CategoryEducationData(
                                educationList = DataGenerator(context).educationInfoDataList,
                                courseList = DataGenerator(context).courseInfoDataList
                            )
                        )
                    )
                )
            }
            DataGenerator.CATEGORY_SKILLS -> {
                emit(Resource.Success(CategoryDetailData(skills = DataGenerator(context).skillInfoDataList)))
            }
            DataGenerator.CATEGORY_TECH_STACK -> {
                emit(
                    Resource.Success(
                        CategoryDetailData(
                            techData = CategoryTechData(
                                projects = DataGenerator(context).projectStackDataList,
                                developmentStacks = DataGenerator(context).developmentStackDataList,
                                androidTools = DataGenerator(context).androidToolsStackDataList,
                                uiFrameworks = DataGenerator(context).uiFrameworksStackDataList,
                                designTools = DataGenerator(context).designToolsStackDataList,
                                databases = DataGenerator(context).databaseStackDataList,
                                versionControlStacks = DataGenerator(context).versionControlStackDataList,
                                releases = DataGenerator(context).releaseStackDataList,
                                analytics = DataGenerator(context).analyticsStackDataList,
                                others = DataGenerator(context).othersStackDataList
                            )
                        )
                    )
                )
            }
            DataGenerator.CATEGORY_LANGUAGES -> {
                emit(Resource.Success(CategoryDetailData(languages = DataGenerator(context).languageInfoDataList)))
            }
        }
    }.catch {
        emit(Resource.Error(ERROR_CODE_SERVICE))
    }
}

object CategoryDetailConstants {
    const val ERROR_CODE_SERVICE = "-9"
}