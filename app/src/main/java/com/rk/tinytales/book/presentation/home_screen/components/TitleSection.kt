package com.rk.tinytales.book.presentation.home_screen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.rk.tinytales.ui.theme.TinyTalesTheme
import com.rk.tinytales.ui.theme.size
import com.rk.tinytales.ui.theme.subtitle

@Composable
fun TitleSection(
    modifier: Modifier = Modifier,
    title: String
) {

    val textColor = MaterialTheme.colorScheme.onSurfaceVariant

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.width(MaterialTheme.size.dp200),
            text = title,
            style = MaterialTheme.subtitle.small.copy(
                color = textColor,
            ),
            textAlign = TextAlign.Center
        )
    }
}

@PreviewLightDark
@Composable
private fun HomeScreenPreview() {
    TinyTalesTheme {

        TitleSection(
            modifier = Modifier.fillMaxWidth(),
            title = ""
        )
    }
}