package com.project.beertracker.ui.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.project.beertracker.ui.main.components.BottomNavigationBar
import com.project.beertracker.ui.main.components.MainTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView(){

    Scaffold(
        topBar = { MainTopBar(name = "Home") },
        content = { innerPadding ->
            Text(
                text = "Body content",
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .wrapContentSize()
            )
        },
        bottomBar = { BottomNavigationBar() }

    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MainView()
}