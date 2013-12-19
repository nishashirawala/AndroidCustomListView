package com.customlist.customlistview;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

import com.customlist.adapter.CustomListAdapter;
import com.customlist.adapter.ListVO;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ListView list = (ListView) findViewById(R.id.list);
		List<ListVO> listVOs = createMockData();
		CustomListAdapter adapter = new CustomListAdapter(this, listVOs);
		list.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private List<ListVO> createMockData() {
		List<ListVO> listVOs = new ArrayList<ListVO>();

		for (int index = 1; index <= 10; index++) {
			ListVO vo = new ListVO();
			vo.setRouteName("list-item-" + index);
			List<String> subItemList =  new ArrayList<String>();
			for (int sub_index = 1; sub_index <= 5; sub_index++) {
				subItemList.add("sub-item-" + sub_index);
			}
			vo.setTimeList(subItemList);
			listVOs.add(vo);
		}

		return listVOs;
	}

}
