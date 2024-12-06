package com.icetang.flyffumonitor

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.*
import androidx.compose.material3.Scaffold

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
//            ItemList(listOf("女神祝福", "恶魔祝福"))

//            ModalNavigationDrawer(
//                drawerState = rememberDrawerState(DrawerValue.Open),
//                drawerContent = {
//                    ModalDrawerSheet {
//                        Text("Drawer title", modifier = Modifier.padding(16.dp))
//                        HorizontalDivider()
//                        NavigationDrawerItem(
//                            label = { Text(text = "Drawer Item1") },
//                            selected = false,
//                            onClick = { /*TODO*/ }
//                        )
//                        HorizontalDivider()
//                        NavigationDrawerItem(
//                            label = { Text(text = "Drawer Item2") },
//                            selected = false,
//                            onClick = { /*TODO*/ }
//                        )
//                    }
//                }
//            ) {
//                // Screen content
//                Button(onClick = { showContent = !showContent }) {
//                    Text("Click me!")
//                }
//            }
            MyApp()
//            AnimatedVisibility(showContent) {
//                val greeting = remember { Greeting().greet() }
//                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//                    Image(painterResource(Res.drawable.compose_multiplatform), null)
//                    Text("Compose: $greeting")
//                }
//            }
        }
    }
}

@Composable
fun MyApp() {
    var selectedScreen by remember { mutableStateOf("Home") }

    Scaffold(
        bottomBar = {
            NavigationRail(
                modifier = Modifier.fillMaxHeight().fillMaxWidth(0.2f),
                containerColor = MaterialTheme.colors.surface)
            {
                NavigationRailItem(
                    modifier = Modifier.fillMaxWidth(),
                    selected = selectedScreen == "Home",
                    onClick = { selectedScreen = "Home" },
//                    label = { Text("Home") },
                    icon = { Text(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp), text = "Home") },
                )
                NavigationRailItem(
                    modifier = Modifier.fillMaxWidth(),
                    selected = selectedScreen == "Settings",
                    onClick = { selectedScreen = "Settings" },
//                    label = { Text("Settings") },
                    icon = { Text(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp), text = "Settings") },
                )
                NavigationRailItem(
                    modifier = Modifier.fillMaxWidth(),
                    selected = selectedScreen == "About",
                    onClick = { selectedScreen = "About" },
//                    label = { Text("About") },
                    icon = { Text(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp), text = "About") },
                )
            }
        },
        content = { innerPadding ->
            Box(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
                when (selectedScreen) {
                    "Home" -> HomeScreen()
                    "Settings" -> SettingsScreen()
                    "About" -> AboutScreen()
                }
            }
        }
    )
}

@Composable
fun HomeScreen() {
    Text("This is the Home Screen", modifier = Modifier.padding(16.dp))
}

@Composable
fun SettingsScreen() {
    Text("This is the Settings Screen", modifier = Modifier.padding(16.dp))
}

@Composable
fun AboutScreen() {
    Text("This is the About Screen", modifier = Modifier.padding(16.dp))
}

@Composable
fun ItemList(items: List<String>) {
    LazyColumn(modifier = Modifier.width(100.dp)) {
        items(items.size) { index ->
            var isFocused by remember { mutableStateOf(false) }
            var isActivated by remember { mutableStateOf(false) }
            Text(
                text = items[index],
                modifier = Modifier.fillMaxWidth()
                    .focusable() // 使按钮可以获取焦点
                    .onFocusChanged { focusState ->
                        isFocused = focusState.isFocused // 更新焦点状态
                    }
                    .background(color = if (isActivated || isFocused) Color.Green else Color.White)
                    .padding(16.dp) // 添加内边距
            )
        }
    }
}