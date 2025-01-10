package com.rk.tinytales.book.presentation.story_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.rk.tinytales.book.presentation.models.StoryUi
import com.rk.tinytales.core.domain.util.stories
import com.rk.tinytales.core.presentation.util.load
import com.rk.tinytales.ui.theme.body
import com.rk.tinytales.ui.theme.shipporiMincho
import com.rk.tinytales.ui.theme.size
import com.rk.tinytales.ui.theme.title

@Composable
fun StoryPage(
    modifier: Modifier = Modifier,
    story: StoryUi
) {

    val scrollState = rememberScrollState()
    val mainStory = story.story

    val spanStory = buildAnnotatedString {
        if (!mainStory.isNullOrEmpty()) {

            withStyle(
                style = SpanStyle(
                    fontSize = 40.sp,
                    fontFamily = shipporiMincho
                )
            ) {
                append(mainStory[0])
            }
            append(mainStory.substring(1))
        }
    }

    Column(
        modifier = modifier
            .verticalScroll(scrollState)
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.surface)
    ) {

        Spacer(modifier = Modifier.height(MaterialTheme.size.dp100))

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = MaterialTheme.size.extraLarge.times(2),
                    end = MaterialTheme.size.extraLarge.times(2),
                ),
            text = story.title ?: "",
            style = MaterialTheme.title.megaLarge.copy(
                color = MaterialTheme.colorScheme.onSurface
            ),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(MaterialTheme.size.extraLarge))

        AsyncImage(
            modifier = Modifier.fillMaxSize()
                .height(MaterialTheme.size.dp200),
            model = load(
                context = LocalContext.current,
                url = story.image
            ),
            contentDescription = "Story Image",
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(MaterialTheme.size.extraLarge))

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = MaterialTheme.size.extraLarge.times(2),
                    end = MaterialTheme.size.extraLarge.times(2),
                ),
            text = spanStory,
            style = MaterialTheme.body.medium.copy(
                color = MaterialTheme.colorScheme.onSurface,
            ),
            textAlign = TextAlign.Justify
        )

        Spacer(
            modifier = Modifier.height(
                MaterialTheme.size.extraLarge.times(2)
            )
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = MaterialTheme.size.extraLarge.times(2),
                    end = MaterialTheme.size.extraLarge.times(2),
                ),
            text = "Moral: ${story.moral ?: ""}",
            style = MaterialTheme.title.small.copy(
                color = MaterialTheme.colorScheme.onSurface,
                fontStyle = FontStyle.Italic
            ),
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier.height(
                MaterialTheme.size.extraLarge.times(2)
            )
        )
    }
}

@Preview
@Composable
private fun StoryPagePreview() {
    StoryPage(
        story = stories[0]
    )
}