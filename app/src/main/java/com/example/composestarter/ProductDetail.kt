package com.example.composestarter

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.composestarter.ui.theme.Green200
import com.example.composestarter.ui.theme.Green500
import com.example.composestarter.ui.theme.Green800

@ExperimentalMaterialApi
@Composable
fun ProductDetail(id: Int) {
    val product = getProducts().firstOrNull { id == id } ?: return

    Surface {
        BottomSheetScaffold(
            sheetContent = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp)
                        .height(300.dp)
                ) {
                    Column {
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
                                    fontSize = 24.sp
                                )
                            )
                            Text(
                                text = "€${product.price}",
                                style = TextStyle(
                                    color = Green500,
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 18.sp
                                ),
                            )
                        }
                        Text(
                            text = "About",
                            modifier = Modifier.padding(top = 24.dp),
                            style = TextStyle(
                                color = Green800,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 14.sp
                            ),
                        )
                        Text(
                            modifier = Modifier.padding(top = 24.dp),
                            text = product.description,
                            style = TextStyle(
                                color = Green800,
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp
                            ),
                        )
                    }
                }
            },
            sheetShape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
            sheetBackgroundColor = Color.White,
        ) {
            Image(
                painter = rememberAsyncImagePainter(product.imageURL),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Green200),
            )
        }
    }
}