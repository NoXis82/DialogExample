package com.example.dialogexample.components

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun AlertDialogExample(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
) {
    AlertDialog(
        icon = {
            Icon(imageVector = Icons.Default.AccountBox, contentDescription = null)
        },
        title = {
            Text(text = "Alert Dialog")
        },
        text = {
            Text(text = "This is an example of an alert dialog with buttons.")
        },
        onDismissRequest = {
            Log.d(AlertDialog_TAG, "AlertDialogExample: onDismissRequest")
            onDismissRequest.invoke()
        },
        confirmButton = {
            TextButton(onClick = { onConfirmation.invoke() }) {
                Text(text = "Confirm")
            }
        },
        dismissButton = {
            TextButton(onClick = { onDismissRequest.invoke() }) {
                Text(text = "Dismiss")
            }
        }
    )
}

const val AlertDialog_TAG = "AlertDialogExample"