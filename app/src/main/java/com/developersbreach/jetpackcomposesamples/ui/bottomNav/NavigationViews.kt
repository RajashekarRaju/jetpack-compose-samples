package com.developersbreach.jetpackcomposesamples.ui.bottomNav

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.developersbreach.jetpackcomposesamples.R
import com.developersbreach.jetpackcomposesamples.ui.theme.ComposeTheme

@ExperimentalFoundationApi
@Composable
fun FavoriteContactsScreen(
    contacts: ArrayList<String> = favoriteContacts()
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        modifier = Modifier.padding(top = 28.dp),
    ) {
        items(contacts) { contact ->

            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Card(
                    modifier = Modifier.clip(CircleShape)
                        .align(Alignment.CenterHorizontally),
                    backgroundColor = pickRandomColor(),
                ) {
                    Text(
                        text = contact[0].toString(),
                        style = MaterialTheme.typography.h4,
                        modifier = Modifier.padding(12.dp).size(48.dp),
                        textAlign = TextAlign.Center,
                        color = Color.Black
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = contact,
                    style = MaterialTheme.typography.h6,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun RecentContactsScreen(
    recent: ArrayList<String> = recentContacts()
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(28.dp),
        modifier = Modifier.padding(top = 28.dp).fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(recent) { contact ->
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 16.dp, end = 12.dp, top = 4.dp, bottom = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    modifier = Modifier.clip(CircleShape)
                        .align(Alignment.CenterVertically),
                    backgroundColor = pickRandomColor(),
                ) {
                    Text(
                        text = contact[0].toString(),
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier.padding(8.dp).size(24.dp),
                        textAlign = TextAlign.Center,
                        color = Color.Black
                    )
                }

                Spacer(modifier = Modifier.width(28.dp))

                Column(
                    modifier = Modifier.weight(7f)
                ) {
                    Text(text = contact, style = MaterialTheme.typography.subtitle1)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = pickRandomTimeData(), style = MaterialTheme.typography.subtitle1)
                }

                Icon(
                    painter = painterResource(id = R.drawable.phone),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp).weight(1.5f)
                )
            }
        }
    }
}

@Composable
fun ContactsScreen(
    contacts: ArrayList<String> = userData()
) {

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .padding(top = 28.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(contacts) { contact ->

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 12.dp, top = 4.dp, bottom = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Card(
                    modifier = Modifier
                        .clip(CircleShape)
                        .align(Alignment.CenterVertically),
                    backgroundColor = pickRandomColor(),
                ) {
                    Text(
                        text = contact[0].toString(),
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier
                            .padding(12.dp)
                            .size(24.dp),
                        textAlign = TextAlign.Center,
                        color = Color.Black
                    )
                }

                Spacer(modifier = Modifier.width(28.dp))

                Text(text = contact, style = MaterialTheme.typography.h6)
            }
        }
    }
}

@ExperimentalFoundationApi
@Preview(widthDp = 360, heightDp = 640)
@Composable
fun FavoriteContactsPreview() {
    ComposeTheme(darkTheme = true) {
        FavoriteContactsScreen()
    }
}

@ExperimentalFoundationApi
@Preview(widthDp = 360, heightDp = 640)
@Composable
fun RecentContactsPreview() {
    ComposeTheme(darkTheme = true) {
        RecentContactsScreen()
    }
}

@ExperimentalFoundationApi
@Preview(widthDp = 360, heightDp = 640)
@Composable
fun ContactsScreenPreview() {
    ComposeTheme(darkTheme = true) {
        ContactsScreen()
    }
}