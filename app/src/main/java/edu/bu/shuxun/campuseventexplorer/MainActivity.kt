package edu.bu.shuxun.campuseventexplorer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.bu.shuxun.campuseventexplorer.ui.theme.CampusEventExplorerTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            CampusEventExplorerTheme {
                CampusEventApp()
            }
        }
    }
}

@Composable
fun CampusEventApp() {
    var searchQuery by rememberSaveable { mutableStateOf("") }

    EventListScreen(
        events = CampusEventData.events,
        query = searchQuery,
        onQueryChange = { searchQuery = it },
        onEventSelected = {
            // Navigation will be added in the next step.
        }
    )
}

@Composable
fun EventListScreen(
    events: List<CampusEvent>,
    query: String,
    onQueryChange: (String) -> Unit,
    onEventSelected: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    val searchText = query.trim()

    val filteredEvents = events.filter { event ->
        event.title.contains(searchText, ignoreCase = true) ||
                event.category.contains(searchText, ignoreCase = true)
    }

    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .imePadding()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Campus Event Explorer",
                style = MaterialTheme.typography.headlineMedium
            )

            OutlinedTextField(
                value = query,
                onValueChange = onQueryChange,
                label = { Text("Search events") },
                placeholder = { Text("Search by title or category") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            if (filteredEvents.isEmpty()) {
                Text(
                    text = "No matching events. Try another search.",
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                items(
                    items = filteredEvents,
                    key = { event -> event.id }
                ) { event ->
                    EventRow(
                        event = event,
                        onClick = { onEventSelected(event.id) }
                    )
                }
            }
        }
    }
}

@Composable
fun EventRow(
    event: CampusEvent,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Column(
            modifier = Modifier.padding(vertical = 20.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = event.category,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.primary
            )

            Text(
                text = event.title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = event.time,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Text(
                text = event.location,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        HorizontalDivider(
            color = MaterialTheme.colorScheme.outlineVariant
        )
    }
}

@Preview(showBackground = true)
@Composable
fun EventListPreview() {
    CampusEventExplorerTheme {
        EventListScreen(
            events = CampusEventData.events,
            query = "",
            onQueryChange = {},
            onEventSelected = {}
        )
    }
}