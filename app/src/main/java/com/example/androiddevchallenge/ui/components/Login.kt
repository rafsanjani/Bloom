package com.example.androiddevchallenge.ui.components


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.BloomTheme

@Composable
fun Login() {
    Surface(color = MaterialTheme.colors.background) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                var email by remember { mutableStateOf("") }

                var password by remember { mutableStateOf("") }


                Text(
                    text = "Log in with email",
                    style = MaterialTheme.typography.h1,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(8.dp))

                InputField(text = email, placeholder = "Email address") {
                    email = it
                }

                Spacer(modifier = Modifier.height(8.dp))

                InputField(text = password, placeholder = "Password (8+ characters)") {
                    password = it
                }

                val termsAndC = buildAnnotatedString {
                    val underline = SpanStyle(
                        textDecoration = TextDecoration.Underline
                    )

                    append("By clicking below, you agree to our ")

                    withStyle(underline) {
                        append("Terms of Use")
                    }

                    append("and consent to our")

                    withStyle(underline) {
                        append("Privacy Policy")
                    }
                }

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .paddingFromBaseline(40.dp),
                    text = termsAndC,
                    style = MaterialTheme.typography.body2,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    modifier = Modifier
                        .height(48.dp)
                        .fillMaxWidth(),
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
                    shape = CircleShape
                ) {
                    Text(text = "Log in", style = MaterialTheme.typography.button)
                }
            }
        }
    }
}

@Composable
fun InputField(text: String, placeholder: String, onTextChanged: (text: String) -> Unit) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = text,
        onValueChange = onTextChanged,
        placeholder = {
            Text(text = placeholder)
        },

        textStyle = MaterialTheme.typography.body1,
        colors = TextFieldDefaults.textFieldColors(),
        singleLine = true
    )
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LoginPreviewLight() {
    BloomTheme {
        Login()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun LoginPreviewDark() {
    BloomTheme(darkTheme = true) {
        Login()
    }
}