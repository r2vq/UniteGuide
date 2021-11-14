package ca.keaneq.presentation.pokemondetail.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PillsRow(
    roleText: String,
    attackStyleText: String,
    color: Color,
    onColor: Color,
) {
    Row {
        PillFilled(
            text = roleText,
            color = color,
            onColor = onColor,
        )
        Spacer(modifier = Modifier.width(10.dp))
        PillOutlined(
            text = attackStyleText,
            color = onColor,
            onColor = color,
        )
    }
}

@Composable
private fun PillFilled(
    text: String,
    color: Color,
    onColor: Color,
) {
    Pill(
        text = text,
        borderColor = color,
        backgroundColor = color,
        contentColor = onColor,
    )
}

@Composable
private fun PillOutlined(
    text: String,
    color: Color,
    onColor: Color,
) {
    Pill(
        text = text,
        borderColor = onColor,
        backgroundColor = color,
        contentColor = onColor,
    )
}

@Composable
private fun Pill(
    text: String,
    borderColor: Color,
    backgroundColor: Color,
    contentColor: Color,
) {
    Button(
        onClick = {},
        border = BorderStroke(4.dp, borderColor),
        shape = RoundedCornerShape(24.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            contentColor = contentColor,
        ),
        modifier = Modifier.width(125.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.body2,
        )
    }
}

@Preview
@Composable
private fun PreviewPillFilled() {
    PillFilled(
        text = "Attacker",
        color = Color(0xFFF06F2A),
        onColor = Color.White
    )
}

@Preview
@Composable
private fun PreviewPillOutlined() {
    PillOutlined(
        text = "Attacker",
        color = Color.White,
        onColor = Color(0xFFF06F2A),
    )
}