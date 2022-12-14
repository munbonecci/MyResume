package com.munbonecci.myresume.core.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.munbonecci.myresume.presentation.CategoryDetailScreen
import com.munbonecci.myresume.presentation.HomeScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            BackHandler(true) {}
            HomeScreen(onCategoryButtonClicked = {
                navController.navigate(NavigationItem.CategoryDetail.route)
            })
        }
        composable(NavigationItem.CategoryDetail.route) {
            CategoryDetailScreen(onBackButtonClicked = {
                navController.navigate(NavigationItem.Home.route)
            })
        }
    }
}