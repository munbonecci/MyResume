package com.munbonecci.myresume.core.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(var route: String, var icon: ImageVector, var title: String) {
    object Home : NavigationItem(HOME_ROUTE, Icons.Default.Home, "Home")
    object CategoryDetail :
        NavigationItem(
            "$CATEGORY_DETAIL_ROUTE/{categoryId}/{categoryName}",
            Icons.Default.Menu,
            "Category"
        )

    companion object {
        const val HOME_ROUTE = "home"
        const val CATEGORY_DETAIL_ROUTE = "category_detail"
    }
}