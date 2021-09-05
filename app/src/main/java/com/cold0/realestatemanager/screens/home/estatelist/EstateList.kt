package com.cold0.realestatemanager.screens.home.estatelist

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import coil.annotation.ExperimentalCoilApi
import com.cold0.realestatemanager.model.Estate
import com.cold0.realestatemanager.screens.home.HomeViewModel
import java.util.*

@ExperimentalCoilApi
@Composable
fun EstateList(estateList: List<Estate>, estateSelected: Pair<UUID, Date>, viewModel: HomeViewModel) {
	LazyColumn(modifier = Modifier
		.fillMaxHeight()
		.drawBehind {
			val strokeWidth = 1 * density
			val y = size.height - strokeWidth / 2
			drawLine(
				Color.LightGray,
				Offset(size.width, 0f),
				Offset(size.width, y),
				strokeWidth
			)
		}) {
		items(estateList) { estate ->
			EstateListItem(estate, estate.compareKeys(estateSelected), viewModel = viewModel)
		}
	}
}