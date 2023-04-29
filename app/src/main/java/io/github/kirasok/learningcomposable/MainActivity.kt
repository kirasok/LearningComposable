package io.github.kirasok.learningcomposable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.github.kirasok.learningcomposable.ui.theme.LearningComposableTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "root") {
                composable("root") {
                    Root(
                        { navController.navigate("article") },
                        { navController.navigate("task-manager") },
                        { navController.navigate("quadrant") }
                    )
                }
                composable("article") {
                    Article()
                }
                composable("task-manager") {
                    TaskManager()
                }
                composable("quadrant") {
                    Quadrant()
                }
            }
        }
    }
}

@Composable
fun Article() {
    Text("TODO")
}

@Composable
fun TaskManager() {
    Text("TODO")
}

@Composable
fun Quadrant() {
    Text("TODO")
}

@Composable
fun Root(
    onNavigateToArticle: () -> Unit,
    onNavigateToTaskManager: () -> Unit,
    onNavigateToQuadrant: () -> Unit
) {
    Surface(Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = onNavigateToArticle) {
                Text(text = "Article")
            }
            Button(onClick = onNavigateToTaskManager) {
                Text(text = "Task Manager")
            }
            Button(onClick = onNavigateToQuadrant) {
                Text(text = "Quadrant")
            }
        }
    }
}