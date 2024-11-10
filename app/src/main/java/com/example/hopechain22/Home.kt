package com.example.hopechain22

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Home() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp,vertical=48.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.wallet),
            contentDescription = "Donation Image",
            modifier = Modifier
                .size(200.dp)
                .padding(bottom = 32.dp)
        )

        // Main heading text
        Text(
            text = "\"The slightest help\nfrom you, will\nmean a lot to them\"",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF007AFF)
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 40.dp)
        )



        Button(
            onClick = { /* Handle Get Started click */ },
            shape = RoundedCornerShape(24.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDA5A08
            )),
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .padding(horizontal = 32.dp)
                .height(48.dp)



        ) {
            Text(
                text = "Connect to Wallet",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }





    }
}