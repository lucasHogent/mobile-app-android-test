package com.project.beertracker.ui.productlist


import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.beertracker.R
import com.project.beertracker.domain.model.Product
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf


@Composable
fun ProductListScreen(
    navigateUp: () -> Unit,
    showFilter: () -> Unit,
    openProductDetails: (String) -> Unit,
    viewModel: ProductListViewModel = hiltViewModel()
) {
    val viewState by viewModel.state.collectAsState()
    ProductListScreen(
        state = viewState,
        navigateUp = navigateUp,
        showFilter = showFilter,
        openProductDetails = openProductDetails,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ProductListScreen(
    state: ProductListViewState,
    navigateUp: () -> Unit,
    showFilter: () -> Unit,
    openProductDetails: (String) -> Unit
) {
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        topBar = {
            ProductListAppBar(
                navigateUp = navigateUp,
                showFilter = showFilter
            )
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        if (state.productList.isEmpty()) {
            Text(text = "No data")
        } else {
            ProductList(
                products = state.productList,
                openProductDetails = openProductDetails,
                contentPadding = paddingValues
            )
        }
    }
}


@Composable
private fun ProductList(
    products: ImmutableList<Product>,
    openProductDetails: (String) -> Unit,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        state = rememberLazyGridState(),
        contentPadding = contentPadding,
        modifier = modifier.fillMaxSize()
    ) {
        items(
            items = products,
            key = { it.id }
        ) {
            Product(
                productModel = it,
                openDetails = { openProductDetails(it.id) }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Product(
    productModel: Product,
    openDetails: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = openDetails,
        modifier = modifier.padding(12.dp),
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        )
    ) {
        Column(
            modifier = Modifier
                .border(0.7.dp, Color(0xffaaaaaa), RoundedCornerShape(12.dp))
                .padding(12.dp)
        ) {

            Text(
                text = productModel.name.orEmpty(),
                modifier = Modifier.fillMaxWidth(),
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2
            )
            Text(
                text = productModel.description.orEmpty(),
                modifier = Modifier.fillMaxWidth(),
                overflow = TextOverflow.Ellipsis,
                maxLines = 2
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${productModel.category}",
                    modifier = Modifier.weight(1f),
                    //color = colorResource(id = R.color.colorPrimary),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ProductListAppBar(
    navigateUp: () -> Unit,
    showFilter: () -> Unit,
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        title = { Text(text = "Products", color = Color.White) },
        modifier = modifier,
        navigationIcon = {
            IconButton(onClick = navigateUp) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back"
                )
            }
        },
        actions = {
            IconButton(
                onClick = showFilter,
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
//                Icon(
//                    painter = painterResource(id = R.drawable.),
//                    contentDescription = "Change action",
//                    tint = Color.White
//                )
            }
        },

    )
}

@Preview
@Composable
private fun ProductListAppBarPreview() {
    ProductListAppBar(navigateUp = {}, showFilter = {})
}

@Preview
@Composable
private fun ProductPreview() {
    Product(
        productModel = Product(
            id = "TcF68MpGmIGiq5LOvF7u",
            name = "Chili, Local Grass-Fed Beef",
            picture = "https://firebasestorage.googleapis.com/v0/b/groceries-store-ad0eb.appspot.com/o/Vegetables%2Fcsm_peppers-plp-desktop_a9c6971df1.jpg?alt=media&token=f986caa0-d65c-4c76-8186-ff75abd6db1e",
            description = "Chili doesn't get much meatier than this; this is the kind you dream about for game days and crisp winter nights.",
        ),
        openDetails = {}
    )
}

@Preview
@Composable
private fun ProductListPreview() {
    Surface(
        modifier = Modifier.height(400.dp)
    ) {
        ProductList(
            products = persistentListOf(
                Product(
                    id = "TcF68MpGmIGiq5LOvF7u",
                    name = "Chili, Local Grass-Fed Beef",
                    picture = "https://firebasestorage.googleapis.com/v0/b/groceries-store-ad0eb.appspot.com/o/Vegetables%2Fcsm_peppers-plp-desktop_a9c6971df1.jpg?alt=media&token=f986caa0-d65c-4c76-8186-ff75abd6db1e",
                    description = "Chili doesn't get much meatier than this; this is the kind you dream about for game days and crisp winter nights.",
                ),
                Product(
                    id = "bhuLZpaY5yqEssty5V7m",
                    name = "Grass-Fed Local Beef Brisket",
                    picture = "https://firebasestorage.googleapis.com/v0/b/groceries-store-ad0eb.appspot.com/o/Vegetables%2Fcsm_spaghetti-squash-overview_b846b6fa65.jpg?alt=media&token=1b68952b-26f0-489a-b979-e23a60b52c45",
                    description = "Braise this lean cut in a seasoned broth alongside vegetables, and you'll be rewarded with the ultimate in comfort food.",
                )
            ),
            openProductDetails = {},
            contentPadding = PaddingValues(0.dp)
        )
    }
}

@Preview
@Composable
private fun ProductListScreenPreview() {
    ProductListScreen(
        state = ProductListViewState(
            persistentListOf()
        ),
        navigateUp = {},
        showFilter = {},
        openProductDetails = {}
    )
}
