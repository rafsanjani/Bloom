package com.example.androiddevchallenge.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.BloomTheme

@Composable
fun Home() {
    Surface(color = MaterialTheme.colors.background) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                BottomNavigation(
                    modifier = Modifier.height(56.dp),
                    backgroundColor = MaterialTheme.colors.primary
                ) {
                    val navItems = listOf(
                        BottomNavItem(title = "Home", Icons.Default.Home),
                        BottomNavItem(title = "Favorites", Icons.Default.Favorite),
                        BottomNavItem(title = "Profile", Icons.Default.AccountCircle),
                        BottomNavItem(title = "Cart", Icons.Default.ShoppingCart),
                    )

                    var selected by remember { mutableStateOf(navItems.first()) }

                    navItems.forEach { navItem ->
                        BottomNavigationItem(
                            selected = navItem == selected,
                            onClick = { selected = navItem },
                            icon = {
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Icon(
                                        imageVector = navItem.icon,
                                        contentDescription = navItem.title
                                    )
                                    Text(
                                        text = navItem.title,
                                        style = MaterialTheme.typography.caption
                                    )
                                }
                            })
                    }
                }
            }
        ) {
            Content()
        }
    }
}

data class BottomNavItem(val title: String, val icon: ImageVector)

@Composable
fun Content() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 40.dp)
        ) {
            var query by remember { mutableStateOf("") }

            SearchField(query = query) {
                query = it
            }

            BloomHeader(
                modifier = Modifier
                    .paddingFromBaseline(40.dp),
                text = "Browse themes"
            )

            Spacer(
                modifier = Modifier
                    .height(16.dp)
            )

            BloomThemes()

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .paddingFromBaseline(40.dp)
                    .padding(end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {

                BloomHeader(
                    modifier = Modifier,
                    text = "Design your home garden"
                )

                Icon(
                    imageVector = Icons.Default.FilterList,
                    contentDescription = "Filter",
                    modifier = Modifier
                        .size(24.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            GardenList()

        }
    }
}

@Composable
fun GardenList() {
    val gardenItems = listOf(
        GardenItem(
            title = "Monstera",
            description = "This is a description",
            image = R.drawable.monstera
        ),
        GardenItem(
            title = "Aglaonema",
            description = "This is a description",
            image = R.drawable.aglaonema
        ),
        GardenItem(
            title = "Peace lily",
            description = "This is a description",
            image = R.drawable.peace_lilly
        ),
        GardenItem(
            title = "Fiddle leaf tree",
            description = "This is a description",
            image = R.drawable.fiddle_leaf
        ),
        GardenItem(
            title = "Snake plant",
            description = "This is a description",
            image = R.drawable.snake_plant
        ),
        GardenItem(
            title = "Pothos",
            description = "This is a description",
            image = R.drawable.pothos
        ),
    )

    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(gardenItems) {
            GardenCard(gardenItem = it)
        }
    }

}


@Composable
fun GardenCard(gardenItem: GardenItem) {
    var checked by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .height(56.dp),
    ) {
        Image(
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1f),
            painter = painterResource(id = gardenItem.image),
            contentDescription = gardenItem.title,
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Column(modifier = Modifier) {
                    Text(
                        text = gardenItem.title,
                        modifier = Modifier.paddingFromBaseline(24.dp),
                        style = MaterialTheme.typography.h2
                    )
                    Text(
                        text = gardenItem.description,
                        modifier = Modifier.paddingFromBaseline(16.dp),
                        style = MaterialTheme.typography.body1
                    )
                }


                Checkbox(
                    modifier = Modifier.align(
                        Alignment.CenterVertically
                    ),
                    checked = checked,
                    onCheckedChange = {
                        checked = it
                    },
                    colors = CheckboxDefaults.colors(checkmarkColor = MaterialTheme.colors.onSecondary)
                )
            }

            Box(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .height(1.dp)
                    .fillMaxWidth()
                    .border(
                        border = BorderStroke(
                            width = 1.dp,
                            color = MaterialTheme.colors.onBackground
                        )
                    )
            )
        }

    }
}

@Composable
fun SearchField(
    modifier: Modifier = Modifier,
    query: String,
    onQueryChange: (query: String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(end = 16.dp),
        value = query, onValueChange = onQueryChange,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon",
                modifier = Modifier.size(18.dp)
            )
        },
        singleLine = true,
        textStyle = MaterialTheme.typography.body1,
        placeholder = {
            Text(text = "Search")
        }
    )
}

@Composable
fun BloomHeader(modifier: Modifier = Modifier, text: String) {
    Text(modifier = modifier, text = text, style = MaterialTheme.typography.h1)
}

@Composable
fun BloomThemes() {
    val themes = listOf(
        Theme("Desert chic", R.drawable.desert_chic),
        Theme("Tiny terrariums", R.drawable.tiny_terrariums),
        Theme("Jungle vibes", R.drawable.jungle_vibes),
        Theme("Easy care", R.drawable.easy_care),
        Theme("Statements", R.drawable.statements),
    )

    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(themes) { theme ->
            ThemeCard(theme = theme)
        }
    }
}

@Composable
fun ThemeCard(theme: Theme) {
    Card(modifier = Modifier.size(136.dp), shape = MaterialTheme.shapes.small) {
        Column {
            Image(
                painter = painterResource(id = theme.image),
                contentDescription = theme.name,
                modifier = Modifier
                    .height(80.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.FillBounds
            )

            Text(
                text = theme.name,
                modifier = Modifier
                    .paddingFromBaseline(24.dp)
                    .padding(start = 16.dp),
                style = MaterialTheme.typography.h2,
                textAlign = TextAlign.Start
            )
        }
    }
}

data class Theme(val name: String, @DrawableRes val image: Int)
data class GardenItem(val title: String, val description: String, @DrawableRes val image: Int)

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun HomePreviewDark() {
    BloomTheme(darkTheme = true) {
        Home()
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun HomePreviewLight() {
    BloomTheme {
        Home()
    }
}
