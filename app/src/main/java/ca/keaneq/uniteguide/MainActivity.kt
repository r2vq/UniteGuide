package ca.keaneq.uniteguide

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.res.stringResource
import ca.keaneq.presentation.UniteGuide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UniteGuide(
                appName = stringResource(R.string.app_name),
                versionName = BuildConfig.VERSION_NAME,
            )
        }
    }
}