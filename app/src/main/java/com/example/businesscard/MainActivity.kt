package com.example.businesscard

import android.media.Image
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingPreview()
                }
            }
        }
    }
}

@Composable
fun NameTitleIcon(name: String, title: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier
                .background(colorResource(id = R.color.Android_BG))
                .padding(bottom = 16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_android),
                contentDescription = null,
                modifier = Modifier
                    .padding(bottom = 16.dp, start = 16.dp, end = 16.dp)
            )
            Text(
                text = stringResource(R.string.android_text),
                color = colorResource(id = R.color.white),
                fontSize = 22.sp,
                modifier = Modifier
            )
        }
        Text(
            text = name,
            textAlign = TextAlign.Center,
            fontSize = 34.sp,
            modifier = Modifier
                .padding(bottom = 8.dp)
        )
        Text(
            text = title,
            fontSize = 12.sp,
            color = colorResource(id = R.color.Android_text)
        )
    }
}

@Composable
fun ContactDetails(contactInfo: String, iconResID: Int) {
    Row {
        Image(
            painter = painterResource(id = iconResID),
            contentDescription = null,
            modifier = Modifier
                .padding(8.dp)
        )
        Text(
            text = contactInfo,
            fontSize = 12.sp,
            modifier = Modifier
                .padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.background))
            .fillMaxSize()
    ) {
        NameTitleIcon(
            name = stringResource(R.string.user_name),
            title = stringResource(R.string.user_designation),
            modifier = Modifier
        )
        Column(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomCenter)
        ) {
            ContactDetails(
                contactInfo = stringResource(R.string.user_phone_number),
                iconResID = R.drawable.phone_android
            )
            ContactDetails(
                contactInfo = stringResource(R.string.user_social_media),
                iconResID = R.drawable.share_android
            )
            ContactDetails(
                contactInfo = stringResource(R.string.user_email_id),
                iconResID = R.drawable.email_android
            )
        }
    }
}