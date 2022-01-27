package com.example.composebasis

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebasis.ui.theme.ComposeBasisTheme
import com.example.composebasis.ui.theme.LatoFamily
import com.example.composebasis.ui.theme.TextInfo

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Carregando o tema padrao para nao sobreescever em todas telas
            ComposeBasisTheme {

            }
        }
    }
}

@Composable
fun CustomText(@StringRes textResId: Int) { //StringRes forcando que envie uma string como id
    Text(
        text = stringResource(id = textResId),
        modifier = Modifier //Modifier para poder modificar e colocar funcoes disponiveis
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                Log.d("Welcome", "Clicked")
            },
        color = Color.Green,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = LatoFamily,
        textAlign = TextAlign.Center,
        //caso nao queira passar toda vez os parametros criar os estilos
        //style = MaterialTheme.typography.body1
    )
}

@Composable
fun feedItem() {
    Column {
        Box {
            Image(
                painter = painterResource(id = R.drawable.download),
                contentDescription = "Thumbnail"
            )
            Text(
                text = "26:15",
                fontSize = 10.sp,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(2.dp, 2.dp)
            )
        }
        //space by colocando um padding geral nos elementos dentro da Row
        Row (
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(16.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(40.dp)
            )
            Column {
                Text(text = "Jetpack Compose - Fundamentos")
                Spacer(modifier = Modifier.size(8.dp))
                Row {
                    Text(text = "Douglas Motta",
                        style = TextInfo)

                    Text(text = "  | 370 views",
                        style = TextInfo)

                    Text(text = " | 3 weeks ago",
                        style = TextInfo)
                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String) {
//    //Elemento texto para colocar um texto na tela, exemplo ao textView
//    Text(text = "Hello $name!")
//}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeBasisTheme {
        feedItem()
    }
}