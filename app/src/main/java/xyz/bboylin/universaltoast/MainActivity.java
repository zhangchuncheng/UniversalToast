package xyz.bboylin.universaltoast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import xyz.bboylin.universialtoast.UniversalToast;

public class MainActivity extends AppCompatActivity {

    public static final String[] ITEMS = {"通用toast", "强调toast", "可点击toast"
            , "通用 + 成功toast", "通用 + 警告toast", "通用 + 错误toast"
            , "强调 + 成功toast", "通用 + 警告toast", "通用 + 错误toast"
            , "可点击 + 成功toast", "可点击 + 警告toast", "可点击 + 错误toast"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.listview);
        final View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "toast clicked!!!");
            }
        };
        listView.setAdapter(new ArrayAdapter(MainActivity.this, R.layout.item, ITEMS));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        UniversalToast.makeText(MainActivity.this, "关注成功", UniversalToast.LENGTH_SHORT, UniversalToast.UNIVERSAL)
                                .setLeftIcon(R.drawable.ic_done_white_24dp)
                                .show();
                        break;
                    case 1:
                        UniversalToast.makeText(MainActivity.this, "关注成功", UniversalToast.LENGTH_SHORT, UniversalToast.EMPHASIZE)
                                .setLeftIcon(R.drawable.ic_check_circle_white_24dp)
                                .show();
                        break;
                    case 2:
                        UniversalToast.makeText(MainActivity.this, "关注成功", UniversalToast.LENGTH_SHORT, UniversalToast.CLICKABLE)
                                .setLeftIcon(R.drawable.ic_done_white_24dp)
                                .setClickCallBack("查看", onClickListener)
                                .show();
                        break;
                    case 3:
                        UniversalToast.makeText(MainActivity.this, "关注成功", UniversalToast.LENGTH_SHORT).showSuccess();
                        break;
                    case 4:
                        UniversalToast.makeText(MainActivity.this, "请先登录", UniversalToast.LENGTH_SHORT).showWarning();
                        break;
                    case 5:
                        UniversalToast.makeText(MainActivity.this, "关注失败", UniversalToast.LENGTH_SHORT).showError();
                        break;
                    case 6:
                        UniversalToast.makeText(MainActivity.this, "关注成功", UniversalToast.LENGTH_SHORT, UniversalToast.EMPHASIZE).showSuccess();
                        break;
                    case 7:
                        UniversalToast.makeText(MainActivity.this, "请先登录", UniversalToast.LENGTH_SHORT, UniversalToast.EMPHASIZE).showWarning();
                        break;
                    case 8:
                        UniversalToast.makeText(MainActivity.this, "关注失败", UniversalToast.LENGTH_SHORT, UniversalToast.EMPHASIZE).showError();
                        break;
                    case 9:
                        UniversalToast.makeText(MainActivity.this, "关注成功", UniversalToast.LENGTH_SHORT, UniversalToast.CLICKABLE)
                                .setClickCallBack("查看", onClickListener)
                                .showSuccess();
                        break;
                    case 10:
                        UniversalToast.makeText(MainActivity.this, "请先登录", UniversalToast.LENGTH_SHORT, UniversalToast.CLICKABLE)
                                .setClickCallBack("查看", onClickListener)
                                .showWarning();
                        break;
                    case 11:
                        UniversalToast.makeText(MainActivity.this, "关注失败", UniversalToast.LENGTH_SHORT, UniversalToast.CLICKABLE)
                                .setClickCallBack("查看", onClickListener)
                                .showError();
                        break;
                }
            }
        });
    }
}