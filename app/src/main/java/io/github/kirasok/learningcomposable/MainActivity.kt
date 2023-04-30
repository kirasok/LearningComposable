package io.github.kirasok.learningcomposable

import android.os.Bundle
import android.telephony.PhoneNumberUtils
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
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
            LearningComposableTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "root") {
                    composable("root") {
                        Root(
                            { navController.navigate("article") },
                            { navController.navigate("task-manager") },
                            { navController.navigate("quadrant") },
                            { navController.navigate("business-card") },
                            { navController.navigate("compose-basics") }
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
                    composable("business-card") {
                        BusinessCard()
                    }
                    composable("compose-basics") {
                        ComposeBasics()
                    }
                }
            }
        }
    }
}

@Composable
fun Article() {
    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
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
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
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
                text = "Nice work!", fontSize = 16.sp
            )
        }
    }
}

@Composable
fun Quadrant() {
    Surface {
        Column {
            Row(modifier = Modifier.weight(weight = 1.0F, fill = true)) {
                Corner(
                    title = "Text composable",
                    description = "Displays text and follows Material Design guidelines.",
                    color = Color.Green,
                    modifier = Modifier.weight(weight = 1.0F, fill = true)
                )
                Corner(
                    title = "Image composable",
                    description = "Creates a composable that lays out and draws a given Painter class object.",
                    color = Color.Yellow,
                    modifier = Modifier.weight(weight = 1.0F, fill = true)
                )
            }
            Row(modifier = Modifier.weight(weight = 1.0F, fill = true)) {
                Corner(
                    title = "Row composable",
                    description = "A layout composable that places its children in a horizontal sequence.",
                    color = Color.Cyan,
                    modifier = Modifier.weight(weight = 1.0F, fill = true)
                )
                Corner(
                    title = "Column composable",
                    description = "A layout composable that places its children in a vertical sequence.",
                    color = Color.LightGray,
                    modifier = Modifier.weight(weight = 1.0F, fill = true)
                )
            }
        }
    }
}

@Composable
fun Corner(title: String, description: String, color: Color, modifier: Modifier) {
    Surface(
        color = color, modifier = modifier
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = title, fontWeight = FontWeight.Bold, modifier = Modifier.padding(16.dp))
            Text(text = description, textAlign = TextAlign.Justify)
        }
    }
}

@Composable
fun BusinessCard() {
    Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFF1B2F3D)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = "Android Logo",
                modifier = Modifier
                    .height(256.dp)
                    .width(256.dp)
            )
            Text(
                text = "Kirill Mokretsov",
                color = Color.White,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Android Developer",
                color = Color.White,
                style = MaterialTheme.typography.titleMedium
            )
        }
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp, start = 64.dp, end = 64.dp)
        ) {
            Contact(
                contact = PhoneNumberUtils.formatNumber("+7 (000) 000-00-00", "RU"),
                icon = Icons.Default.Phone,
                contentDescriptor = "Phone"
            )
            Contact(
                contact = "github.com/kirasok",
                icon = Icons.Default.AccountCircle,
                contentDescriptor = "Account"
            )
            Contact(
                contact = "kirill.mokretsov@protonmail.ch",
                icon = Icons.Default.Email,
                contentDescriptor = "Email"
            )
        }
    }
}

@Composable
fun Contact(contact: String, icon: ImageVector, contentDescriptor: String) {
    Row(modifier = Modifier.padding(bottom = 8.dp)) {
        Icon(icon, contentDescription = contentDescriptor, tint = Color.White)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = contact, color = Color.White)
    }
}

@Composable
fun ComposeBasics(modifier: Modifier = Modifier) {
    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }

    Surface(modifier) {
        if (shouldShowOnboarding) {
            OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
        } else {
            Greetings()
        }
    }
}

@Composable
private fun Greetings(
    modifier: Modifier = Modifier,
    names: List<String> = List(1000) { "$it" }
) {
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items(items = names) { name -> Greeting(name = name) }
    }
}

@Composable
private fun Greeting(name: String) {
    val expanded = rememberSaveable { mutableStateOf(false) }
    Card(
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(24.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioLowBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
        ) {
            Column(
                modifier = Modifier
                    .weight(1F)
            ) {
                Text(text = "Hello,")
                Text(
                    text = name,
                    style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.ExtraBold)
                )
                if (expanded.value) Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    textAlign = TextAlign.Justify
                )
            }
            IconButton(onClick = { expanded.value = !expanded.value }) {
                Icon(
                    if (expanded.value) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                    contentDescription = if (expanded.value) "Show less" else "Show more"
                )
            }
        }
    }
}

@Composable
fun OnboardingScreen(
    onContinueClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to the Basics Codelab!")
        Button(
            modifier = Modifier
                .padding(vertical = 24.dp),
            onClick = onContinueClicked
        ) {
            Text("Continue")
        }
    }
}

@Composable
fun Root(
    onNavigateToArticle: () -> Unit,
    onNavigateToTaskManager: () -> Unit,
    onNavigateToQuadrant: () -> Unit,
    onNavigateToBusinessCard: () -> Unit,
    onNavigateToComposeBasics: () -> Unit
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
            Button(onClick = onNavigateToBusinessCard) {
                Text(text = "Business Card")
            }
            Button(onClick = onNavigateToComposeBasics) {
                Text(text = "Compose Basics")
            }
        }
    }
}