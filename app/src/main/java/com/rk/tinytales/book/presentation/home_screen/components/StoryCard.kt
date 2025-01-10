package com.rk.tinytales.book.presentation.home_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.rk.tinytales.R
import com.rk.tinytales.book.presentation.models.StoryUi
import com.rk.tinytales.core.domain.util.stories
import com.rk.tinytales.core.presentation.util.clickableWithoutRipple
import com.rk.tinytales.ui.theme.DarkTheme
import com.rk.tinytales.ui.theme.LightTheme
import com.rk.tinytales.ui.theme.TinyTalesTheme
import com.rk.tinytales.ui.theme.body
import com.rk.tinytales.ui.theme.size
import com.rk.tinytales.ui.theme.title

@Composable
fun StoryCard(
    modifier: Modifier = Modifier,
    story: StoryUi,
    color: Color,
    onPromptClicked: (StoryUi) -> Unit = {}
) {

    val storyCardShape = RoundedCornerShape(MaterialTheme.size.dp24)

    Column(
        modifier = modifier
            .width(MaterialTheme.size.dp200)
            .clip(storyCardShape)
            .background(color = color)
            .padding(all = MaterialTheme.size.extraLarge)
            .clickableWithoutRipple { onPromptClicked(story) }
    ) {

        Icon(
            modifier = Modifier.size(MaterialTheme.size.dp30),
            imageVector = ImageVector.vectorResource(id = story.icon),
            contentDescription = "Send",
            tint = LightTheme.title
        )

        Spacer(modifier = Modifier.height(MaterialTheme.size.dp100))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = story.title ?: "",
                style = MaterialTheme.title.large.copy(
                    color = LightTheme.title,
                )
            )

            Icon(
                modifier = Modifier
                    .size(MaterialTheme.size.dp18),
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "",
                tint = LightTheme.title
            )
        }

        /* Text(
             modifier = Modifier.fillMaxWidth(),
             text = prompt.title ?: "",
             style = MaterialTheme.title.large.copy(
                 color = LightTheme.title,
             ),
         )*/

        Spacer(modifier = Modifier.height(MaterialTheme.size.extraSmall))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = story.title ?: "",
            style = MaterialTheme.body.small.copy(
                color = LightTheme.title
            ),
        )
    }
}

@PreviewLightDark
@Composable
private fun PromptCardPreview() {
    TinyTalesTheme {
        StoryCard(
            modifier = Modifier,
            story = stories.first(),
            color = DarkTheme.cardColorPink,
        )
    }
}