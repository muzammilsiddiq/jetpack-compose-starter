package com.example.composestarter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.compose.rememberAsyncImagePainter
import com.example.composestarter.ui.theme.ComposeStarterTheme
import com.example.composestarter.ui.theme.Green200
import com.example.composestarter.ui.theme.Green500
import com.example.composestarter.ui.theme.Green800

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeStarterTheme {
                Navigation()
            }
        }
    }
}

@Composable
fun Home(navController: NavController) {
    Scaffold(bottomBar = {
        BottomNavigationBar(
            items = getBottomBarItems(),
            navController = navController,
            onItemClick = {

            }
        )
    }) {
        Column(
            modifier = Modifier
                .background(Color.White)
        ) {
            val modifier = Modifier.padding(24.dp, 0.dp)

            TopBar()
            Header(modifier)
            Search(modifier)
            Categories(modifier)
            Products(modifier, navController)
        }
    }
}

@Composable
fun TopBar() {
    Column {
        ComposeStarterTheme {
            TopAppBar(
                title = {
                    Row(
                        Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        IconButton(
                            onClick =
                            {

                            }) {
                            Image(
                                painter = painterResource(R.drawable.profile),
                                contentDescription = "avatar",
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier
                                    .size(35.dp)
                                    .clip(CircleShape)

                            )
                        }
                        IconButton(
                            modifier = Modifier
                                .align(Alignment.CenterVertically),
                            onClick = {

                            },
                        ) {
                            Icon(
                                imageVector = Icons.Default.ShoppingCart,
                                contentDescription = "Person Profile"
                            )
                        }
                    }
                },
            )
        }
    }
}

@Composable
fun Header(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier.padding(top = 12.dp),
        text = "Let's find your\nplants!",
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        color = Green800
    )
}

@Composable
fun Search(modifier: Modifier = Modifier) {
    var textValue by remember {
        mutableStateOf("")
    }

    TextField(
        modifier = modifier
            .padding(vertical = 12.dp)
            .fillMaxWidth()
            .background(Green200, shape = RoundedCornerShape(8.dp))
            .height(50.dp),
        value = textValue,
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
        },
        placeholder = {
            Text(text = "Search Plant")
        },
        textStyle = TextStyle(
            fontSize = 16.sp
        ),
        onValueChange = {
            textValue = it
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,
            disabledTextColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun Categories(modifier: Modifier) {
    val categories = listOf("Recommended", "Top", "Indoor", "Outdoor")
    var selectedPosition by remember {
        mutableStateOf(0)
    }

    LazyRow(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(4) { index ->
            ClickableText(
                modifier = Modifier
                    .let {
                        if (selectedPosition == index) {
                            return@let it
                                .background(
                                    Green200,
                                    shape = RoundedCornerShape(12.dp)
                                )

                        }
                        it
                    }
                    .padding(horizontal = 12.dp, vertical = 4.dp),
                text = AnnotatedString(categories[index]),
                style = TextStyle(
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center
                ),
                onClick = {
                    selectedPosition = index
                }
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Products(modifier: Modifier, navController: NavController) {
    val products = getProducts()

    LazyVerticalGrid(
        modifier = modifier.padding(vertical = 12.dp),
        cells = GridCells.Fixed(count = 2)
    ) {
        items(products.size) { index ->
            val product = products[index]
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .background(Green200, shape = RoundedCornerShape(8.dp))
                    .padding(8.dp)
                    .fillMaxSize()
                    .clickable {
                        navController.navigate(Screen.ProductDetail.withArgs(product.id.toString()))
                    }
            ) {
                Column {
                    Image(
                        painter = rememberAsyncImagePainter(product.imageURL),
                        contentDescription = null,
                        modifier = Modifier.size(150.dp)
                    )
                    Text(
                        modifier = Modifier.padding(top = 12.dp),
                        text = product.category,
                        style = TextStyle(
                            color = Green800,
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp
                        ),
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = product.title,
                            style = TextStyle(
                                color = Green800,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 14.sp
                            )
                        )
                        Text(
                            text = "€${product.price}",
                            style = TextStyle(
                                color = Green800,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 12.sp
                            ),
                        )
                    }
                }

            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            Home(navController = navController)
        }
        composable(
            route = Screen.ProductDetail.route + "/{id}",
            arguments = listOf(navArgument("id") {
                type = NavType.IntType
                defaultValue = -1
            })
        ) { entry ->
            ProductDetail(id = entry.arguments?.getInt("id") ?: return@composable)
        }
    }
}