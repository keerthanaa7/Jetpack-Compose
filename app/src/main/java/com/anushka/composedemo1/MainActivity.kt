package com.anushka.composedemo1

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anushka.composedemo1.ui.theme.ComposeDemo1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //BoxExample1()
            // BoxExample2()
            // BoxExample3()
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                ButtonDemo()
            }
            /* Column (modifier = Modifier.background(color = Color.Blue)
                 .fillMaxSize(),
                 horizontalAlignment = Alignment.Start)*/
            /* Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceEvenly)*//*{
                Greeting(name = "Android")
                Greeting(name = "KEER")
                Greeting(name = "vishwa")*/
        }
    }
}

@Composable
fun BoxExample1() {
    Box(
        modifier = Modifier
            .background(color = Color.Green)
            .size(180.dp, 300.dp)
    ) {
        Box(
            modifier = Modifier
                .background(color = Color.Yellow)
                .size(125.dp, 100.dp)
        ) {
        }
        Text(
            text = "Hi",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .background(color = Color.White)
                .size(90.dp, 50.dp)
        )
    }

}

@Composable
fun BoxExample2() {
    Box(
        modifier = Modifier
            .background(color = Color.LightGray)
            .fillMaxSize()
    ) {

        Text(
            text = "TopStart",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier
                .background(Color.Yellow)
                .padding(10.dp)
                .align(Alignment.TopStart)
        )

        Text(
            text = "TopCenter",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier
                .background(Color.Yellow)
                .padding(10.dp)
                .align(Alignment.TopCenter)
        )

    }
}

@Composable
fun BoxExample3() {
    Box() {
        Image(
            painter = painterResource(id = R.drawable.cat),
            contentDescription = "cat",
            modifier = Modifier.size(300.dp, 400.dp)

        )
        Text(
            text = "cute cat",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.Blue,
            modifier = Modifier.align(Alignment.BottomStart)
        )
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color.Yellow
            ),
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(10.dp)
                .border(5.dp, Color.DarkGray, RectangleShape)
        ) {
            Text("Hello cat")
        }
    }

}

@Composable
fun ButtonDemo() {
    val context = LocalContext.current
    Button(onClick = {
        Toast.makeText(context, "clicked button", Toast.LENGTH_SHORT).show()
    },
        shape = CircleShape,
        contentPadding = PaddingValues(16.dp),
        border = BorderStroke(10.dp, Color.Black),
        colors = ButtonDefaults.textButtonColors(
            contentColor = Color.DarkGray,
            containerColor = Color.White
        )
    ) {
        Text("Add to cart",
            style = MaterialTheme.typography.headlineSmall)

    }
    TextButton(onClick = {
        Toast.makeText(context, "clicked text button", Toast.LENGTH_SHORT).show()
    }) {
        Text("Add to cart")
    }
    Button(onClick = {
        Toast.makeText(context, "clicked text button", Toast.LENGTH_SHORT).show()
    },
        enabled = false) {
        Text("Add to cart")
    }
    OutlinedButton(onClick = {
        Toast.makeText(context, "clicked outlined  button", Toast.LENGTH_SHORT).show()
    }) {
        Text("Add to cart")
    }
    IconButton (onClick = {
        Toast.makeText(context, "clicked button", Toast.LENGTH_SHORT).show()
    }) {
        Icon(Icons.Filled.Refresh,
            contentDescription = "Refresh button")
    }
}

@Composable
fun DisplaySnackBar() {
    val scaffoldState:Scaff
}

/*@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "$name!",
        color = Color.Red,
        fontSize = 32.sp,
        textAlign = TextAlign.Center,
        modifier = modifier
    )
}*/

/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeDemo1Theme {
        Greeting("Android")
    }
}*/
