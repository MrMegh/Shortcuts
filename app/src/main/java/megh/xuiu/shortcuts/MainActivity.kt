package megh.xuiu.shortcuts
import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import kotlinx.coroutines.launch
import megh.xuiu.shortcuts.ui.theme.ShortcutsTheme

@Suppress("DEPRECATION")
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ShortcutsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UI()

                }


            }
        }


    }


}
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UI() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val context = LocalContext.current

    val coroutineScope = rememberCoroutineScope()
    val openUrl=Intent(Intent(Intent.ACTION_VIEW))
    ModalNavigationDrawer( drawerContent = {

        Scaffold(

            content = {
                LazyColumn(modifier = Modifier.fillMaxSize(), content = {
                    item {

                        Image(modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                            painter = painterResource(id = R.drawable.profile),
                            contentDescription =null
                        )
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            content = {
                                Text(modifier = Modifier.padding(top = 16.dp, bottom = 16.dp, start = 105.dp,), text = "Megh Badoniya")
                            }
                        )
                        Divider()
                        Card(modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()) {
                            Text(modifier = Modifier.padding(16.dp), text = "Hi 👋 , " +
                                    "I am Megh Badoniya . " +
                                    "Living in Jabalpur Madhya Pradesh " +
                                    "Now has been become an successful app developer ")
                        }

                    }
                })
            },

            floatingActionButton = {
                ExtendedFloatingActionButton(
                    text = { Text(text = "Visit us")},
                    icon = { Icon(imageVector = Icons.Default.Info, contentDescription = null)},
                    onClick = {
                        openUrl.data= Uri.parse("https://sites.google.com/view/xuiu")
                        context.startActivity(openUrl)
                    })
            },
            floatingActionButtonPosition = FabPosition.End




        )

    } ) {
        Scaffold(modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),


            topBar = {
                CenterAlignedTopAppBar(
                    scrollBehavior=scrollBehavior,
                    navigationIcon = {
                        IconButton(onClick = {


                            if (drawerState.isClosed){coroutineScope.launch { drawerState.open() }}else{coroutineScope.launch { drawerState.close() }}






                        }) {
                            Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                        }
                    },
                    title = {
                        Text(text = "Shortcuts")
                    },
                    actions = {
                        IconButton(onClick = {
                            openUrl.data= Uri.parse("https://myaccount.google.com/")
                            context.startActivity(openUrl)
                        }) {
                            //Icon(painter = painterResource(id = R.drawable.profile ), contentDescription = null)
                            Image(painter = painterResource(id = R.drawable.profile), contentDescription = null )
                        }
                    }
                )
            },
            content = {

                List_View(paddingValues = it)
            },
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    text = { Text(text = "Join") },
                    icon = { Icon(imageVector = Icons.Default.Person, contentDescription = null ) },
                    onClick = {
                        openUrl.data= Uri.parse("https://www.instagram.com/megh_badoniya1806/")
                        context.startActivity(openUrl)
                    })
            }
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun List_View(paddingValues: PaddingValues) {
    val context = LocalContext.current
    val openUrl=Intent(Intent(Intent.ACTION_VIEW))
    LazyColumn(modifier = Modifier.padding(top = paddingValues.calculateTopPadding()), content = {
        item {

            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                ,
                content = {

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Image(modifier = Modifier
                            .clip(CircleShape)
                            .padding(10.dp)

                            .size(150.dp), painter = painterResource(id = R.drawable.mptreasury_icon),
                            contentDescription = "image",)

                        Button(onClick = {
                            openUrl.data= Uri.parse("https:/mptreasury.gov.in/IFMS")
                            context.startActivity(openUrl)
                        },
                            modifier = Modifier.padding(top = 60.dp, start = 45.dp)
                        ) {
                            Text(text = "open")
                        }
                    }

                }
            )
            Divider()

            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                ,
                content = {

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Image(modifier = Modifier
                            .clip(CircleShape)
                            .padding(10.dp)

                            .size(150.dp), painter = painterResource(id = R.drawable.electricity),
                            contentDescription = "image",)

                        Button(onClick = {
                            openUrl.data= Uri.parse("https://billing.mpez.co.in/index.jsp?msg=captchafailed")
                            context.startActivity(openUrl)
                        },
                            modifier = Modifier.padding(top = 60.dp, start = 45.dp)
                        ) {
                            Text(text = "open")
                        }
                    }

                }
            )
            Divider()

            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                ,
                content = {

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Image(modifier = Modifier
                            .clip(CircleShape)
                            .padding(10.dp)

                            .size(150.dp), painter = painterResource(id = R.drawable.nagarnigam),
                            contentDescription = "image",)

                        Button(onClick = {
                            openUrl.data= Uri.parse("https://www.mpenagarpalika.gov.in:8005/sap/bc/webdynpro/sap/zpt_qpay?partner=1000520271#")
                            context.startActivity(openUrl)
                        },
                            modifier = Modifier.padding(top = 60.dp, start = 45.dp)
                        ) {
                            Text(text = "open")
                        }
                    }

                }
            )
            Divider()

            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                ,
                content = {

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Image(modifier = Modifier
                            .clip(CircleShape)
                            .padding(10.dp)

                            .size(150.dp), painter = painterResource(id = R.drawable.speed_post),
                            contentDescription = "image",)

                        Button(onClick = {
                            openUrl.data= Uri.parse("https://speedposts.in/")
                            context.startActivity(openUrl)
                        },
                            modifier = Modifier.padding(top = 60.dp, start = 45.dp)
                        ) {
                            Text(text = "open")
                        }
                    }

                }
            )
            Divider()

            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                ,
                content = {

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Image(modifier = Modifier
                            .clip(CircleShape)
                            .padding(10.dp)

                            .size(150.dp), painter = painterResource(id = R.drawable.ekart_track),
                            contentDescription = "image",)

                        Button(onClick = {
                            openUrl.data= Uri.parse("https://trackcourier.io/ekart-logistics-courier-tracking")
                            context.startActivity(openUrl)
                        },
                            modifier = Modifier.padding(top = 60.dp, start = 45.dp)
                        ) {
                            Text(text = "open")
                        }
                    }

                }
            )
            Divider()

            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                ,
                content = {

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Image(modifier = Modifier
                            .clip(CircleShape)
                            .padding(10.dp)

                            .size(150.dp), painter = painterResource(id = R.drawable.calendar_icon),
                            contentDescription = "image",)

                        Button(onClick = {
                            openUrl.data= Uri.parse("https://jabalpur.nic.in/en/document/local-holiday-2020/")
                            context.startActivity(openUrl)
                        },
                            modifier = Modifier.padding(top = 60.dp, start = 45.dp)
                        ) {
                            Text(text = "open")
                        }
                    }

                }
            )
            Divider()

            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                ,
                content = {

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Image(modifier = Modifier
                            .clip(CircleShape)
                            .padding(10.dp)

                            .size(150.dp), painter = painterResource(id = R.drawable.sbi_logo),
                            contentDescription = "image",)

                        Button(onClick = {
                            openUrl.data= Uri.parse("https://homeloans.sbi/getcibil")
                            context.startActivity(openUrl)
                        },
                            modifier = Modifier.padding(top = 60.dp, start = 45.dp)
                        ) {
                            Text(text = "open")
                        }
                    }

                }
            )
            Divider()



            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                ,
                content = {

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Image(modifier = Modifier
                            .clip(CircleShape)
                            .padding(10.dp)

                            .size(150.dp), painter = painterResource(id = R.drawable.snaptube_logo),
                            contentDescription = "image",)

                        Button(onClick = {
                            openUrl.data= Uri.parse("https://ssyoutube.com/en353/")
                            context.startActivity(openUrl)
                        },
                            modifier = Modifier.padding(top = 60.dp, start = 45.dp)
                        ) {
                            Text(text = "open")
                        }
                    }

                }
            )
            Divider()

            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                ,
                content = {

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Image(modifier = Modifier
                            .clip(CircleShape)
                            .padding(10.dp)

                            .size(150.dp), painter = painterResource(id = R.drawable.film_icon),
                            contentDescription = "image",)

                        Button(onClick = {
                            openUrl.data= Uri.parse("https://cinehub.wtf/")
                            context.startActivity(openUrl)
                        },
                            modifier = Modifier.padding(top = 60.dp, start = 45.dp)
                        ) {
                            Text(text = "open")
                        }
                    }

                }
            )
            Divider()

            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                ,
                content = {

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Image(modifier = Modifier
                            .clip(CircleShape)
                            .padding(10.dp)

                            .size(150.dp), painter = painterResource(id = R.drawable.movie_icon),
                            contentDescription = "image",)

                        Button(onClick = {
                            openUrl.data= Uri.parse("https://111.90.159.132/?s=Gabbar+is+the+back&post_type%5B%5D=post&post_type%5B%5D=tv")
                            context.startActivity(openUrl)
                        },
                            modifier = Modifier.padding(top = 60.dp, start = 45.dp)
                        ) {
                            Text(text = "open")
                        }
                    }

                }
            )
            Divider()

            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                ,
                content = {

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Image(modifier = Modifier
                            .clip(CircleShape)
                            .padding(10.dp)

                            .size(150.dp), painter = painterResource(id = R.drawable.gov_email),
                            contentDescription = "image",)

                        Button(onClick = {
                            openUrl.data= Uri.parse("https://email.gov.in/")
                            context.startActivity(openUrl)
                        },
                            modifier = Modifier.padding(top = 60.dp, start = 45.dp)
                        ) {
                            Text(text = "open")
                        }
                    }

                }
            )
            Divider()

            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                ,
                content = {

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Image(modifier = Modifier
                            .clip(CircleShape)
                            .padding(10.dp)

                            .size(150.dp), painter = painterResource(id = R.drawable.writer_icon),
                            contentDescription = "image",)

                        Button(onClick = {
                            openUrl.data= Uri.parse("https://rytr.me/privacy")
                            context.startActivity(openUrl)
                        },
                            modifier = Modifier.padding(top = 60.dp, start = 45.dp)
                        ) {
                            Text(text = "open")
                        }
                    }

                }
            )
            Divider()

            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                ,
                content = {

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Image(modifier = Modifier
                            .clip(CircleShape)
                            .padding(10.dp)

                            .size(150.dp), painter = painterResource(id = R.drawable.db_logo),
                            contentDescription = "image",)

                        Button(onClick = {
                            openUrl.data= Uri.parse("https://epaper.bhaskarhindi.com/")
                            context.startActivity(openUrl)
                        },
                            modifier = Modifier.padding(top = 60.dp, start = 45.dp)
                        ) {
                            Text(text = "open")
                        }
                    }

                }
            )
            Divider()

            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                ,
                content = {

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Image(modifier = Modifier
                            .clip(CircleShape)
                            .padding(10.dp)

                            .size(150.dp), painter = painterResource(id = R.drawable.nai_duniya),
                            contentDescription = "image",)

                        Button(onClick = {
                            openUrl.data= Uri.parse("https://epaper.naidunia.com/mepaper/edition-today-jabalpur-59.html")
                            context.startActivity(openUrl)
                        },
                            modifier = Modifier.padding(top = 60.dp, start = 45.dp)
                        ) {
                            Text(text = "open")
                        }
                    }

                }
            )
            Divider()

           




        }
    })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    UI()
}