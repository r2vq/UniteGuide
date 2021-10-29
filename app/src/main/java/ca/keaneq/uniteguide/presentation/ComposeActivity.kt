package ca.keaneq.uniteguide.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import ca.keaneq.uniteguide.R
import ca.keaneq.uniteguide.presentation.main.ActionBar
import ca.keaneq.uniteguide.presentation.main.NavigationDrawer
import ca.keaneq.uniteguide.presentation.main.UniteGuideTheme
import ca.keaneq.uniteguide.presentation.navigation.Navigation

class ComposeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val scope = rememberCoroutineScope()
            UniteGuideTheme {
                val scaffoldState = rememberScaffoldState()
                Scaffold(
                    topBar = {
                        ActionBar(
                            text = stringResource(id = R.string.app_name),
                            drawerState = scaffoldState.drawerState,
                            scope = scope,
                        )
                    },
                    drawerContent = {
                        NavigationDrawer(
                            navController = navController,
                            drawerState = scaffoldState.drawerState,
                            scope = scope,
                        )
                    },
                    drawerShape = RoundedCornerShape(topEnd = 24.dp),
                    content = { Navigation(navController) },
                    scaffoldState = scaffoldState,
                )
            }
        }
    }
}