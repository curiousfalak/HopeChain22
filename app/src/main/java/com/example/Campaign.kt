import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hopechain22.R

// Data class for campaigns with unique ID
data class Campaign(
    val id: String,
    val title: String,
    val organizer: String,
    val amount: String,
    val timeLeft: String,
    val imageResId: Int
)

// Sample list of Indian campaigns with unique IDs
val campaigns = listOf(
    Campaign("1", "Help Kerala Flood Victims", "Relief India Trust", "Goal: ₹10,00,000", "3 days left", R.drawable.img),
    Campaign("2", "Educate Underprivileged Kids", "Bharat Education Foundation", "Goal: ₹5,00,000", "15 days left", R.drawable.img_1),
    Campaign("3", "Support Animal Welfare", "Paws for India", "Goal: ₹1,50,000", "7 days left", R.drawable.img_5)
)

// CampaignCard composable to display each campaign in the list
@Composable
fun CampaignCard(campaign: Campaign, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable(onClick = onClick)
            .background(Color.White)
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = campaign.imageResId),
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(campaign.title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text("Organizer: ${campaign.organizer}", fontSize = 14.sp, color = Color.Gray)
                Text("Goal: ${campaign.amount}", fontSize = 14.sp, color = Color.Gray)
                Text("Time Left: ${campaign.timeLeft}", fontSize = 14.sp, color = Color.Red)
            }
        }
    }
}

// CampaignListScreen displays the list of campaigns
@Composable
fun CampaignListScreen(navController: NavController) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(campaigns) { campaign ->
            CampaignCard(
                campaign = campaign,
                onClick = { navController.navigate("campaign_details/${campaign.id}") }
            )
        }
    }
}

// CampaignDetailsScreen displays details of a specific campaign
@Composable
fun CampaignDetailsScreen(campaignId: String?, navController: NavController) {
    val campaign = campaigns.find { it.id == campaignId }
    if (campaign != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(campaign.title, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Image(
                painter = painterResource(id = campaign.imageResId),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Text("Organized by: ${campaign.organizer}", fontSize = 16.sp)
            Text("Goal: ${campaign.amount}", fontSize = 16.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                onClick = {
                    navController.navigate("donate/${campaign.id}")
                },
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Text("Donate Now")
            }
        }
    } else {
        Text("Campaign not found", color = Color.Red)
    }
}