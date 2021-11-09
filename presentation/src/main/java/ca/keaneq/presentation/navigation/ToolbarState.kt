package ca.keaneq.presentation.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.graphics.vector.ImageVector
import ca.keaneq.presentation.R

enum class ToolbarState(
    val icon: ImageVector,
    @StringRes val contentDescription: Int,
) {
    Menu(
        icon = Icons.Filled.Menu,
        contentDescription = R.string.descriptor_menu_button,
    ),
    Up(
        icon = Icons.Filled.ArrowBack,
        contentDescription = R.string.descriptor_up_button,
    ),
    Close(
        icon = Icons.Filled.Close,
        contentDescription = R.string.descriptor_close_button,
    ),
}