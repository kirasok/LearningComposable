package io.github.kirasok.learningcomposable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column() {
            Image(
                painter = painterResource(id = R.drawable.bg_compose_background),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "Jetpack Compose tutorial",
                fontSize = 24.sp,
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                textAlign = TextAlign.Justify,
            )
            Text(
                text = "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name.",
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Justify,
            )
        }
    }
}

@Composable
fun TaskManager() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_task_completed),
                contentDescription = "Task Completed Icon"
            )
            Text(
                text = "All tasks completed",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
            )
            Text(
                text = "Nice work!",
                fontSize = 16.sp
            )
        }
    }
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