package com.benidict.jetpackanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.benidict.jetpackanimation.navigation.host.MainGraph
import com.benidict.jetpackanimation.ui.theme.JetpackanimationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackanimationTheme {
                val navController = rememberNavController()
                MainGraph(navHostController = navController)
            }
        }
    }
}
