package ca.keaneq.uniteguide.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ca.keaneq.uniteguide.R
import ca.keaneq.uniteguide.presentation.main.ActionBar
import ca.keaneq.uniteguide.presentation.main.NavigationDrawer

class ComposeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val scaffoldState = rememberScaffoldState()
                Scaffold(
                    topBar = {
                        ActionBar(
                            text = stringResource(id = R.string.app_name),
                            drawerState = scaffoldState.drawerState,
                        )
                    },
                    drawerContent = { NavigationDrawer() },
                    drawerShape = RoundedCornerShape(topEnd = 24.dp),
                    content = { Text(stringResource(id = R.string.title_home)) },
                    scaffoldState = scaffoldState,
                )
            }
        }
    }
}