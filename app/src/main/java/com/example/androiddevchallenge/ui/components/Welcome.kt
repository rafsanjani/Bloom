package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.BloomTheme

@Composable
fun Welcome() {
    Surface(color = MaterialTheme.colors.background) {

        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colors.primary)
                .fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.welcome_bg),
                contentDescription = "Welcome Background",
                contentScale = ContentScale.FillBounds
            )

            Column(
                modifier = Modifier
                    .padding(top = 72.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .offset(x = 88.dp),
                    painter = painterResource(id = R.drawable.ic_welcome_illos),
                    contentDescription = "Welcome Green Leaf",
                    contentScale = ContentScale.None
                )
                Spacer(modifier = Modifier.height(48.dp))

                Image(
                    painter = painterResource(id = R.drawable.ic_logo),
                    contentDescription = "Bloom Logo"
                )

                Text(
                    modifier = Modifier.paddingFromBaseline(top = 32.dp),
                    text = "Beautiful home garden solutions",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.subtitle1
                )

                Spacer(modifier = Modifier.height(40.dp))

                Button(
                    modifier = Modifier
                        .height(48.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    onClick = {},
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
                ) {
                    Text("Create Account", style = MaterialTheme.typography.button)
                }

                Text(
                    modifier = Modifier
                        .paddingFromBaseline(40.dp)
                        .clickable {

                        },
                    text = "Log in",
                    style = MaterialTheme.typography.button
                )
            }
        }
    }
}


@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun WelcomePreviewLight() {
    BloomTheme {
        Welcome()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun WelcomePreviewDark() {
    BloomTheme(darkTheme = true) {
        Welcome()
    }
}