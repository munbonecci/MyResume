package com.munbonecci.myresume.domain.use_case

import android.content.Context
import com.munbonecci.myresume.commons.Resource
import com.munbonecci.myresume.domain.DataGenerator
import com.munbonecci.myresume.domain.model.ProfileData
import com.munbonecci.myresume.domain.use_case.ProfileConstants.ERROR_CODE_SERVICE
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class ProfileUseCase @Inject constructor(private val context: Context) {
    operator fun invoke(): Flow<Resource<ProfileData>> = flow {
        emit(Resource.Loading())
        emit(Resource.Success(DataGenerator(context).profileData))
    }.catch {
        emit(Resource.Error(ERROR_CODE_SERVICE))
    }
}

object ProfileConstants {
    const val ERROR_CODE_SERVICE = "-9"
}