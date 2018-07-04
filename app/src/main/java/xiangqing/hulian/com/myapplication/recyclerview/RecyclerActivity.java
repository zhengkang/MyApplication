package xiangqing.hulian.com.myapplication.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import xiangqing.hulian.com.myapplication.R;

public class RecyclerActivity extends Activity {

    private RecyclerView recyclerView;
    private List<String> dataList;

    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        initData();

        myAdapter.setItenClick(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(RecyclerActivity.this, dataList.get(position)+"", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void initData(){
        recyclerView=findViewById(R.id.recycler);
        dataList=new ArrayList<String>();
        for (int i = 0; i < 45; i++) {
            dataList.add(i+"");
        }
        myAdapter=new MyAdapter(dataList,this);
        //LinearLayoutManager ms= new LinearLayoutManager(this);
        GridLayoutManager ms=new GridLayoutManager(this,4);
        ms.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(ms);
        /*recyclerView.setLayoutManager(new StaggeredGridLayoutManager(4,
                StaggeredGridLayoutManager.HORIZONTAL));*/
        //recyclerView.addItemDecoration(new DividerItemDecoration(this,
                //DividerItemDecoration.VERTICAL_LIST));

       /* recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,
                StaggeredGridLayoutManager.VERTICAL));*/

        // 设置item动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.addItemDecoration(new DividerGridItemDecoration(5,5));
        recyclerView.setAdapter(myAdapter);
    }

}
