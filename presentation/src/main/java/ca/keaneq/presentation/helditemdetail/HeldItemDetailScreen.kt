package ca.keaneq.presentation.helditemdetail

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ca.keaneq.presentation.R
import ca.keaneq.presentation.helditemdetail.model.HeldItemDetailEvent
import ca.keaneq.presentation.helditemdetail.model.HeldItemDetailEvent.ClickStat
import ca.keaneq.presentation.helditemdetail.model.HeldItemDetailEvent.ClickUpgrade
import ca.keaneq.presentation.helditemdetail.model.HeldItemStatDetailState
import ca.keaneq.presentation.helditemdetail.model.HeldItemState
import ca.keaneq.presentation.helditemdetail.viewmodel.HeldItemDetailViewModel
import ca.keaneq.presentation.main.heldItems
import coil.compose.rememberImagePainter

@Composable
fun HeldItemDetailScreen(
    viewModel: HeldItemDetailViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    when {
        state.isLoading -> HeldItemLoadingContent()
        state.error.isNotEmpty() -> HeldItemErrorContent(state.error)
        state.heldItem != null -> HeldItemSuccessContent(state.heldItem) { event ->
            viewModel.onEvent(event)
        }
        else -> HeldItemErrorContent("Unknown error")
    }
}

@Composable
private fun HeldItemSuccessContent(
    heldItem: HeldItemState,
    onEvent: (HeldItemDetailEvent) -> Unit,
) {
    val scrollState = rememberScrollState()

    Card(
        shape = RoundedCornerShape(20.dp),
        backgroundColor = MaterialTheme.colors.surface,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .verticalScroll(scrollState)
            .padding(10.dp)
    ) {
        Box {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Box(
                    contentAlignment = Alignment.BottomStart,
                    modifier = Modifier
                        .height(100.dp)
                        .background(MaterialTheme.colors.heldItems)
                        .fillMaxWidth()
                ) {
                    Text(
                        style = MaterialTheme.typography.h1,
                        text = heldItem.name,
                        color = MaterialTheme.colors.onPrimary,
                        modifier = Modifier
                            .padding(
                                start = 120.dp,
                                bottom = 10.dp
                            )
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(top = 30.dp)
                        .fillMaxWidth()
                ) {
                    heldItem.upgrades.forEach { upgrade ->
                        HeldItemUpgradeImage(
                            image = upgrade.image,
                            isClicked = upgrade.isClicked,
                        ) {
                            onEvent(ClickUpgrade(upgrade))
                        }
                    }
                }
                Text(
                    text = heldItem.upgrades.first { it.isClicked }.description,
                    modifier = Modifier.padding(
                        start = 20.dp,
                        end = 20.dp,
                        bottom = 20.dp
                    )
                )
                heldItem.stats.forEach { stat ->
                    HeldItemStat(
                        name = stat.name,
                        isClicked = stat.isClicked,
                        details = stat.details,
                    ) {
                        onEvent(ClickStat(stat))
                    }
                }
            }
            HeldItemImage(heldItem.image)
        }
    }
}

@Composable
private fun HeldItemUpgradeImage(
    image: String,
    isClicked: Boolean,
    onEvent: () -> Unit,
) {
    Image(
        painter = rememberImagePainter(image),
        contentDescription = null,
        modifier = Modifier
            .padding(20.dp)
            .width(80.dp)
            .height(80.dp)
            .clip(RoundedCornerShape(40.dp))
            .run {
                takeUnless { isClicked } ?: border(
                    width = 10.dp,
                    color = MaterialTheme.colors.heldItems,
                    shape = RoundedCornerShape(40.dp)
                )
            }
            .clickable { onEvent() }
    )
}

@Composable
private fun HeldItemStat(
    name: String,
    isClicked: Boolean,
    details: List<HeldItemStatDetailState>,
    onEvent: () -> Unit,
) {
    Card(
        shape = RoundedCornerShape(10.dp),
        backgroundColor = MaterialTheme.colors.heldItems,
        modifier = Modifier
            .padding(
                horizontal = 20.dp,
                vertical = 10.dp
            )
            .fillMaxWidth()
            .animateContentSize()
            .clickable { onEvent() }
    ) {
        Column {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.h2,
                    color = MaterialTheme.colors.onPrimary,
                    modifier = Modifier.padding(20.dp)
                )
                if (!isClicked) {
                    Text(
                        text = stringResource(
                            R.string.held_item_stat_description_summary,
                            details.first().description,
                            details.last().description
                        ),
                        color = MaterialTheme.colors.onPrimary,
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.padding(20.dp)
                    )
                }
            }
            if (isClicked) {
                Column(
                    modifier = Modifier.padding(bottom = 20.dp)
                ) {
                    details.forEachIndexed { i, detail ->
                        HeldItemStatDetail(
                            isFirstRow = i == 0,
                            level = detail.level,
                            description = detail.description,
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun HeldItemStatDetail(
    isFirstRow: Boolean,
    level: String,
    description: String,
) {
    if (!isFirstRow) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(5f)
            )
            Box(
                modifier = Modifier
                    .height(1.dp)
                    .background(MaterialTheme.colors.onPrimary)
                    .weight(90f)
            )
            Box(
                modifier = Modifier
                    .weight(5f)
            )
        }
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 20.dp,
                vertical = 4.dp
            )
    ) {
        Text(
            textAlign = TextAlign.Center,
            text = stringResource(R.string.held_item_stat_level, level),
            color = MaterialTheme.colors.onPrimary,
            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .weight(1f)
        )
        Text(
            textAlign = TextAlign.Center,
            text = description,
            color = MaterialTheme.colors.onPrimary,
            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .weight(1f)
        )
    }
}

@Composable
private fun HeldItemImage(
    image: String,
) {
    Image(
        painter = rememberImagePainter(image),
        contentDescription = null,
        modifier = Modifier
            .padding(
                top = 20.dp,
                start = 10.dp
            )
            .border(
                width = 2.dp,
                color = MaterialTheme.colors.heldItems,
                shape = RoundedCornerShape(20.dp)
            )
            .width(100.dp)
            .height(100.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(MaterialTheme.colors.surface)
            .padding(10.dp)
    )
}

@Composable
private fun HeldItemLoadingContent() {
    Text("Loading")
}

@Composable
private fun HeldItemErrorContent(message: String) {
    Text(message)
}