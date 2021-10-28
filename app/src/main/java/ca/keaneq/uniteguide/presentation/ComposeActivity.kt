package ca.keaneq.uniteguide.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ca.keaneq.uniteguide.R
import kotlinx.coroutines.launch

class ComposeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scaffoldState = rememberScaffoldState()
            val scope = rememberCoroutineScope()
            Scaffold(
                topBar = {
                    TopAppBar(
                        navigationIcon = {
                            IconButton(onClick = {
                                scope.launch {
                                    scaffoldState.drawerState.open()
                                }
                            }) {
                                Icon(Icons.Filled.Menu, contentDescription = "Menu")
                            }
                        },
                        title = { Text(text = stringResource(id = R.string.app_name)) }
                    )
                },
                drawerContent = {
                    Text(text = stringResource(id = R.string.title_pokemon))
                },
                drawerShape = RoundedCornerShape(topEnd = 24.dp),
                content = {
                    Text(stringResource(id = R.string.title_home))
                },
                scaffoldState = scaffoldState,
            )
        }
    }
}