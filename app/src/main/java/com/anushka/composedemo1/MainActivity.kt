package com.anushka.composedemo1

import android.content.Context
import android.health.connect.datatypes.units.Length
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
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
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Label
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.motionEventSpy
import coil.compose.AsyncImage
import com.anushka.composedemo1.ui.theme.Fruit
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var fruitList: List<Fruit> = listOf(
            Fruit("mango", "yellow", 1),
            Fruit("Banana", "Yellow", 2),
            Fruit("Apple", "Red", 3),
            Fruit("Pineapple", "yellow", 4),
            Fruit("Pineapple", "yellow", 5),
            Fruit("Pineapple", "yellow", 6),
            Fruit("Pineapple", "yellow", 7),
            Fruit("Pineapple", "yellow", 8),
            Fruit("Pineapple", "yellow", 9),
            Fruit("Pineapple", "yellow", 10),
            Fruit("Apple", "Red", 11),
            Fruit("Apple", "Red", 12),
            Fruit("Apple", "Red", 13),
            Fruit("Apple", "Red", 14),
            Fruit("Apple", "Red", 3),
            Fruit("Apple", "Red", 3),
            Fruit("Apple", "Red", 3),
            Fruit("Apple", "Red", 3),
            Fruit("Apple", "Red", 3),
            Fruit("Apple", "Red", 3),
            Fruit("Apple", "Red", 3),
        )
        setContent {
            // listlazyColumn(fruitList)
            //listLazyRow(fruitList)
           // lazyGrid1()
          //  lazyGrid2(fruitList)
            // columnExample("Hello World", this)
            // rowExample()
            // rowColumnExample()
            // BoxExample()
            //simpleList()
            //BoxExample1()
            // BoxExample2()
            // BoxExample3()
            /*Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                ButtonDemo()
            }*/
            /* Column (modifier = Modifier.background(color = Color.Blue)
                 .fillMaxSize(),
                 horizontalAlignment = Alignment.Start)*/
            /* Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceEvenly)*//*{
                Greeting(name = "Android")
                Greeting(name = "KEER")
                Greeting(name = "vishwa")*/
            dropdownMenuExample()
        }
    }
}

@Composable
fun dropdownMenuExample() {
    var expanded by remember { mutableStateOf(false) }
    var itemPosition by remember { mutableStateOf(0) }
    val username = listOf("john", "jacob", "kenny", "arjun")
    Box {
        Row(horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable {
                expanded = true
            }) {
            Text(text = username[itemPosition])
            Image(painter = painterResource(id = android.R.drawable.ic_menu_more), contentDescription = null)
        }
        DropdownMenu(expanded = expanded,
            onDismissRequest = {expanded = false}) {
            username.forEachIndexed { index, name ->
                DropdownMenuItem(text = { Text(text = name) },
                    onClick = {
                        expanded = false
                        itemPosition = index
                    })
            }
        }
    }

}

@Composable
fun BoxExample() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "Top center", modifier = Modifier.align(Alignment.TopCenter))
        Text(text = "Bottom end", modifier = Modifier.align(Alignment.BottomEnd))
        Button(onClick = {}, modifier = Modifier.align(Alignment.BottomStart)) { Text("Button") }
    }
}

@Composable
fun lazyGrid1() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(5),
    ) { items(100){
        index: Int ->  Text(text = "item $index")
    } }
}

@Composable
fun lazyGrid2(fruitlist: List<Fruit>){
    var state = rememberLazyGridState()
    LazyVerticalGrid(columns = GridCells.Fixed(6),
        state = state) {
        items(fruitlist){item: Fruit ->
            Text(item.name)
        }
    }
}

@Composable
fun listlazyColumn(fruitlist: List<Fruit>) {
    LazyColumn {
        item { Text("item1") }
        items(count = 5) { index -> Text("list item + $index") }
        items(fruitlist) { item: Fruit -> lazyColumnItem(item.name, item.color) }
    }
}

@Composable
fun listLazyRow(fruitlist: List<Fruit>) {
    LazyRow {
        item { Text("RowItem") }
        items(fruitlist) { item: Fruit ->
            listlazyRowItem(item.qty)
        }
    }
}

@Composable
fun listlazyRowItem(qty: Int) {
    Text(text = qty.toString() + " ")
}


@Composable
fun lazyColumnItem(fruitName: String, fruitColor: String) {
    Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
        Text(
            text = fruitName, fontSize = 40.sp,
        )
        Text(
            text = fruitColor, fontSize = 40.sp,
        )
    }

}

@Composable
fun rowColumnExample() {
    Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
        Text(text = "TextView1")
        Text(text = "TextView2")
        Text(text = "TextView3")
    }
    Column(verticalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxSize()) {
        Text(text = "TextView4")
        Text(
            text = "TextView5",
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        )
        Text(text = "TextView6")
    }
}

@Composable
fun rowExample() {
    Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
        Text(text = "TextView1")
        Text(text = "TextView2")
        Text(text = "TextView3")
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun columnExample(name: String, context: Context) {
    var input by remember { mutableStateOf("initial value") }
    Column(verticalArrangement = Arrangement.SpaceEvenly) {
        Image(
            painter = painterResource(R.drawable.cat),
            contentDescription = "cat"
        )

        AsyncImage(
            model = "https://picsum.photos/200",
            contentDescription = "image from Internet"
        )

        GlideImage(
            model = "https://picsum.photos/200",
            contentDescription = "image from Internet"
        )

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = input,
            onValueChange = { input = it },
        )
        Text(name, modifier = Modifier.background(color = Color.Red), fontSize = 30.sp)
        Button(
            onClick = {
                Toast.makeText(context, input, Toast.LENGTH_LONG).show()
            },
            enabled = true,
            modifier = Modifier.fillMaxHeight()

        ) { Text("CLICK ME") }
    }
}

@Composable
fun simpleList() {
    var editText by remember { mutableStateOf("") }
    var names = remember {
        mutableStateListOf<String>()
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            TextField(
                value = editText,
                onValueChange = { editText = it },
                modifier = Modifier.weight(2F)
            )
            Button(
                modifier = Modifier.weight(1F),
                onClick = {
                    if (editText.isNotBlank()) {
                        names.add(editText)
                    }
                }
            ) {
                Text("Add")
            }
        }
        Spacer(modifier = Modifier.size(20.dp))
        LazyColumn {
            items(names) { currentname ->
                Text(text = currentname)
            }
        }
    }
}

@Composable
@Preview
fun testPreview() {
    simpleList()
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
    Button(
        onClick = {
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
        Text(
            "Add to cart",
            style = MaterialTheme.typography.headlineSmall
        )

    }
    TextButton(onClick = {
        Toast.makeText(context, "clicked text button", Toast.LENGTH_SHORT).show()
    }) {
        Text("Add to cart")
    }
    Button(
        onClick = {
            Toast.makeText(context, "clicked text button", Toast.LENGTH_SHORT).show()
        },
        enabled = false
    ) {
        Text("Add to cart")
    }
    OutlinedButton(onClick = {
        Toast.makeText(context, "clicked outlined  button", Toast.LENGTH_SHORT).show()
    }) {
        Text("Add to cart")
    }
    IconButton(onClick = {
        Toast.makeText(context, "clicked button", Toast.LENGTH_SHORT).show()
    }) {
        Icon(
            Icons.Filled.Refresh,
            contentDescription = "Refresh button"
        )
    }
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
