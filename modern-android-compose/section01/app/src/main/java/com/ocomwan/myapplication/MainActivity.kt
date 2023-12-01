package com.ocomwan.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ocomwan.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                PracticeImageCardState()
            }
        }
    }

    @Composable
    fun PracticeColumn() {
        Surface(
            color = MaterialTheme.colorScheme.background,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.Blue)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                Text("Hello")
                Text("World")
            }
        }
    }

    @Composable
    fun PracticeBox() {
        Box(
            modifier = Modifier
                .background(color = Color.Green)
                .fillMaxWidth()
                .height(200.dp),
        ) {
            Text("오늘 컴포즈")
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.BottomEnd,
            ) {
                Text("완료")
            }
        }
    }

    @Composable
    fun PracticeListAndLazyColumn() {
        ListUsingLazyColumn()
    }

    @Composable
    private fun ListUsingColum(scrollState: ScrollState) {
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .background(color = Color.Green)
                .fillMaxWidth()
                .verticalScroll(
                    state = scrollState,
                ),
        ) {
            for (i in 1..50) {
                Text(getString(R.string.section1_letter, i.toString()))
            }
        }
    }

    @Composable
    fun ListUsingLazyColumn() {
        val scrollState = rememberScrollState()
        LazyColumn(
            modifier = Modifier
                .background(color = Color.Green)
                .fillMaxWidth(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            item {
                Text(stringResource(R.string.section1_header))
            }
            items(50) { index ->
                Text(stringResource(R.string.section1_letter, index))
            }
            item {
                Text(stringResource(R.string.section1_footer))
            }
        }
    }

    @Composable
    fun PracticeImageCardState() {
        var isFavorite by rememberSaveable {
            mutableStateOf(false)
        }

        ImageCard(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(16.dp),
            isFavorite = isFavorite,
        ) { favorite ->
            isFavorite = favorite
        }
    }

    @Composable
    fun ImageCard(
        modifier: Modifier = Modifier,
        isFavorite: Boolean,
        onTabFavorite: (Boolean) -> Unit,
    ) {
        Card(
            modifier = modifier,
            shape = RoundedCornerShape(5.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp,
            ),
        ) {
            Box(
                modifier = Modifier
                    .height(200.dp),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_kermit),
                    contentDescription = stringResource(R.string.section1_kermit_img),
                    contentScale = ContentScale.Crop,
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.TopEnd,
                ) {
                    IconButton(onClick = { onTabFavorite(!isFavorite) }) {
                        Icon(
                            imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                            contentDescription = stringResource(R.string.section1_favorite),
                            tint = Color.White,
                        )
                    }
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        PracticeColumn()
    }
}
