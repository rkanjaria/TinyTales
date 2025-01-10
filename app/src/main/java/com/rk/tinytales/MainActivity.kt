package com.rk.tinytales

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.rk.tinytales.core.navigation.RootNavigationGraph
import com.rk.tinytales.core.presentation.util.ObserveAsEvents
import com.rk.tinytales.core.presentation.util.SimpleSnackBarVisuals
import com.rk.tinytales.core.presentation.util.SnackBarController
import com.rk.tinytales.ui.theme.TinyTalesTheme
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        installSplashScreen()
        enableEdgeToEdge()

        super.onCreate(savedInstanceState)

        setContent {
            TinyTalesTheme {

                val onBoardingNavController = rememberNavController()
                val homeNavController = rememberNavController()

                val scope = rememberCoroutineScope()
                val snackBarHostState = remember { SnackbarHostState() }

                ObserveAsEvents(
                    flow = SnackBarController.events,
                    key1 = snackBarHostState
                ) { event ->
                    scope.launch {
                        snackBarHostState.currentSnackbarData?.dismiss()

                        val result = snackBarHostState.showSnackbar(
                            SimpleSnackBarVisuals(
                                message = event.message,
                                snackBarType = event.snackBarType,
                                actionLabel = event.snackBarAction?.name,
                                duration = event.snackBarDuration
                            )
                        )

                        if (result == SnackbarResult.ActionPerformed) {
                            event.snackBarAction?.action?.invoke()
                        }
                    }
                }

                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) {
                    RootNavigationGraph(
                        onBoardingNavController = onBoardingNavController,
                        homeNavController = homeNavController
                    )
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
fun FontComposablePreview() {
    TinyTalesTheme {  }
}