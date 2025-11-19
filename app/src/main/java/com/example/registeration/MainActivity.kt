package com.example.registeration

import android.R.attr.id
import android.R.attr.value
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.registeration.ui.theme.RegisterationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RegisterationTheme {
                HostelBooking()
            }
        }
    }
}

@Composable
fun HostelBooking(){
    var fee by remember{ mutableStateOf("") }
    var reg by remember{ mutableStateOf("") }
    var name by remember{ mutableStateOf("") }
    var hostelName by remember { mutableStateOf("") }
    var issueDate by remember{mutableStateOf("")}



    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxSize() , horizontalAlignment = Alignment.CenterHorizontally , verticalArrangement = Arrangement.Center) {
        Text("Hostel Name" , modifier = Modifier.align(Alignment.Start).padding(horizontal = 60.dp).padding(vertical = 5.dp))
        TextField(value=hostelName , onValueChange =  { hostelName = it } , label ={Text("Enter Your Name")})

        Text(text = "Name" , modifier = Modifier.align(Alignment.Start).padding(horizontal = 60.dp))
        TextField(value=name , onValueChange =  { name = it } , label ={Text("Enter Your Name")})

        Text(text="Registeration No." , modifier = Modifier.align(Alignment.Start).padding(horizontal = 60.dp).padding(vertical = 5.dp))
        TextField(value=reg , onValueChange =  { reg = it } , label ={Text("Enter Registeration No.")})

        Text("Issue Date" , modifier = Modifier.align(Alignment.Start).padding(horizontal = 60.dp).padding(vertical = 5.dp))
        TextField(value=issueDate , onValueChange =  { issueDate = it } , label ={Text("Enter Date Of Issue")})

        Text("FEE" , modifier = Modifier.align(Alignment.Start).padding(horizontal = 60.dp).padding(vertical = 5.dp))
        TextField(value=fee , onValueChange =  { fee = it } , label ={Text("Enter Fee to pay")})

        Button(onClick={
            var amount = fee.toIntOrNull()
            if(amount == 100000){
                Toast.makeText(context,"Successfully Booked",Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(context,"Booking Failed",Toast.LENGTH_LONG).show()
            }
        } , modifier = Modifier.padding(vertical = 15.dp)) {
            Text("Book Now")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RegisterationTheme {
        HostelBooking()
    }
}