package com.arvind.jetcomposeloginui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.arvind.jetcomposeloginui.navigation.Navigation
import com.arvind.jetcomposeloginui.ui.theme.JetComposeLoginUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetComposeLoginUITheme {
                JetComposeLoginUiMain()
            }
        }
    }
}

@Preview
@Composable
fun JetComposeLoginUiMain() {
    JetComposeLoginUITheme {
        Surface(color = MaterialTheme.colors.background) {
            Navigation()
        }
    }
}

