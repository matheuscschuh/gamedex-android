package br.ulbra.gamedex.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.ulbra.gamedex.data.JogoRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogoScreen(onJogoClick: (Int) -> Unit) {
    Scaffold(topBar = { TopAppBar(title = { Text("GameDex") }) }) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(JogoRepository.listar(), key = { it.id }) { jogo ->
                JogoCard(jogo = jogo, onClick = { onJogoClick(jogo.id) })
            }
        }
    }
}