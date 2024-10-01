package com.shu.home.domain


import com.shu.models.ManyScreens

interface HomeRepository {

    suspend fun getAllNewScreen(): ManyScreens


}