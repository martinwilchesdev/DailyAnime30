package com.example.dailyanime30

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dailyanime30.model.AnimeInfo
import com.example.dailyanime30.ui.theme.DailyAnime30Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DailyAnime30Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppInfoList(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun AppInfoList(modifier: Modifier = Modifier) {
    InfoCard(
        AnimeInfo(
            R.string.day1,
            R.string.title1,
            R.drawable.anime1,
            R.string.description1
        )
    )
}

@Composable
fun InfoCard(info: AnimeInfo, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column(modifier = Modifier.padding(vertical = 16.dp, horizontal = 24.dp)) {
            Text(
                text = stringResource(id = info.day),
                style = MaterialTheme.typography.headlineLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(id = info.title),
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(4.dp))
            Image(
                painter = painterResource(id = info.image),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = stringResource(id = info.description),
                style = MaterialTheme.typography.bodyLarge, textAlign = TextAlign.Justify
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppListPreview() {
    AppInfoList(modifier = Modifier)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DailyAnime30Theme {
        InfoCard(
            AnimeInfo(
                R.string.day1,
                R.string.title1,
                R.drawable.anime1,
                R.string.description1
            )
        )
    }
}