package com.example.dialogexample

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.dialogexample.components.AlertDialogExample
import com.example.dialogexample.components.CustomDialogExample
import com.example.dialogexample.ui.theme.DialogExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DialogExampleTheme {
                MainScreen()
            }
        }
    }
}


@Composable
fun MainScreen() {
    var visibleAlertDialog by remember { mutableStateOf(false) }
    var visibleCustomDialog by remember { mutableStateOf(false) }
    val context = LocalContext.current
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {
                visibleAlertDialog = true
                visibleCustomDialog = false
            }) {
                Text(text = "Alarm Dialog")
            }
            Button(onClick = {
                visibleAlertDialog = false
                visibleCustomDialog = true
            }) {
                Text(text = "Custom Dialog")
            }
        }

        when {
            visibleAlertDialog -> {
                AlertDialogExample(
                    onConfirmation = {
                        Toast.makeText(context, "AlertDialogExample: onConfirmation", Toast.LENGTH_SHORT).show()
                        visibleAlertDialog = false
                    },
                    onDismissRequest = {
                        Toast.makeText(context, "AlertDialogExample: onDismissRequest", Toast.LENGTH_SHORT).show()
                        visibleAlertDialog = false
                    }
                )
            }

            visibleCustomDialog -> {
                CustomDialogExample(
                    onConfirmation = { text ->
                        Toast.makeText(context, "CustomDialogExample: onConfirmation -> $text", Toast.LENGTH_SHORT).show()
                        visibleCustomDialog = false
                    },
                    onDismissRequest = {
                        Toast.makeText(context, "CustomDialogExample: onDismissRequest", Toast.LENGTH_SHORT).show()
                        visibleCustomDialog = false
                    }
                )
            }
        }
    }
}