package ca.keaneq.presentation.helditemdetail

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import ca.keaneq.presentation.helditemdetail.component.HeldItemDetailComponent
import ca.keaneq.presentation.helditemdetail.viewmodel.HeldItemDetailViewModel

@Composable
fun HeldItemDetailScreen(
    viewModel: HeldItemDetailViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    when {
        state.isLoading -> HeldItemLoadingContent()
        state.error.isNotEmpty() -> HeldItemErrorContent(state.error)
        state.pageItems.isNotEmpty() -> HeldItemSuccessContent(state.pageItems)
        else -> HeldItemErrorContent("Unknown error")
    }
}

@Composable
fun HeldItemSuccessContent(listItems: List<HeldItemDetailComponent>) {
    LazyColumn {
        items(listItems) { item -> item.Draw() }
    }
}

@Composable
fun HeldItemLoadingContent() {
    Text("Loading")
}

@Composable
fun HeldItemErrorContent(message: String) {
    Text(message)
}