package com.arvind.jetcomposeloginui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.arvind.jetcomposeloginui.R
import com.arvind.jetcomposeloginui.component.TopAppBarWithBack
import com.arvind.jetcomposeloginui.navigation.Screen
import com.arvind.jetcomposeloginui.ui.theme.*

@Composable
fun FlowerDetailsScreen(navController: NavController) {
    val pageCount by remember { mutableStateOf(0) }
    Scaffold(topBar = {
        TopAppBarWithBack(
            onBackClick = {

            },
        )

    }, backgroundColor = bgwhitelight,
        content = { padding ->

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .verticalScroll(rememberScrollState())
            ) {

                ConstraintLayout {
                    val (imagesliderref, addtocartref) = createRefs()
                    Box(modifier = Modifier
                        .height(280.dp)
                        .constrainAs(imagesliderref) {
                            top.linkTo(imagesliderref.top)
                            bottom.linkTo(imagesliderref.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }) {
                        HeaderImagesSlider(pageCount)
                    }
                    Surface(color = colorPrimary,
                        shape = RoundedCornerShape(40.dp)
                            .copy(
                                bottomStart = ZeroCornerSize,
                                bottomEnd = ZeroCornerSize
                            ), modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 300.dp)
                            .constrainAs(addtocartref) {
                                bottom.linkTo(parent.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(20.dp)
                        ) {

                            FlowerTitleSubtitle()
                            Spacer(modifier = Modifier.padding(10.dp))
                            AddtoCartPrice()
                            Spacer(modifier = Modifier.padding(10.dp))
                            Divider(color = colorprimarywhite, thickness = 1.dp)
                            Spacer(modifier = Modifier.padding(20.dp))
                            FlowerAbout()
                            Spacer(modifier = Modifier.padding(20.dp))
                            FlowerAddToCartButton(navController)
                        }

                    }

                }
            }
        }
    )
}

@Preview
@Composable
fun FlowerDetailsScreenPreview() = FlowerDetailsScreen(NavController(LocalContext.current))

@Preview
@Composable
fun FlowerTitleSubtitle() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Jannien Flower Bouquet",
            style = MaterialTheme.typography.h6,
            color = white
        )

        Text(
            text = "includes jannein flower, lily leaves",
            style = MaterialTheme.typography.caption,
            color = white
        )
    }
}

@Preview
@Composable
fun AddtoCartPrice() {
    val counter = remember {
        mutableStateOf(1)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$567.00",
            color = white,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Box(
            modifier = Modifier
                .width(110.dp)
                .wrapContentHeight()
                .clip(RoundedCornerShape(10.dp))
                .background(colorprimarywhite)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {

                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_minimize_24),
                        contentDescription = "",
                        modifier = Modifier.padding(bottom = 15.dp),
                        tint = white
                    )
                }

                Text(
                    text = "${counter.value}",
                    color = white,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                IconButton(onClick = {
                    counter.value++
                }) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "",
                        tint = white,
                    )
                }
            }
        }

    }
}

@Preview
@Composable
fun FlowerAbout() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "About",
            style = MaterialTheme.typography.h6,
            color = white
        )
        Spacer(modifier = Modifier.padding(5.dp))

        Text(
            text = "Lorem ipsum is simply dummy text of the printing and \n" +
                    "typesetting industry. Loremk ipsum has been the industy's \n" +
                    "standard dummy text ever since the 1500s.",
            style = MaterialTheme.typography.caption,
            color = white
        )
    }
}

@Composable
fun FlowerAddToCartButton(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Button(
            onClick = {
                navController.navigate(Screen.AddToCartScreen.route)
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = white),
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .height(60.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = "Add to Cart",
                color = colorPrimary,
                fontWeight = FontWeight.Bold
            )
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = null,
                tint = colorPrimary,
                modifier = Modifier
                    .padding(start = 4.dp)
                    .size(20.dp, 20.dp)
            )
        }
    }

}
@Preview
@Composable
fun FlowerAddToCartButtonPreview() = FlowerAddToCartButton(NavController(LocalContext.current))

@Composable
fun HeaderImagesSlider(pageCount: Int) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 10.dp)
    ) {

        Box(modifier = Modifier.fillMaxHeight()) {

            Image(
                painter = painterResource(id = R.drawable.ic_pink_rose_bouquet),
                contentDescription = "",
                modifier = Modifier
                    .size(250.dp)
                    .padding(top = 20.dp)
            )
        }


    }
    PageIndicatorFlower(pageCount)
}

@Preview
@Composable
fun HeaderImagesSliderPreview() = HeaderImagesSlider(3)

@Composable
fun PageIndicatorFlower(pageCount: Int) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 250.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(if (pageCount == 0) 10.dp else 8.dp)
                    .clip(CircleShape)
                    .background(if (pageCount == 0) dark_gray else Color.LightGray)
            )

            Spacer(modifier = Modifier.padding(horizontal = 4.dp))
            Box(
                modifier = Modifier
                    .size(if (pageCount == 1) 10.dp else 8.dp)
                    .clip(CircleShape)
                    .background(if (pageCount == 1) dark_gray else Color.LightGray)
            )
            Spacer(modifier = Modifier.padding(horizontal = 4.dp))
            Box(
                modifier = Modifier
                    .size(if (pageCount == 2) 10.dp else 8.dp)
                    .clip(CircleShape)
                    .background(if (pageCount == 2) dark_gray else Color.LightGray)
            )

            Spacer(modifier = Modifier.padding(horizontal = 4.dp))
            Box(
                modifier = Modifier
                    .size(if (pageCount == 3) 10.dp else 8.dp)
                    .clip(CircleShape)
                    .background(if (pageCount == 3) dark_gray else Color.LightGray)
            )

            Spacer(modifier = Modifier.padding(horizontal = 4.dp))
            Box(
                modifier = Modifier
                    .size(if (pageCount == 4) 10.dp else 8.dp)
                    .clip(CircleShape)
                    .background(if (pageCount == 4) dark_gray else Color.LightGray)
            )

            Spacer(modifier = Modifier.padding(horizontal = 4.dp))
            Box(
                modifier = Modifier
                    .size(if (pageCount == 5) 10.dp else 8.dp)
                    .clip(CircleShape)
                    .background(if (pageCount == 5) dark_gray else Color.LightGray)
            )

        }
    }

}

@Preview
@Composable
fun PageIndicatorFlowerPreview() = PageIndicatorFlower(3)
