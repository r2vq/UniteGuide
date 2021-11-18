package ca.keaneq.presentation.helditemlist

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import ca.keaneq.presentation.helditemlist.component.HeldListItem
import ca.keaneq.presentation.helditemlist.viewmodel.HeldItemListViewModel

@Composable
fun HeldItemListScreen(
    viewModel: HeldItemListViewModel = hiltViewModel(),
    onNavigate: (route: String) -> Unit = {},
) {
    val state = viewModel.state.value
    LazyColumn(
        Modifier
            .fillMaxSize()
    ) {
        itemsIndexed(
            items = state.heldItems,
            key = { _, heldItem ->
                heldItem.name
            }
        ) { _, heldItem ->
            HeldListItem(heldItem) {
                // todo navigate
            }
        }
    }
}