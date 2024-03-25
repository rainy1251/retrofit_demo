package com.example.retrofit_demo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.retrofit_demo.home.TeacherWeekBean
import com.example.retrofit_demo.internet.CoroutineHandler
import com.example.retrofit_demo.internet.RetrofitClient
import com.example.retrofit_demo.ui.theme.Retrofit_demoTheme
import com.example.retrofit_demo.utils.PreferenceManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Retrofit_demoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
        // 这里使用了刚才写的CoroutineHandler对异常进行处理
        CoroutineScope(Dispatchers.Main).launch(CoroutineHandler) {
            val weekPlan = RetrofitClient.apiService.postData(TeacherWeekBean("123",
                "周五","13245","158558","2024-03-25","2024-03-25"))

         // val banner =  RetrofitClient.apiService.location()

          //  Log.d("Levi","[当前线程为：${Thread.currentThread().name}], 获得数据:${weekPlan}")
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column {
        Text(text = "你好，Android!")
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Retrofit_demoTheme {
        Greeting("Android")
    }
}