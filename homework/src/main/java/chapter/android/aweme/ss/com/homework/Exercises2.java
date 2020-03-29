package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */
public class Exercises2 extends AppCompatActivity {

    private static TextView count;
    private static View view;
    private static Button button;
    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relativelayout);
        count = findViewById(R.id.tv_center);
        view = findViewById(R.id.root_view);
        button = findViewById(R.id.btn_left_top);
        int num = getAllChildViewCount(view);
        count.append("总个数："+num);

      /*  button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view1) {
                int num = getAllChildViewCount(view);
                count.setText("总个数："+num);
            }

        });
*/
    }

    public int getAllChildViewCount(View root) {

            int viewCount = 0;

            if (null == root) {
                return 0;
            }

            if (root instanceof ViewGroup) {

                for (int i = 0; i < ((ViewGroup) root).getChildCount(); i++) {
                    View view = ((ViewGroup) root).getChildAt(i);
                    if (view instanceof ViewGroup) {
                        viewCount += getAllChildViewCount(view);
                    } else {
                        viewCount++;
                    }
                }
            }else{
                viewCount++;
            }

            return viewCount;
    }
}
