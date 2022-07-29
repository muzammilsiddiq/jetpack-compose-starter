package com.example.composestarter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.composestarter.ui.theme.Green200
import com.example.composestarter.ui.theme.Green800

@Composable
fun BottomNavigationBar(
    items: List<BottomNavBarItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavBarItem) -> Unit
) {
    BottomNavigation(
        modifier = modifier.background(
            color = Green200,
            shape = RoundedCornerShape(20.dp)
        ),
        backgroundColor = Color.White,
        elevation = 35.dp
    ) {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

        items.forEach { item ->

            val isSelected = item.route == currentRoute

            BottomNavigationItem(
                selected = isSelected,
                onClick = {
                    onItemClick(item)
                },
                selectedContentColor = Color.Gray
                 ,
                unselectedContentColor = Color.Gray,
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.name
                    )
                })
        }
    }
}
