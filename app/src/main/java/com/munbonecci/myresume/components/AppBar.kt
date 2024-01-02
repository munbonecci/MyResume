package com.munbonecci.myresume.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.munbonecci.myresume.R

/**
 * A customizable [TopAppBar] for the application.
 *
 * @param modifier Modifier for styling or positioning the [TopAppBar].
 * @param currentScreen The title to be displayed on the app bar.
 * @param showBackButton Flag indicating whether the back navigation button should be shown.
 * @param onBackButtonClick Callback for the back navigation button click event.
 */
@Composable
fun CustomTopAppBar(
    modifier: Modifier = Modifier,
    currentScreen: String = "",
    showBackButton: Boolean = true,
    onBackButtonClick: () -> Unit
) {
    TopAppBar(
        title = { Text(currentScreen) },
        modifier = modifier,
        navigationIcon = {
            if (showBackButton) {
                // Show back navigation button if allowed
                IconButton(onClick = onBackButtonClick) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        tint = Color.White,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

/**
 * A preview function for [CustomTopAppBar].
 */
@Preview
@Composable
fun PreviewCustomTopAppBar() {
    // Example usage with navigation controller
    val navController: NavHostController = rememberNavController()
    CustomTopAppBar(onBackButtonClick = { navController.navigateUp() })
}
