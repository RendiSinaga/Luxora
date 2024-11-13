package com.example.luxora

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.luxora.animation.AnimatedBackground
import com.example.luxora.ui.theme.LightGray

@Composable
fun AboutScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 4.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.rendi),
            contentDescription = "Rendi Sinaga",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(250.dp)
                .padding(16.dp)
                .clip(CircleShape)
        )
        ProfileCard()
        SocialMediaCard()
    }
}

@Composable
private fun ProfileCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(containerColor = LightGray)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "PROFILE",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(8.dp))

            ProfileInfoRow(label = "Nama", value = "Rendi Sinaga")
            ProfileInfoRow(label = "Email", value = "rendysinagaa10@gmail.com")
            ProfileInfoRow(label = "Perguruan Tinggi", value = "Politeknik Negeri Batam")
            ProfileInfoRow(label = "Jurusan", value = "Teknologi Rekayasa Perangkat Lunak")
        }
    }
}

@Composable
private fun ProfileInfoRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Text(
            text = "$label:",
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
        Text(
            text = value,
            fontSize = 14.sp,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Composable
private fun SocialMediaCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(containerColor = LightGray)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "SOCIAL MEDIA",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            SocialMediaRow(iconRes = R.drawable.instagram, text = "@rendy_snaga")
            SocialMediaRow(iconRes = R.drawable.github, text = "github.com/RendiSinaga")
            SocialMediaRow(iconRes = R.drawable.linkedin, text = "www.linkedin.com/in/rendi-sinaga")
        }
    }
}

@Composable
private fun SocialMediaRow(iconRes: Int, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier
                .size(42.dp)
                .padding(end = 16.dp)
        )
        Text(
            text = text,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun AboutScreenPreview() {
    Box(modifier = Modifier.fillMaxSize()) {
        AnimatedBackground()
        AboutScreen()
    }
}
