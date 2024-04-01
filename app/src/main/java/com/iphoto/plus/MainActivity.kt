package com.iphoto.plus

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iphoto.plus.base.MyAppContext
import com.iphoto.plus.home.LoginBean
import com.iphoto.plus.home.WeekPlanListBeanItem
import com.iphoto.plus.internet.CoroutineUtil
import com.iphoto.plus.internet.HttpRequest
import com.iphoto.plus.internet.RetrofitClient
import com.iphoto.plus.ui.theme.Retrofit_demoTheme
import com.iphoto.plus.utils.SpUtil

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Retrofit_demoTheme {
//                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("在成长")
                    Log.i("levi", MyAppContext.context.packageName)
//                    BottomAppBar {
//                    setContent {
//                        val navList = listOf("首页","课程","发现","我的")
//                    }
//                    }
                }
            }
        }
    }


}

private fun login() {
    val appId = "77bc4d3c-4592-4307-adc4-1d45a019efc8"
    val deviceId = "92cd07d0-5b4e-4c5e-9cd6-18c436505480"
    val deviceName = "BKL-AL20"
    val ipAddress = ""
    val osName = "10"
    val password = "f379eaf3c831b04de153469d1bec345e"
    val userName = "13839131251"
    val versionName = "4.2.41.50651"
    val loginBean = LoginBean(
        appId,
        deviceId,
        deviceName,
        ipAddress,
        osName,
        password,
        userName,
        versionName
    )

    HttpRequest.execute {
        val login = it.login(loginBean)
        SpUtil.encode("token", login.data.token)
        SpUtil.encode("gradeId", login.data.gradeId)
    }

}


//suspend fun getWeekPlanList(): List<WeekPlanListBeanItem> {
//   val gradeId = SpUtil.decodeString("gradeId")
//    val weekPlanList = RetrofitClient.apiService.getWeekPlanList(gradeId.toString())
//    return weekPlanList.data
//}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var weekPlanList by remember {
        mutableStateOf(emptyList<WeekPlanListBeanItem>())
    }

    Column {

        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Button(onClick = { login() }) {
            Text(text = "登录")
        }
        Button(onClick = {
            CoroutineUtil.execMain {
                val gradeId = SpUtil.decodeString("gradeId")
                val responseList = RetrofitClient.apiService.getWeekPlanList(gradeId.toString())
                weekPlanList = responseList.data
            }

        }) {
            Text(text = "请求周计划列表")

        }
        PuppyListItem(weekPlanList)

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PuppyListItem(weekPlanList: List<WeekPlanListBeanItem>) {

    LazyColumn(
        Modifier.fillMaxHeight(),
        //设置Padding为20dp
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 20.dp),
        //设置item的间距为10dp
        verticalArrangement = Arrangement.spacedBy(10.dp)

    ) {
        //添加多个item，回调中没有数据的下标
        items(weekPlanList.size) {
            Card(onClick = { Log.i("levi", "点击==>$it") }) {
                Text("第$it 个Item")
            }
            Text(text = "${weekPlanList.get(it).planName}")
        }


    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Retrofit_demoTheme {
        Greeting("Android")
    }
}