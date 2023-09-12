package com.arvind.jetcomposeloginui.view

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.arvind.jetcomposeloginui.R
import com.arvind.jetcomposeloginui.ui.theme.*

@Preview(showBackground = true)
@Composable
fun CheckoutScreen() {
    Box(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())) {
        ConstraintLayout {
            val (cartitemsbgref, checkoutref) = createRefs()

            Box(modifier = Modifier
                .height(100.dp)
                .constrainAs(cartitemsbgref) {
                    top.linkTo(cartitemsbgref.top)
                    bottom.linkTo(cartitemsbgref.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }) {
                HeaderCartItems()
            }

            Surface(color = ghost_white,
                shape = RoundedCornerShape(40.dp).copy(bottomStart = ZeroCornerSize,
                    bottomEnd = ZeroCornerSize), modifier = Modifier
                    .padding(top = 70.dp)
                    .constrainAs(checkoutref) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }) {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)) {
                    ItemsFlower()
                    Spacer(modifier = Modifier.padding(10.dp))
                    ItemsFlower()
                    Spacer(modifier = Modifier.padding(20.dp))
                    ApplyCoupon()
                    Spacer(modifier = Modifier.padding(10.dp))
                    CheckoutDetails()
                }
            }
        }
    }
}

@Preview
@Composable
fun HeaderCartItems() {
    Image(
        painter = painterResource(id = R.drawable.login_bg),
        contentDescription = "login bg",
        contentScale = ContentScale.FillWidth,
        modifier = Modifier.fillMaxSize()
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { }) {
            Icon(
                modifier = Modifier.size(32.dp, 32.dp),
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = "",
                tint = white
            )
        }

        Text(
            text = "Cart Items",
            color = white,
            modifier = Modifier.padding(end = 150.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
        )
    }
}

@Preview
@Composable
fun ItemsFlower() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .clip(RoundedCornerShape(16.dp))
        .background(white)) {

        Row(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(10.dp)) {
            Box(
                modifier = Modifier
                    .weight(0.3f)
                    .height(70.dp)
                    .clip(RoundedCornerShape(12.dp)),
            ) {
                Image(
                    modifier = Modifier
                        .size(70.dp),
                    painter = painterResource(R.drawable.ic_pink_rose_bouquet),
                    contentDescription = "",
                )
            }

            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .weight(0.9f)
                    .wrapContentHeight()
            ) {
                Text(
                    text = "Angle Flower Bouquet",
                    fontSize = 16.sp,
                    color = black,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "$567.00",
                    fontSize = 16.sp,
                    color = colorPrimary,
                )

                val counter = remember {
                    mutableStateOf(1)
                }
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(
                        text = "Quantity:",
                        color = Color.Gray,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(top = 10.dp)
                    )
                    Box(
                        modifier = Modifier
                            .width(110.dp)
                            .height(40.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFFE5F4EF))
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(colorPrimary)
                                    .size(32.dp, 32.dp),
                                contentAlignment = Alignment.Center
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
                            }

                            Text(
                                text = "${counter.value}",
                                color = colorPrimary,
                                fontWeight = FontWeight.Bold,
                                fontSize = 24.sp
                            )

                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(colorPrimary)
                                    .size(32.dp, 32.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                IconButton(onClick = {
                                    counter.value++
                                }) {
                                    Icon(
                                        imageVector = Icons.Default.Add,
                                        contentDescription = "",
                                        tint = white,
                                        modifier = Modifier.size(20.dp, 20.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ApplyCoupon() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()) {

        Text(text = "Apply Coupon",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold)

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {

            var userapplycode by remember { mutableStateOf("") }

            TextField(
                value = userapplycode,

                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = white,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .padding(top = 10.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                label = { Text(text = "Enter Code") },
                shape = RoundedCornerShape(8.dp),
                onValueChange = {
                    userapplycode = it
                }
            )
            Spacer(modifier = Modifier.padding(10.dp))

            Button(onClick = {}, colors = ButtonDefaults.textButtonColors(
                backgroundColor = colorPrimary
            ),
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .height(55.dp)
                    .fillMaxWidth()) {
                Text("Apply",
                    color = white)
            }
        }
    }
}

@Preview
@Composable
fun CheckoutDetails() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .clip(RoundedCornerShape(16.dp))
        .background(white)) {

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)) {

            Text(text = "Price Details",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold)

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically) {

                Text(text = "Jannien Flower Bouquet",
                    fontSize = 14.sp,
                    color = Color.Gray)

                Text(text = "1 x $567.00",
                    fontSize = 14.sp,
                    color = Color.Gray)
            }

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically) {

                Text(text = "Jannien Flower Bouquet",
                    fontSize = 14.sp,
                    color = Color.Gray)

                Text(text = "1 x $567.00",
                    fontSize = 14.sp,
                    color = Color.Gray)
            }


            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically) {

                Text(text = "Delivery Charges",
                    fontSize = 14.sp,
                    color = Color.Gray)

                Text(text = "$50.00",
                    fontSize = 14.sp,
                    color = Color.Gray)
            }

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically) {

                Text(text = "Coupon Discount",
                    fontSize = 14.sp,
                    color = Color.Gray)

                Text(text = "$184.00",
                    fontSize = 14.sp,
                    color = Color.Gray)
            }
            Spacer(modifier = Modifier.padding(10.dp))

            Divider(color = Color.Gray, thickness = 1.dp)
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically) {

                Text(text = "Total Amount Payable",
                    fontSize = 14.sp,
                    color = black,
                    fontWeight = FontWeight.Bold)

                Text(text = "$1000.00",
                    fontSize = 14.sp,
                    color = colorPrimary)
            }
            Spacer(modifier = Modifier.padding(10.dp))

            Column(modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom) {
                Button(onClick = { },
                    colors = ButtonDefaults.buttonColors(backgroundColor = colorPrimary),
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .height(60.dp),
                    shape = RoundedCornerShape(16.dp)) {
                    Text(text = "Checkout",
                        color = white,
                        fontWeight = FontWeight.Bold)
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = null,
                        tint = white,
                        modifier = Modifier
                            .padding(start = 4.dp)
                            .size(20.dp, 20.dp)
                    )
                }
            }
        }
    }
}
