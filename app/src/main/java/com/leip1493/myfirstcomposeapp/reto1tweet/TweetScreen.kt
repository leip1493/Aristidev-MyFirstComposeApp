package com.leip1493.myfirstcomposeapp.reto1tweet

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leip1493.myfirstcomposeapp.R

@Composable
fun TweetScreen(modifier: Modifier) {
    Column(
        modifier
            .fillMaxSize()
            .background(Color(0xFF15202b))
            .verticalScroll(rememberScrollState())
    ) {
        TweetCard()
        HorizontalDivider(
            Modifier
                .padding(top = 4.dp)
                .fillMaxWidth(), color = Color.White, thickness = 0.5.dp
        )
        TweetCard()
        HorizontalDivider(
            Modifier
                .padding(top = 4.dp)
                .fillMaxWidth(), color = Color.White, thickness = 0.5.dp
        )
        TweetCard()
        HorizontalDivider(
            Modifier
                .padding(top = 4.dp)
                .fillMaxWidth(), color = Color.White, thickness = 0.5.dp
        )
        TweetCard()
        HorizontalDivider(
            Modifier
                .padding(top = 4.dp)
                .fillMaxWidth(), color = Color.White, thickness = 0.5.dp
        )
    }
}

@Composable
fun TweetCard() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Profile",
            modifier = Modifier
                .size(55.dp)
                .clip(CircleShape)
        )
        Column(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            TweetHeader()
            TweetText()
            Spacer(Modifier.size(16.dp))
            TweetImage()
            TweetActions()
        }
    }
}

@Composable
fun TweetActions() {
    Row(Modifier.padding(top = 16.dp)) {
        TweetChat(Modifier)
        Spacer(Modifier.width(64.dp))
        TweetRT(Modifier)
        Spacer(Modifier.width(64.dp))
        TweetLike(Modifier)
    }
}

@Composable
fun SocialIcon(
    modifier: Modifier,
    unselectedIcon: @Composable () -> Unit,
    selectedIcon: @Composable () -> Unit,
    isSelected: Boolean,
    onItemSelected: () -> Unit,
) {
    val defaultValue = 1

    Row(modifier.clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() }) { onItemSelected() }) {
        if (isSelected) {
            selectedIcon()
        } else {
            unselectedIcon()
        }

        Text(
            text = if (isSelected) (defaultValue + 1).toString() else defaultValue.toString(),
            color = Color(0xFF7E8B98),
            fontSize = 12.sp,
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}

@Composable
fun TweetLike(modifier: Modifier) {
    var isSelected by remember { mutableStateOf(false) }
    SocialIcon(modifier = modifier, unselectedIcon = {
        Icon(
            painter = painterResource(id = R.drawable.ic_like),
            contentDescription = "Like",
            tint = Color.Gray
        )
    }, selectedIcon = {
        Icon(
            painter = painterResource(id = R.drawable.ic_like_filled),
            contentDescription = "Like",
            tint = Color.Red
        )
    }, isSelected = isSelected, onItemSelected = {
        isSelected = !isSelected
    })
}

@Composable
fun TweetRT(modifier: Modifier) {
    var isSelected by remember { mutableStateOf(false) }
    SocialIcon(modifier = modifier, unselectedIcon = {
        Icon(
            painter = painterResource(id = R.drawable.ic_rt),
            contentDescription = "Chat",
            tint = Color.Gray
        )
    }, selectedIcon = {
        Icon(
            painter = painterResource(id = R.drawable.ic_rt),
            contentDescription = "Chat",
            tint = Color.Green
        )
    }, isSelected = isSelected, onItemSelected = {
        isSelected = !isSelected
    })
}

@Composable
fun TweetChat(modifier: Modifier) {
    var isSelected by remember { mutableStateOf(false) }
    SocialIcon(modifier = modifier, unselectedIcon = {
        Icon(
            painter = painterResource(id = R.drawable.ic_chat),
            contentDescription = "Chat",
            tint = Color.Gray
        )
    }, selectedIcon = {
        Icon(
            painter = painterResource(id = R.drawable.ic_chat_filled),
            contentDescription = "Chat",
            tint = Color.Gray
        )
    }, isSelected = isSelected, onItemSelected = {
        isSelected = !isSelected
    })
}

@Composable
fun TweetImage() {
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "Tweet image",
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(10)),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun TweetText() {
    Text(
        "Esto es un tweet larguisimo de una verga que no se queloque" + "Esto es un tweet larguisimo de una verga que no se queloque" + "Esto es un tweet larguisimo de una verga que no se queloque" + "Esto es un tweet larguisimo de una verga que no se queloque",
        color = Color.White,
        fontWeight = FontWeight.Light,
    )
}

@Composable
fun TweetHeader() {
    Row(Modifier.fillMaxWidth()) {
        Text("Aris", color = Color.White, fontWeight = FontWeight.ExtraBold)
        Spacer(Modifier.size(8.dp))
        Text("@AristiDevs", color = Color.Gray)
        Spacer(Modifier.size(8.dp))
        Text("4h", color = Color.Gray)
        Spacer(Modifier.weight(1f))
        Icon(
            painter = painterResource(id = R.drawable.ic_dots),
            contentDescription = "Options",
            tint = Color.White
        )

    }
}
